<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>购物流程 </title>
	<meta name="author" content="hqlq4 Team" />
	<meta name="copyright" content="hqlq4" />
		<meta name="keywords" content="购物流程" />
		<meta name="description" content="购物流程" />
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $hits = $("#hits");

	// 查看点击数
	$.ajax({
		url: "/article/hits/1.jhtml",
		type: "GET",
		success: function(data) {
			$hits.text(data);
		}
	});

});
</script>
</head>
<body>
<script type="text/javascript">
$().ready(function() {

	var $headerLogin = $("#headerLogin");
	var $headerRegister = $("#headerRegister");
	var $headerUsername = $("#headerUsername");
	var $headerLogout = $("#headerLogout");
	var $productSearchForm = $("#productSearchForm");
	var $keyword = $("#productSearchForm input");
	var defaultKeyword = "商品搜索";
	
	var username = getCookie("username");
	if (username != null) {
		$headerUsername.text("您好, " + username).show();
		$headerLogout.show();
	} else {
		$headerLogin.show();
		$headerRegister.show();
	}
	
	$keyword.focus(function() {
		if ($keyword.val() == defaultKeyword) {
			$keyword.val("");
		}
	});
	
	$keyword.blur(function() {
		if ($keyword.val() == "") {
			$keyword.val(defaultKeyword);
		}
	});
	
	$productSearchForm.submit(function() {
		if ($.trim($keyword.val()) == "" || $keyword.val() == defaultKeyword) {
			return false;
		}
	});

});
</script>
<div class="container header">
	<jsp:include page="head.jsp"></jsp:include>
</div>
<div class="container articleContent">
		<div class="span6">
			<div class="hotArticleCategory">
				<div class="title">热点分类</div>
						<dl>
							<dt>
								<a href="/article/list/1.jhtml">商城动态</a>
							</dt>
						</dl>
						<dl>
							<dt>
								<a href="/article/list/2.jhtml">活动促销</a>
							</dt>
						</dl>
						<dl>
							<dt>
								<a href="/eshop/webf/article3.jsp">购物指南</a>
							</dt>
						</dl>
						<dl>
							<dt>
								<a href="/article/list/4.jhtml">支付方式</a>
							</dt>
						</dl>
						<dl>
							<dt>
								<a href="/article/list/5.jhtml">配送方式</a>
							</dt>
						</dl>
						<dl>
							<dt>
								<a href="/article/list/6.jhtml">售后服务</a>
							</dt>
						</dl>
						<dl class="last">
							<dt>
								<a href="/article/list/7.jhtml">关于我们</a>
							</dt>
						</dl>
			</div>
			<div class="hotArticle">
				<div class="title">热点文章</div>
				<ul>
							<li>
								<a href="3.jsp" title="购物流程">购物流程</a>
							</li>
							<li>
								<a href="/article/content/201301/2/1.html" title="会员等级">会员等级</a>
							</li>
							<li>
								<a href="/article/content/201301/5/1.html" title="退换货政策">退换货政策</a>
							</li>
							<li>
								<a href="/article/content/201301/7/1.html" title="货到付款">货到付款</a>
							</li>
							<li>
								<a href="/article/content/201301/3/1.html" title="新用户注册">新用户注册</a>
							</li>
							<li>
								<a href="/article/content/201301/4/1.html" title="预存款支付">预存款支付</a>
							</li>
							<li>
								<a href="/article/content/201301/14/1.html" title="会员积分">会员积分</a>
							</li>
							<li>
								<a href="/article/content/201301/8/1.html" title="服务理念">服务理念</a>
							</li>
							<li>
								<a href="/article/content/201301/18/1.html" title="防骗提示">防骗提示</a>
							</li>
							<li>
								<a href="/article/content/201301/6/1.html" title="发票制度">发票制度</a>
							</li>
				</ul>
			</div>
		</div>
		<div class="span18 last">
			<div class="path">
				<ul>
					<li>
						<a href="/">首页</a>
					</li>
					<li>
						<a href="/eshop0810/webf/3.jsp">购物指南</a>
					</li>
				</ul>
			</div>
			<div class="main">
				<h1 class="title">购物流程</h1>
				<div class="info">
					日期: 2013-01-01 20:17:08
					作者: 
					点击数: <span id="hits">&nbsp;</span>
				</div>
				<div class="content"><p> 用户购物流程如下： </p> <img src="../images/201301/01.jpg" /></div>
			</div>
		</div>
	</div>
<div class="container footer">
	<jsp:include page="footpage.jsp"></jsp:include>
</div></body>
</html>