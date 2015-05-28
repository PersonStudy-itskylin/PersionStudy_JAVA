<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<%@page import="cn.hglq4.eshop.dao.UserDAO"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	boolean success = false;
	String msg = null;
	UserDAO userDao = new UserDAO();
	if (userDao.delUser(request.getParameter("user_id"))) {
		success = true;
		msg = "用户删除成功！";
	} else {
		msg = "用户删除失败,请重试！";
	}
	response.getWriter().print(msg);
%>