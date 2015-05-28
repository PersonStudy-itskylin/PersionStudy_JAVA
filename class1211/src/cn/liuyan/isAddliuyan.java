package cn.liuyan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class isAddliuyan extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		DBLiuyan liuyan = new DBLiuyan();
		if(liuyan.addliuyan(req.getParameter("userno"), req.getParameter("content"))){
			resp.sendRedirect("liuyan_success.jsp");				
		}else {
			resp.sendRedirect("liuyan_error.jsp");				
		}	
	}
}
