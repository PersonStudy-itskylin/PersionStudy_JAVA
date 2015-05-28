<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>eshop购物车</title>
<meta name="author" content="hglq4 Team" />
<meta name="copyright" content="hglq4" />
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/cart.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/common.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $quantity = $("input[name='quantity']");
	var $increase = $("span.increase");
	var $decrease = $("span.decrease");
	var $delete = $("a.delete");
	var $giftItems = $("#giftItems");
	var $promotion = $("#promotion");
	var $point = $("#point");
	var $amount = $("#amount");
	var $clear = $("#clear");
	var $submit = $("#submit");
	
	// 数量
	$quantity.keypress(function(event) {
		var key = event.keyCode ? event.keyCode : event.which;
		if ((key >= 48 && key <= 57) || key==8) {
			return true;
		} else {
			return false;
		}
	});
	
	// 增加数量
	$increase.click(function() {
		var $quantity = $(this).parent().siblings("input");
		var quantity = $quantity.val();
		if (/^\d*[1-9]\d*$/.test(quantity)) {
			$quantity.val(parseInt(quantity) + 1);
		} else {
			$quantity.val(1);
		}
	});
	
	// 减少数量
	$decrease.click(function() {
		var $quantity = $(this).parent().siblings("input");
		var quantity = $quantity.val();
		if (/^\d*[1-9]\d*$/.test(quantity) && parseInt(quantity) > 1) {
			$quantity.val(parseInt(quantity) - 1);
		} else {
			$quantity.val(1);
		}
	});
	
	// 编辑
	setInterval(function() {
		$quantity.each(function() {
			var $this = $(this);
			var quantity = $this.val();
			if ($this.data("value") == null) {
				$this.data("value", quantity);
			} else if ($this.data("value") != quantity) {
				if (/^\d*[1-9]\d*$/.test(quantity)) {
					var $tr = $this.closest("tr");
					var id = $tr.find("input[name='id']").val();
					$.ajax({
						url: "edit.jhtml",
						type: "POST",
						data: {id: id, quantity: quantity},
						dataType: "json",
						cache: false,
						beforeSend: function() {
							$submit.prop("disabled", true);
						},
						success: function(data) {
							if (data.message.type == "success") {
								$this.data("value", $this.val());
								$tr.find("span.subtotal").text(currency(data.subtotal, true));
								if (data.giftItems != null && data.giftItems.length > 0) {
									$giftItems.html('<dt>赠品:<\/dt>');
									$.each(data.giftItems, function(i, giftItem) { 
										$giftItems.append('<dd><a href="' + giftItem.gift.path + '" title="' + giftItem.gift.fullName + '" target="_blank">' + giftItem.gift.fullName.substring(0, 50) + ' * ' + giftItem.quantity + '<\/a><\/dd>');
									});
									$giftItems.show();
								} else {
									$giftItems.hide();
								}
								if (data.promotions != null && data.promotions.length > 0) {
									var promotionName = "";
									$.each(data.promotions, function(i, promotion) { 
										promotionName += promotion.name + " ";
									});
									$promotion.text(promotionName);
								} else {
									$promotion.empty();
								}
								if (!data.isLowStock) {
									$tr.find("span.lowStock").remove();
								}
								$point.text(data.point);
								$amount.text(currency(data.amount, true, true));
							} else if (data.message.type == "warn") {
								$.message(data.message);
								$this.val($this.data("value"));
							} else if (data.message.type == "error") {
								$.message(data.message);
								window.setTimeout(function() {
									window.location.reload(true);
								}, 3000);
							}
						},
						complete: function() {
							$submit.prop("disabled", false);
						}
					});
				} else {
					$this.val($this.data("value"));
				}
			}
		});
	}, 300);

	// 删除
	$delete.click(function() {
		if (confirm("您确定要删除吗？")) {
			var $this = $(this);
			var $tr = $this.closest("tr");
			var id = $tr.find("input[name='id']").val();
			$.ajax({
				url: "delete.jhtml",
				type: "POST",
				data: {id: id},
				dataType: "json",
				cache: false,
				beforeSend: function() {
					$submit.prop("disabled", true);
				},
				success: function(data) {
					if (data.message.type == "success") {
						if (data.quantity > 0) {
							$tr.remove();
							if (data.giftItems != null && data.giftItems.length > 0) {
								$giftItems.html('<dt>赠品:<\/dt>');
								$.each(data.giftItems, function(i, giftItem) { 
									$giftItems.append('<dd><a href="' + giftItem.gift.path + '" title="' + giftItem.gift.fullName + '" target="_blank">' + giftItem.gift.fullName.substring(0, 50) + ' * ' + giftItem.quantity + '<\/a><\/dd>');
								});
								$giftItems.show();
							} else {
								$giftItems.hide();
							}
							if (data.promotions != null && data.promotions.length > 0) {
								var promotionName = "";
								$.each(data.promotions, function(i, promotion) { 
									promotionName += promotion.name + " ";
								});
								$promotion.text(promotionName);
							} else {
								$promotion.empty();
							}
							$point.text(data.point);
							$amount.text(currency(data.amount, true, true));
						} else {
							window.location.reload(true);
						}
					} else {
						$.message(data.message);
						window.setTimeout(function() {
							window.location.reload(true);
						}, 3000);
					}
				},
				complete: function() {
					$submit.prop("disabled", false);
				}
			});
		}
		return false;
	});
	
	// 清空
	$clear.click(function() {
		if (confirm("您确定要清空吗？")) {
			$.ajax({
				url: "clear.jhtml",
				type: "POST",
				dataType: "json",
				cache: false,
				success: function(data) {
					window.location.reload(true);
				}
			});
		}
		return false;
	});
	
	// 提交
	$submit.click(function() {
		if (!$.checkLogin()) {
			$.redirectLogin("/cart/list.jhtml", "必须登录后才能提交订单");
			return false;
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
<div class="container cart">
		<div class="span24">
			<div class="step step1">
				<ul>
					<li class="current">查看购物车</li>
					<li>订单信息</li>
					<li>完成订单</li>
				</ul>
			</div>
				<p>
					<a href="/">您的购物车是空的，立即去商城逛逛</a>
				</p>
		</div>
	</div>
<div class="container footer">
<jsp:include page="footpage.jsp"></jsp:include>
	</div></body>
</html>