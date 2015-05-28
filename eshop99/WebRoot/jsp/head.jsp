<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>head.jsp</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
<meta http-equiv="description" content="this is my page"/>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/head.css"/>
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="/demo/"> <img src="<%=basePath%>images/header_logo.gif"
					alt="黄冈蓝桥四期网上商城" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="<%=basePath%>images/h_1002.jpg" width="320" height="50" alt="正品保障"
					title="正品保障" />
			</div>
		</div>

		<div class="span10 last">
			<div class="topNav clearfix">
				<ul>
					<li id="headerLogin" class="headerLogin"><a href="<%=basePath%>jsp/login.jsp">登录</a>|</li>
					<li id="headerRegister" class="headerRegister"><a href="<%=basePath%>jsp/register.jsp">注册</a>|
					</li>
					<li id="headerUsername" class="headerUsername"></li>
					<li id="headerLogout" class="headerLogout"><a href="<%=basePath%>jsp/login.jsp">[退出]</a>|
					</li>
					<li><a href="<%=basePath%>jsp/login.jsp">会员中心</a> |</li>
					<li><a href="<%=basePath%>jsp/article3.jsp">购物指南</a> |</li>
					<li><a href="#">关于我们</a></li>
				</ul>
			</div>
			<div class="cart">
				<a href="<%=basePath%>jsp/shoppingcart.jsp"><img src="<%=basePath%>images/shoppingcar.jpg"/>购物车</a>
			</div>
			<div class="phone">
				客服热线: <strong>400-8888888</strong>
			</div>
		</div>
		<div class="span24">
			<ul class="mainNav">
				<li><a href="<%=basePath%>index.jsp">首页</a> |</li>
				<li><a href="<%=basePath%>jsp/womendress.jsp">时尚女装</a> |</li>
				<li><a href="#">精品男装</a> |</li>
				<li><a href="#">精致内衣</a> |</li>
				<li><a href="#">服饰配件</a> |</li>
				<li><a href="#">时尚女鞋</a> |</li>
				<li><a href="#">流行男鞋</a> |</li>
				<li><a href="#">童装童鞋</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="tagWrap">
				<ul class="tag">
					<li class="icon"
						style="background: url(<%=basePath%>images/qiang.jpg) right no-repeat;">
						<a href="#">热销</a>
					</li>
					<li class="icon"
						style="background: url(<%=basePath%>images/xin.jpg) right no-repeat;">
						<a href="#">最新</a>
					</li>
				</ul>
				<div class="hotSearch">
					热门搜索: <a href="#">T恤</a> <a href="#">衬衫</a> <a href="#">西服</a> <a
						href="#">西裤</a> <a href="#">森马</a> <a href="#">七匹狼</a> <a href="#">梵希蔓</a>
					<a href="#">春夏新款</a> <a href="#">牛仔裤</a>
				</div>
				<div class="search">
					<form id="productSearchForm" action="#" method="get">
						<input name="keyword" class="keyword" value="商品搜索" maxlength="30" />
						<button type="submit">搜索</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	

</body>
</html>
