<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰 - Powered By SHOP++</title>
<meta name="author" content="hglq4 Team" />
<meta name="copyright" content="hglq4" />
		<meta name="keywords" content="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰" />
		<meta name="description" content="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰" />
		
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/secondary.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath%>js/secondary-js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/secondary-js/tool.js"></script>
<script type="text/javascript" src="<%=basePath%>js/secondary-js/jquery.jqzoom.js"></script>
<script type="text/javascript" src="<%=basePath%>js/secondary-js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>js/secondary-js/common.js"></script>

<script type="text/javascript">
$().ready(function() {

	var $historyProduct = $("#historyProduct ul");
	var $clearHistoryProduct = $("#clearHistoryProduct");
	var $zoom = $("#zoom");
	var $scrollable = $("#scrollable");
	var $thumbnail = $("#scrollable a");
	var $specification = $("#specification dl");
	var $specificationTitle = $("#specification div");
	var $specificationValue = $("#specification a");
	var $productNotifyForm = $("#productNotifyForm");
	var $productNotify = $("#productNotify");
	var $productNotifyEmail = $("#productNotify input");
	var $addProductNotify = $("#addProductNotify");
	var $quantity = $("#quantity");
	var $increase = $("#increase");
	var $decrease = $("#decrease");
	var $addCart = $("#addCart");
	var $addFavorite = $("#addFavorite");
	var $window = $(window);
	var $bar = $("#bar ul");
	var $introductionTab = $("#introductionTab");
	var $parameterTab = $("#parameterTab");
	var $reviewTab = $("#reviewTab");
	var $consultationTab = $("#consultationTab");
	var $introduction = $("#introduction");
	var $parameter = $("#parameter");
	var $review = $("#review");
	var $addReview = $("#addReview");
	var $consultation = $("#consultation");
	var $addConsultation = $("#addConsultation");
	var barTop = $bar.offset().top;
	var productMap = {};
productMap[54] = { path: null, specificationValues: [ "19", "44" ] }; productMap[51] = { path: "/product/content/201301/51.html", specificationValues: [ "19", "47" ] }; productMap[52] = { path: "/product/content/201301/52.html", specificationValues: [ "19", "46" ] }; productMap[53] = { path: "/product/content/201301/53.html", specificationValues: [ "19", "45" ] };	
	// 锁定规格值
	lockSpecificationValue();
	
	// 商品图片放大镜
	$zoom.jqzoom({
		zoomWidth: 368,
		zoomHeight: 368,
		title: false,
		showPreload: false,
		preloadImages: false
	});
	
	// 商品缩略图滚动
	$scrollable.scrollable();
	
	$thumbnail.hover(function() {
		var $this = $(this);
		if ($this.hasClass("current")) {
			return false;
		} else {
			$thumbnail.removeClass("current");
			$this.addClass("current").click();
		}
	});
	
	// 规格值选择
	$specificationValue.click(function() {
		var $this = $(this);
		if ($this.hasClass("locked")) {
			return false;
		}
		$this.toggleClass("selected").parent().siblings().children("a").removeClass("selected");
		var selectedIds = new Array();
		$specificationValue.filter(".selected").each(function(i) {
			selectedIds[i] = $(this).attr("val");
		});
		var locked = true;
		$.each(productMap, function(i, product) {
			if (product.specificationValues.length == selectedIds.length && contains(product.specificationValues, selectedIds)) {
				if (product.path != null) {
					location.href = "" + product.path;
					locked = false;
				}
				return false;
			}
		});
		if (locked) {
			lockSpecificationValue();
		}
		$specificationTitle.hide();
		return false;
	});
	
	// 锁定规格值
	function lockSpecificationValue() {
		var selectedIds = new Array();
		$specificationValue.filter(".selected").each(function(i) {
			selectedIds[i] = $(this).attr("val");
		});
		$specification.each(function() {
			var $this = $(this);
			var selectedId = $this.find("a.selected").attr("val");
			var otherIds = $.grep(selectedIds, function(n, i) {
				return n != selectedId;
			});
			$this.find("a").each(function() {
				var $this = $(this);
				otherIds.push($this.attr("val"));
				var locked = true;
				$.each(productMap, function(i, product) {
					if (contains(product.specificationValues, otherIds)) {
						locked = false;
						return false;
					}
				});
				if (locked) {
					$this.addClass("locked");
				} else {
					$this.removeClass("locked");
				}
				otherIds.pop();
			});
		});
	}
	
	// 判断是否包含
	function contains(array, values) {
		var contains = true;
		for(i in values) {
			if ($.inArray(values[i], array) < 0) {
				contains = false;
				break;
			}
		}
		return contains;
	}
	
	// 到货通知
	$addProductNotify.click(function() {
			var specificationValueIds = new Array();
			$specificationValue.filter(".selected").each(function(i) {
				specificationValueIds[i] = $(this).attr("val");
			});
			if (specificationValueIds.length != 2) {
				$specificationTitle.show();
				return false;
			}
		if ($addProductNotify.val() == "到货通知我") {
			$addProductNotify.val("确定登记");
			$productNotify.show();
			$productNotifyEmail.focus();
			if ($.trim($productNotifyEmail.val()) == "") {
				$.ajax({
					url: "/product_notify/email.jhtml",
					type: "GET",
					dataType: "json",
					cache: false,
					success: function(data) {
						$productNotifyEmail.val(data.email);
					}
				});
			}
		} else {
			$productNotifyForm.submit();
		}
		return false;
	});
	
	// 到货通知表单验证
	$productNotifyForm.validate({
		rules: {
			email: {
				required: true,
				email: true
			}
		},
		submitHandler: function(form) {
			$.ajax({
				url: "/product_notify/save.jhtml",
				type: "POST",
				data: {productId: 54, email: $productNotifyEmail.val()},
				dataType: "json",
				cache: false,
				beforeSend: function() {
					$addProductNotify.prop("disabled", true);
				},
				success: function(data) {
					if (data.message.type == "success") {
						$addProductNotify.val("到货通知我");
						$productNotify.hide();
					}
					$.message(data.message);
				},
				complete: function() {
					$addProductNotify.prop("disabled", false);
				}
			});
		}
	});
	
	// 购买数量
	$quantity.keypress(function(event) {
		var key = event.keyCode ? event.keyCode : event.which;
		if ((key >= 48 && key <= 57) || key==8) {
			return true;
		} else {
			return false;
		}
	});
	
	// 增加购买数量
	$increase.click(function() {
		var quantity = $quantity.val();
		if (/^\d*[1-9]\d*$/.test(quantity)) {
			$quantity.val(parseInt(quantity) + 1);
		} else {
			$quantity.val(1);
		}
	});
	
	// 减少购买数量
	$decrease.click(function() {
		var quantity = $quantity.val();
		if (/^\d*[1-9]\d*$/.test(quantity) && parseInt(quantity) > 1) {
			$quantity.val(parseInt(quantity) - 1);
		} else {
			$quantity.val(1);
		}
	});
	
	// 加入购物车
	$addCart.click(function() {
			var specificationValueIds = new Array();
			$specificationValue.filter(".selected").each(function(i) {
				specificationValueIds[i] = $(this).attr("val");
			});
			if (specificationValueIds.length != 2) {
				$specificationTitle.show();
				return false;
			}
		var quantity = $quantity.val();
		if (/^\d*[1-9]\d*$/.test(quantity) && parseInt(quantity) > 0) {
			$.ajax({
				url: "/cart/add.jhtml",
				type: "POST",
				data: {id: 54, quantity: quantity},
				dataType: "json",
				cache: false,
				success: function(message) {
					$.message(message);
				}
			});
		} else {
			$.message("warn", "购买数量必须为正整数");
		}
	});
	
	// 添加商品收藏
	$addFavorite.click(function() {
		$.ajax({
			url: "/member/favorite/add.jhtml?id=54",
			type: "POST",
			dataType: "json",
			cache: false,
			success: function(message) {
				$.message(message);
			}
		});
		return false;
	});
	
	$window.scroll(function() {
		var scrollTop = $(this).scrollTop();
		if (scrollTop > barTop) {
			if (window.XMLHttpRequest) {
				$bar.css({position: "fixed", top: 0});
			} else {
				$bar.css({top: scrollTop});
			}
			var introductionTop = $introduction.size() > 0 ? $introduction.offset().top - 36 : null;
			var parameterTop = $parameter.size() > 0 ? $parameter.offset().top - 36 : null;
			var reviewTop = $review.size() > 0 ? $review.offset().top - 36 : null;
			var consultationTop = $consultation.size() > 0 ? $consultation.offset().top - 36 : null;
			if (consultationTop != null && scrollTop >= consultationTop) {
				$bar.find("li").removeClass("current");
				$consultationTab.addClass("current");
			} else if (reviewTop != null && scrollTop >= reviewTop) {
				$bar.find("li").removeClass("current");
				$reviewTab.addClass("current");
			} else if (parameterTop != null && scrollTop >= parameterTop) {
				$bar.find("li").removeClass("current");
				$parameterTab.addClass("current");
			} else if (introductionTop != null && scrollTop >= introductionTop) {
				$bar.find("li").removeClass("current");
				$introductionTab.addClass("current");
			}
		} else {
			$bar.find("li").removeClass("current");
			$bar.css({position: "absolute", top: barTop});
		}
	});
	
		// 发表商品评论
		$addReview.click(function() {
			if ($.checkLogin()) {
				return true;
			} else {
				$.redirectLogin("/review/add/54.jhtml", "必须登录后才能发表商品评论");
				return false;
			}
		});
	
		// 发表商品咨询
		$addConsultation.click(function() {
			if ($.checkLogin()) {
				return true;
			} else {
				$.redirectLogin("/consultation/add/54.jhtml", "必须登录后才能发表商品咨询");
				return false;
			}
		});
	
	// 浏览记录
	var historyProduct = getCookie("historyProduct");
	var historyProductIds = historyProduct != null ? historyProduct.split(",") : new Array();
	for (var i = 0; i < historyProductIds.length; i ++) {
		if (historyProductIds[i] == "54") {
			historyProductIds.splice(i, 1);
			break;
		}
	}
	historyProductIds.unshift("54");
	if (historyProductIds.length > 6) {
		historyProductIds.pop();
	}
	addCookie("historyProduct", historyProductIds.join(","), {path: "/"});
	$.ajax({
		url: "/product/history.jhtml",
		type: "GET",
		data: {ids: historyProductIds},
		dataType: "json",
		traditional: true,
		cache: false,
		success: function(data) {
			$.each(data, function (index, product) {
				var thumbnail = product.thumbnail != null ? product.thumbnail : "/upload/image/default_thumbnail.jpg";
				$historyProduct.append('<li><img src="' + thumbnail + '" \/><a href="' + product.path + '">' + product.name + '<\/a><span>' + currency(product.price, true) + '<\/span><\/li>');
			});
		}
	});
	
	// 清空浏览记录
	$clearHistoryProduct.click(function() {
		$historyProduct.empty();
		$(this).text("暂无记录");
		removeCookie("historyProduct", {path: "/"});
	});
	
	// 点击数
	$.ajax({
		url: "/product/hits/54.jhtml",
		type: "GET"
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
	
</div>	<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
						<dl>
							<dt>
								<a href="/product/list/1.jhtml">时尚女装</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">连衣裙</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">针织衫</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">短外套</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">小西装</a>
									</dd>
						</dl>
						<dl>
							<dt>
								<a href="http://www.baidu.com">精品男装</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">针织衫</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">POLO衫</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">休闲裤</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">牛仔裤</a>
									</dd>
						</dl>
						<dl>
							<dt>
								<a href="http://www.baidu.com">精致内衣</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">女式内裤</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">男式内裤</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">保暖内衣</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">塑身衣</a>
									</dd>
						</dl>
						<dl>
							<dt>
								<a href="http://www.baidu.com">服饰配件</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">女士腰带</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">男士皮带</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">女士围巾</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">男士围巾</a>
									</dd>
						</dl>
						<dl>
							<dt>
								<a href="http://www.baidu.com">时尚女鞋</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">高帮鞋</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">雪地靴</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">中筒靴</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">单鞋</a>
									</dd>
						</dl>
						<dl>
							<dt>
								<a href="http://www.baidu.com">流行男鞋</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">低帮鞋</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">高帮鞋</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">休闲鞋</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">正装鞋</a>
									</dd>
						</dl>
						<dl>
							<dt>
								<a href="http://www.baidu.com">潮流女包</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">单肩包</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">双肩包</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">手提包</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">手拿包</a>
									</dd>
						</dl>
						<dl>
							<dt>
								<a href="http://www.baidu.com">精品男包</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">单肩男</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">双肩包</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">手提包</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">手拿包</a>
									</dd>
						</dl>
						<dl>
							<dt>
								<a href="http://www.baidu.com">童装童鞋</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">运动鞋</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">牛仔裤</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">套装</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">裤子</a>
									</dd>
						</dl>
						<dl class="last">
							<dt>
								<a href="http://www.baidu.com">时尚饰品</a>
							</dt>
									<dd>
										<a href="http://www.baidu.com">项链</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">手链</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">戒指</a>
									</dd>
									<dd>
										<a href="http://www.baidu.com">耳饰</a>
									</dd>
						</dl>
			</div>
			<div class="hotProduct">
				<div class="title">热销商品</div>
				<ul>
							<li>
								<a href="http://www.baidu.com" title="梵希蔓2013夏装新款大码品质女装蕾丝连衣裙夏季蛋糕裙短袖连衣裙">梵希蔓2013夏装新款大码品质女装</a>
									<div>
										<div>评分: </div>
										<div class="score8"></div>
										<div>4.0</div>
									</div>
								<div>销售价: <strong>￥209.00元</strong></div>
								<div>月销量: <em>0</em></div>
							</li>
							<li>
								<a href="http://www.baidu.com" title="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰">梵希蔓2013夏装淑女连衣裙雪纺刺</a>
									<div>
										<div>评分: </div>
										<div class="score10"></div>
										<div>5.0</div>
									</div>
								<div>销售价: <strong>￥288.00元</strong></div>
								<div>月销量: <em>0</em></div>
							</li>
							<li>
								<a href="http://www.baidu.com" title="唯维欣怡2013春夏季新款波西米亚女装中长款百褶蕾丝雪纺连衣裙子">唯维欣怡2013春夏季新款波西米亚</a>
									<div>
										<div>评分: </div>
										<div class="score10"></div>
										<div>5.0</div>
									</div>
								<div>销售价: <strong>￥268.99元</strong></div>
								<div>月销量: <em>0</em></div>
							</li>
							<li>
								<a href="http://www.baidu.com" title="尚都比拉2013夏装新款 春款甜美淑女装 荷叶袖修身蕾丝雪纺连衣裙">尚都比拉2013夏装新款 春款甜美淑</a>
									<div>
										<div>评分: </div>
										<div class="score10"></div>
										<div>5.0</div>
									</div>
								<div>销售价: <strong>￥269.00元</strong></div>
								<div>月销量: <em>0</em></div>
							</li>
							<li>
								<a href="http://www.baidu.com" title="尚都比拉2013夏装新款淑女装 春款森女系 碎花修身短袖蕾丝连衣裙">尚都比拉2013夏装新款淑女装 春款</a>
									<div>
										<div>评分: </div>
										<div class="score8"></div>
										<div>4.0</div>
									</div>
								<div>销售价: <strong>￥289.00元</strong></div>
								<div>月销量: <em>0</em></div>
							</li>
							<li class="last">
								<a href="http://www.baidu.com" title="梵希蔓 2013新款女装春装白色蕾丝连衣裙长袖大摆裙纱网连衣裙">梵希蔓 2013新款女装春装白色蕾丝</a>
									<div>
										<div>评分: </div>
										<div class="score10"></div>
										<div>5.0</div>
									</div>
								<div>销售价: <strong>￥238.00元</strong></div>
								<div>月销量: <em>0</em></div>
							</li>
				</ul>
			</div>
			<div id="historyProduct" class="historyProduct">
				<div class="title">最近浏览过的</div>
				<ul></ul>
				<a href="javascript:;" id="clearHistoryProduct" class="clearHistoryProduct">清除历史记录</a>
			</div>
		</div>
		<div class="span18 last">
			<div class="path">
				<ul>
					<li>
						<a href="http://www.baidu.com">首页</a>
					</li>
							<li>
								<a href="http://www.baidu.com">时尚女装</a>
							</li>
					<li>
						<a href="http://www.baidu.com">连衣裙</a>
					</li>
				</ul>
			</div>
			<div class="productImage">
					<a id="zoom" href="http://storage.shopxx.net/demo-image/3.0/201301/92a7bf42-6294-44a7-b518-19a77186d380-large.jpg" rel="gallery">
						<img class="medium" src="http://storage.shopxx.net/demo-image/3.0/201301/92a7bf42-6294-44a7-b518-19a77186d380-medium.jpg" />
					</a>
				<a href="javascript:;" class="prev"></a>
				<div id="scrollable" class="scrollable">
					<div class="items">
								<a class="current" href="javascript:;" rel="{gallery: 'gallery', smallimage: 'http://storage.shopxx.net/demo-image/3.0/201301/92a7bf42-6294-44a7-b518-19a77186d380-medium.jpg', largeimage: 'http://storage.shopxx.net/demo-image/3.0/201301/92a7bf42-6294-44a7-b518-19a77186d380-large.jpg'}"><img src="http://storage.shopxx.net/demo-image/3.0/201301/92a7bf42-6294-44a7-b518-19a77186d380-thumbnail.jpg" title="" /></a>
								<a href="javascript:;" rel="{gallery: 'gallery', smallimage: 'http://storage.shopxx.net/demo-image/3.0/201301/cd0d0c32-a641-44fc-b780-c144db4dd7e8-medium.jpg', largeimage: 'http://storage.shopxx.net/demo-image/3.0/201301/cd0d0c32-a641-44fc-b780-c144db4dd7e8-large.jpg'}"><img src="http://storage.shopxx.net/demo-image/3.0/201301/cd0d0c32-a641-44fc-b780-c144db4dd7e8-thumbnail.jpg" title="" /></a>					</div>
				</div>
				<a href="javascript:;" class="next"></a>
			</div>
			<div class="name">梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰</div>
			<div class="sn">
				<div>编号: 201304151</div>
					<div>评分:</div>
					<div class="score10"></div>
					<div>5.0 (评分数: 1)</div>
			</div>
			<div class="info">
				<dl>
					<dt>销售价:</dt>
					<dd>
						<strong>￥288.00</strong>
							市场价:
							<del>￥345.60</del>
					</dd>
				</dl>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a href="/promotion/content/1.jhtml" target="_blank" title="2013-01-01 ~ 2015-01-01">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>赠送积分:</dt>
						<dd>
							<span>288</span>
						</dd>
					</dl>
			</div>
				<div class="action">
						<div id="specification" class="specification clearfix">
							<div class="title">请选择商品规格</div>
								<dl>
									<dt>
										<span title="颜色">颜色:</span>
									</dt>
											<dd>
												<a href="javascript:;" class="image selected" val="19"><img src="http://storage.shopxx.net/demo-image/3.0/specification/19.gif" alt="米黄色" title="米黄色" /><span title="点击取消选择">&nbsp;</span></a>											</dd>
								</dl>
								<dl>
									<dt>
										<span title="尺码">尺码:</span>
									</dt>
											<dd>
												<a href="javascript:;" class="text selected" val="44">S<span title="点击取消选择">&nbsp;</span></a>											</dd>
											<dd>
												<a href="javascript:;" class="text" val="45">M<span title="点击取消选择">&nbsp;</span></a>											</dd>
											<dd>
												<a href="javascript:;" class="text" val="46">L<span title="点击取消选择">&nbsp;</span></a>											</dd>
											<dd>
												<a href="javascript:;" class="text" val="47">XL<span title="点击取消选择">&nbsp;</span></a>											</dd>
								</dl>
						</div>
						<dl class="quantity">
							<dt>购买数量:</dt>
							<dd>
								<input type="text" id="quantity" name="quantity" value="1" maxlength="4" onpaste="return false;" />
								<div>
									<span id="increase" class="increase">&nbsp;</span>
									<span id="decrease" class="decrease">&nbsp;</span>
								</div>
							</dd>
							<dd>
								件
							</dd>
						</dl>
					<div class="buy">
							<input type="button" id="addCart" class="addCart" value="加入购物车" />
						<a href="javascript:;" id="addFavorite">收藏商品</a>
					</div>
				</div>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">商品介绍</a>
						</li>
						<li id="parameterTab">
							<a href="#parameter">商品参数</a>
						</li>
						<li id="reviewTab">
							<a href="#review">商品评论</a>
						</li>
						<li id="consultationTab">
							<a href="#consultation">商品咨询</a>
						</li>
				</ul>
			</div>
				<table class="brief">
							<tr>
						<th>裙长</th>
						<td>
							<span title="短裙(76-90厘米)">短裙(76-90厘米)</span>
						</td>
						<th>主材质</th>
						<td>
							<span title="聚酯纤维">聚酯纤维</span>
						</td>
						<th>领型</th>
						<td>
							<span title="圆领">圆领</span>
						</td>
							</tr>
							<tr>
						<th>袖长</th>
						<td>
							<span title="无袖/背心裙">无袖/背心裙</span>
						</td>
						<th>款式</th>
						<td>
							<span title="其他款式">其他款式</span>
						</td>
						<th>组合形式</th>
						<td>
							<span title="单件">单件</span>
						</td>
							</tr>
				</table>
				<div id="introduction" name="introduction" class="introduction">
					<div class="title">
						<strong>商品介绍</strong>
					</div>
					<div>
						<img alt="" src="http://storage.shopxx.net/demo-image/3.0/201301/d24042c7-74f7-4831-b38b-6531c15e0a03.jpg" />
					</div>
				</div>
				<div id="parameter" name="parameter" class="parameter">
					<div class="title">
						<strong>商品参数</strong>
					</div>
					<table>
							<tr>
								<th class="group" colspan="2">基本参数</th>
							</tr>
									<tr>
										<th>风格</th>
										<td>通勤</td>
									</tr>
									<tr>
										<th>通勤</th>
										<td>淑女</td>
									</tr>
									<tr>
										<th>组合形式</th>
										<td>单件</td>
									</tr>
									<tr>
										<th>裙长</th>
										<td>短裙(76-90厘米)</td>
									</tr>
									<tr>
										<th>款式</th>
										<td>其他款式</td>
									</tr>
									<tr>
										<th>袖长</th>
										<td>无袖/背心裙</td>
									</tr>
									<tr>
										<th>领型</th>
										<td>圆领</td>
									</tr>
									<tr>
										<th>腰型</th>
										<td>高腰</td>
									</tr>
									<tr>
										<th>衣门襟</th>
										<td>套头</td>
									</tr>
									<tr>
										<th>裙型</th>
										<td>荷叶边裙</td>
									</tr>
									<tr>
										<th>图案</th>
										<td>其它图案</td>
									</tr>
									<tr>
										<th>流行元素/工艺</th>
										<td>荷叶边 刺绣/绣花 拼贴</td>
									</tr>
									<tr>
										<th>材质</th>
										<td>雪纺</td>
									</tr>
									<tr>
										<th>主成份含量</th>
										<td>95%以上</td>
									</tr>
									<tr>
										<th>主材质</th>
										<td>聚酯纤维</td>
									</tr>
					</table>
				</div>
				<div id="review" name="review" class="review">
					<div class="title">商品评论</div>
					<div class="content clearfix">
							<div class="score">
								<strong>5.0</strong>
								<div>
									<div class="score10"></div>
									<div>评分数: 1</div>
								</div>
							</div>
							<div class="graph">
								<span style="width: 100.0%" id="satisfaction">
									<em></em>
								</span>
								<div >&nbsp;</div>
								<ul>
									<li>非常不满</li>
									<li>不满意</li>
									<li>一般</li>
									<li>满意</li>
									<li>非常满意</li>
								</ul>
							</div>
							<div class="handle">
								<a href="/review/add/54.jhtml" id="addReview">发表商品评论</a>
							</div>
									<table>
											<tr>
												<th>
													很满意的一款裙子，做工很好，很淑女哦，尺码也非常合适，裙子好漂亮，我好喜欢，穿上身也特别美(*^__^*) 嘻嘻……
													<div class="score10"></div>
												</th>
												<td>
														游客
													<span title="2013-01-01 15:20:18">2013-01-01</span>
												</td>
											</tr>
									</table>
									<p>
										<a href="/review/content/54.jhtml">[查看所有评论]</a>
									</p>
					</div>
				</div>
				<div id="consultation" name="consultation" class="consultation">
					<div class="title">商品咨询</div>
					<div class="content">
								<p>
									暂无商品咨询信息 <a href="/consultation/add/54.jhtml" id="addConsultation">[发表商品咨询]</a>
								</p>
					</div>
				</div>
		</div>
	</div>
<div class="container footer">
<jsp:include page="footpage.jsp"></jsp:include>
</div></body>
</html>