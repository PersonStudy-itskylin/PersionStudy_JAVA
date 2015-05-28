package controllers;

import java.util.Map;

import javax.servlet.http.Cookie;

import rbac.impl.DefaultRbacService;

import com.et.mvc.filter.BeforeFilter;

@BeforeFilter(execute="auth", except={"login","logout"})
public class HomeController extends ApplicationController{
	public void index(){
	}
	
	public void login(String username, String password) throws Exception {
		if (request.getMethod().equalsIgnoreCase("post")){
			rbac = new DefaultRbacService(request);
			Map<String,Object> result = rbac.login(username, password);
			if (result.get("success") != null){
				deleteCookie();
				Cookie c = new Cookie("sessionId", result.get("sessionId").toString());
				c.setMaxAge(240*3600);
				c.setPath(request.getContextPath());
				response.addCookie(c);
				
				redirect("/home/index");
			} else {
				flash.setAttribute("errors", result.get("errors"));
				redirect("/home/login");
			}
		}
	}
	
	public void logout() throws Exception {
		rbac = new DefaultRbacService(request);
		rbac.logout();
		deleteCookie();
        
		redirect("/home/index");
	}
	
	private void deleteCookie(){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for(Cookie cookie: cookies){
                if (cookie.getName().equals("sessionId")){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
	}
}
