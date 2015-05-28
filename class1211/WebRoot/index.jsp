<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<title>软件1211班—登陆</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/login.css">  
</head>

<body>
	<form action="islogin" method="post">
		<div class="content">
			<div class="user">
				账号：<input type="text" name="userno" ><br />
				密码：<input type="password" name="pwd" >
			</div>
			<div class="enterinput">
			<input type="submit" value="登陆" />			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<input type="reset" value="重置">			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="reg/reg.jsp">注册</a>
			</div>
		</div>
	</form>
</body>
</html>