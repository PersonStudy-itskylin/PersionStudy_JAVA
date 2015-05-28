<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'abouteshop.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/legalnotice.css" />
<link href="<%=basePath%>css/common.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<div class="container header">
		<jsp:include page="head.jsp"></jsp:include>
	</div>


	<div class="body">
		<div class="pathBar">
			<span>当前位置</span> <a href="/">首页</a><a
				href="<%=basePath%>jsp/legalnotice.jsp">法律申明</a>
		</div>
		<div class="bodyLeft">
			<div class="menu">
				<ul>

					<li><a href="#">关于我们</a></li>
					<li><a href="<%=basePath%>jsp/contaction.jsp"">联系我们</a></li>
					<li><a href="#">诚聘英才</a></li>
					<li><a href="#">支付方式</a></li>
					<li><a href="#">配送方式</a></li>
					<li class="current"><a href="<%=basePath%>jsp/legalnotice.jsp">法律声明</a></li>
					<li><a href="/link.html">友情链接</a></li>
				</ul>
			</div>
		</div>
		<div class="bodyRight">
			<div class="content">
				<div class="top"></div>
				<div class="middle">
					<div class="title">联系我们</div>
					<div class="blank"></div>
					<p>公司名称：工信部人才中心蓝桥软件培训公司</p>
					<p>联系地址：湖北省黄州经济开发区新港二路43号</p>
					<p>邮政编码：438000</p>
					<p>咨询电话：800-000-8488、 0731-88722558</p>
				</div>
				<div class="bottom"></div>
			</div>
		</div>


		<div class="container footer">
			<jsp:include page="footpage.jsp"></jsp:include>
		</div>
</body>
</html>
