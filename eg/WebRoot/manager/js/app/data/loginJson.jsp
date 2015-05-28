<%@page import="cn.hglq4.eshop.dao.loginDAO"%>
<%@page import="cn.hglq4.eshop.entity.login"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	ArrayList<login> loginlist = new ArrayList();
	loginlist = new loginDAO().selectAll();
	String json = new StringBuffer("{");

	response.getWriter().println(josn);
%>