<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" SYSTEM "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:xn="http://www.renren.com/2009/xnml">

<head>
    
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
    <meta http-equiv="expires" content="0"/>
    <title>登录京东商城</title>
    <!-- CSS 外部样式 -->
    <link type="text/css" rel="stylesheet" href="/JingDongSSH/css/passport.css"/>
    <link type="text/css" rel="stylesheet" href="/JingDongSSH/css/regist00.css"/>
    
    <!-- CSS 内部样式 -->
    <style type="text/css">
    	.user{width:250px;height:25px;font-size:40px;font-weight:200;color:#333;}
    	#shortcut,#li_3{background-color:#fbfbfb;border-color:red;border-bottom:1px;}
    </style>
    
    <!-- JavaScript 页面脚本语言  -->
    <script type="text/javascript">

		//里面写JS脚本语言
		
		//javascript 方法
		function checkLogin(){

			//通过 id 寻找该元素对象  , 通过 value 属性获取 该对象的值
			var user = document.getElementById("loginname").value;
			//获取长度
			var userLength = user.length;

			var password = document.getElementById("loginpwd").value;
			var passLength = password.length;
			
			//判断账号是否为空
			if(user == ""){
				//提示 请输入账号
				alert("请输入账号 !");
				return false;
			}else{
				//如果输入了值 ， 则判断账号是否合法  譬如 长度为 5 - 12 之间
				if(userLength < 5 || userLength >= 12){
					//长度不合法
					alert("请输入正确的账号 !");
					return false;
				}else{

					//验证密码
					//判断账号是否为空
					if(password == ""){
						//提示 请输入账号
						alert("请输入密码 !");
						return false;
					}else{
						//如果输入了值 ， 则判断账号是否合法  譬如 长度为 5 - 12 之间
						
						if(passLength < 5 || passLength >= 12){
							//长度不合法
							alert("请输入正确的密码 !");
							return false;
						}else{
							//数据有效 提交信息
							return true;
						}
					}

				}
			}

			//返回 false 表示 不提交表单
			return false;
		}
		
    </script>
    
</head>
<body>		

<form id="formlogin" method="post" action="users/LoginAction.action" onsubmit="return checkLogin()">
    
    <script type="text/javascript">function login(){location.href="https://passport.360buy.com/new/login.aspx"+location.search;return false}function regist(){location.href="https://passport.360buy.com/new/registpersonal.aspx"+location.search;return false}(function(a){a.fn.Jdropdown=function(d,e){if(!this.length){return}if(typeof d=="function"){e=d;d={}}var c=a.extend({event:"mouseover",current:"hover",delay:0},d||{});var b=(c.event=="mouseover")?"mouseout":"mouseleave";a.each(this,function(){var h=null,g=null,f=false;a(this).bind(c.event,function(){if(f){clearTimeout(g)}else{var j=a(this);h=setTimeout(function(){j.addClass(c.current);f=true;if(e){e(j)}},c.delay)}}).bind(b,function(){if(f){var j=a(this);g=setTimeout(function(){j.removeClass(c.current);f=false},c.delay)}else{clearTimeout(h)}})})}})(jQuery);function addToFavorite(){var a="http://www.360buy.com/";var b="京东商城-网购上京东，省钱又放心";if(document.all){window.external.AddFavorite(a,b)}else if(window.sidebar){window.sidebar.addPanel(b,a,"")}else{alert("对不起，您的浏览器不支持此操作!\n请您使用菜单栏或Ctrl+D收藏本站。")}}</script>
<div id="shortcut">
	<div class="w">
		<ul class="fl lh">
			<li class="fore1 ld"><b></b><a href="javascript:addToFavorite()">收藏京东商城</a></li>
			<li class="fore2"><a href="http://www.360top.com/" target="_blank">360TOP奢侈品</a></li>
			<li class="fore3"><a href="http://www.qianxun.com/" target="_blank">千寻网</a></li>
		</ul>
		
		<ul class="fr lh">
			<li class="fore1 ld" id="loginbar">您好！欢迎来到京东商城！<a href="<%=path%>/login.jsp">[登录]</a>&nbsp;<a href="<%=path%>/register.jsp">[免费注册]</a></li>
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
</div><!--shortcut end-->    <div class="w" id="logo">
        <div><a href="http://www.360buy.com/"><img src="image/logo0000.gif" alt="京东商城" width="167" height="46"/></a></div>
    </div>

    <div class="w" id="entry">
        <div class="mt" id="li_3">
            <h2>用户登录</h2>
            <b></b>
            <span style="text-align:right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="javascript:location.href=&quot;http://passport.360buy.com/new2/global/switchlanguage.aspx?l=en&amp;ReturnUrl=http://passport.360buy.com/new2/login.aspx&quot;+location.search;" href="https://passport.360buy.com/new/login.aspx?ReturnUrl=http%3A%2F%2Fwww.360buy.com%2F#">English</a></span>
        </div>
        <div class="mc" style="padding-top:20px;">
            <div class="form">
                <div class="item">
                    <span class="label">用户名：</span>

                    <div class="fl">
                        <input type="text" class="user" id="loginname" name="loginname" tabindex="1"/>
                        <label id="loginname_succeed" class="blank invisible"></label>
                        <span class="clr"></span>
                        <label id="loginname_error"></label>
                    </div>
                </div>
                <div class="item">
                    <span class="label">密码：</span>

                    <div class="fl">
                        <input type="password" id="loginpwd" name="loginpwd" class="user" tabindex="2"/>
                        <label id="loginpwd_succeed" class="blank invisible"></label>
                        <label><a href="http://passport.360buy.com/retrievepassword.aspx" class="flk13">忘记密码?</a></label>
                        <span class="clr"></span>
                        <label id="loginpwd_error"></label>
                    </div>
                </div>
                <div class="item  hide " id="o-authcode">
                    <span class="label">验证码：</span>

                    <div class="fl">
                        <input type="text" id="authcode" name="authcode" class="text text-1" tabindex="6"/>

                        <label class="image">
                            <img style="cursor:pointer;width:100px;height:26px;" alt src2="JDVerification.aspx?a=1&amp;uid=d2908ceb-2784-4edf-b0b9-1bf4346cb198" onclick="this.src='JDVerification.aspx?a=1&amp;uid=d2908ceb-2784-4edf-b0b9-1bf4346cb198&amp;yys='+new Date().getTime()" ver_colorofnoisepoint="#888888" id="JD_Verification1"/>
                        </label>

                        <label class="ftx23">&nbsp;看不清？<a href="javascript:void(0)" onclick="verc()" class="flk13">换一张</a></label>
                        <label id="authcode_succeed" class="blank invisible"></label>
                        <span class="clr"></span>
                        <span id="authcode_error"></span>
                    </div>
                </div>
                <div class="item" id="autoentry">
                    <span class="label">&nbsp;</span>

                    <div class="fl">
                        <label class="mar"><input type="checkbox" class="checkbox" checked="checked" id="chkRememberUsername" name="chkRememberUsername"/>
                            记住用户名</label>
                        <label><input type="checkbox" class="checkbox" id="chkRememberMe" name="freeLogin"/>
                            自动登录</label>
                    </div>
                </div>
                <div class="item">
                    <span class="label">&nbsp;</span>

                    <input type="image" src="image/login.bmp" style="height:32px;" class="btn-image btn-entry" id="loginsubmit" value="登录" tabindex="8"/>
                </div>


                <div class="item extra">
                    <label class="ftx24">
                        使用合作网站账号登录京东：
                        <span class="clr"></span>
                        <span class="btns qq"><s><img src="image/QQ.bmp"/></s><a href="javascript:void(0)" onclick="window.location='http://qq.360buy.com/new/qq/login.aspx'+window.location.search;return false;">QQ</a></span>
                        <span class="btns net163"><s><img src="image/wangyi.bmp"/></s><a href="javascript:void(0)" onclick="window.location='http://qq.360buy.com/new/netease/login.aspx'+window.location.search;return false;">网易</a></span>
                        <span class="btns renren"><s><img src="image/renren.bmp"/></s><a href="javascript:void(0)" onclick="renrenLogin('');return false;">人人网</a></span>
                        <span class="btns sina"><s><img src="image/xinlang.bmp"/></s><a href="javascript:void(0)" onclick="openWind('http://qq.360buy.com/new/sina/login.aspx');return false;">新浪微博</a></span>
                        <span class="btns kaixing001"><s><img src="image/kaixin.bmp"/></s><a href="javascript:void(0);" onclick="openWind('http://www.kaixin001.com/login/connect.php?appkey=569559288279830b66734654259458a9&amp;re=/kx001_receiver.htm&amp;t=57');return false;">开心网</a></span>
                        <span class="btns douban"><s><img src="image/douban.bmp"/></s><a onclick="window.location='http://qq.360buy.com/new/douban/login.action'+window.location.search;return false;" href="javascript:void(0);">豆瓣</a></span>
                        <span class="btns more"><a href="javascript:void(0)" onclick="window.location='http://qq.360buy.com/new/alipay/login.aspx'+window.location.search;return false;">更多&gt;&gt;</a></span>
                        <a id="kx001_btn_login" style="display:none"></a>
                    </label>
                </div>

            </div>
            <!--[if !ie]>form end<![endif]-->

            <div id="guide">
                <h5>还不是京东商城用户？</h5>

                <div class="content">现在免费注册成为京东商城用户，便能立刻享受便宜又放心的购物乐趣。</div>
                <a href="<%=path%>/register.jsp" class="btn-link btn-personal"><img src="<%=path%>/image/zhuce.bmp"/></a>
                <div class="btns"><a href="https://passport.360buy.com/new/registcompany.aspx">企业用户注册</a><a href="https://passport.360buy.com/new/registschool.aspx">校园用户注册</a></div>
                <div class="app">
                    <a target="_blank" href="http://app.360buy.com/"><img src="<%=path%>/image/app00000.jpg"/></a>
                </div>
            </div>
            <!--[if !ie]>guide end<![endif]-->
            <span class="clr"></span>
        </div>
        <!--[if !ie]>mc end<![endif]-->
    </div>

<div class="w">
    <div id="footer">
        <div class="links"><a href="http://www.360buy.com/intro/about.aspx" target="_blank">关于我们</a>|<a href="http://www.360buy.com/contact/" target="_blank">联系我们</a>|<a href="http://zhaopin.360buy.com/" target="_blank">人才招聘</a>|<a href="http://www.360buy.com/contact/joinin.aspx" target="_blank">商家入驻</a>|<a href="http://www.qianxun.com/" target="_blank">千寻网</a>|<a href="http://www.360top.com/" target="_blank">奢侈品网</a>|<a href="http://www.360buy.com/intro/service.aspx" target="_blank">广告服务</a>|<a href="http://app.360buy.com/" target="_blank">移动终端</a>|<a href="http://club.360buy.com/links.aspx" target="_blank">友情链接</a>|<a href="http://cps.360buy.com/" target="_blank">销售联盟</a>|<a target="_blank" href="http://bbs.360buy.com/">京东论坛</a>
        </div>

        <div class="copyright">北京市公安局朝阳分局备案编号110105014669&nbsp;&nbsp;|&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;|&nbsp;&nbsp;互联网药品信息服务资格证编号(京)-非经营性-2011-0034<br>
            <a target="_blank" href="http://misc.360buyimage.com/skin/df/i/com/f_music.jpg">音像制品经营许可证苏宿批005号</a>&nbsp;&nbsp;|&nbsp;&nbsp;出版物经营许可证编号新出发(苏)批字第N-012号&nbsp;&nbsp;|&nbsp;&nbsp;互联网出版许可证编号新出网证(京)字150号<br>
            Copyright©2004-2012&nbsp;&nbsp;360buy京东商城&nbsp;版权所有
        </div>

        <div class="authentication"><a href="http://www.hd315.gov.cn/beian/view.asp?bianhao=010202007080200026" target="_blank"><img src="<%=path%>/image/f_icp000.gif" width="108" height="40" alt="经营性网站备案中心"/></a>
            <a href="https://ss.cnnic.cn/verifyseal.dll?sn=2008070300100000031&amp;pa=294005" tabindex="-1" id="urlknet" target="_blank"><img name="seal" border="true" src="image/d2.jpg" width="112" height="40" oncontextmenu="return false;" onclick="change('urlknet')" alt="可信网站"/></a><a href="http://fzp.bjhd.gov.cn/Default.aspx?TabId=105" target="_blank"><img src="<%=path%>/image/d3.jpg" width="108" height="40" alt="海淀网络警察"/></a><a href="https://search.szfw.org/cert/l/CX20120111001803001836" target="_blank"><img src="<%=path%>/image/d4.jpg" width="112" height="40"/></a></div>
    </div>
</div>
</form>
</body>
</html>


<!-- This document saved from https://passport.360buy.com/new/login.aspx?ReturnUrl=http%3A%2F%2Fwww.360buy.com%2F -->
