<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理员登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/themes/icon.css" />
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {

		$('#a_login').window({
			width : 380,
			height : 240,
			title : "管理员登录",
			top : 150,
			resizable : false,
			shadow : true,
			collapsible : false,
			maximizable : false
		});

		$(':text').focus(function() {

			$(this).val("").css({
				'color' : 'black'
			})
			
			   .validate({
				rules : {
					firstname : "required",
					lastname : "required",
				},
				messages : {
					firstname : "Please enter your firstname",
					lastname : "Please enter your lastname",
				}
			});

		})

		/* .blur( function () { alert("Hello World!"); } ) */
		.mousemove(function() {
			$(this).css({
				'border-color' : '#0fc'
			});
		}).mouseout(function() {
			$(this).css({
				'border-color' : '#9cf'
			});
		});

		$('#a_login').css({
			'text-align' : 'center',
			'padding-top' : '50',
			'style' : 'margin-top:20px'
		});

	});
</script>



</head>

<body>
	<div id="a_login">
		<form action="" method="post">
			<input type="text" name="admin_name" value="请输入帐号" style="color: c8c8c8" id="admin_nameID" /><br /> 
			<input type="text" name="admin_pwd" value="请输入密码" style="color: c8c8c8" id="admin_pwdID" /><br /> 
			<input type="text" name="admin_pwd1" value="确认密码" style="color: c8c8c8" /><br /> 
			<input type="checkbox" />记住密码
			<input type="submit" name="admin_submit" value="登录" />
		</form>
	</div>
</body>
</html>
