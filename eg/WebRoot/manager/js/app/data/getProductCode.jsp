<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	long now = System.currentTimeMillis();
	String productsCode  = new StringBuffer("{code:'")
		.append(now)
		.append("'}")
		.toString();
	response.getWriter().println(productsCode);
%>
