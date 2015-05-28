<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>eshop商城首页</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/head.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css"/>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
<script type="text/javascript">
	$(function(){
	$('#newArticle .tab li a').hover(function(){
		$(this).addClass("#tab_a").siblings().removeClass();
		$("#newArticle .tabContent").hide().eq($('#newArticle .tab li a').index(this)).show(); 		
	});
	$('#promotionProduct .tab li a').hover(function(){
		$(this).addClass("#tab_l").siblings().removeClass();
		$("#promotionProduct .tabContent").hide().eq($('#promotionProduct .tab li a').index(this)).show(); 		
	});
	$('#hotProduct .tab li a').hover(function(){
		$(this).addClass("#tab_i").siblings().removeClass();
		$("#hotProduct .tabContent").hide().eq($('#hotProduct .tab li a').index(this)).show(); 		
	});
	$('#newProduct .tab li a').hover(function(){
		$(this).addClass("#tab_n").siblings().removeClass();
		$("#newProduct .tabContent").hide().eq($('#newProduct .tab li a').index(this)).show(); 		
	});
	
	
	});
</script>
</head>


<body>
	<div class="container header">
		<jsp:include page="/jsp/head.jsp"></jsp:include>
	</div>
	<div class="container index">
		<div class="span18">
			<div id="slider" class="slider">
			<jsp:include page="/jsp/ImageSwitcher.jsp"></jsp:include>
			</div>
		</div>
		<div class="span6 last">
			<div id="newArticle" class="newArticle">
				<ul class="tab">
					<li id="tab_a"><a href="#" target="_blank">商城动态</a></li>
					<li><a href="#" target="_blank">活动促销</a></li>
					<li><a href="#" target="_blank">购物指南</a></li>
				</ul>
				<ul class="tabContent">
					<li><a href="#" title="五月靓丽女人节 呵护自己" target="_blank">五月靓丽女人节
							呵护自己</a></li>
					<li><a href="#" title="电子商务未来是否需要“移动”" target="_blank">电子商务未来是否需要“移动”</a>
					</li>
					<li><a href="#" title="合并运费返还方案公告" target="_blank">合并运费返还方案公告</a>
					</li>
					<li><a href="#" title="电商变革 电商造节促销欲打翻身仗" target="_blank">电商变革
							电商造节促销欲打翻身仗</a></li>
					<li><a href="#" title="酷酷搭配逛街去 时尚美范赚足回头率" target="_blank">酷酷搭配逛街去
							时尚美范赚足回头</a></li>
				</ul>
				<ul class="tabContent" style="display:none">
					<li><a href="#" title="为雅安开辟爱心快通道" target="_blank">为雅安开辟爱心快通道</a>
					</li>
					<li><a href="#" title="店庆活动 有你更精彩" target="_blank">店庆活动
							有你更精彩</a></li>
					<li><a href="#" title="低价一站到底" target="_blank">低价一站到底</a></li>
					<li><a href="#" title="周末耍大牌" target="_blank">周末耍大牌</a></li>
					<li><a href="#" title="箱包百万优惠券大派送" target="_blank">箱包百万优惠券大派送</a>
					</li>
				</ul>
				<ul class="tabContent" style="display:none">
					<li><a href="#" title="购物流程" target="_blank">购物流程</a></li>
					<li><a href="#" title="会员等级" target="_blank">会员等级</a></li>
					<li><a href="#" title="新用户注册" target="_blank">新用户注册</a></li>
					<li><a href="#" title="预存款支付" target="_blank">预存款支付</a></li>
					<li><a href="#" title="退换货政策" target="_blank">退换货政策</a></li>
				</ul>
			</div>
			<div class="rightAd">
				<img src="<%=basePath%>images/index_right.jpg" width="230" height="106"
					alt="春季新品" title="春季新品" />
			</div>
		</div>
		<div class="span18">
			<div class="hotBrand clearfix">
				<div class="title">
					<a href="#">所有品牌</a> <strong>热门品牌</strong>BRAND
				</div>
				<ul>
					<li><a href="/brand/content/1.jhtml" title="梵希蔓"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/vimly.gif"
							alt="梵希蔓" /></a></li>
					<li><a href="/brand/content/2.jhtml" title="伊芙丽"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/eifini.gif"
							alt="伊芙丽" /></a></li>
					<li><a href="/brand/content/3.jhtml" title="尚都比拉"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/sentubila.gif"
							alt="尚都比拉" /></a></li>
					<li><a href="/brand/content/4.jhtml" title="森马"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/semir.gif"
							alt="森马" /></a></li>
					<li><a href="/brand/content/5.jhtml" title="以纯"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/yishion.gif"
							alt="以纯" /></a></li>
					<li><a href="/brand/content/6.jhtml" title="李宁"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/lining.gif"
							alt="李宁" /></a></li>
					<li><a href="/brand/content/7.jhtml" title="耐克"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/nike.gif"
							alt="耐克" /></a></li>
					<li><a href="/brand/content/8.jhtml" title="阿迪达斯"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/adidas.gif"
							alt="阿迪达斯" /></a></li>
					<li><a href="/brand/content/9.jhtml" title="Jack Jones"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/jackjones.gif"
							alt="Jack Jones" /></a></li>
					<li><a href="/brand/content/10.jhtml" title="七匹狼"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/septwolves.gif"
							alt="七匹狼" /></a></li>
					<li><a href="/brand/content/11.jhtml" title="恒源祥"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/hengyuanxiang.gif"
							alt="恒源祥" /></a></li>
					<li><a href="/brand/content/12.jhtml" title="圣得西"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/sundance.gif"
							alt="圣得西" /></a></li>
					<li><a href="/brand/content/13.jhtml" title="猫人"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/maoren.gif"
							alt="猫人" /></a></li>
					<li><a href="/brand/content/14.jhtml" title="北极绒"><img
							src="http://storage.shopxx.net/demo-image/3.0/brand/beijirong.gif"
							alt="北极绒" /></a></li>
				</ul>
			</div>
			<div class="hotProductCategory">
				<div class="title">
					<a href="/product_category.jhtml">所有分类</a> <strong>热门分类</strong>CATEGORY
				</div>
				<div class="content">
					<table>
						<tr>
							<th><a href="/product/list/1.jhtml">时尚女装</a></th>
							<td><a href="/product/list/11.jhtml">连衣裙</a> <a
								href="/product/list/12.jhtml">针织衫</a> <a
								href="/product/list/13.jhtml">短外套</a> <a
								href="/product/list/14.jhtml">小西装</a> <a
								href="/product/list/15.jhtml">牛仔裤</a> <a
								href="/product/list/16.jhtml">T恤</a> <a
								href="/product/list/17.jhtml">衬衫</a> <a
								href="/product/list/18.jhtml">风衣</a> <a
								href="/product/list/19.jhtml">卫衣</a> <a
								href="/product/list/20.jhtml">裤子</a></td>
						</tr>
						<tr>
							<th><a href="/product/list/2.jhtml">精品男装</a></th>
							<td><a href="/product/list/21.jhtml">针织衫</a> <a
								href="/product/list/22.jhtml">POLO衫</a> <a
								href="/product/list/23.jhtml">休闲裤</a> <a
								href="/product/list/24.jhtml">牛仔裤</a> <a
								href="/product/list/25.jhtml">T恤</a> <a
								href="/product/list/26.jhtml">衬衫</a> <a
								href="/product/list/27.jhtml">西服</a> <a
								href="/product/list/28.jhtml">西裤</a> <a
								href="/product/list/29.jhtml">风衣</a> <a
								href="/product/list/30.jhtml">卫衣</a></td>
						</tr>
						<tr>
							<th><a href="/product/list/3.jhtml">精致内衣</a></th>
							<td><a href="/product/list/31.jhtml">女式内裤</a> <a
								href="/product/list/32.jhtml">男式内裤</a> <a
								href="/product/list/33.jhtml">保暖内衣</a> <a
								href="/product/list/34.jhtml">塑身衣</a> <a
								href="/product/list/35.jhtml">连裤袜</a> <a
								href="/product/list/36.jhtml">打底袜</a> <a
								href="/product/list/37.jhtml">文胸</a> <a
								href="/product/list/38.jhtml">睡衣</a> <a
								href="/product/list/39.jhtml">泳装</a> <a
								href="/product/list/40.jhtml">浴袍</a></td>
						</tr>
						<tr class="last">
							<th><a href="/product/list/4.jhtml">服饰配件</a></th>
							<td><a href="/product/list/41.jhtml">女士腰带</a> <a
								href="/product/list/42.jhtml">男士皮带</a> <a
								href="/product/list/43.jhtml">女士围巾</a> <a
								href="/product/list/44.jhtml">男士围巾</a> <a
								href="/product/list/45.jhtml">帽子</a> <a
								href="/product/list/46.jhtml">手套</a> <a
								href="/product/list/47.jhtml">领带</a> <a
								href="/product/list/48.jhtml">领结</a> <a
								href="/product/list/49.jhtml">发饰</a> <a
								href="/product/list/50.jhtml">袖扣</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="span6 last">
			<div id="promotionProduct" class="promotionProduct">
				<ul class="tab">
					<li id="tab_l"><a href="#" target="_blank">限时抢购</a></li>
					<li><a href="#" target="_blank">双倍积分</a></li>
				</ul>
				<ul class="tabContent">
					<li><span class="info" beginTimeStamp="1356969600000"
						endTimeStamp="1420041600000"> 开始时间: <strong>2013-01-01
								00:00</strong>
					</span>
						<div class="product">
							<img
								src="<%=basePath%>upload/cloth/girl/1.jpg?pid=24"
								alt="梵希蔓2013夏装新款大码品质女装蕾丝连衣裙夏季蛋糕裙短袖连衣裙" /> <a
								href="/product/content/201301/76.html"
								title="梵希蔓2019夏装新款大码品质女装蕾丝连衣裙夏季蛋糕裙短袖连衣裙" target="_blank">梵希蔓2013夏装新款大码品</a>
							<div>
								市场价:
								<del>￥250.80</del>
							</div>
						</div>
						<div>
							销售价: <strong>￥209.00</strong>
						</div></li>
					<li class="last"><span class="info"
						beginTimeStamp="1356969600000" endTimeStamp="1420041600000">
							开始时间: <strong>2013-01-01 00:00</strong>
					</span>
						<div class="product">
							<img
								src="<%=basePath%>upload/cloth/girl/2.jpg?pid=24"
								alt="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰" /> <a
								href="/product/content/201301/54.html"
								title="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰" target="_blank">梵希蔓2013夏装淑女连衣裙</a>
							<div>
								市场价:
								<del>￥345.60</del>
							</div>
						</div>
						<div>
							销售价: <strong>￥288.00</strong>
						</div></li>
				</ul>
				<ul class="tabContent" style="display: none;">
					<li><span class="info"> </span>
						<div class="product">
							<img
								src="http://storage.shopxx.net/demo-image/3.0/201301/a39fce79-fc04-4400-9e0f-47cee57accab-thumbnail.jpg"
								alt="OSA春装外套女春秋韩版泡泡袖女士小西装短外套W13254" /> <a
								href="/product/content/201301/122.html"
								title="OSA春装外套女春秋韩版泡泡袖女士小西装短外套W13254" target="_blank">OSA春装外套女春秋韩版泡泡</a>
							<div>
								市场价:
								<del>￥345.60</del>
							</div>
						</div>
						<div>
							销售价: <strong>￥288.00</strong>
						</div></li>
					<li class="last"><span class="info"> </span>
						<div class="product">
							<img
								src="http://storage.shopxx.net/demo-image/3.0/201301/69439b45-8626-451c-a31a-08f9df5d702b-thumbnail.jpg"
								alt="伊芙丽 2013春装新款 女装OL通勤修身长袖小外套女小西装1211120" /> <a
								href="/product/content/201301/194.html"
								title="伊芙丽 2013春装新款 女装OL通勤修身长袖小外套女小西装1211120" target="_blank">伊芙丽
								2013春装新款 女装</a>
							<div>
								市场价:
								<del>￥681.60</del>
							</div>
						</div>
						<div>
							销售价: <strong>￥568.00</strong>
						</div></li>
				</ul>
			</div>
			<div class="newReview">
				<div class="title">最新评论</div>
				<ul>
					<li><a href="/review/content/150.jhtml"
						title="不错，很好，质量很好。穿着也很合身。" target="_blank">不错，很好，质量很好。穿着也很合</a></li>
					<li><a href="/review/content/142.jhtml"
						title="东西收到了，第一次购买杰克琼斯买的衣服，虽然贵，但是质量很满意，大小合适、面料很舒服、样式很新颖、真的不..."
						target="_blank">东西收到了，第一次购买杰克琼斯</a></li>
					<li><a href="/review/content/137.jhtml"
						title="整体上还不错,就是颜色没有想象的那么好，面料很舒服，应该穿着会很舒服。" target="_blank">整体上还不错,就是颜色没有想象的</a>
					</li>
					<li><a href="/review/content/2.jhtml"
						title="衣服很漂亮，做工质量都不错，面料很舒适，裁剪很合身。是那种特别淑女特别有范儿的样式。只是希望快递能给力..."
						target="_blank">衣服很漂亮，做工质量都不错，面</a></li>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div class="middleAd">
				<img src="<%=basePath%>images/1.jpg"
					width="1000" height="120" alt="特卖会专场" title="特卖会专场" />
			</div>
		</div>
		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
				<div class="title">
					<strong>热门商品</strong> <a href="/product/list.jhtml?tagIds=1"
						target="_blank"></a>
				</div>
				<ul class="tab">
					<li id="tab_i"><a href="/product/list/1.jhtml?tagIds=1" target="_blank">时尚女装</a>
					</li>
					<li><a href="/product/list/2.jhtml?tagIds=1" target="_blank">精品男装</a>
					</li>
					<li><a href="/product/list/3.jhtml?tagIds=1" target="_blank">精致内衣</a>
					</li>
				</ul>
				<div class="hotProductAd">
					<img
						src="http://storage.shopxx.net/demo-image/3.0/ad/index_hot_product.jpg"
						width="260" height="343" alt="热门商品" title="热门商品" />
				</div>
				<ul class="tabContent">
					<li><a href="/upload/cloth/girl/1.jpg?product_id=24"
						title="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰" target="_blank"><img
							src="<%=basePath%>/upload/cloth/girl/1.jpg?product_id=24"
							alt="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰" /></a></li>
					<li><a href="/upload/cloth/girl/3.jpg?product_id=41"
						title="梵希蔓2013夏装新款蕾丝连衣裙镂空假两件套连衣裙刺绣短袖连衣裙" target="_blank"><img
							src="<%=basePath%>/upload/cloth/girl/3.jpg?product_id=41"
							alt="梵希蔓2013夏装新款蕾丝连衣裙镂空假两件套连衣裙刺绣短袖连衣裙" /></a></li>
					<li><a href="/upload/cloth/girl/4.jpg?product_id=44"
						title="维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子" target="_blank"><img
							src="<%=basePath%>/upload/cloth/girl/4.jpg?product_id=44"
							alt="维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子" /></a></li>
					<li><a href="/upload/cloth/girl/5.jpg?product_id=48"
						title="尚都比拉2013春夏装新款女装 春款淑女两件套 蕾丝雪纺短袖连衣裙" target="_blank"><img
							src="<%=basePath%>/upload/cloth/girl/5.jpg?product_id=48"
							alt="尚都比拉2013春夏装新款女装 春款淑女两件套 蕾丝雪纺短袖连衣裙" /></a></li>
					<li><a href="/product/content/201301/96.html"
						title="梵希蔓2013新款夏装甜美女装连衣裙短袖雪纺蕾丝拼接公主裙百褶裙" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/94fd156b-cbdc-40d7-8231-8e26bae2ed9c-thumbnail.jpg"
							alt="梵希蔓2013新款夏装甜美女装连衣裙短袖雪纺蕾丝拼接公主裙百褶裙" /></a></li>
					<li><a href="/product/content/201301/279.html"
						title="尚都比拉2013春夏装新款女装 春款修身女裙 蕾丝雪纺短袖连衣裙子" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/2553e635-7aa4-416a-83f4-5288145684a1-thumbnail.jpg"
							alt="尚都比拉2013春夏装新款女装 春款修身女裙 蕾丝雪纺短袖连衣裙子" /></a></li>
					<li><a href="/product/content/201301/290.html"
						title="尚都比拉2013夏装新款 韩版优雅甜美淑女装 春款蕾丝雪纺连衣裙子" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/51afeef5-f6cb-4936-abea-315cfca0edc0-thumbnail.jpg"
							alt="尚都比拉2013夏装新款 韩版优雅甜美淑女装 春款蕾丝雪纺连衣裙子" /></a></li>
					<li><a href="/product/content/201301/300.html"
						title="尚都比拉女装2013夏装新款蕾丝连衣裙 韩版修身雪纺打底裙子 春款" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg"
							alt="尚都比拉女装2013夏装新款蕾丝连衣裙 韩版修身雪纺打底裙子 春款" /></a></li> 
				</ul>
				<ul class="tabContent" style="display: none;">
					<li><a href="/upload/cloth/boy/1.jpg?product_id=9"
						title="JackJones杰克琼斯男士纯棉格纹短袖衬衫C212204021" target="_blank"><img
							src="<%=basePath%>/upload/cloth/boy/1.jpg?product_id=9"
							alt="JackJones杰克琼斯男士纯棉格纹短袖衬衫C212204021" /></a></li>
					<li><a href="/upload/cloth/boy/2.jpg?product_id=11"
						title="2013春夏柒牌男装官方正品男士休闲印花短袖T恤衫702T506653" target="_blank"><img
							src="<%=basePath%>/upload/cloth/boy/2.jpg?product_id=11"
							alt="2013春夏柒牌男装官方正品男士休闲印花短袖T恤衫702T506653" /></a></li>
					<li><a href="/upload/cloth/boy/3.jpg?product_id=14"
						title="JackJones杰克琼斯男士立领拼接式夹克I212121041" target="_blank"><img
							src="<%=basePath%>/upload/cloth/boy/3.jpg?product_id=14"
							alt="JackJones杰克琼斯男士立领拼接式夹克I212121041" /></a></li>
					<li><a href="/upload/cloth/boy/4.jpg?product_id=17"
						title="Max Toney春装高端暗门襟修身长袖衬衫男 小方领休闲男士衬衣 678" target="_blank"><img
							src="<%=basePath%>/upload/cloth/boy/4.jpg?product_id=17"
							alt="Max Toney春装高端暗门襟修身长袖衬衫男 小方领休闲男士衬衣 678" /></a></li>
					<li><a href="/product/content/201301/58.html"
						title="Max Toney 春夏男士休闲西服西装 永不起褶休闲小西装外套 男627" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/40e34b2d-d240-446e-9874-89969edbe89f-thumbnail.jpg"
							alt="Max Toney 春夏男士休闲西服西装 永不起褶休闲小西装外套 男627" /></a></li>
					<li><a href="/product/content/201301/66.html"
						title="Max Toney 春装男士休闲西服便西装 时尚修身外套小西装 男 229" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/cae1bc6b-0159-4ce0-9a9c-4926df231b4f-thumbnail.jpg"
							alt="Max Toney 春装男士休闲西服便西装 时尚修身外套小西装 男 229" /></a></li>
					<li><a href="/product/content/201301/109.html"
						title="2013春夏柒牌男装正品西服 男立领修身韩版 西服套装 902C141200" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/5e5be432-fbee-4bdd-a7bd-a92e01f9bfc4-thumbnail.jpg"
							alt="2013春夏柒牌男装正品西服 男立领修身韩版 西服套装 902C141200" /></a></li>
					<li><a href="/product/content/201301/189.html"
						title="圣得西 正品男装 经典版白蓝粉色 商务长袖正装衬衫" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/c5b1b396-181a-4805-9e68-9b400d71f91e-thumbnail.jpg"
							alt="圣得西 正品男装 经典版白蓝粉色 商务长袖正装衬衫" /></a></li> 
				</ul>
				<ul class="tabContent" style="display: none;">
					<li><a href="/product/content/201301/213.html"
						title="女士夏季短袖睡裙清纯棉质甜美可爱少女睡衣V领条纹连衣裙家居裙" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/f1174ca6-6bdf-4d0b-86e6-5455bc8e89ad-thumbnail.jpg"
							alt="女士夏季短袖睡裙清纯棉质甜美可爱少女睡衣V领条纹连衣裙家居裙" /></a></li>
					<li><a href="/product/content/201301/221.html"
						title="2013新款夏季家居服女 大码全棉夏装家居睡衣 运动短袖短裤套装" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/1c81f492-a3d7-4c06-8658-bc2c76808cd3-thumbnail.jpg"
							alt="2013新款夏季家居服女 大码全棉夏装家居睡衣 运动短袖短裤套装" /></a></li>
					<li><a href="/product/content/201301/229.html"
						title="卡绚 男士睡衣春秋条纹纯棉长袖家居服套装大码圆领全棉质居家服" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/dea31d42-fa3e-4b69-a631-51ca7c79f032-thumbnail.jpg"
							alt="卡绚 男士睡衣春秋条纹纯棉长袖家居服套装大码圆领全棉质居家服" /></a></li>
					<li><a href="/product/content/201301/230.html"
						title="卡绚 情侣家居服套装 春秋纯棉男女睡衣长袖条纹居家服 时" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/ea566af4-0cdb-4017-a8c7-27e407794204-thumbnail.jpg"
							alt="卡绚 情侣家居服套装 春秋纯棉男女睡衣长袖条纹居家服 时" /></a></li>
					<li><a href="/product/content/201301/241.html"
						title="婷美正品 四季款魔鬼瘦塑身衣套装瘦腰翘臀B罩杯" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/1a3ad7de-7ee9-4530-b89a-46375219beb5-thumbnail.jpg"
							alt="婷美正品 四季款魔鬼瘦塑身衣套装瘦腰翘臀B罩杯" /></a></li>
					<li><a href="/product/content/201301/242.html"
						title="婷美正品秋冬保暖衣 轻压塑身衣美体衣保暖内衣 塑身内衣分体套装" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/2af8be8a-75b9-41ae-b009-a7c54b685a4e-thumbnail.jpg"
							alt="婷美正品秋冬保暖衣 轻压塑身衣美体衣保暖内衣 塑身内衣分体套装" /></a></li>
					<li><a href="/product/content/201301/247.html"
						title="婷美正品塑身衣收腹 塑身背心 舒适托胸 蕾丝动能燃脂 瘦身美体" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/9f164e13-bcaa-48a6-9b35-0ca96629f614-thumbnail.jpg"
							alt="婷美正品塑身衣收腹 塑身背心 舒适托胸 蕾丝动能燃脂 瘦身美体" /></a></li>
					<li><a href="/product/content/201301/248.html"
						title="婷美塑身内衣正品燃脂塑身衣套装tingmei收腹瘦身衣薄束身衣" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/c41d0347-364c-42bb-baeb-25142c1ed167-thumbnail.jpg"
							alt="婷美塑身内衣正品燃脂塑身衣套装tingmei收腹瘦身衣薄束身衣" /></a></li>
				</ul> 
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>最新商品</strong> <a href="/product/list.jhtml?tagIds=2"
						target="_blank"></a>
				</div>
				<ul class="tab">
					<li id="tab_n"><a href="/product/list/1.jhtml?tagIds=2" target="_blank">时尚女装</a>
					</li>
					<li><a href="/product/list/2.jhtml?tagIds=2" target="_blank">精品男装</a>
					</li>
					<li><a href="/product/list/3.jhtml?tagIds=2" target="_blank">精致内衣</a>
					</li>
				</ul>
				<div class="newProductAd">
					<img
						src="http://storage.shopxx.net/demo-image/3.0/ad/index_new_product.jpg"
						width="260" height="343" alt="最新商品" title="最新商品" />
				</div>
				<ul class="tabContent">
					<li><a href="/upload/cloth/girl/6.jpg?product_id=51"
						title="维依恋春装2013新款七分袖中长款风衣韩版修身双排扣外套春款大衣" target="_blank"><img
							src="<%=basePath%>/upload/cloth/girl/6.jpg?product_id=51"
							alt="维依恋春装2013新款七分袖中长款风衣韩版修身双排扣外套春款大衣" /></a></li>
					<li><a href="/upload/cloth/girl/7.jpg?product_id=55"
						title="尚都比拉2013夏装新款 春款甜美淑女装 荷叶袖修身蕾丝雪纺连衣裙" target="_blank"><img
							src="<%=basePath%>/upload/cloth/girl/7.jpg?product_id=55"
							alt="尚都比拉2013夏装新款 春款甜美淑女装 荷叶袖修身蕾丝雪纺连衣裙" /></a></li>
					<li><a href="/upload/cloth/girl/8.jpg?product_id=58"
						title="维依恋2013夏装新款韩版修身娃娃领女式短袖雪纺衫蕾丝拼接上衣" target="_blank"><img
							src="<%=basePath%>/upload/cloth/girl/8.jpg?product_id=58"
							alt="维依恋2013夏装新款韩版修身娃娃领女式短袖雪纺衫蕾丝拼接上衣" /></a></li>
					<li><a href="/upload/cloth/girl/9.jpg?product_id=62"
						title="唯维欣怡2013春装新款韩版女装修身网纱长袖衬衣休闲女士白色衬衫" target="_blank"><img
							src="<%=basePath%>/upload/cloth/girl/9.jpg?product_id=62"
							alt="唯维欣怡2013春装新款韩版女装修身网纱长袖衬衣休闲女士白色衬衫" /></a></li>
					<li><a href="/product/content/201301/267.html"
						title="唯维欣怡2013春夏季新款韩版大码宽松显瘦女装荷叶边雪纺连衣裙子" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/b499fb5e-999f-431b-a375-172ee09e4a3e-thumbnail.jpg"
							alt="唯维欣怡2013春夏季新款韩版大码宽松显瘦女装荷叶边雪纺连衣裙子" /></a></li> 
					<li><a href="/product/content/201301/30.html"
						title="梵希蔓 2013夏装新款女装女裙子长款雪纺百褶连衣裙韩版修身裙子" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/3999515b-48ba-476e-b810-3ca57f4b9e29-thumbnail.jpg"
							alt="梵希蔓 2013夏装新款女装女裙子长款雪纺百褶连衣裙韩版修身裙子" /></a></li>
					<li><a href="/product/content/201301/122.html"
						title="OSA春装外套女春秋韩版泡泡袖女士小西装短外套W13254" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/a39fce79-fc04-4400-9e0f-47cee57accab-thumbnail.jpg"
							alt="OSA春装外套女春秋韩版泡泡袖女士小西装短外套W13254" /></a></li>
					<li><a href="/product/content/201301/285.html"
						title="尚都比拉2013夏装新款 春款修身淑女装 雪纺短袖假两件套连衣裙子" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg"
							alt="尚都比拉2013夏装新款 春款修身淑女装 雪纺短袖假两件套连衣裙子" /></a></li>
				</ul>
				<ul class="tabContent" style="display: none;">
					<li><a href="/upload/cloth/boy/5.jpg?product_id=20"
						title="JackJones杰克琼斯男士立领拉链机车夹克B212121038" target="_blank"><img
							src="<%=basePath%>/upload/cloth/boy/5.jpg?product_id=20"
							alt="JackJones杰克琼斯男士立领拉链机车夹克B212121038" /></a></li>
					<li><a href="/upload/cloth/boy/6.jpg?product_id=8"
						title="JackJones杰克琼斯男纯棉怀旧图案短袖T恤V212201016" target="_blank"><img
							src="<%=basePath%>/upload/cloth/boy/6.jpg?product_id=8"
							alt="JackJones杰克琼斯男纯棉怀旧图案短袖T恤V212201016" /></a></li>
					<li><a href="/upload/cloth/boy/7.jpg?product_id=10"
						title="2013春夏柒牌男装官方正品男士条纹T恤衫702T563985" target="_blank"><img
							src="<%=basePath%>/upload/cloth/boy/7.jpg?product_id=10"
							alt="2013春夏柒牌男装官方正品男士条纹T恤衫702T563985" /></a></li>
					<li><a href="/upload/cloth/boy/8.jpg?product_id=21"
						title="Max Toney 春装时尚休闲多层卷边领莱卡棉T恤 男 长袖T恤 599" target="_blank"><img
							src="<%=basePath%>/upload/cloth/boy/8.jpg?product_id=21"
							alt="Max Toney 春装时尚休闲多层卷边领莱卡棉T恤 男 长袖T恤 599" /></a></li>
				<li><a href="/product/content/201301/46.html"
						title="Max Toney奢华春装 单扣高档全羊毛休闲西装西服 男 219" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/3c79f82f-f136-48aa-9e81-7e10fbb3de2a-thumbnail.jpg"
							alt="Max Toney奢华春装 单扣高档全羊毛休闲西装西服 男 219" /></a></li>
					<li><a href="/product/content/201301/174.html"
						title="圣得西 正品男装 浅蓝色细格休闲长袖衬衫 经典版" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/b04a22f5-267d-4e33-ac58-dda941eeaf84-thumbnail.jpg"
							alt="圣得西 正品男装 浅蓝色细格休闲长袖衬衫 经典版" /></a></li>
					<li><a href="/product/content/201301/98.html"
						title="春装新款159 与狼共舞长袖T恤 男装正品 翻领纯棉条纹体恤衫6534" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/bb99deac-0b33-48f1-a3ad-e8310516be07-thumbnail.jpg"
							alt="春装新款159 与狼共舞长袖T恤 男装正品 翻领纯棉条纹体恤衫6534" /></a></li>
					<li><a href="/product/content/201301/91.html"
						title="夏装新品179 与狼共舞短袖T恤 气质拼接 男装正品 翻领修身6614" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/7b3c0647-1016-4d13-8b84-4d63818e1179-thumbnail.jpg"
							alt="夏装新品179 与狼共舞短袖T恤 气质拼接 男装正品 翻领修身6614" /></a></li>
				</ul>
				<ul class="tabContent" style="display: none;">
					<li><a href="/product/content/201301/200.html"
						title="卡绚 情侣家居服睡衣套装 夏季纯棉 时尚条纹男女士睡衣短" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/2971c96e-9f11-4491-9faf-9ea7e1fec53c-thumbnail.jpg"
							alt="卡绚 情侣家居服睡衣套装 夏季纯棉 时尚条纹男女士睡衣短" /></a></li>
					<li><a href="/product/content/201301/213.html"
						title="女士夏季短袖睡裙清纯棉质甜美可爱少女睡衣V领条纹连衣裙家居裙" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/f1174ca6-6bdf-4d0b-86e6-5455bc8e89ad-thumbnail.jpg"
							alt="女士夏季短袖睡裙清纯棉质甜美可爱少女睡衣V领条纹连衣裙家居裙" /></a></li>
					<li><a href="/product/content/201301/221.html"
						title="2013新款夏季家居服女 大码全棉夏装家居睡衣 运动短袖短裤套装" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/1c81f492-a3d7-4c06-8658-bc2c76808cd3-thumbnail.jpg"
							alt="2013新款夏季家居服女 大码全棉夏装家居睡衣 运动短袖短裤套装" /></a></li>
					<li><a href="/product/content/201301/229.html"
						title="卡绚 男士睡衣春秋条纹纯棉长袖家居服套装大码圆领全棉质居家服" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/dea31d42-fa3e-4b69-a631-51ca7c79f032-thumbnail.jpg"
							alt="卡绚 男士睡衣春秋条纹纯棉长袖家居服套装大码圆领全棉质居家服" /></a></li>
					<li><a href="/product/content/201301/230.html"
						title="卡绚 情侣家居服套装 春秋纯棉男女睡衣长袖条纹居家服 时" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/ea566af4-0cdb-4017-a8c7-27e407794204-thumbnail.jpg"
							alt="卡绚 情侣家居服套装 春秋纯棉男女睡衣长袖条纹居家服 时" /></a></li>
					<li><a href="/product/content/201301/241.html"
						title="婷美正品 四季款魔鬼瘦塑身衣套装瘦腰翘臀B罩杯" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/1a3ad7de-7ee9-4530-b89a-46375219beb5-thumbnail.jpg"
							alt="婷美正品 四季款魔鬼瘦塑身衣套装瘦腰翘臀B罩杯" /></a></li>
					<li><a href="/product/content/201301/247.html"
						title="婷美正品塑身衣收腹 塑身背心 舒适托胸 蕾丝动能燃脂 瘦身美体" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/9f164e13-bcaa-48a6-9b35-0ca96629f614-thumbnail.jpg"
							alt="婷美正品塑身衣收腹 塑身背心 舒适托胸 蕾丝动能燃脂 瘦身美体" /></a></li>
					<li><a href="/product/content/201301/240.html"
						title="婷美正品内衣塑身衣佳丽燃脂猫背夹超薄透气收腹瘦腰" target="_blank"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/7acae4ac-5909-4142-8b20-19c5462859d6-thumbnail.jpg"
							alt="婷美正品内衣塑身衣佳丽燃脂猫背夹超薄透气收腹瘦腰" /></a></li>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div class="friendLink">
				<dl>
					<dt>合作伙伴</dt>
					<dd>
						<a href="http://www.shopxx.net" target="_blank">黄冈蓝桥官网</a> |
					</dd>
					<dd>
						<a href="http://bbs.shopxx.net" target="_blank">黄冈蓝桥四期论坛</a> |
					</dd>
					<dd>
						<a href="http://www.alipay.com" target="_blank">支付宝</a> |
					</dd>
					<dd>
						<a href="http://www.tenpay.com" target="_blank">财付通</a> |
					</dd>
					<dd>
						<a href="http://www.chinapay.com" target="_blank">银联在线</a> |
					</dd>
					<dd>
						<a href="http://www.99bill.com" target="_blank">快钱支付</a> |
					</dd>
					<dd>
						<a href="http://down.admin5.com" target="_blank">A5下载</a> |
					</dd>
					<dd>
						<a href="http://www.kuaidi100.com" target="_blank">快递100</a> |
					</dd>
					<dd>
						<a href="http://www.cnzz.com" target="_blank">站长统计</a>

					</dd>
					<dd class="more">
						<a href="/friend_link.jhtml">更多</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="container footer">
		<jsp:include page="/jsp/footpage.jsp"></jsp:include>
	</div>
</body>
</html>
