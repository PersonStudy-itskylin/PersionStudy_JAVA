package com.softeem.jingdong.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.softeem.jingdong.entity.ShoppingCarBean;
import com.softeem.jingdong.entity.UsersBean;
import com.softeem.jingdong.service.UsersService;

/**
 * 用户 Action 
 * @author Administrator
 *
 */
public class UsersAction extends ActionSupport {
	
	private static final long serialVersionUID = -9123012026453733830L;
	private UsersService usersService;
	private String loginname;
	private String loginpwd;
	private String freeLogin;
	private String username;
	private String pwd;
	
	//注册
	public String register(){
		
		//调用方法
		usersService.register(new UsersBean(username,pwd));
		
		//获取 Session
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		
		//注册成功！
		session.setAttribute("info","注册成功 !");
		return SUCCESS;
	}

	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		
		//调用方法 返回结果
		UsersBean users = usersService.login( new UsersBean(loginname,loginpwd) );
	
		//获取 Session
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		
		//判断是否为 Null
		if( users != null){
			
			//判断用户是否勾选
			if( "on".equals(freeLogin)){
				
				//如果勾选了 , 创建 Cookie
				Cookie CName = new Cookie("name",loginname);
				CName.setMaxAge( 60 * 60 * 24 * 7 );
				CName.setPath("/");
				
				Cookie CPassword = new Cookie("password",loginpwd);
				CPassword.setMaxAge( 60 * 60 * 24 * 7 );
				CPassword.setPath("/");
				
				//添加到客户端中
				ServletActionContext.getResponse().addCookie(CName);
				ServletActionContext.getResponse().addCookie(CPassword);
			}
			
			//给用户创建一个购物车
			users.setShoppingCar( new ShoppingCarBean() );
			
			//登录成功 添加到 Session 中 跳转首页
			session.setAttribute("users",users);
			//跳转 到 获取 所有商品的 Servlet 中
			return SUCCESS;
		}else{
			//失败 则继续跳转到 登陆页面
			//记录错误提示信息
			session.setAttribute("info","账号密码有误 , 请重新登录 !");
			return ERROR;
		}
	}

	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	public String getFreeLogin() {
		return freeLogin;
	}
	public void setFreeLogin(String freeLogin) {
		this.freeLogin = freeLogin;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
}
