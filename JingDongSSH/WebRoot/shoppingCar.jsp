<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
   <link rel="stylesheet" href="css/base1.css"/>
   <link href="css/purchase1.css" rel="stylesheet" type="text/css"/>
   <title>我的购物车 - 京东商城</title>
   
   <script type="text/javascript">

  		//删除指定购物车商品
  		function deleteGoods(id){
  	  		if(confirm("确定要删除吗 ?")){
	  	  		//获取商品 ID
				window.location.href = "/JingDongSSH/shoppingCar/DeleteShoppingCarGoodsAction?index=" + id;
  	  		}
  		}

  	   //删除选中对象
  	   function deleteAllGoods(){

		  if(confirm("确定要全部删除吗 ?")){
	  		   //拼接 查询字符串
	  		   var query = "";
			   
	  		   //获取所有操作对象
			   var items = document.getElementsByName("checkItem");
				
			   //遍历所有商品
			   for(i=0;i<items.length;i++){
					//判断是否勾选 , 够选择 为需要删除的对象 。 保存该对象的索引值
					if( items[i].checked == true ){
						query += "index=" + i + "&";	
					}
			   }
	
	  	  	   //将选中的商品索引都传递过去
	  	  	   window.location.href = "/JingDongSSH/shoppingCar/DeleteShoppingCarGoodsAction?" + query;
		  }
  	   }

  	   //全选 / 反选
  	   function allAndNot(){

  			//获取所有操作对象
 			var items = document.getElementsByName("checkItem");

			for(item in items){
				
				if(items[item].checked == true){
					items[item].checked = false;
				}else{
					items[item].checked = true;
				}
				
			}
							
  	   }
  	   
   </script>
   	
   </head>   
<body> 
<!--shortcut start-->
<div id="shortcut">
	<div class="w">
		<ul class="fl lh">
			<li class="fore1"><a href="http://www.360top.com/" target="_blank">360TOP奢侈品</a></li>
			<li class="fore2"><a href="http://www.minitiao.com/" target="_blank">迷你挑</a></li>
			<li class="fore3"><a href="http://www.ehaoyao.com/" target="_blank">京东好药师</a></li>
		</ul>
		<ul class="fr lh">
			<li class="fore1 ld" id="loginbar">${users.name} ！欢迎来到京东商城！<span><a href="<%=path%>/login.jsp">[登录]</a> <a href="<%=path%>/register.jsp" class="link-regist">[免费注册]</a></span></li>
			<li class="fore2"><a href="http://jd2008.360buy.com/JdHome/OrderList.aspx">我的订单</a></li>
			<li class="fore3 menu" data-widget="dropdown">
				<dl>
					<dt class="ld">特色栏目<b></b></dt>
					<dd>
						<div><a href="http://read.360buy.com/" target="_blank">在线读书</a></div>
						<div><a href="http://diy.360buy.com/" target="_blank">装机大师</a></div>
						<div><a href="http://market.360buy.com/giftcard/" target="_blank">礼品卡</a></div>
					</dd>
				</dl>
			</li>
			<li class="fore4"><a href="http://app.360buy.com/" target="_blank">移动京东</a></li>
			<li class="fore5 menu" data-widget="dropdown">
				<dl>
					<dt class="ld">企业服务<b></b></dt>
					<dd>
						<div><a href="http://market.360buy.com/giftcard/company/default.aspx" target="_blank">企业客户</a></div>
						<div><a href="http://wop.360buy.com/p962.html" target="_blank">办公直通车</a></div>
					</dd>
				</dl>
			</li>
			<li class="fore6 menu" data-widget="dropdown">
				<dl>
					<dt class="ld"><a href="http://help.360buy.com/" target="_blank">客户服务<b></b></a></dt>
					<dd>
						<div><a href="http://help.360buy.com/help/question-61.html" target="_blank">常见问题</a></div>
						<div><a href="http://myjd.360buy.com/repair/orderlist.action" target="_blank">售后服务</a></div>
						<div><a href="http://myjd.360buy.com/opinion/list.action" target="_blank">投诉中心</a></div>
						<div><a href="http://www.360buy.com/contact/service.html" target="_blank">客服邮箱</a></div>
					</dd>
				</dl>
			</li>
		</ul>
		<span class="clr"></span>
	</div>
</div>
<!--shortcut end-->

<div class="w w1 header clearfix">
	<div id="logo"><a href="http://www.360buy.com/"><img clstag="clickcart|keycount|xincart|logo" src="image/logo.gif" alt="京东商城" height="46" width="251"></a></div>
    <div class="language"><a href="javascript:void(0);" onclick="toEnCart()">English Site(海外购物点击)</a></div>
	<div class="progress clearfix">
		<ul class="progress-1">
			<li class="step-1"><b></b>1.我的购物车</li>
			<li class="step-2"><b></b>2.填写核对订单信息</li>
			<li class="step-3">3.成功提交订单</li>
		</ul>
	</div>
</div>
<div class="w cart">
	<h2 class="w1">我的购物车</h2>
	
	<div id="show"><input value="0" id="isLogin" type="hidden">
<input value="495612,637467" id="ids" type="hidden">
<!-- 延保和赠品宏定义开始 -->
<!-- 延保和赠品宏定义结束 -->
 
<div class="cart-frame">
    <div class="tl"></div>
    <div class="tr"></div>
</div>
<div class="cart-inner">
    <div class="cart-thead clearfix">
        <div class="column t-checkbox form"><input data-cart="toggle-cb" id="toggle-checkboxes" onclick="allAndNot()" checked="checked" value="" type="checkbox"><label for="toggle-checkboxes">全选</label></div>
        <div class="column t-goods">商品</div>
        <div class="column t-price">京东价</div>
        <div class="column t-promotion">返现/送积分</div>
        <div class="column t-inventory">
            <div id="inventory" clstag="clickcart|keycount|xincart|kucunshai">
            <span id="location">武汉</span>
            </div>
        </div>
        <div class="column t-quantity">数量</div>
        <div class="column t-action">操作</div>
    </div>
    <div id="product-list" class="cart-tbody">
        <!-- ************************商品开始********************* -->
        <!-- ***************************************************** -->
  <!-- 主商品 -->
  	
  	<c:forEach var="list" items="${users.shoppingCar.list}" varStatus="i">
  
        <div data-bind="rowid:2" class="item item_selected ">
        <div class="item_form clearfix">
            <div class="cell p-checkbox"><input data-bind="cbid:2" class="checkbox" name="checkItem" checked="checked" value="637467-1" type="checkbox"></div>
            <div class="cell p-goods">
                <div class="p-img"><a href="http://www.360buy.com/product/637467.html" target="_blank"><img clstag="clickcart|keycount|xincart|p-imglistcart" width="50px;" src="${list.imgURL}"></a></div>    
                <div class="p-name"><a href="http://www.360buy.com/product/637467.html" clstag="clickcart|keycount|xincart|productnamelink" target="_blank">${list.title}</a></div>    
            </div>
            <div class="cell p-price"><span class="price">¥${list.price}</span></div>
            <div class="cell p-promotion">
               </div>
            <div class="cell p-inventory stock-637467">现货</div>
            <div class="cell p-quantity">
                <div class="quantity-form" data-bind="">
                    <a href="javascript:void(0);" class="decrement" clstag="clickcart|keycount|xincart|diminish1" id="decrement-637467-1-1">-</a>
                    <input class="quantity-text" value="1" id="changeQuantity-637467-1-1-0" type="text">
                    <a href="javascript:void(0);" class="increment" clstag="clickcart|keycount|xincart|add1" id="increment-637467-1-1-0">+</a>
                </div>
            </div>
            <div class="cell p-remove"><a id="remove-637467-1" data-name="CASIO卡西欧指针系列大表盘商务钢带石英男..." data-more="removed-299.00-1" clstag="clickcart|keycount|xincart|btndel318558" class="cart-remove" href="javascript:deleteGoods(${i.index});">删除</a></div>
        </div>
            <div class="item_extra">
        <div class="sku-yanBao" data="skuYb_637467_0">
            <!-- 延保服务按钮异步加载 -->
        </div>
         
   <!-- 延保 -->
    </div>
<!-- 延保和赠品 -->
        
        </div> 
	</c:forEach>      
       
    </div><!-- product-list结束 -->
      <div class="cart-toolbar clearfix">
    <div class="control fl">
        <span class="delete"><a href="javascript:deleteAllGoods();" clstag="clickcart|keycount|xincart|clearcartlink" id="remove-batch"><img src="image/shanchu.jpg"/>删除选中的商品</a></span>
        <span class="pool"><a target="_blank" href="http://www.360buy.com/special.aspx?id=7&amp;price=1" clstag="clickcart|keycount|xincart|coudanlink"><img src="image/tianjia.jpg"/>凑单商品</a></span>
    </div>
    <div class="total fr">
        <p><span>¥${users.shoppingCar.sumPrice}</span>总计：</p>
        <p><span>- ¥0.00</span>返现：</p>
    </div>
    <div class="amout fr"><span>${users.shoppingCar.number}</span> 件商品</div>
    </div>
    <div class="cart-total clearfix">
        <div class="control fl clearfix">
            <a href="javascript:void(0);" class="btn gray-btn btn-storage" clstag="clickcart|keycount|xincart|savecartlink" alt="点击'寄存'后，京东商城将为您保存购物车内的商品，方便您随时随地去结算" title="点击'寄存'后，京东商城将为您保存购物车内的商品，方便您随时随地去结算"><span class="btn-icon"></span><img src="image/jicun.jpg"/></a>
            <a href="javascript:void(0);" class="btn gray-btn btn-takeout" alt="点击'取出'后，您可取出之前寄存在购物车内的商品" title="点击'取出'后，您可取出之前寄存在购物车内的商品"><span class="btn-icon"></span><img src="image/quchu.jpg"/></a>
        </div>
        <div class="total fr"><span id="finalPrice" data-bind="2298.00">¥${users.shoppingCar.sumPrice}</span>总计：</div>
<div class="delivery fr">本订单已经免运费</div>    </div>
</div><!-- cart-inner结束 -->

<div class="cart-frame">
    <div class="bl"></div>

    <div class="br"></div>
</div>
<div class="cart-button clearfix">
    <a class="btn continue" href="<%=path%>/goods/IndexAction" clstag="clickcart|keycount|xincart|continueBuyBtn" id="continue"><img src="image/jixugouwu.jpg"/></a>
    <a class="checkout" href="order.jsp" clstag="clickcart|keycount|xincart|gotoOrderInfo" id="toSettlement"><img src="image/qujiezhang.jpg"/></a>
</div>
</div>
	
	<div class="cart-removed" style="display:none;">
		<div class="r-title">已删除商品，您可以重新购买或加关注：</div>

	</div>
</div>

<!--@end #c-tabs-->
<div id="cart-feedback" class="w w1"><a href="http://club.360buy.com/jdvote/vote2.aspx?voteId=65" style="color: rgb(68, 68, 68);" target="_blank">帮我们改进购物车</a></div>
<div class="w">
	<div id="footer">
		<div class="links"><a href="http://www.360buy.com/intro/about.aspx" target="_blank">关于我们</a>|<a href="http://www.360buy.com/contact/" target="_blank">联系我们</a>|<a href="http://zhaopin.360buy.com/" target="_blank">人才招聘</a>|<a href="http://www.360buy.com/contact/joinin.aspx" target="_blank">商家入驻</a>|<a href="http://www.minitiao.com/" target="_blank">迷你挑</a>|<a href="http://www.360top.com/" target="_blank">奢侈品网</a>|<a href="http://www.360buy.com/intro/service.aspx" target="_blank">广告服务</a>|<a href="http://app.360buy.com/" target="_blank">移动终端</a>|<a href="http://club.360buy.com/links.aspx" target="_blank">友情链接</a>|<a href="http://cps.360buy.com/" target="_blank">销售联盟</a>|<a target="_blank" href="http://bbs.360buy.com/">京东论坛</a></div>
		<div class="copyright">北京市公安局朝阳分局备案编号110105014669&nbsp;&nbsp;|&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;|&nbsp;&nbsp;互联网药品信息服务资格证编号(京)-非经营性-2011-0034<br><a target="_blank" href="http://misc.360buyimg.com/skin/df/i/com/f_music.jpg">音像制品经营许可证苏宿批005号</a>&nbsp;&nbsp;|&nbsp;&nbsp;出版物经营许可证编号新出发(苏)批字第N-012号&nbsp;&nbsp;|&nbsp;&nbsp;互联网出版许可证编号新出网证(京)字150号<br>Copyright©2004-2012&nbsp;&nbsp;360buy京东商城&nbsp;版权所有</div>
		<div class="authentication"><a href="http://www.hd315.gov.cn/beian/view.asp?bianhao=010202007080200026" target="_blank"><img class="err-product" src="image/d1.jpg" alt="经营性网站备案中心" height="40" width="108"></a><script>function change(eleId){var str= document.getElementById(eleId).href;var str1 =str.substring(0,(str.length-6));str1+=RndNum(6);document.getElementById(eleId).href=str1;}function RndNum(k){var rnd="";for (var i=0;i<k;i++){rnd+=Math.floor(Math.random()*10);}return rnd;}</script><a href="https://ss.cnnic.cn/verifyseal.dll?sn=2008070300100000031&amp;pa=294005" tabindex="-1" id="urlknet" target="_blank"><img class="err-product" src="image/d2.jpg" name="seal" oncontextmenu="return false;" onclick="change('urlknet')" alt="可信网站" border="true" height="40" width="112"></a><a href="http://fzp.bjhd.gov.cn/Default.aspx?TabId=105" target="_blank"><img class="err-product" src="image/d3.jpg" alt="海淀网络警察" height="40" width="108"></a><a href="https://search.szfw.org/cert/l/CX20120111001803001836" target="_blank"><img class="err-product" src="image/d4.jpg" height="40" width="112"></a></div>
	</div>
</div>
<!-- 各种弹出层开始 -->
<!-- 地区下拉 -->
<div id="inventory-dialog" class="dialog" style="display:none;">
<input value="北京朝阳区" id="hiddenLocation" type="hidden"/>
<input value="1-72-0" id="hiddenLocationId" type="hidden"/>
	<div class="dialog-outer">
		<span class="dialog-bg dialog-bg-n"></span>
		<span class="dialog-bg dialog-bg-ne"></span>
		<span class="dialog-bg dialog-bg-e"></span>
		<span class="dialog-bg dialog-bg-se"></span>
		<span class="dialog-bg dialog-bg-s"></span>
		<span class="dialog-bg dialog-bg-sw"></span>
		<span class="dialog-bg dialog-bg-w"></span>
		<span class="dialog-bg dialog-bg-nw"></span>
		<div class="dialog-inner">
			<div class="dialog-toolbar clearfix">
				<a class="dialog-close" href="javascript:void(0);" title="关闭" onclick="javascript:$('#inventory-dialog').hide();">关闭</a>
				<h3 class="dialog-title">查看库存</h3>
			</div>
			<div class="dialog-content clearfix">
				<select id="province" multiple="multiple" class="multiple-select"><option value="1" selected="selected">北京</option><option value="2">上海</option><option value="3">天津</option><option value="4">重庆</option><option value="5">河北</option><option value="6">山西</option><option value="7">河南</option><option value="8">辽宁</option><option value="9">吉林</option><option value="10">黑龙江</option><option value="11">内蒙古</option><option value="12">江苏</option><option value="13">山东</option><option value="14">安徽</option><option value="15">浙江</option><option value="16">福建</option><option value="17">湖北</option><option value="18">湖南</option><option value="19">广东</option><option value="20">广西</option><option value="21">江西</option><option value="22">四川</option><option value="23">海南</option><option value="24">贵州</option><option value="25">云南</option><option value="26">西藏</option><option value="27">陕西</option><option value="28">甘肃</option><option value="29">青海</option><option value="30">宁夏</option><option value="31">新疆</option><option value="32">台湾</option><option value="42">香港</option><option value="43">澳门</option><option value="84">钓鱼岛</option></select>
				<select id="city" multiple="multiple" class="multiple-select"><option value="72" selected="selected">朝阳区</option><option value="2800">海淀区</option><option value="2801">西城区</option><option value="2802">东城区</option><option value="2803">崇文区</option><option value="2804">宣武区</option><option value="2805">丰台区</option><option value="2806">石景山区</option><option value="2807">门头沟</option><option value="2808">房山区</option><option value="2809">通州区</option><option value="2810">大兴区</option><option value="2812">顺义区</option><option value="2814">怀柔区</option><option value="2816">密云区</option><option value="2901">昌平区</option><option value="2953">平谷区</option><option value="3065">延庆县</option></select>
				<select id="county" multiple="multiple" class="multiple-select"><option value="2799">三环以内</option><option value="2819">三环到四环之间</option><option value="2839">四环到五环之间</option><option value="2840">五环到六环之间</option><option value="4137">管庄</option><option value="4139">北苑</option><option value="4211">定福庄</option><option value="4212">北京经济技术开发区</option></select>
			</div>
		</div>
	</div>
</div>

<!-- 修改、删除等操作弹层 -->
<div id="cart-delete-dialog" class="dialog" style="display:none;">
	<div class="dialog-outer">
		<span class="dialog-bg dialog-bg-n"></span>
		<span class="dialog-bg dialog-bg-ne"></span>

		<span class="dialog-bg dialog-bg-e"></span>
		<span class="dialog-bg dialog-bg-se"></span>
		<span class="dialog-bg dialog-bg-s"></span>
		<span class="dialog-bg dialog-bg-sw"></span>
		<span class="dialog-bg dialog-bg-w"></span>
		<span class="dialog-bg dialog-bg-nw"></span>
		<div class="dialog-inner">
			<div class="dialog-toolbar clearfix">
				<a class="dialog-close" href="javascript:void(0);" title="关闭">关闭</a>

				<h3 class="dialog-title">删除商品</h3>
			</div>
			<div class="dialog-content">
				<div class="cart-delete">确定从购物车中删除此商品？</div>
				<div class="btns clearfix">
					<a href="javascript:void(0);" class="btn btn-ok" id="btnRemoveConfirm" data-bind="" data-show=""><span class="btn-text">确定</span></a>
					<a href="javascript:void(0);" class="btn btn-cancel" id="btnRemoveCancel"><span class="btn-text">取消</span></a>

				</div>
			</div>
		</div>
	</div>
</div>

<div id="cart-loading-dialog" class="dialog cart-tooltip" style="display:none; left:20px;">
	<div class="dialog-outer">
		<span class="dialog-bg dialog-bg-n"></span>
		<span class="dialog-bg dialog-bg-ne"></span>

		<span class="dialog-bg dialog-bg-e"></span>
		<span class="dialog-bg dialog-bg-se"></span>
		<span class="dialog-bg dialog-bg-s"></span>
		<span class="dialog-bg dialog-bg-sw"></span>
		<span class="dialog-bg dialog-bg-w"></span>
		<span class="dialog-bg dialog-bg-nw"></span>
		<div class="dialog-inner">
			<div class="loading-style1"><b></b>加载中,请稍候...</div>

		</div>
		<div class="dialog-bump"><span class="dialog-arrow"></span></div>
	</div>
</div>

<div id="cart-success-dialog" class="dialog cart-tooltip" style="display:none; left:250px;">
	<div class="dialog-outer">
		<span class="dialog-bg dialog-bg-n"></span>
		<span class="dialog-bg dialog-bg-ne"></span>
		<span class="dialog-bg dialog-bg-e"></span>

		<span class="dialog-bg dialog-bg-se"></span>
		<span class="dialog-bg dialog-bg-s"></span>
		<span class="dialog-bg dialog-bg-sw"></span>
		<span class="dialog-bg dialog-bg-w"></span>
		<span class="dialog-bg dialog-bg-nw"></span>
		<div class="dialog-inner">
			<div class="dialog-content">
				<div class="dialog-message">
					商品数量修改成功！
					<br>
					<span id="adMessage"></span>
					商品金额为：
					<span id="finalPriceChanged">¥0</span>
					元
					<br>
					<a href="javascript:void(0);" id="closeSuccessDialog">关闭</a>
				</div>
			</div>
		</div>
		<div class="dialog-bump"><span class="dialog-arrow"></span></div>
	</div>

</div>

<div id="cart-restrict-warning-dialog" class="dialog cart-tooltip cart-tooltip-notice" style="display:none; left:480px;">
	<div class="dialog-outer">
		<span class="dialog-bg dialog-bg-n"></span>
		<span class="dialog-bg dialog-bg-ne"></span>
		<span class="dialog-bg dialog-bg-e"></span>
		<span class="dialog-bg dialog-bg-se"></span>
		<span class="dialog-bg dialog-bg-s"></span>
		<span class="dialog-bg dialog-bg-sw"></span>

		<span class="dialog-bg dialog-bg-w"></span>
		<span class="dialog-bg dialog-bg-nw"></span>
		<div class="dialog-inner">
			<div class="dialog-content">
				<div class="dialog-notice">该商品限购<span id="limitNum"></span>个，超出则不享受优惠</div>
			</div>
		</div>
		<div class="dialog-bump"><span class="dialog-arrow"></span></div>

	</div>
</div>

<div id="cart-format-warning-dialog" class="dialog cart-tooltip cart-tooltip-notice" style="display:none; left:710px;">
	<div class="dialog-outer">
		<span class="dialog-bg dialog-bg-n"></span>
		<span class="dialog-bg dialog-bg-ne"></span>
		<span class="dialog-bg dialog-bg-e"></span>
		<span class="dialog-bg dialog-bg-se"></span>
		<span class="dialog-bg dialog-bg-s"></span>

		<span class="dialog-bg dialog-bg-sw"></span>
		<span class="dialog-bg dialog-bg-w"></span>
		<span class="dialog-bg dialog-bg-nw"></span>
		<div class="dialog-inner">
			<div class="dialog-content">
				<div class="dialog-notice" id="dialog-warning-notice">输入的数量只能是数字!</div>
			</div>
		</div>

		<div class="dialog-bump"><span class="dialog-arrow"></span></div>
	</div>
</div>
<div id="cart-notify-dialog" class="dialog" style="display:none;">
	<div class="dialog-outer">
		<span class="dialog-bg dialog-bg-n"></span>
		<span class="dialog-bg dialog-bg-ne"></span>

		<span class="dialog-bg dialog-bg-e"></span>
		<span class="dialog-bg dialog-bg-se"></span>
		<span class="dialog-bg dialog-bg-s"></span>
		<span class="dialog-bg dialog-bg-sw"></span>
		<span class="dialog-bg dialog-bg-w"></span>
		<span class="dialog-bg dialog-bg-nw"></span>
		<div class="dialog-inner">
			<div class="dialog-toolbar clearfix">
				<a class="dialog-close" href="javascript:void(0);" title="关闭">关闭</a>

				<h3 class="dialog-title">到货通知</h3>
			</div>
			<div class="dialog-content">
				<div class="cart-notify-email clearfix">
					<label>留下您的邮箱，到货后将及时通知您：</label>
					<input class="notify-email" type="text">
				</div>
				<div class="btns clearfix">

					<a href="javascript:void(0);" class="btn btn-ok" id="notifyConfirm" data-bind="" onclick="sendNotify(this);"><span class="btn-text">确定</span></a>
					<a href="javascript:void(0);" class="btn btn-cancel"><span class="btn-text">取消</span></a>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- 存放延保弹出层div -->
<div id="sku_yb_div">     <div id="extend-dialog_495612_0" class="dialog extend-dialog" style="display:none;">
        <div class="dialog-outer">
            <span class="dialog-bg dialog-bg-n"></span>
            <span class="dialog-bg dialog-bg-ne"></span>
            <span class="dialog-bg dialog-bg-e"></span>
            <span class="dialog-bg dialog-bg-se"></span>
            <span class="dialog-bg dialog-bg-s"></span>
            <span class="dialog-bg dialog-bg-sw"></span>
            <span class="dialog-bg dialog-bg-w"></span>
            <span class="dialog-bg dialog-bg-nw"></span>
            <div class="dialog-inner">

                <div class="dialog-toolbar clearfix">
                    <a class="dialog-close" href="javascript:void(0);" title="关闭">关闭</a>
                    <h3 class="dialog-title">购买延保服务</h3>
                </div>
                <div class="dialog-content">
                    <div class="extend-title">保修时间更长，使用更放心！<a target="_blank" href="http://help.360buy.com/help/question-87.html">查看保修范围</a></div>
                    <div class="extend-items clearfix">
                        <div class="extend-item">
                            <span>¥299.00</span>
                            <input value="161697" name="yb-radio_495612_0" id="yb-radio_161697_495612_0" type="radio">
                            <label title="延保通 手机 保修二年 特有多项意外保障（2501-3000）" for="yb-radio_161697_495612_0">延保通 手机 保修二年 特有多项意外保障（2501-3000）</label>
                        </div>
                        <div class="extend-item">
                            <span>¥199.00</span>
                            <input value="296801" name="yb-radio_495612_0" id="yb-radio_296801_495612_0" type="radio">
                            <label title="延保通 手机 保修一年  特有多项额外保障（2501-3000）" for="yb-radio_296801_495612_0">延保通 手机 保修一年  特有多项额外保障（2501-3000...</label>
                        </div>
                    </div>
                    <div class="btns clearfix">
                        <a href="javascript:void(0);" class="btn orange-btn btn-ok"><span class="btn-text" clstag="clickcart|keycount|xincart|ybnamelink" id="yb-confirm_495612_0">确定</span></a>
                        <a href="javascript:void(0);" class="btn btn-cancel"><span class="btn-text">取消</span></a>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 各种弹出层结束 -->
<input id="outSkus" value="" type="hidden">

<!-- 修改数量之前的值 -->
<input id="changeBeforeValue" value="" type="hidden">
<input id="changeBeforeId" value="" type="hidden">


<!-- 延保弹出层 -->
<textarea id="cart_skuYb_jst" style="display: none;">{if productYbInfos 
!= null}
    {for productYbInfo in productYbInfos}
    &lt;div 
id="extend-dialog_${productYbInfo.wid}_${productYbInfo.suitId}" 
class="dialog extend-dialog" style="display:none;"&gt;
		&lt;div class="dialog-outer"&gt;
			&lt;span class="dialog-bg dialog-bg-n"&gt;&lt;/span&gt;
			&lt;span class="dialog-bg dialog-bg-ne"&gt;&lt;/span&gt;
			&lt;span class="dialog-bg dialog-bg-e"&gt;&lt;/span&gt;
			&lt;span class="dialog-bg dialog-bg-se"&gt;&lt;/span&gt;
			&lt;span class="dialog-bg dialog-bg-s"&gt;&lt;/span&gt;
			&lt;span class="dialog-bg dialog-bg-sw"&gt;&lt;/span&gt;
			&lt;span class="dialog-bg dialog-bg-w"&gt;&lt;/span&gt;
			&lt;span class="dialog-bg dialog-bg-nw"&gt;&lt;/span&gt;
			&lt;div class="dialog-inner"&gt;

				&lt;div class="dialog-toolbar clearfix"&gt;
					&lt;a class="dialog-close" href="javascript:void(0);" 
title="关闭"&gt;关闭&lt;/a&gt;
					&lt;h3 class="dialog-title"&gt;购买延保服务&lt;/h3&gt;
				&lt;/div&gt;
				&lt;div class="dialog-content"&gt;
					&lt;div class="extend-title"&gt;保修时间更长，使用更放心！&lt;a  target="_blank"
  
href="http://help.360buy.com/help/question-87.html"&gt;查看保修范围&lt;/a&gt;&
lt;/div&gt;
					&lt;div class="extend-items clearfix"&gt;
					{for ybInfo in productYbInfo.ybInfos}
						&lt;div class="extend-item"&gt;
							&lt;span&gt;¥${ybInfo.price}&lt;/span&gt;
							&lt;input type="radio" value="${ybInfo.id}" 
name="yb-radio_${productYbInfo.wid}_${productYbInfo.suitId}" 
id="yb-radio_${ybInfo.id}_${productYbInfo.wid}_${productYbInfo.suitId}"/&gt;

							&lt;label title="${ybInfo.name}" 
for="yb-radio_${ybInfo.id}_${productYbInfo.wid}_${productYbInfo.suitId}"&gt;${ybInfo.shortName}&lt;/label&gt;

						&lt;/div&gt;
					{/for}
					&lt;/div&gt;
					&lt;div class="btns clearfix"&gt;
						&lt;a href="javascript:void(0);" class="btn orange-btn 
btn-ok"&gt;&lt;span class="btn-text" 
clstag='clickcart|keycount|xincart|ybnamelink' 
id="yb-confirm_${productYbInfo.wid}_${productYbInfo.suitId}"&gt;确定&lt;
/span&gt;&lt;/a&gt;
						&lt;a href="javascript:void(0);" class="btn 
btn-cancel"&gt;&lt;span class="btn-text"&gt;取消&lt;/span&gt;&lt;/a&gt;

					&lt;/div&gt;
				&lt;/div&gt;
			&lt;/div&gt;
		&lt;/div&gt;
	&lt;/div&gt;
    {/for}
{/if}

</textarea>




<script type="text/javascript" src="%E8%B4%AD%E7%89%A9%E8%BD%A6_files/config.js"></script>
<script type="text/javascript" src="%E8%B4%AD%E7%89%A9%E8%BD%A6_files/base-2011.js" charset="gb2312"></script>
<script type="text/javascript" src="%E8%B4%AD%E7%89%A9%E8%BD%A6_files/lib-v1.js" charset="gb2312"></script>
<script type="text/javascript" src="%E8%B4%AD%E7%89%A9%E8%BD%A6_files/cart_002.js"></script>
<script type="text/javascript" src="%E8%B4%AD%E7%89%A9%E8%BD%A6_files/cart.js"></script>
<!-- 公共头尾js start -->	
<script type="text/javascript">
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-2176661-1']);
_gaq.push(['_setDomainName', '360buy.com']);
_gaq.push(['_addOrganic', 'soso', 'w']);
_gaq.push(['_addOrganic', 'sogou', 'query']);
_gaq.push(['_addOrganic', 'youdao', 'q']);
_gaq.push(['_addOrganic', 'baidu', 'word']);
_gaq.push(['_addOrganic', 'baidu', 'q1']);
_gaq.push(['_addOrganic', 'ucweb', 'keyword']);
_gaq.push(['_addOrganic', 'ucweb', 'word']);
_gaq.push(['_addOrganic', '114so', 'kw']);
_gaq.push(['_trackPageview']);
_gaq.push(['_trackPageLoadTime']);
(function() {
	var ga = document.createElement('script');
	ga.type = 'text/javascript';
	ga.async = true;
	ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(ga, s);
})();
</script>
<!-- 公共头尾js end -->


<script src="%E8%B4%AD%E7%89%A9%E8%BD%A6_files/wl.js" type="text/javascript"></script></body></html>