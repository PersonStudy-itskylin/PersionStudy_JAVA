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
						<li class="last">时尚女装</li>
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
											<a href="/product/list/11.jhtml">连衣裙</a>										</dd>
										<dd>
											<a href="/product/list/12.jhtml">针织衫</a>										</dd>
										<dd>
											<a href="/product/list/13.jhtml">短外套</a>										</dd>
										<dd>
											<a href="/product/list/14.jhtml">小西装</a>										</dd>
										<dd>
											<a href="/product/list/15.jhtml">牛仔裤</a>										</dd>
										<dd>
											<a href="/product/list/16.jhtml">T恤</a>										</dd>
										<dd>
											<a href="/product/list/17.jhtml">衬衫</a>										</dd>
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
						<a href="javascript:;" class="size current" pageSize="20">
							<span>20</span>
						</a>
						<a href="javascript:;" class="size" pageSize="40">
							<span>40</span>
						</a>
						<a href="javascript:;" class="size" pageSize="80">
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
											<a href="javascript:;" orderType="topDesc">置顶降序</a>										</li>
										<li>
											<a href="javascript:;" orderType="priceAsc">价格升序</a>										</li>
										<li>
											<a href="javascript:;" orderType="priceDesc">价格降序</a>										</li>
										<li>
											<a href="javascript:;" orderType="salesDesc">销量降序</a>										</li>
										<li>
											<a href="javascript:;" orderType="scoreDesc">评分降序</a>										</li>
										<li>
											<a href="javascript:;" orderType="dateDesc">日期降序</a>										</li>
								</ul>
							</div>
						</div>
						<a href="javascript:;" class="asc" orderType="priceAsc">价格</a>
						<a href="javascript:;" class="desc" orderType="salesDesc">销量</a>
						<a href="javascript:;" class="desc" orderType="scoreDesc">评分</a>
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
										<a href="/product/content/201306/290.html">
											<img src="../images/dress/product_1.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/51afeef5-f6cb-4936-abea-315cfca0edc0-thumbnail.jpg" />
											<span class="price">
												￥299.00
													<del>￥358.80</del>
											</span>
											<span title="尚都比拉2013夏装新款 韩版优雅甜美淑女装 春款蕾丝雪纺连衣裙子">尚都比拉2013夏装新款 韩版优雅甜美淑女装 春款蕾丝雪纺连衣裙子</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/300.html">
											<img src="../images/dress/product_2.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg" />
											<span class="price">
												￥298.00
													<del>￥357.60</del>
											</span>
											<span title="尚都比拉女装2013夏装新款蕾丝连衣裙 韩版修身雪纺打底裙子 春款">尚都比拉女装2013夏装新款蕾丝连衣裙 韩版修身雪纺打底裙子 春款</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/267.html">
											<img src="../images/dress/product_3.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/b499fb5e-999f-431b-a375-172ee09e4a3e-thumbnail.jpg" />
											<span class="price">
												￥206.00
													<del>￥247.20</del>
											</span>
											<span title="唯维欣怡2013春夏季新款韩版大码宽松显瘦女装荷叶边雪纺连衣裙子">唯维欣怡2013春夏季新款韩版大码宽松显瘦女装荷叶边雪纺连衣裙子</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/30.html">
											<img src="../images/dress/product_4.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/3999515b-48ba-476e-b810-3ca57f4b9e29-thumbnail.jpg" />
											<span class="price">
												￥308.00
													<del>￥369.60</del>
											</span>
											<span title="梵希蔓 2013夏装新款女装女裙子长款雪纺百褶连衣裙韩版修身裙子">梵希蔓 2013夏装新款女装女裙子长款雪纺百褶连衣裙韩版修身裙子</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/285.html">
											<img src="../images/dress/product_5.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg" />
											<span class="price">
												￥269.00
													<del>￥322.80</del>
											</span>
											<span title="尚都比拉2013夏装新款 春款修身淑女装 雪纺短袖假两件套连衣裙子">尚都比拉2013夏装新款 春款修身淑女装 雪纺短袖假两件套连衣裙子</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/122.html">
											<img src="../images/dress/product_6.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/a39fce79-fc04-4400-9e0f-47cee57accab-thumbnail.jpg" />
											<span class="price">
												￥288.00
													<del>￥345.60</del>
											</span>
											<span title="OSA春装外套女春秋韩版泡泡袖女士小西装短外套W13254">OSA春装外套女春秋韩版泡泡袖女士小西装短外套W13254</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/134.html">
											<img src="../images/dress/product_7.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/1a53a089-fe86-4826-92a9-019c27463d90-thumbnail.jpg" />
											<span class="price">
												￥288.50
													<del>￥346.20</del>
											</span>
											<span title="OSA女装雪纺衬衫 长袖韩版蕾丝休闲衬衣女C22432">OSA女装雪纺衬衫 长袖韩版蕾丝休闲衬衣女C22432</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/239.html">
											<img src="../images/dress/product_8.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/aec6d0ae-cad6-4cca-96bb-4bcd25e994cb-thumbnail.jpg" />
											<span class="price">
												￥168.00
													<del>￥201.60</del>
											</span>
											<span title="维依恋2013夏装新款韩版修身娃娃领女式短袖雪纺衫蕾丝拼接上衣">维依恋2013夏装新款韩版修身娃娃领女式短袖雪纺衫蕾丝拼接上衣</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/246.html">
											<img src="../images/dress/product_9.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/698a395e-ac95-4f76-a3c9-aa4e5fbc9217-thumbnail.jpg" />
											<span class="price">
												￥199.00
													<del>￥238.80</del>
											</span>
											<span title="维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子">维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/50.html">
											<img src="../images/dress/product_10.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/a86dec8b-1142-429f-8be4-2933e6f47b9d-thumbnail.jpg" />
											<span class="price">
												￥238.00
													<del>￥285.60</del>
											</span>
											<span title="梵希蔓 2013新款女装春装白色蕾丝连衣裙长袖大摆裙纱网连衣裙">梵希蔓 2013新款女装春装白色蕾丝连衣裙长袖大摆裙纱网连衣裙</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/287.html">
											<img src="../images/dress/product_11.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/059b5245-e3c8-43bf-80fe-700f0e4e68b8-thumbnail.jpg" />
											<span class="price">
												￥339.00
													<del>￥406.80</del>
											</span>
											<span title="尚都比拉2013夏装新款 韩版优雅淑女装 七分袖蕾丝雪纺连衣裙春款">尚都比拉2013夏装新款 韩版优雅淑女装 七分袖蕾丝雪纺连衣裙春款</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/96.html">
											<img src="../images/dress/product_12.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/94fd156b-cbdc-40d7-8231-8e26bae2ed9c-thumbnail.jpg" />
											<span class="price">
												￥268.00
													<del>￥321.60</del>
											</span>
											<span title="梵希蔓2013新款夏装甜美女装连衣裙短袖雪纺蕾丝拼接公主裙百褶裙">梵希蔓2013新款夏装甜美女装连衣裙短袖雪纺蕾丝拼接公主裙百褶裙</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/80.html">
											<img src="../images/dress/product_13.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/9aafeb39-655a-43f9-97d5-248508deeeed-thumbnail.jpg" />
											<span class="price">
												￥298.00
													<del>￥357.60</del>
											</span>
											<span title="梵希蔓2013夏装新款蕾丝连衣裙镂空假两件套连衣裙刺绣短袖连衣裙">梵希蔓2013夏装新款蕾丝连衣裙镂空假两件套连衣裙刺绣短袖连衣裙</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/205.html">
											<img src="../images/dress/product_14.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/f5e39c37-94b2-462e-8e58-8bde3c5f1b8c-thumbnail.jpg" />
											<span class="price">
												￥358.00
													<del>￥429.60</del>
											</span>
											<span title="伊芙丽2013春款新款女士西装领一粒扣短款小西装外套女1161024-2">伊芙丽2013春款新款女士西装领一粒扣短款小西装外套女1161024-2</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/194.html">
											<img src="../images/dress/product_15.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/69439b45-8626-451c-a31a-08f9df5d702b-thumbnail.jpg" />
											<span class="price">
												￥568.00
													<del>￥681.60</del>
											</span>
											<span title="伊芙丽 2013春装新款 女装OL通勤修身长袖小外套女小西装1211120">伊芙丽 2013春装新款 女装OL通勤修身长袖小外套女小西装1211120</span>
										</a>
									</li>
									<li>
										<a href="/product/content/201306/2.html">
											<img src="../images/dress/product_16.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/94aa25f9-f3ef-4f7f-8c7c-197cd04b68ea-thumbnail.jpg" />
											<span class="price">
												￥280.00
													<del>￥336.00</del>
											</span>
											<span title="维依恋春装2013新款七分袖中长款风衣韩版修身双排扣外套春款大衣">维依恋春装2013新款七分袖中长款风衣韩版修身双排扣外套春款大衣</span>
										</a>
									</li>
									<li class="last">
										<a href="/product/content/201306/298.html">
											<img src="../images/dress/product_17.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/f37ba36a-181b-4161-a88f-f74c9adb485d-thumbnail.jpg" />
											<span class="price">
												￥289.00
													<del>￥346.80</del>
											</span>
											<span title="尚都比拉2013夏装新款淑女装 春款森女系 碎花修身短袖蕾丝连衣裙">尚都比拉2013夏装新款淑女装 春款森女系 碎花修身短袖蕾丝连衣裙</span>
										</a>
									</li>
									<li class="last">
										<a href="/product/content/201306/76.html">
											<img src="../images/dress/product_18.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/f90c486f-eb84-4105-81ef-473cf82eb500-thumbnail.jpg" />
											<span class="price">
												￥209.00
													<del>￥250.80</del>
											</span>
											<span title="梵希蔓2013夏装新款大码品质女装蕾丝连衣裙夏季蛋糕裙短袖连衣裙">梵希蔓2013夏装新款大码品质女装蕾丝连衣裙夏季蛋糕裙短袖连衣裙</span>
										</a>
									</li>
									<li class="last">
										<a href="/product/content/201306/254.html">
											<img src="../images/dress/product_19.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/b967015f-bc3b-47af-97d5-6446d7a590cb-thumbnail.jpg" />
											<span class="price">
												￥269.00
													<del>￥322.80</del>
											</span>
											<span title="维依恋2013春装新款韩版双排扣中长款女式风衣女装外套春款大衣">维依恋2013春装新款韩版双排扣中长款女式风衣女装外套春款大衣</span>
										</a>
									</li>
									<li class="last">
										<a href="/product/content/201306/54.html">
											<img src="../images/dress/product_20.jpg" width="170" height="170" data-original="http://storage.shopxx.net/demo-image/3.0/201301/92a7bf42-6294-44a7-b518-19a77186d380-thumbnail.jpg" />
											<span class="price">
												￥288.00
													<del>￥345.60</del>
											</span>
											<span title="梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰">梵希蔓2013夏装淑女连衣裙雪纺刺绣背心裙高腰荷叶边连衣裙高腰</span>
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