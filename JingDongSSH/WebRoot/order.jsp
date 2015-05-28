<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="Head1">
		<title>订单信息确认</title>
		<link type="text/css" rel="stylesheet" href="css/common1.css"/>
		<link type="text/css" rel="stylesheet" href="css/shoppingcart1.css"/>
		<link href="css/orderInfo1.css" rel="stylesheet" type="text/css"/>
	<style>
 .shopTitle{height:15px;margin:3px;padding:3px;font-weight:bold;font-size:13px;}
 .submitSucInfo{color:#ff6600;text-align:center;border:1px solid #edd28b;background:#fffdee;line-height:30px;padding:8px 0 7px 10px;font-size:16px;margin-top:10px;margin-bottom:20px;font-weight:bold}
 #cartSelectPanel tr.Thead td{background:#f0f0f0}
 #cartSelectPanel tr.Thead .price span{color:red}
 #cartSelectPanel .o_show{border-bottom:none;}
 .cart_op .li3{padding-left:10px;}
 .submitSucInfo strong{color:red;font-weight:bold;}
 .submitSucInfo .tip_1{margin-left:35px;color:green;text-align:left;}
 .submitSucInfo .tip_5,.submitSucInfo .tip_6{margin-left:90px;color:#000;text-align:left;font-weight:normal;font-size:13px;padding:2px;height:20px;line-height:20px;margin-top:5px;margin-bottom:5px;}
 </style><script src="%E8%AE%A2%E5%8D%95_files/log.xml"></script>
 
 <style type="text/css">
 	
 	.info{width:400px;height:20px;}
 	
 </style>	
 
 <script type="text/javascript">

	//订单验证方法
	function orderCheck(){

		//获取表单的值
		var name = document.getElementById("name").value;
		var address = document.getElementById("address").value;
		var phone = document.getElementById("phone").value;
		var email = document.getElementById("email").value;

		/**
			手机号码的正则表达式
			13111111010
		*/
		var regexPhone = /^1[3-9][0-9]{9}$/;

		/**
			邮箱正则表达式
			370363583@qq.com
		*/
		var regexEmail = /^\w+@\w+[.](com||cn||com.cn||org||net)$/;

		//判断
		if(name == ""){
			alert("收货人姓名不能为空 !");
			return false;
		}else if(address == ""){
			alert("收件人地址不能为空 !");
			return false;
		}else if(!regexPhone.test(phone)){
			alert("请输入正确的手机号码 !");
			return false;
		}else if(!regexEmail.test(email)){
			alert("请输入正确的邮箱地址 !");
			return false;
		}else{
			return true;
		}
		
		return false;
	}
	
 </script>
  
</head>
	
  

<body>

<div class="Wrap_cart">

	<div id="Top1_order_step2" class="Header_cart">
		<div class="Logo">
			<a href="http://www.360buy.com/" clstag="clickcart|keycount|shoppingcartpop|logo"><img src="image/logo.gif" height="46" width="251"/></a>
		</div>
		<ul class="Order_cart" id="Order_cart_S2">
			<li class="step1 s1complete"><a href="http://cart.360buy.com/cart/cart.html" style="color: rgb(0, 0, 0);">1.我的购物车</a></li>
			<li class="step2">2.填写核对订单信息</li>
			<li class="step3">3.成功提交订单</li>
		</ul>
		
	</div>
				
	<div class="List_cart marginb10" id="show" name="show"><div id="Split_panel">
    <div id="sbox_1" style="display: none;">
            <div class="corner_t"><div class="corner_tl"></div><div class="corner_tr"></div></div><div class="corner_c">
            <h3>温馨提示</h3>
            <div>&nbsp;&nbsp;&nbsp;&nbsp;尊敬的客户，您订单中的商品存放在不同仓库中，为确保商品能够快速送达，您下单后系统将对订单进行自动拆分，商品按拆分后的子订单分开配送，所产生的额外运费由京东商城承担，您可以放心购买，给您带来的不便请谅解。</div>
            </div><div class="corner_b"><div class="corner_bl"></div><div class="corner_br"></div></div>
    </div>
    <div id="sbox_2" style="display: none;">
            <div class="corner_t"><div class="corner_tl"></div><div class="corner_tr"></div></div><div class="corner_c">
            <h3>温馨提示</h3>
            <div>&nbsp;&nbsp;&nbsp;&nbsp;订单预计送达日期为预估时间，实际送达日期受订单提交时间、库存、支付时间，以及您送货时间的特殊要求等因素影响。</div>
            </div><div class="corner_b"><div class="corner_bl"></div><div class="corner_br"></div></div>
    </div>
</div>

<h2><strong>填写核对订单信息</strong></h2>


        <form method="post" action="<%=path%>/order/AddOrderAction" onsubmit="return orderCheck()">
			<s:token></s:token>
	     <div class="cart_table">
            <!--收货人地址开始-->
             <div id="part_consignee">
                <div class="o_show">
                    <h1>
                    收货人信息&nbsp;
                    <a id="lbtnConsigneeWrite" href="javascript:void(0)" clstag="checkout|keycount|jiesuan|lconsigneewrite" onclick="Edit_Consignee(this)">[修改]</a>
                    </h1>
                    <div class="middle">
                    
                        <table>
                            <tbody><tr>
                                <td style="width: 80px;" align="right">收货人姓名：</td><td><input class="info" type="text" id="name" name="name"/></td>
                            </tr>
                            <tr>
                                <td align="right">地　　址：</td><td><input class="info"  type="text" id="address" name="address"/></td>
                            </tr>
                            <tr>
                                <td align="right">手机号码：</td><td><input class="info"  type="text" id="phone" name="phone"/></td>
                            </tr>
                            <tr>
                                <td align="right">电子邮件：</td><td><input class="info"  type="text" id="email" name="email"/></td>
                            </tr>
                        </tbody></table>
                       
                    </div>
                </div>
            </div>
            <!--收货人地址结束-->  
            <!--支付方式及配送方式开始-->
            <div id="part_payTypeAndShipType">
            <div class="o_show">
                <h1>
                    支付及配送方式&nbsp;<a id="linkPayTypeShipType" href="javascript:void(0)" clstag="checkout|keycount|jiesuan|linkpayshiptype" onclick="Edit_PayType(this);" style="">[修改]</a></h1><div id="updateInfo_payType"></div>
                 <div class="middle">
                        <table style="width: 100%;">
<!-- 非自提 -->
                            <tbody><tr> 
                                  <td style="text-align: right; width: 80px;">支付方式：</td>
                                  <td>
                                  	<select name="payWay">
                                  		<option selected="selected" value="货到付款">货到付款</option>
                                  		<option value="公司付账">公司付账</option>
                                  		<option value="邮局汇款">邮局汇款</option>
                                  		<option value="网上支付">网上支付</option>
                                  	</select>
                                  </td>
                              </tr>
                              <tr style="">
                                  <td style="text-align: right;">配送方式：</td>
                                  <td>京东快递</td>
                              </tr>
                             <tr style="">
                                  <td style="text-align: right;">运　　费：</td>
                                      <td>0.00元
 
                                              <span style="color:red">(免运费)</span>
                                      </td>
                              </tr>
                                  <tr style="">
                                      <td style="text-align: right;">送货日期：</td>
                                      <td style="color: red;">
                                          非大件商品 工作日、双休日与假日均可送货
                                      </td>
                                  </tr>
                               
                        </tbody></table>
                   </div>
                   <div class="footer"></div>
            </div>
            </div>
            <!--支付方式及配送方式结束-->  
             <!--发票信息开始-->
              <div id="part_invoice">
              
             <div class="o_show">
                 <h1>发票信息&nbsp;<a href="javascript:void(0)" clstag="checkout|keycount|jiesuan|xiugaifapiao" onclick="showForm_invoice(this)">[修改]</a></h1>
                  <div class="middle">
                                                   <table style="width: 100%;">
                            <tbody><tr>
                                <td style="text-align: right; width: 82px;">发票类型：</td>
                                <td>普通发票</td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">发票抬头：</td>
                                    <td>个人</td>
                            </tr>
                            <tr>
                               <td style="text-align: right;">发票内容：</td>
                               <td>
                                     <div>
                                            <span style="display:none">非图书商品：</span>
                                             <span>明细</span>
                                     </div>
                                     <div>
                                            <span style="display:none;">图书商品：</span>
                                             <span style="display:none;">不开发票</span>
                                    </div>
                               </td>
                            </tr>
                        </tbody></table>
                            <table style="width: 100%; display: none;">
                            <tbody><tr>
                                <td style="text-align: left; padding-left: 22px;">不开发票</td>
                            </tr>
                        </tbody></table>
   
                   </div>
                   <div class="footer"></div>
             </div>
        </div>
        <!--发票信息结束-->
        <!--Cart信息开始-->
                <div id="part_cart"><div class="o_show">
<h1><span style="margin-right:700px;">商品清单</span><a id="backToCartBtn" href="shoppingCar.jsp" onclick="toCart();" clstag="checkout|keycount|jiesuan|backtocartbtn" style="color: rgb(0, 112, 215);">返回修改购物车</a></h1>
<div id="promiseDate" style="color:#FF9900"></div>
  <div class="middle">
    <table class="Table" cellpadding="0" cellspacing="0" width="100%">
         <tbody><tr class="align_Center Thead">
            <td width="7%">商品类型</td>
            <td>商品名称</td>
            <td width="10%">京东价</td>
            <td width="8%">返现</td>
            <td width="8%">赠送积分</td>
            <td width="9%">库存状态</td>
            <td width="9%">商品数量</td>
         </tr>
            
           <!-- **************************单品和赠品显示 ***************************** -->
 <!--设置京卷默认值 -->
<!--设置积分默认值-->
<!--设置商品数量默认值-->
<!--设置商品价格默认值-->
<!--设置商品返现-->
<!--设置商品名称-->
<!--设置商品ID--> 
<!-- 显示商品库存 -->          
 <!-- 找到主商品 -->
   
                  
             <!-- 显示主商品 -->
             <c:forEach var="list" items="${users.shoppingCar.list}">
             <tr class="align_Center">
	             <td style="padding: 5px 0px;">${list.type}</td>
	             <td class="align_Left">
	             <a target="_blank" href="CheckGoodsServlet?id=${list.id}" onclick="this.blur();" clstag="clickcart|keycount|shoppingcartpop|productnamelinklistcart">${list.title}</a>
	               <!-- 如果有京卷显示京卷 -->
	             <!-- 如果有赠品循环显示-->
	              </td>
	            <td><span class="price">￥${list.price}</span></td>
	            <td>￥0.00</td>
	            <td>0</td>
	            <td>现货</td>
	            <td>1</td>
            </tr>
            </c:forEach>
            <!-- 显示延保服务 -->
              
            <!-- ****************************** 一般套装显示 ****************************** -->
          
           <!-- ************************ 满返满赠套装显示 ***********************-->
         
      </tbody></table>
  </div>   
 
<!-- <div class='footer'></div> -->
<!-- </div> --></div></div>
         <!--Cart信息结束-->
         
         <!--有货先发开始-->
        <div id="part_FirstInstockShip" style="padding:8px 0 8px 30px;color:red;display:none;"></div>
        <!--有货先发结束-->
        
        <!-- 结算信息开始 -->
         <div id="ware_info">
                  <div style="background:#fff;font-size:14px;font-weight:bold;padding-left:2px;">结算信息</div>
                  <h1></h1>
                  <div class="middle">
                    <!--金额信息-->
                    <span id="moneyArea">
                    <ul id="part_info">
                    <li class="info1" style="padding-bottom:5px">
                          商品金额：${users.shoppingCar.sumPrice}元 
                        + 运费：0.00元 
                        - 优惠券： 0.00元
                        - 礼品卡：0.00元
                        - 返现：0.00元
                    <br>
                    </li>                
                    <li class="info2" style="width:100%;overflow:hidden;">
                        <table style="width: 100%;" cellpadding="0" cellspacing="0">
                            <tbody><tr>
                                   <td>
                                <div style="display:">
                                    <a href="javascript:void(0);" onclick="showTicket(this);this.blur();">(<span id="couponStateShow">+</span>)使用优惠券抵消部分总额</a><font style="font-size:12px;margin-left:15px;" color="red"><div id="couponWaste" style="display:none">提醒：您的优惠券有浪费使用的情况，请检查！</div></font>
                                </div>              
                                  </td>
                                  <td style="text-align: right; font-size: 15px;">
                                  <b>应付总额：<font color="red">￥${users.shoppingCar.sumPrice}</font> 元</b>
                                   </td>
                               </tr>
                         </tbody></table>
                    </li>
                    </ul>
                    </span>
                        <!--金额信息结束-->
                        <!--优惠券-->
                        <div class="ticket" id="part_ticket" style="display:none;">     
                            <div style="margin:7px">
                                <div><span style="margin-right:340px">提示：东券每次只能使用一张，京券每次可使用多张，两种不可混合使用</span><a href="#none" onclick="showTicket();">[关闭]</a></div>
                                <div id="CouponRemark"></div>
                                <h2 class="m10"><span style="font-size:13px;font-weight:bold">请选择要使用的优惠券：</span></h2>
                                <span id="couponsArea"></span>
                                
                            </div>
                        </div>
                        <!--优惠券结束-->              
                     <!--礼品卡-->
                        <a href="javascript:void(0);" onclick="showLipinka();this.blur();" style="line-height: 25px; float: left; display: block; padding-left: 10px; background: url(&quot;http://www.360buy.com/purchase/skin/images/point.jpg&quot;) no-repeat scroll left center transparent; color: rgb(198, 134, 0); font-weight: bold;">(<span id="lipinkaStateShow">+</span>)使用京东礼品卡</a>
                        <div style="clear:both"></div>
                            <div class="ticket" id="part_lipinka" style="display:none">
                                <div><span style="margin-right: 310px">提示：京东礼品卡可多张一起使用，也可与东券、京券混合使用。<a href="http://market.360buy.com/giftcard/index.html" target="_blank">什么是礼品卡</a></span><a href="#none" onclick="showLipinka();">[关闭]</a></div>
                                <div id="LiPinKaRemark"></div>
                                <h2><span style="font-size: 13px; font-weight: bold">添加礼品卡</span></h2>
                                <div>请输入您手中礼品卡的密码：
                                    <input id="txtInputLPKey" class="txt" type="text"/>&nbsp;
                                    <input name="Submit" class="btn" id="btnAddLPK" value="添加" type="image" src="image/tiijaodingdan.jpg"/>
                                </div>
                                <h2 class="m10"><span style="font-size: 13px; font-weight: bold">已有礼品卡</span></h2>
                                <span id="lipinkasArea"></span>
                            </div>
                    <!--礼品卡结束-->
                    </div>  
              </div>
              <!-- 结算信息结束 -->
              
              <!-- 支付密码 -->
              <div class="safepsd01" id="paypasswordPanel" style="display:none">
                   <span class="label">支付密码：</span><div class="fl"><input class="text" id="txt_paypassword" type="password"><div class="msg-text"><a target="_blank" href="http://safe.360buy.com/user/paymentpassword/getBackPassword.action">忘记支付密码？</a></div><div class="clr"></div>
                   </div>
                 <div class="clr"></div>
                </div>
                <!-- end支付密码 -->
              
              
        <!--提交-->
        <div class="o_show submit"> 
           <div><span id="submitWaitInfo"></span></div>
           <div id="show_error"></div>
           <div id="submit_btn">
             <span id="ccPanel" name="ccPanel"></span>
             <table cellpadding="0" cellspacing="0" width="100%">
                 <tbody><tr>
                     <td style="padding: 0px; text-align: left; vertical-align: top;">
                       <div style="width:600px;" id="part_remark">
                            <div>
                               <input onclick="ShowForm_remark(this)" id="remark_checkbox" type="checkbox">
                               订单备注  
                               <input id="remark_remark" style="width: 220px; color: rgb(204, 204, 204); display: none;" class="txt" value="限15个字" onblur="if(this.value==''||this.value=='限15个字'){this.value='限15个字';this.style.color='#cccccc'}" onfocus="if(this.value=='限15个字'){this.value='';};this.style.color='#000000';" maxlength="15" type="text"> 
                                <div class="middle" style="display:none" id="remark_remark_div">
                                           <font color="red">*提示</font>
                                           <font color="#cccccc">：请勿填写有关支付、收货、方面的信息。</font>
                                </div>
                            </div>
                        </div>
                     </td>
                     <td style="width: 100px; padding: 0px;">
                         <input id="Consignee_Hidden_Type" value="0" type="hidden"/>
                         <input id="PayType_Hidden_Type" value="0" type="hidden"/>
                         <input id="PartInvoice_Hidden_Type" value="0" type="hidden"/>
                         <input id="TrackID" name="TrackID" value="97efba86-c65d-4073-875a-f82c45095830^I3WJCX5MTIA2MBNNXFBPD6MXVNEO5JUGC5VZC4I" type="hidden"/>
                     <input id="submit" clstag="checkout|keycount|jiesuan|sumbit" style="margin-top: 2px; border: medium none; cursor: pointer; width: 160px; height: 53px; background: url(&quot;http://www.360buy.com/purchase/skin/images/submit.jpg&quot;) repeat scroll 0% 0% transparent;" type="image" src="image/tijiaodingdan.jpg"/>
                     </td>
                 </tr>
             </tbody></table>
           </div>
        </div>
                <!--提交结束-->
                 
              </div>
             </form>                  
            <div class="round"><div class="lround"></div><div class="rround"></div>
            
</div></div>
	<div class="Footer_Nav"> 
   		<a href="http://www.360buy.com/intro/about.aspx" target="_blank">关于我们</a>|<a href="http://www.360buy.com/contact/" target="_blank">联系我们</a>|<a href="http://www.360buy.com/intro/job.aspx" target="_blank">人才招聘</a>|<a target="_blank" href="http://www.minitiao.com/"> 迷你挑</a>|<a href="http://www.360buy.com/contact/joinin.aspx" target="_blank">商家入驻</a>|<a href="http://www.360buy.com/intro/service.aspx" target="_blank">广告服务</a>|<a href="http://app.360buy.com/" target="_blank">移动终端</a>|<a href="http://club.360buy.com/links.aspx" target="_blank">友情链接</a>|<a href="http://cps.360buy.com/" target="_blank">销售联盟</a>
	</div>
	<div class="Copyright" style="margin-top:10px"> 北京市公安局海淀分局备案编号：1101081681&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;<a href="http://misc.360buyimg.com/skin/df/i/com/f_music.jpg" target="_blank">音像制品经营许可证苏宿批005 号</a><a href="http://misc.360buyimg.com/skin/df/i/com/medicines.jpg" target="_blank">互联网药品信息服务资格证</a><br>
		Copyright©2004-2012&nbsp;&nbsp;360buy京东商城&nbsp;版权所有
	</div> 
	<div class="Footer_Link"><a href="http://www.hd315.gov.cn/beian/view.asp?bianhao=010202007080200026" target="_blank"><img src="image/d1.jpg" alt="经营性网站备案中心" height="40" width="108"></a> 
	<script type="text/JavaScript">function change(eleId){var str= document.getElementById(eleId).href;var str1 =str.substring(0,(str.length-6));str1+=RndNum(6);document.getElementById(eleId).href=str1;}function RndNum(k){var rnd="";for (var i=0;i<k;i++){rnd+=Math.floor(Math.random()*10);}return rnd;}</script><a href="https://ss.cnnic.cn/verifyseal.dll?sn=2008070300100000031&amp;pa=294005" tabindex="-1" id="urlknet" target="_blank"><img name="seal" src="image/d2.jpg" oncontextmenu="return false;" onclick="change('urlknet')" alt="可信网站" border="true" height="40" width="112"></a> <a href="http://fzp.bjhd.gov.cn/Default.aspx?TabId=105" target="_blank"><img src="image/d3.jpg" alt="海淀网络警察" height="40" width="108"><img src="image/d4.jpg" alt="诚信网站" height="40" width="108"></a></div> 
	
</div>
</body></html>