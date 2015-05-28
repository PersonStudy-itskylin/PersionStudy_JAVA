<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>eshop尾页</title>
<meta name="author" content="hglq4 Team" />
<meta name="copyright" content="hglq4" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/footer.css" />
</head>
<body>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="http://storage.shopxx.net/demo-image/3.0/ad/footer.jpg"
					width="950" height="52" alt="我们的优势" title="我们的优势" />
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a href="#">关于我们</a> |</li>
				<li><a href="<%=basePath%>jsp/contaction.jsp"">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="<%=basePath %>jsp/legalnotice.jsp">法律声明</a> |</li>
				<li><a href="/demo/friend_link.jhtml">友情链接</a> |</li>
				<li><a href="/demo/article/list/4.jhtml" target="_blank">支付方式</a>
					|</li>
				<li><a href="/demo/article/list/5.jhtml" target="_blank">配送方式</a>
					|</li>
				<li><a href="http://www.shopxx.net">黄冈蓝桥四期官网</a> |</li>
				<li><a href="http://bbs.shopxx.net">黄冈蓝桥四期论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2014-2020 黄冈蓝桥四期商城 版权所有</div>
		</div>
	</div>
</body>
</html>
