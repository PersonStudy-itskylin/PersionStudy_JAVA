<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'doregister.jsp' starting page</title>
  </head>  
  <body>
  	<jsp:useBean id="register" class="cn.reg.Register">
  		<jsp:setProperty property="*" name="register"/>  		
  	</jsp:useBean>
  </body>
</html>
