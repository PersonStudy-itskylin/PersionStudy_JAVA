package cn.reg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class isReg extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2659316744161516511L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("utf-8");
		DBReg dbreg = new DBReg();
		if(dbreg.getReg(req) == true){
				resp.sendRedirect("reg_success.jsp");						
	  	}else{
	  		resp.sendRedirect("reg_error.jsp");
	  	}	
	}
}
