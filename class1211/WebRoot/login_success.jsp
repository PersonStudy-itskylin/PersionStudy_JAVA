<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<title><%= session.getAttribute("username")  %>登陆成功</title> 
   	<style type="text/css">
   		a{text-decoration: none;}
   		body{ background-color:#09f; font-size:12px}
		.content{width: 250px;height:120px; margin: 0 auto; border: 1px groove #88f; padding: 20px;margin-top:200px;background-color:#fff; }
   	</style>
  </head>
  
  <body>
  	<jsp:useBean id="login" class="cn.tongxuelu.Tongxuelu"/>
  	<div class="content">
  		<p>
  			<%	 
  				out.println("登陆成功！<br/>您好，<a href=\"tongxue/person.jsp\">"+ session.getAttribute("username")
  					+"</a>.	<br />"
					+"3秒后自动跳转，如果没有跳转，请单击<a href=\"class_index.jsp\">这里</a>。");
				response.setHeader("refresh", "3;URL=class_index.jsp");    	
  	 		%>  		
  		</p>
  	
  	</div>
  	
  </body>
</html>
