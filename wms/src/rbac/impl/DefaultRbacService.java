package rbac.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import rbac.RbacException;
import rbac.RbacService;
import rbac.models.Privilege;
import rbac.models.Role;
import rbac.models.Session;
import rbac.models.User;

public class DefaultRbacService implements RbacService {
	private HttpSession httpSession;
	private HttpServletRequest request;
	
	public DefaultRbacService(HttpServletRequest request){
		this.request = request;
		this.httpSession = request.getSession();
	}

	@Override
	public boolean exists() throws RbacException {
		return getCurrentUser() != null;
	}

    /**
     * 取得会话ID，从COOKIE中获取
     */
    private String getSessionId(){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for(Cookie cookie: cookies){
                if (cookie.getName().equals("sessionId")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
	@Override
	public Object getCurrentUser() throws RbacException {
		String sessionId = getSessionId();
		if (sessionId == null){
			return null;
		}
        
        try{
        	Session session = Session.findFirst(Session.class, "sessionId=?", new Object[]{sessionId});
        	if (session == null){
        		return null;
        	} else {
        		return session.getUser();
        	}
        } catch(Exception ex){
        	throw new RbacException("查询用户资料过程出现错误", ex);
        }
	}
	
	/**
	 * 返回当前所拥有的所有权限
	 */
	@SuppressWarnings("unchecked")
	private List<Privilege> getCurrentPrivileges() throws RbacException {
		try{
			List<Privilege> privileges = (List<Privilege>)httpSession.getAttribute("SESSION_PRIVILEGES");
			if (privileges != null){
				return privileges;
			}
			
			privileges = new ArrayList<Privilege>();
			
			User user = (User)getCurrentUser();
			
			// 用户没定义角色
			if (user.getRoleIds() == null || user.getRoleIds().trim().equals("")){
				return privileges;
			}
			
			Map<String,String> tmp = new HashMap<String,String>();
			List<Role> roles = Role.findAll(Role.class, "id in (" + user.getRoleIds() + ") and privilegeIds is not null", null);
			for(Role role: roles){
				if (!role.getPrivilegeIds().trim().equals("")){
					for(String id: role.getPrivilegeIds().trim().split(",")){
						if (!tmp.containsKey(id)){
							tmp.put(id, id);
						}
					}
				}
			}
			String ids = "";
			for(String id: tmp.keySet()){
				ids += id + ",";
			}
			if (!ids.equals("")){
				ids = ids.substring(0, ids.length() - 1);
				privileges = Privilege.findAll(Privilege.class, "id in (" + ids + ")");
			}
			
			httpSession.setAttribute("SESSION_PRIVILEGES", privileges);
			
			return privileges;
		} catch(Exception ex){
			throw new RbacException("获取用户权限过程出现错误", ex);
		}
	}

	@Override
	public boolean isAllowed(String actionUrl) throws RbacException {
		List<Privilege> privileges = getCurrentPrivileges();
		for(Privilege privilege: privileges){
			String urls = privilege.getUrls();
			if (urls == null || urls.trim().equals("")){
				continue;
			}
			for(String url: urls.split("\r\n")){
				Pattern p = Pattern.compile(url, Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(actionUrl);
				if (m.find()){
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean hasPrivilege(String privilegeName) throws RbacException{
		List<Privilege> privileges = getCurrentPrivileges();
		for(Privilege privilege: privileges){
			if (privilege.getName().equals(privilegeName)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Map<String, Object> login(String login, String pass)
			throws RbacException {
		logout();
		try{
			Map<String, Object> result = new HashMap<String, Object>();
			User user = User.findFirst(User.class, "login=? and password=?", new Object[]{login, pass});
			if (user == null){
				result.put("failure", true);
				result.put("errors", "用户名或者密码错误");
			} else {
				Session.deleteAll(Session.class, "userId=?", new Object[]{user.getId()});
	            String sessionId = UUID.randomUUID().toString();
	            Session s = new Session();
	            s.setSessionId(sessionId);
	            s.setUserId(user.getId());
	            s.setLoginTime(new java.sql.Timestamp(System.currentTimeMillis()));
	            s.save();
				
				result.put("success", true);
				result.put("sessionId", sessionId);
			}
			return result;
		} catch( Exception ex){
			throw new RbacException("查询过程出现错误", ex);
		}
	}

	@Override
	public void logout() throws RbacException {
		httpSession.removeAttribute("SESSION_PRIVILEGES");
		try{
			Session.deleteAll(Session.class, "sessionId=?", new Object[]{getSessionId()});
		} catch(Exception ex){
			throw new RbacException("删除会话记录过程出现错误", ex);
		}
	}

}
