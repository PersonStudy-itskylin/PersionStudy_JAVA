<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<title>软件1211班—注册成功</title> 
  </head>
  
  <body>
  	<%
  		out.println("注册成功！<br/>"
  				+".	<br />"
				+"3秒后自动跳转，如果没有跳转，请单击<a href=\"./index.jsp\">这里</a>。");
		response.setHeader("refresh", "3;URL=../index.jsp");    	
  	 %>
  </body>
</html>
