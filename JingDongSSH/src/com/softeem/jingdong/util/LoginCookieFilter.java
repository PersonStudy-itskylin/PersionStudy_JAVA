package com.softeem.jingdong.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.jingdong.entity.UsersBean;

/**
 * 保存用户在 Cookie 中 实现免登录过程
 * @author Administrator
 *
 */
public class LoginCookieFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		//获取所有的Cookie
		Cookie[] cookies = request.getCookies();
		
		//遍历所有 现有 Cookie 
		if( cookies != null ){
			
			//Session 里面的用户对象
			UsersBean users = new UsersBean();
			
			//标示符 表示是否找到该用户的 Cookie信息
			boolean nb = false;
			boolean pb = false;
			
			for(Cookie c : cookies){
				
				//找你指定的Cookie
				if(c.getName().equals("name")){
					//则找到对应的值
					users.setName(c.getValue());
					//修改状态
					nb = true;
				}
				
				//找你指定的Cookie
				if(c.getName().equals("password")){
					//则找到对应的值
					users.setPassword(c.getValue());
					//修改状态
					pb = true;
				}
				
			}
			
			//确定找到指定 Cookie 之后 才能免登陆
			if(nb && pb){
				//将用户信息添加到 Session 跳转到 首页
				request.getSession(true).setAttribute("users",users);
				response.sendRedirect("/JingDong/AllGoodsServlet");
			}else{
				//放行
				arg2.doFilter(request, response);
			}
			
		}else{
			// 没有 Cookie记录  , 放行
			arg2.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
