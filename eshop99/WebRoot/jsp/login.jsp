<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>会员登录</title>
<meta name="author" content="hglq4 Team" />
<meta name="copyright" content="hglq4" />

<link href="<%=basePath%>css/login.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/footer.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<!-- <script type="text/javascript">
	$().ready(function() {

						var $loginForm = $("#loginForm");
						var $username = $("#username");
						var $password = $("#password");
						var $captcha = $("#captcha");
						var $captchaImage = $("#captchaImage");
						var $isRememberUsername = $("#isRememberUsername");
						var $submit = $(":submit");

						// 记住用户名
						if (getCookie("memberUsername") != null) {
							$isRememberUsername.prop("checked", true);
							$username.val(getCookie("memberUsername"));
							$password.focus();
						} else {
							$isRememberUsername.prop("checked", false);
							$username.focus();
						}
						// 表单验证、记住用户名
						$loginForm
								.validate({
									rules : {
										username : "required",
										password : "required",
										captcha : "required"
									},
									submitHandler : function(form) {
										$
												.ajax({
													url : "/common/public_key.jhtml",
													type : "GET",
													dataType : "json",
													cache : false,
													beforeSend : function() {
														$submit.prop(
																"disabled",
																true);
													},
													success : function(data) {
														var rsaKey = new RSAKey();
														rsaKey
																.setPublic(
																		b64tohex(data.modulus),
																		b64tohex(data.exponent));
														var enPassword = hex2b64(rsaKey
																.encrypt($password
																		.val()));
														$
																.ajax({
																	url : $loginForm
																			.attr("action"),
																	type : "POST",
																	data : {
																		username : $username
																				.val(),
																		enPassword : enPassword,
																		captchaId : "286e6010-f0ba-4337-acae-69fd5116c32a",
																		captcha : $captcha
																				.val()
																	},
																	dataType : "json",
																	cache : false,
																	success : function(
																			message) {
																		if ($isRememberUsername
																				.prop("checked")) {
																			addCookie(
																					"memberUsername",
																					$username
																							.val(),
																					{
																						expires : 7 * 24 * 60 * 60
																					});
																		} else {
																			removeCookie("memberUsername");
																		}
																		$submit
																				.prop(
																						"disabled",
																						false);
																		if (message.type == "success") {
																			location.href = "/";
																		} else {
																			$
																					.message(message);
																			$captcha
																					.val("");
																			$captchaImage
																					.attr(
																							"src",
																							"/common/captcha.jhtml?captchaId=286e6010-f0ba-4337-acae-69fd5116c32a&timestamp="
																									+ (new Date())
																											.valueOf());
																		}
																	}
																});
													}
												});
									}
								});

					});
</script> -->

</head>
<body>
	<div class="container header">
		<jsp:include page="head.jsp"></jsp:include>
	</div>
	<div class="container login">
		<div class="span12">
			<div class="ad">
				<img src="http://storage.shopxx.net/demo-image/3.0/ad/login.jpg"
					width="500" height="330" alt="会员登录" title="会员登录" />
			</div>
		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN
					</div>
					<form id="loginForm" action="<%=basePath%>jsp/index.jsp" method="post">
						<table>
							<tr>
								<th>用户名/E-mail:</th>
								<td><input type="text" id="username" name="username"
									class="text" maxlength="20" /></td>
							</tr>
							<tr>
								<th>密&nbsp;&nbsp;码:</th>
								<td><input type="password" id="password" name="password"
									class="text" maxlength="20" autocomplete="off" /></td>
							</tr>
							<tr>
								<th>验证码</th>
								<td><input type="text" class="text" /> <iframe
										scrolling="no" src="checkcode.jsp" width="100px" height="28px"
										style="position: relative; top: 5px;"></iframe></td>
							</tr>
							<tr>
								<th>&nbsp;</th>
								<td><label> <input type="checkbox"
										id="isRememberUsername" name="isRememberUsername" value="true" />记住用户名
								</label> <label> &nbsp;&nbsp;<a href="/password/find.jhtml">找回密码</a>
								</label></td>
							</tr>
							<tr>
								<th>&nbsp;</th>
								<td><input id="code_ok" onclick="validate();" type="submit"
									class="submit" value="登录" /></td>

							</tr>
							<tr class="register">
								<th>&nbsp;</th>
								<td>
									<dl>
										<dt>还没有注册账号？</dt>
										<dd>
											立即注册即可体验在线购物！ <a href="<%=basePath%>jsp/register.jsp">立即注册</a>
										</dd>
									</dl>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div>
		<jsp:include page="footpage.jsp"></jsp:include>
	</div>
</body>
</html>