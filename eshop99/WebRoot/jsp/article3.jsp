<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>购物指南</title>
<meta name="author" content="hglq4 Team" />
<meta name="copyright" content="hglq4" />

<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $articleSearchForm = $("#articleSearchForm");
	var $keyword = $("#articleSearchForm input");
	var $articleForm = $("#articleForm");
	var $pageNumber = $("#pageNumber");
	var defaultKeyword = "文章搜索";
	
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

	$articleSearchForm.submit(function() {
		if ($.trim($keyword.val()) == "" || $keyword.val() == defaultKeyword) {
			return false;
		}
	});
	
	$articleForm.submit(function() {
		if ($pageNumber.val() == "" || $pageNumber.val() == "1") {
			$pageNumber.prop("disabled", true)
		}
	});
	
	$.pageSkip = function(pageNumber) {
		$pageNumber.val(pageNumber);
		$articleForm.submit();
		return false;
	}

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
<!-- -------------------head end-------------------------------- -->
	<div class="container articleList">
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
						<a href="/eshop0810/webf/3.html">购物指南</a>
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
					<li><a href="<%=basePath%>jsp/article3_1.jsp" title="购物流程">购物流程</a>
					</li>
					<li><a href="<%=basePath%>jsp/article3_2.jsp" title="会员等级">会员等级</a>
					</li>
					<li><a href="/article/content/201301/5/1.html" title="退换货政策">退换货政策</a>
					</li>
					<li><a href="/article/content/201301/7/1.html" title="货到付款">货到付款</a>
					</li>
					<li><a href="/article/content/201301/3/1.html" title="新用户注册">新用户注册</a>
					</li>
					<li><a href="/article/content/201301/4/1.html" title="预存款支付">预存款支付</a>
					</li>
					<li><a href="/article/content/201301/14/1.html" title="会员积分">会员积分</a>
					</li>
					<li><a href="/article/content/201301/8/1.html" title="服务理念">服务理念</a>
					</li>
					<li><a href="/article/content/201301/18/1.html" title="防骗提示">防骗提示</a>
					</li>
					<li><a href="/article/content/201301/6/1.html" title="发票制度">发票制度</a>
					</li>
				</ul>
			</div>
			<div class="articleSearch">
				<div class="title">文章搜索</div>
				<div class="content">
					<form id="articleSearchForm" action="/article/search.jhtml"
						method="get">
						<input type="text" name="keyword" value="文章搜索" maxlength="30" />
						<button type="submit">搜&nbsp;&nbsp;索</button>
					</form>
				</div>
			</div>
		</div>
		<div class="span18 last">
			<div class="path">
				<ul>
					<li><a href="/">首页</a></li>
					<li class="last">购物指南</li>
				</ul>
			</div>
			<form id="articleForm" action="/eshop0810/webf/3.jsp" method="get">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1" />
				<div class="result">
					<ul>
						<li><a href="/eshop/webf/article3_1.html" title="购物流程">购物流程</a>

							<span title="2013-01-01 20:17:08">2013-01-01</span>
							<p>用户购物流程如下：</p></li>
						<li><a href="/eshop/webf/article3_2.html" title="会员等级">会员等级</a>

							<span title="2013-01-01 20:23:07">2013-01-01</span>
							<p>会员等级共分为：注册会员、铜牌会员、银牌会员、金牌会员，会员等级晋升均由系统自动实现，无需申请。</p></li>
						<li><a href="/article/content/201301/3/1.html" title="新用户注册">新用户注册</a>

							<span title="2013-01-01 20:37:20">2013-01-01</span>
							<p>进入网站首页，点击页面右上方的“注册”链接，将进入会员注册页面，输入您的用户名、密码等信息后点击“注册”按钮即可完成注册。注册成功后，您可以进入“会员中心
								- 个人资料”进行个人信息的修改。</p></li>
						<li><a href="/article/content/201301/4/1.html" title="预存款支付">预存款支付</a>

							<span title="2013-01-01 10:57:50">2013-01-01</span>
							<p>预存款是商城为方便用户支付而设计开发的支付方式，方便、快捷无任何手续费。您可以先将货款充值到预存款帐户中，在订单支付的过程中可以用此方式来进行支付，同样，如果订单发生退换货产生退款时，也可以退到您的预存款帐户中，以便您下次...</p>
						</li>
						<li><a href="/article/content/201301/5/1.html" title="退换货政策">退换货政策</a>

							<span title="2013-01-01 11:06:37">2013-01-01</span>
							<p>退换货说明: 一、 退换货总则：
								商城所售商品都是正品行货。商城所有商家将严格按照国家三包政策，针对所售商品履行保修、换货和退货的义务。
								1.符合以下情况，由您实际收到货物日期起7日内可退货；您实际收到货物日期起8日至第15日内可换...</p></li>
						<li><a href="/article/content/201301/6/1.html" title="发票制度">发票制度</a>

							<span title="2013-01-01 11:30:27">2013-01-01</span>
							<p>发票注意事项：
								1.为了保障消费者的合法权益，在商城购物时，均为您开具由税务局监制印制的正规机打销售发票（海外代购商品除外）;
								2.发票是有效交易的重要凭据，可作为单位报销的凭证，也能保证您充分享受到我司提供的售后服务，请妥善保...</p></li>
						<li><a href="/article/content/201301/7/1.html" title="货到付款">货到付款</a>

							<span title="2013-01-01 11:43:00">2013-01-01</span>
							<p>货到付款： 配送人员将货物送达订单指定的收货地址后，由客户支付订单金额给配送人员的一种付款方式。
								在商城购物您可以选择货到付款的支付方式，目前货到付款支持现金支付、移动POS刷卡支付等。
								您在使用货到付款支付方式时，请在购物车支付...</p></li>
						<li><a href="/article/content/201301/8/1.html" title="服务理念">服务理念</a>

							<span title="2013-01-01 11:51:04">2013-01-01</span>
							<p>承担商城各类产品的售后服务，致力于为广大消费者提供“亲切、快捷、周到”优质阳光服务。多年来我们一直秉承“至真至诚，服务第一；服务是我们的唯一产品，顾客满意是我们服务的终极目标、服务理念。我们提出“服务与责任”理念，把服务责任化，真...</p>
						</li>
						<li><a href="/article/content/201301/9/1.html" title="订单查询">订单查询</a>

							<span title="2013-01-01 13:18:50">2013-01-01</span>
							<p>登陆后，进入“会员中心”可查询到订单状态。
								1、等待付款：请您支付订单款项，若订单尚未获得确认，正常工作时间内，最迟2小时可以获得确认，如非正常工作时间，需要等到上班时间确认。
								3、已支付/等待发货：这时订单已在我们工作人员的处...</p></li>
						<li><a href="/article/content/201301/10/1.html" title="配送方式">配送方式</a>

							<span title="2013-01-01 13:34:35">2013-01-01</span>
							<p>配送范围：全国各地。 配送方式：普通快递、自营快递、EMS。 1. 商品购买时根据会员所选配送方式为您安排。 2.
								选择快递的配送方式，系统会默认为申通快递。 收货时间：因所在地区不同而略有差异 对于一些送货上门，货到付款的；如果...</p></li>
						<li><a href="/article/content/201301/11/1.html" title="会员级别">会员级别</a>

							<span title="2013-01-01 13:41:28">2013-01-01</span>
							<p>会员级别分四级，具体为：普通会员、银牌会员、金牌会员、白金会员，会员级别晋升均由系统自动实现，无需申请。 普通会员：
								条件：任何愿意到商城购物的用户都可以免费注册。 待遇：可以享受注册会员所能购买的产品及服务。 银牌会员： 条件：商...</p></li>
						<li><a href="/article/content/201301/12/1.html" title="交易条款">交易条款</a>

							<span title="2013-01-01 13:48:26">2013-01-01</span>
							<p>客户在接受商品订购与送货的同时，有义务遵守以下交易条款。您在商城下订单之前或接受商城送货之前，请您仔细阅读以下条款：
								1.订购的商品价格以您下订单时价格为准。 2.请清楚准确地填写您的真实姓名、送货地址及联系方式。因如下情况造成...</p></li>
						<li><a href="/article/content/201301/13/1.html" title="帮助中心">帮助中心</a>

							<span title="2013-01-01 13:58:54">2013-01-01</span>
							<p>长时间未收到订单可能出现的问题
								1.请您确保订单中的收货地址、邮编、电话、Email地址等信息的准确性，以便商品及时、准确地发出；
								2.快递送货上门的订单，配送过程中如果我们联络您的时间超过7天未得到回复，此订单将被默认为您已经放弃...</p></li>
						<li><a href="/article/content/201301/14/1.html" title="会员积分">会员积分</a>

							<span title="2013-01-01 14:08:47">2013-01-01</span>
							<p>一、如何获得积分： 购买带有积分的商品，或者参加送积分的活动，您即可获得积分;
								获得的积分数量：请参照商品详情页展示的积分，最终获得的积分数量以订单结算页显示为准; 积分可在“会员中心”内查询到;
								如果您退货，则会在退货成功后扣减...</p></li>
						<li><a href="/article/content/201301/15/1.html" title="优惠券">优惠券</a>

							<span title="2013-01-01 14:18:16">2013-01-01</span>
							<p>优惠券是本商城在线发放给用户用于抵扣产品金额的优惠券。 如何获取商城优惠券
								积分兑换：用积分兑换礼券，如每100积分可兑换1元现金券。具体积分可在“会员中心”——“我的积分”中查询；
								现金购买：与在线客户联系，直接用现金购买； 会员专...</p></li>
						<li><a href="/article/content/201301/16/1.html"
							title="退款注意事项">退款注意事项</a> <span title="2013-01-01 14:22:19">2013-01-01</span>
							<p>1 若订单交易未成功，麻烦申请订单金额的正常退款。退款金额返回到您的账户。 2
								若订单交易成功，通过实名认证的用户，退款金额会以即时到帐方式打入您的支付宝/财付通账号，若是非认证用户，请提供其它已认证的支付宝/财付通账号或银行账...</p>
						</li>
						<li><a href="/article/content/201301/17/1.html" title="投诉与建议">投诉与建议</a>

							<span title="2013-01-01 14:24:00">2013-01-01</span>
							<p>如果您对本商城有任何建议或不满，请与联系我们，我们将在3个工作日内给予回复，非常感谢对我们商城的督促和支持。</p></li>
						<li class="last"><a href="/article/content/201301/18/1.html"
							title="防骗提示">防骗提示</a> <span title="2013-01-01 14:30:23">2013-01-01</span>
							<p>基于国内诈骗案件频发，有不法分子假借一些正规电子商务营运商（下简称电商）的名义推销、强卖假冒产品（如化妆品）或会员卡等，情节恶劣，防不胜防。本商城提醒您网购时留意以下几点，谨防上当。
								1. 收到货到付款订单，先验货，再付款 当...</p></li>
					</ul>
				</div>
			</form>
		</div>
	</div>
	<div class="container footer">
	<jsp:include page="footpage.jsp"></jsp:include>
	</div>
</body>
</html>