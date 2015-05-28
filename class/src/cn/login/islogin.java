package cn.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tongxuelu.Username;

public class islogin extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -596020672839246209L;
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		DBlogin dologin =new DBlogin();
        req.setCharacterEncoding("utf-8");
		boolean flag = dologin.ifUser(req.getParameter("userno"), req.getParameter("pwd"));
		if(flag){
			
	  		Username username = new Username();		
	        String uname = username.getUsername(req);
						
			HttpSession session = req.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("user", req.getParameter("userno"));
			session.setMaxInactiveInterval(1000);
			
			resp.sendRedirect("login_success.jsp");
		}else{
			resp.sendRedirect("login_error.jsp");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doPost(req, resp);
	}
}
