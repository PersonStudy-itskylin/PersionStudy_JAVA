<%@page import="cn.hglq4.eshop.dao.UserDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	String userName = request.getParameter("user_name");
	UserDAO userDao = new UserDAO();
	boolean  result = false;
	if(userDao.checkUser(userName)){
		result= true;
	}
	out.print("{success:" + result + "}");	
%>
