<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰 - Powered By SHOP++</title>
<meta name="author" content="hglq Team" />
<meta name="copyright" content="hglq4" />
<meta name="keywords" content="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰" />
<meta name="description" content="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰" />

<link href="<%=basePath%>css/secondary.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/jingpinnvzhuang.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../js/womenjs/jquery.js"></script>
<script type="text/javascript" src="../js/womenjs/lazyload.js"></script>
<script type="text/javascript" src="../js/womenjs/common.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $productForm = $("#productForm");
	var $brandId = $("#brandId");
	var $promotionId = $("#promotionId");
	var $orderType = $("#orderType");
	var $pageNumber = $("#pageNumber");
	var $pageSize = $("#pageSize");
	var $filter = $("#filter dl");
	var $lastFilter = $("#filter dl:eq(2)");
	var $hiddenFilter = $("#filter dl:gt(2)");
	var $moreOption = $("#filter dd.moreOption");
	var $moreFilter = $("#moreFilter a");
	var $tableType = $("#tableType");
	var $listType = $("#listType");
	var $orderSelect = $("#orderSelect");
	var $brand = $("#filter a.brand");
	var $attribute = $("#filter a.attribute");
	var $previousPage = $("#previousPage");
	var $nextPage = $("#nextPage");
	var $size = $("#layout a.size");
	var $tagIds = $("input[name='tagIds']");
	var $sort = $("#sort a");
	var $startPrice = $("#startPrice");
	var $endPrice = $("#endPrice");
	var $result = $("#result");
	var $productImage = $("#result img");
	
		$filter.each(function() {
			var $this = $(this);
			var height = $this.height();
			if (height > 30) {
				$this.find("dt").height(height);
				if ($this.find("a.current").size() == 0) {
					$this.height(30);
					$this.find(".moreOption").show();
				}
			}
		});
		
		$moreOption.click(function() {
			var $this = $(this);
			if ($this.hasClass("close")) {
				$this.removeClass("close");
				$this.attr("title", "更多");
				$this.parent().height(30);
			} else {
				$this.addClass("close");
				$this.attr("title", "收起");
				$this.parent().height("auto");
			}
		});
		
		$moreFilter.click(function() {
			var $this = $(this);
			if ($this.hasClass("close")) {
				$this.removeClass("close");
				$this.text("更多选项");
				$lastFilter.addClass("last");
				$hiddenFilter.hide();
			} else {
				$this.addClass("close");
				$this.text("收起选项");
				$lastFilter.removeClass("last");
				$hiddenFilter.show();
			}
		});
		
		$brand.click(function() {
			var $this = $(this);
			if ($this.hasClass("current")) {
				$brandId.val("");
			} else {
				$brandId.val($this.attr("brandId"));
			}
			$pageNumber.val(1);
			$productForm.submit();
			return false;
		});
		
		$attribute.click(function() {
			var $this = $(this);
			if ($this.hasClass("current")) {
				$this.closest("dl").find("input").prop("disabled", true);
			} else {
				$this.closest("dl").find("input").prop("disabled", false).val($this.text());
			}
			$pageNumber.val(1);
			$productForm.submit();
			return false;
		});
	
	var layoutType = getCookie("layoutType");
	if (layoutType == "listType") {
		$listType.addClass("currentList");
		$result.removeClass("table").addClass("list");
	} else {
		$tableType.addClass("currentTable");
		$result.removeClass("list").addClass("table");
	}
	
	$tableType.click(function() {
		var $this = $(this);
		if (!$this.hasClass("currentTable")) {
			$this.addClass("currentTable");
			$listType.removeClass("currentList");
			$result.removeClass("list").addClass("table");
			addCookie("layoutType", "tableType", {path: "/"});
		}
	});
	
	$listType.click(function() {
		var $this = $(this);
		if (!$this.hasClass("currentList")) {
			$this.addClass("currentList");
			$tableType.removeClass("currentTable");
			$result.removeClass("table").addClass("list");
			addCookie("layoutType", "listType", {path: "/"});
		}
	});
	
	$size.click(function() {
		var $this = $(this);
		$pageNumber.val(1);
		$pageSize.val($this.attr("pageSize"));
		$productForm.submit();
		return false;
	});
	
	$previousPage.click(function() {
		$pageNumber.val(0);
		$productForm.submit();
		return false;
	});
	
	$nextPage.click(function() {
		$pageNumber.val(2);
		$productForm.submit();
		return false;
	});
	
	$orderSelect.mouseover(function() {
		var $this = $(this);
		var offset = $this.offset();
		var $menuWrap = $this.closest("div.orderSelect");
		var $popupMenu = $menuWrap.children("div.popupMenu");
		$popupMenu.css({left: offset.left, top: offset.top + $this.height()}).show();
		$menuWrap.mouseleave(function() {
			$popupMenu.hide();
		});
	});
	
	$tagIds.click(function() {
		$pageNumber.val(1);
		$productForm.submit();
	});
	
	$sort.click(function() {
		var $this = $(this);
		if ($this.hasClass("current")) {
			$orderType.val("");
		} else {
			$orderType.val($this.attr("orderType"));
		}
		$pageNumber.val(1);
		$productForm.submit();
		return false;
	});
	
	$startPrice.add($endPrice).focus(function() {
		$(this).siblings("button").show();
	});
	
	$startPrice.add($endPrice).keypress(function(event) {
		var $this = $(this);
		var key = event.keyCode?event.keyCode:event.which;
		if (key == 13 || (key >= 48 && key <= 57) || (key == 46 && $this.val().indexOf(".") == -1)) {
			return true;
		} else {
			return false;
		}
	});
	
	$productForm.submit(function() {
		if ($brandId.val() == "") {
			$brandId.prop("disabled", true)
		}
		if ($promotionId.val() == "") {
			$promotionId.prop("disabled", true)
		}
		if ($orderType.val() == "" || $orderType.val() == "topDesc") {
			$orderType.prop("disabled", true)
		}
		if ($pageNumber.val() == "" || $pageNumber.val() == "1") {
			$pageNumber.prop("disabled", true)
		}
		if ($pageSize.val() == "" || $pageSize.val() == "20") {
			$pageSize.prop("disabled", true)
		}
		if ($startPrice.val() == "" || !/^\d+(\.\d+)?$/.test($startPrice.val())) {
			$startPrice.prop("disabled", true)
		}
		if ($endPrice.val() == "" || !/^\d+(\.\d+)?$/.test($endPrice.val())) {
			$endPrice.prop("disabled", true)
		}
	});
	
	$productImage.lazyload({
		threshold: 100,
		effect: "fadeIn"
	});
	
	$.pageSkip = function(pageNumber) {
		$pageNumber.val(pageNumber);
		$productForm.submit();
		return false;
	}
	
});
</script>
</head>

<body>
    <div class="container header">
		<jsp:include page="head.jsp"></jsp:include>
	</div>
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<dl>
					<dt>
						<a href="<%=basePath%>jsp/womendress.jsp">时尚女装</a>
					</dt>
					<dd>
						<a href="/product/list/11.jhtml">连衣裙</a>
					</dd>
					<dd>
						<a href="/product/list/12.jhtml">针织衫</a>
					</dd>
					<dd>
						<a href="/product/list/13.jhtml">短外套</a>
					</dd>
					<dd>
						<a href="/product/list/14.jhtml">小西装</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/2.jhtml">精品男装</a>
					</dt>
					<dd>
						<a href="/product/list/21.jhtml">针织衫</a>
					</dd>
					<dd>
						<a href="/product/list/22.jhtml">POLO衫</a>
					</dd>
					<dd>
						<a href="/product/list/23.jhtml">休闲裤</a>
					</dd>
					<dd>
						<a href="/product/list/24.jhtml">牛仔裤</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/3.jhtml">精致内衣</a>
					</dt>
					<dd>
						<a href="/product/list/31.jhtml">女式内裤</a>
					</dd>
					<dd>
						<a href="/product/list/32.jhtml">男式内裤</a>
					</dd>
					<dd>
						<a href="/product/list/33.jhtml">保暖内衣</a>
					</dd>
					<dd>
						<a href="/product/list/34.jhtml">塑身衣</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/4.jhtml">服饰配件</a>
					</dt>
					<dd>
						<a href="/product/list/41.jhtml">女士腰带</a>
					</dd>
					<dd>
						<a href="/product/list/42.jhtml">男士皮带</a>
					</dd>
					<dd>
						<a href="/product/list/43.jhtml">女士围巾</a>
					</dd>
					<dd>
						<a href="/product/list/44.jhtml">男士围巾</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/5.jhtml">时尚女鞋</a>
					</dt>
					<dd>
						<a href="/product/list/51.jhtml">高帮鞋</a>
					</dd>
					<dd>
						<a href="/product/list/52.jhtml">雪地靴</a>
					</dd>
					<dd>
						<a href="/product/list/53.jhtml">中筒靴</a>
					</dd>
					<dd>
						<a href="/product/list/54.jhtml">单鞋</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/6.jhtml">流行男鞋</a>
					</dt>
					<dd>
						<a href="/product/list/59.jhtml">低帮鞋</a>
					</dd>
					<dd>
						<a href="/product/list/60.jhtml">高帮鞋</a>
					</dd>
					<dd>
						<a href="/product/list/61.jhtml">休闲鞋</a>
					</dd>
					<dd>
						<a href="/product/list/62.jhtml">正装鞋</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/7.jhtml">潮流女包</a>
					</dt>
					<dd>
						<a href="/product/list/63.jhtml">单肩包</a>
					</dd>
					<dd>
						<a href="/product/list/64.jhtml">双肩包</a>
					</dd>
					<dd>
						<a href="/product/list/65.jhtml">手提包</a>
					</dd>
					<dd>
						<a href="/product/list/66.jhtml">手拿包</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/8.jhtml">精品男包</a>
					</dt>
					<dd>
						<a href="/product/list/67.jhtml">单肩男</a>
					</dd>
					<dd>
						<a href="/product/list/68.jhtml">双肩包</a>
					</dd>
					<dd>
						<a href="/product/list/69.jhtml">手提包</a>
					</dd>
					<dd>
						<a href="/product/list/70.jhtml">手拿包</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/9.jhtml">童装童鞋</a>
					</dt>
					<dd>
						<a href="/product/list/71.jhtml">运动鞋</a>
					</dd>
					<dd>
						<a href="/product/list/72.jhtml">牛仔裤</a>
					</dd>
					<dd>
						<a href="/product/list/73.jhtml">套装</a>
					</dd>
					<dd>
						<a href="/product/list/74.jhtml">裤子</a>
					</dd>
				</dl>
				<dl class="last">
					<dt>
						<a href="/product/list/10.jhtml">时尚饰品</a>
					</dt>
					<dd>
						<a href="/product/list/75.jhtml">项链</a>
					</dd>
					<dd>
						<a href="/product/list/76.jhtml">手链</a>
					</dd>
					<dd>
						<a href="/product/list/77.jhtml">戒指</a>
					</dd>
					<dd>
						<a href="/product/list/78.jhtml">耳饰</a>
					</dd>
				</dl>
			</div>
			<div class="hotProduct">
				<div class="title">热销商品</div>
				<ul>
					<li><a href="/product/content/201301/76.html"
						title="梵希蔓2013夏装新款大码品质女装蕾丝连衣裙夏季蛋糕裙短袖连衣裙">梵希蔓2013夏装新款大码品质女装</a>
						<div>
							<div>评分:</div>
							<div class="score8"></div>
							<div>4.0</div>
						</div>
						<div>
							销售价: <strong>￥209.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li><a href="/product/content/201301/54.html"
						title="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰">梵希蔓2013夏装淑女连衣裙雪纺刺</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥288.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li><a href="/product/content/201301/271.html"
						title="唯维欣怡2013春夏季新款波西米亚女装中长款百褶蕾丝雪纺连衣裙子">唯维欣怡2013春夏季新款波西米亚</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥268.99元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li><a href="/product/content/201301/282.html"
						title="尚都比拉2013夏装新款 春款甜美淑女装 荷叶袖修身蕾丝雪纺连衣裙">尚都比拉2013夏装新款 春款甜美淑</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥269.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li><a href="/product/content/201301/298.html"
						title="尚都比拉2013夏装新款淑女装 春款森女系 碎花修身短袖蕾丝连衣裙">尚都比拉2013夏装新款淑女装 春款</a>
						<div>
							<div>评分:</div>
							<div class="score8"></div>
							<div>4.0</div>
						</div>
						<div>
							销售价: <strong>￥289.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li class="last"><a href="/product/content/201301/50.html"
						title="梵希蔓 2013新款女装春装白色蕾丝连衣裙长袖大摆裙纱网连衣裙">梵希蔓 2013新款女装春装白色蕾丝</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥238.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
				</ul>
			</div>
			<div id="historyProduct" class="historyProduct">
				<div class="title">最近浏览过的</div>
				<ul></ul>
				<a href="javascript:;" id="clearHistoryProduct"
					class="clearHistoryProduct">清除历史记录</a>
			</div>
		</div>
		
		
				<div class="span18 last">
			<div class="path">
				<ul>
					<li>
						<a href="/">首页</a>
					</li>
						<li class="last">精品男装</li>
				</ul>
			</div>
			<form id="productForm" action="/product/list/1.jhtml" method="get">
				<input type="hidden" id="brandId" name="brandId" value="" />
				<input type="hidden" id="promotionId" name="promotionId" value="" />
				<input type="hidden" id="orderType" name="orderType" value="" />
				<input type="hidden" id="pageNumber" name="pageNumber" value="1" />
				<input type="hidden" id="pageSize" name="pageSize" value="20" />
					<div id="filter" class="filter">
						<div class="title">筛选商品</div>
						<div class="content clearfix">
								<dl class="last">
									<dt>分类:</dt>
										<dd>
											<a href="/product/list/11.jhtml">针织衫</a>										</dd>
										<dd>
											<a href="/product/list/12.jhtml">POTO杉</a>										</dd>
										<dd>
											<a href="/product/list/13.jhtml">休闲裤</a>										</dd>
										<dd>
											<a href="/product/list/14.jhtml">牛仔裤</a>										</dd>
										<dd>
											<a href="/product/list/15.jhtml">T恤</a>										</dd>
										<dd>
											<a href="/product/list/16.jhtml">衬衫</a>										</dd>
										<dd>
											<a href="/product/list/17.jhtml">西装</a>										</dd>
										<dd>
											<a href="/product/list/18.jhtml">风衣</a>										</dd>
										<dd>
											<a href="/product/list/19.jhtml">卫衣</a>										</dd>
										<dd>
											<a href="/product/list/20.jhtml">裤子</a>										</dd>
									<dd class="moreOption" title="更多">&nbsp;</dd>
								</dl>
						</div>

					</div>
				<div class="bar">
					<div id="layout" class="layout">
						<label>布局:</label>
						<a href="javascript:;" id="tableType" class="tableType">
							<span>&nbsp;</span>
						</a>
						<a href="javascript:;" id="listType" class="listType">
							<span>&nbsp;</span>
						</a>
						<label>数量:</label>
						<a href="javascript:;" class="size current" >
							<span>20</span>
						</a>
						<a href="javascript:;" class="size" >
							<span>40</span>
						</a>
						<a href="javascript:;" class="size" >
							<span>80</span>
						</a>
						<span class="page">

						</span>
					</div>
					<div id="sort" class="sort">
						<div id="orderSelect" class="orderSelect">
								<span>置顶降序</span>
							<div class="popupMenu">
								<ul>
										<li>
											<a href="javascript:;" >置顶降序</a>										</li>
										<li>
											<a href="javascript:;" >价格升序</a>										</li>
										<li>
											<a href="javascript:;" >价格降序</a>										</li>
										<li>
											<a href="javascript:;" >销量降序</a>										</li>
										<li>
											<a href="javascript:;" >评分降序</a>										</li>
										<li>
											<a href="javascript:;" >日期降序</a>										</li>
								</ul>
							</div>
						</div>
						<a href="javascript:;" class="asc" >价格</a>
						<a href="javascript:;" class="desc">销量</a>
						<a href="javascript:;" class="desc" >评分</a>
						<input type="text" id="startPrice" name="startPrice" class="startPrice" value="" maxlength="16" title="价格过滤最低价格" onpaste="return false" />-<input type="text" id="endPrice" name="endPrice" class="endPrice" value="" maxlength="16" title="价格过滤最高价格" onpaste="return false" />
						<button type="submit">确&nbsp;&nbsp;定</button>
					</div>
					<div class="tag">
						<label>只查看:</label>
								<label>
									<input type="checkbox" name="tagIds" value="1" />热销
								</label>
								<label>
									<input type="checkbox" name="tagIds" value="2" />最新
								</label>
					</div>
				</div>
				<div id="result" class="result table clearfix">
						<ul>
								

									<li>
										<a href="/product/content/201306/66.html">
											<img src="../images/dress/product_m1.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/cae1bc6b-0159-4ce0-9a9c-4926df231b4f-thumbnail.jpg" />
											<span class="price">
												￥453.00
													<del>￥543.60</del>
											</span>
											<span title="Max Toney 春装男士休闲西服便西装 时尚修身外套小西装 男 229">Max Toney 春装男士休闲西服便西装 时尚修身外套小西装 男 229</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/150.html">
											<img src="../images/dress/product_m2.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/ca3043f5-dbb0-4a03-9bb6-8274f78b5d7e-thumbnail.jpg" />
											<span class="price">
												￥325.00
													<del>￥390.00</del>
											</span>
											<span title="JackJones杰克琼斯男士立领拉链机车夹克B212121038">JackJones杰克琼斯男士立领拉链机车夹克B212121038</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/91.html">
											<img src="../images/dress/product_m3.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/7b3c0647-1016-4d13-8b84-4d63818e1179-thumbnail.jpg" />
											<span class="price">
												￥203.00
													<del>￥243.60</del>
											</span>
											<span title="夏装新品179 与狼共舞短袖T恤 气质拼接 男装正品 翻领修身6614">夏装新品179 与狼共舞短袖T恤 气质拼接 男装正品 翻领修身6614</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/108.html">
											<img src="../images/dress/product_m4.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/1677d34a-0983-4b00-930a-7da65fe2475b-thumbnail.jpg" />
											<span class="price">
												￥489.00
													<del>￥586.80</del>
											</span>
											<span title="2013春夏柒牌男装官方正品男士商务印花短袖T恤衫802T504280">2013春夏柒牌男装官方正品男士商务印花短袖T恤衫802T504280</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/42.html">
											<img src="../images/dress/product_m5.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/b998f840-91fc-41b6-b73d-70587babf760-thumbnail.jpg" />
											<span class="price">
												￥74.00
													<del>￥88.80</del>
											</span>
											<span title="Max Toney 春装时尚休闲多层卷边领莱卡棉T恤 男 长袖T恤 599">Max Toney 春装时尚休闲多层卷边领莱卡棉T恤 男 长袖T恤 599</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/46.html">
											<img src="../images/dress/product_m6.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/3c79f82f-f136-48aa-9e81-7e10fbb3de2a-thumbnail.jpg" />
											<span class="price">
												￥420.00
													<del>￥504.00</del>
											</span>
											<span title="Max Toney奢华春装 单扣高档全羊毛休闲西装西服 男 219">Max Toney奢华春装 单扣高档全羊毛休闲西装西服 男 219</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/58.html">
											<img src="../images/dress/product_m7.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/40e34b2d-d240-446e-9874-89969edbe89f-thumbnail.jpg" />
											<span class="price">
												￥422.00
													<del>￥506.40</del>
											</span>
											<span title="Max Toney 春夏男士休闲西服西装 永不起褶休闲小西装外套 男627">Max Toney 春夏男士休闲西服西装 永不起褶休闲小西装外套 男627</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/117.html">
											<img src="../images/dress/product_m8.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/fbb80ec8-a1d3-49de-b83b-79eae4b1ff69-thumbnail.jpg" />
											<span class="price">
												￥819.00
													<del>￥982.80</del>
											</span>
											<span title="2013春夏柒牌男装官方正品男士条纹T恤衫702T563985">2013春夏柒牌男装官方正品男士条纹T恤衫702T563985</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/125.html">
											<img src="../images/dress/product_m9.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/a2ac0816-37e4-477a-b179-e64f71252cf5-thumbnail.jpg" />
											<span class="price">
												￥138.00
													<del>￥165.60</del>
											</span>
											<span title="JackJones杰克琼斯男纯棉怀旧图案短袖T恤V212201016">JackJones杰克琼斯男纯棉怀旧图案短袖T恤V212201016</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/174.html">
											<img src="../images/dress/product_m10.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/b04a22f5-267d-4e33-ac58-dda941eeaf84-thumbnail.jpg" />
											<span class="price">
												￥125.00
													<del>￥150.00</del>
											</span>
											<span title="圣得西 正品男装 浅蓝色细格休闲长袖衬衫 经典版">圣得西 正品男装 浅蓝色细格休闲长袖衬衫 经典版</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/98.html">
											<img src="../images/dress/product_m1.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/bb99deac-0b33-48f1-a3ad-e8310516be07-thumbnail.jpg" />
											<span class="price">
												￥203.00
													<del>￥243.60</del>
											</span>
											<span title="春装新款159 与狼共舞长袖T恤 男装正品 翻领纯棉条纹体恤衫6534">春装新款159 与狼共舞长袖T恤 男装正品 翻领纯棉条纹体恤衫6534</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/142.html">
											<img src="../images/dress/product_m1.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/a197e9ea-0430-4846-9ac1-daaf4d1d6eb3-thumbnail.jpg" />
											<span class="price">
												￥203.00
													<del>￥243.60</del>
											</span>
											<span title="JackJones杰克琼斯男胶印机械图案短袖T恤I212101034">JackJones杰克琼斯男胶印机械图案短袖T恤I212101034</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/189.html">
											<img src="../images/dress/product_m1.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/c5b1b396-181a-4805-9e68-9b400d71f91e-thumbnail.jpg" />
											<span class="price">
												￥1589.00
													<del>￥1906.80</del>
											</span>
											<span title="圣得西 正品男装 经典版白蓝粉色 商务长袖正装衬衫">圣得西 正品男装 经典版白蓝粉色 商务长袖正装衬衫</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/113.html">
											<img src="../images/dress/product_m1.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/3d835c07-08c5-46d7-912d-adcd41f8c8e6-thumbnail.jpg" />
											<span class="price">
												￥739.00
													<del>￥886.80</del>
											</span>
											<span title="2013春夏柒牌男装官方正品男士休闲印花短袖T恤衫702T506653">2013春夏柒牌男装官方正品男士休闲印花短袖T恤衫702T506653</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/86.html">
											<img src="../images/dress/product_m1.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/a8f4a6a2-2a80-47a2-91b4-af47f46240a0-thumbnail.jpg" />
											<span class="price">
												￥198.00
													<del>￥237.60</del>
											</span>
											<span title="新款夏装159 与狼共舞短袖T恤 男装正品 2013条纹翻领体恤衫 6560">新款夏装159 与狼共舞短袖T恤 男装正品 2013条纹翻领体恤衫 6560</span>
										</a>
									</li>

						</ul>
				</div>

			</form>
		</div>
	</div>
	
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
				<li><a href="#">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="#">法律声明</a> |</li>
				<li><a href="/friend_link.jhtml">友情链接</a> |</li>
				<li><a href="/article/list/4.jhtml" target="_blank">支付方式</a> |
				</li>
				<li><a href="/article/list/5.jhtml" target="_blank">配送方式</a> |
				</li>
				<li><a href="http://www.shopxx.net">SHOP++官网</a> |</li>
				<li><a href="http://bbs.shopxx.net">SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2013 SHOP++商城 版权所有</div>
		</div>
	</div>
</body>
</html>