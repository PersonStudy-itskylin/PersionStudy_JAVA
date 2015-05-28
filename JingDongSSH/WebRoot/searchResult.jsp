<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0041)http://www.360buy.com/product/288725.html -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>京东商城</TITLE>
<LINK media=all href="css/base.css" type=text/css rel=stylesheet>
<LINK media=all href="css/pshow20120508.css" type=text/css rel=stylesheet>
<SCRIPT src="js/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT type=text/javascript>window.pageConfig = { compatible: true}; </SCRIPT>

	<style type="text/css">
		#content{width:1000px;margin:0 auto;text-align:center;overflow:auto;}
		#goods{width:225px;float:left;padding:5px 10px}
		#dd_1{font-size:14px;height:50px;padding:10px 0px;}
		#dd_2{font-size:18px;font-weight:600;color:red;padding-bottom:10px;}
		#dd_2 img{padding-right:4px;}
		#dd_3{font-size:13px;height:18px;line-height:18px;}
		#dd_4{padding:10px 0px;};
	</style>
	
	<script type="text/javascript">

		//模糊查询
		function search(){

			//获取输入框输入关键字信息
			var key = document.getElementById("key").value;

			//为空 表示用户没有输入 则不提交
			if( key != ""){
				return true;
			}
			
			return false;
		}
	
	</script>
	
</HEAD>

<BODY>



<DIV id=shortcut>
<DIV class=w>
<UL class="fl lh">
  <LI class="fore1 ld"><B></B><A 
  href="javascript:addToFavorite()">收藏京东<SPAN>商城</SPAN></A> </LI>
  <LI class=fore2><A href="http://www.360top.com/" 
  target=_blank>360TOP<SPAN>奢侈品</SPAN></A> </LI>
  <LI class=fore3><A href="http://www.minitiao.com/" target=_blank>迷你挑</A> </LI>
  <LI class=fore4><A href="http://www.ehaoyao.com/" 
  target=_blank><SPAN>京东</SPAN>好药师</A> </LI></UL>
<UL class="fr lh">
  <LI class="fore1 ld" id=loginbar>${users.name} ！欢迎来到京东商城！<A 
  href="<%=path%>/login.jsp">[登录]</A>&nbsp;<A 
  href="<%=path%>/register.jsp">[免费注册]</A> </LI>
  <LI class=fore2><A 
  href="http://jd2008.360buy.com/JdHome/OrderList.aspx">我的订单</A> </LI>
  <LI class="fore3 menu" data-widget="dropdown">
  <DL>
    <DT class=ld>特色栏目<B></B> 
    <DD>
    <DIV><A href="http://xiaoyuan.360buy.com/" target=_blank>校园频道</A></DIV>
    <DIV><A href="http://read.360buy.com/" target=_blank>在线读书</A></DIV>
    <DIV><A href="http://diy.360buy.com/" target=_blank>装机大师</A></DIV>
    <DIV><A href="http://market.360buy.com/giftcard/" 
    target=_blank>礼品卡</A></DIV></DD></DL></LI>
  <LI class=fore4><A href="http://app.360buy.com/" target=_blank>移动京东</A> </LI>
  <LI class="fore5 menu" data-widget="dropdown">
  <DL>
    <DT class=ld>企业服务<B></B> 
    <DD>
    <DIV><A href="http://market.360buy.com/giftcard/company/default.aspx" 
    target=_blank>企业客户</A></DIV>
    <DIV><A href="http://wop.360buy.com/p962.html" 
    target=_blank>办公直通车</A></DIV></DD></DL></LI>
  <LI class="fore6 menu" data-widget="dropdown">
  <DL>
    <DT class=ld><A href="http://help.360buy.com/" target=_blank>客户服务<B></B></A> 

    <DD>
    <DIV><A href="http://help.360buy.com/help/question-61.html" 
    target=_blank>常见问题</A></DIV>
    <DIV><A href="http://myjd.360buy.com/repair/orderlist.action" 
    target=_blank>售后服务</A></DIV>
    <DIV><A href="http://chat.360buy.com/jdchat/custom.action" 
    target=_blank>在线客服</A></DIV>
    <DIV><A href="http://myjd.360buy.com/opinion/list.action" 
    target=_blank>投诉中心</A></DIV>
    <DIV><A href="http://www.360buy.com/contact/service.html" 
    target=_blank>客服邮箱</A></DIV></DD></DL></LI></UL><SPAN 
class=clr></SPAN></DIV></DIV><!--shortcut end-->
<DIV id=o-header>
<DIV class=w id=header>
<DIV class=ld id=logo><A href="http://www.360buy.com/"><B></B><IMG height=50 
alt=京东商城 src="image/logo.png" width=259></A></DIV><!--logo end-->
<DIV id=search>
<DIV class="i-search ld"><B></B><S></S>
<UL class=hide id=shelper></UL>
<DIV class=form>

<form action="SearchServlet" method="post" onsubmit="return search()">
	<INPUT class=text id=key name="key"> <INPUT class=button type=submit value=搜索>
</form>
 
</DIV></DIV>
<DIV id=hotwords></DIV></DIV><!--search end-->
<DIV id=my360buy>
<DL>
  <DT class=ld><A href="http://home.360buy.com/"><img src="image/wodejingdnog.jpg"/></A></DT>
  <DD>
  <DIV class=loading-style1><B></B>加载中，请稍候...</DIV></DD></DL></DIV><!--my360buy end-->
<DIV id=settleup>
<DL>
  <DT class=ld><SPAN id=shopping-amount></SPAN><A 
  href="/JingDong/shoppingCar.jsp"><img src="image/gouwuchejiezhang.jpg"/></A> 
  </DT>
  <DD>
  <DIV class=prompt>
  <DIV class=loading-style1><B></B>加载中，请稍候...</DIV></DIV></DD></DL></DIV><!--settleup end--></DIV><!--header end-->
<DIV class=w>
<DIV id=nav>
<DIV id=categorys>
<DIV class="mt ld">
<H2><A href="http://www.360buy.com/allSort.aspx">全部商品分类<B></B></A></H2></DIV>
<DIV class=mc id=_JD_ALLSORT>
<DIV class="item fore1"><SPAN>
<H3><A href="http://book.360buy.com/">图书</A>、<A 
href="http://e.360buy.com/">电子书刊</A>、<A 
href="http://mvd.360buy.com/">音像</A></H3><S></S></SPAN></DIV>
<DIV class="item fore2"><SPAN>
<H3><A 
href="http://www.360buy.com/electronic.html">家用电器</A></H3><S></S></SPAN></DIV>
<DIV class="item fore3"><SPAN>
<H3><A 
href="http://www.360buy.com/digital.html">手机数码</A></H3><S></S></SPAN></DIV>
<DIV class="item fore4"><SPAN>
<H3><A 
href="http://www.360buy.com/computer.html">电脑、办公</A></H3><S></S></SPAN></DIV>
<DIV class="item fore5"><SPAN>
<H3><A href="http://www.360buy.com/home.html">家居家装</A>、<A 
href="http://www.360buy.com/kitchenware.html">厨具</A></H3><S></S></SPAN></DIV>
<DIV class="item fore6"><SPAN>
<H3><A 
href="http://www.360buy.com/clothing.html">服饰鞋帽</A></H3><S></S></SPAN></DIV>
<DIV class="item fore7"><SPAN>
<H3><A 
href="http://www.360buy.com/beauty.html">个护化妆</A></H3><S></S></SPAN></DIV>
<DIV class="item fore8"><SPAN>
<H3><A href="http://www.360buy.com/bag.html">礼品箱包</A>、<A 
href="http://www.360buy.com/watch.html">钟表</A>、<A 
href="http://www.360buy.com/jewellery.html">珠宝</A></H3><S></S></SPAN></DIV>
<DIV class="item fore9"><SPAN>
<H3><A 
href="http://www.360buy.com/sports.html">运动健康</A></H3><S></S></SPAN></DIV>
<DIV class="item fore10"><SPAN>
<H3><A href="http://www.360buy.com/auto.html">汽车用品</A></H3><S></S></SPAN></DIV>
<DIV class="item fore11"><SPAN>
<H3><A href="http://www.360buy.com/baby.html">母婴</A>、<A 
href="http://www.360buy.com/toys.html">玩具乐器</A></H3><S></S></SPAN></DIV>
<DIV class="item fore12"><SPAN>
<H3><A 
href="http://www.360buy.com/food.html">食品饮料、保健食品</A></H3><S></S></SPAN></DIV>
<DIV class="item fore13"><SPAN>
<H3><A href="http://caipiao.360buy.com/">彩票</A>、<A 
href="http://trip.360buy.com/">旅行</A>、<A 
href="http://chongzhi.360buy.com/">充值</A>、<A 
href="http://www.360buy.com/products/4938-4943-000.html">票务</A></H3><S></S></SPAN></DIV>
<DIV class=extra><A 
href="http://www.360buy.com/allSort.aspx">全部商品分类</A></DIV></DIV></DIV>
<DIV id=treasure></DIV>
<UL id=navitems>
  <LI class=fore1 id=nav-home><A href="<%=path%>/goods/IndexAction">首页</A> </LI>
  <LI class=fore2 id=nav-mall><A href="http://fashion.360buy.com/">服装城</A> </LI>
  <LI class=fore3 id=nav-tuan><A href="http://tuan.360buy.com/">团购</A> </LI>
  <LI class=fore4 id=nav-auction><A href="http://auction.360buy.com/">夺宝岛</A> 
  </LI>
  <LI class=fore5 id=nav-club><A href="http://club.360buy.com/">京东社区</A> 
</LI></UL>
</DIV>
</DIV>
</DIV>
<SCRIPT type=text/javascript>
(function(){if(pageConfig.navId){var object=document.getElementById("nav-"+pageConfig.navId);if(object)object.className+=" curr";}})();
</SCRIPT>

<div id="content">
	<c:forEach var="list" items="${searchList}" varStatus="index">
			<div id="goods">
			<dl>
				<dt><a href="CheckGoodsServlet?id=${list.id}"><img src="${list.imgURL}"/></a></dt>
				<dd id="dd_1"><a href="CheckGoodsServlet?id=${list.id}">
					<c:choose>
						<c:when test="${fn:length(list.title) > 50}">
							${fn:substring(list.title,0,50)} ...
						</c:when>
						<c:otherwise>
							${list.title}
						</c:otherwise>
					</c:choose>
				</a></dd>
				<dd id="dd_2"><img src="image/qian.jpg"/>${list.price}</dd>
				<dd id="dd_3"><a href="###">已有${list.evaluate}多人评价了</a> <img src="image/zhijiang.jpg"/> <img src="image/zengpin.jpg"/> <img src="image/fanjuan.jpg"/> </dd>
				<dd id="dd_4"><a href="BuyServlet?id=${list.id}"><img src="image/goumai.jpg"/></a>&nbsp;<a href=""><img src="image/guanzhu1.jpg"/></a>&nbsp;<a href=""><img src="image/duibi.jpg"/></a></dd>
			</dl>
		</div>
	</c:forEach>
  	
  	
  
</div>



<DIV class=w>
<DIV id=service>
<DL class=fore1>
  <DT><B></B><STRONG>购物指南</STRONG> </DT>
  <DD>
  <DIV><A href="http://help.360buy.com/help/question-56.html" 
  target=_blank>购物流程</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-57.html" 
  target=_blank>会员介绍</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-181.html" 
  target=_blank>团购/机票/充值/点卡</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-61.html" 
  target=_blank>常见问题</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-63.html" 
  target=_blank>大家电</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-62.html" 
  target=_blank>联系客服</A></DIV></DD></DL>
<DL class=fore2>
  <DT><B></B><STRONG>配送方式</STRONG> </DT>
  <DD>
  <DIV><A href="http://help.360buy.com/help/question-64.html" 
  target=_blank>上门自提</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-65.html" 
  target=_blank>快递运输</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-66.html" 
  target=_blank>特快专递（EMS）</A></DIV>
  <DIV><A href="http://market.360buy.com/giftcard/index.html#one5" 
  target=_blank>如何送礼</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-151.html" 
  target=_blank>海外购物</A></DIV></DD></DL>
<DL class=fore3>
  <DT><B></B><STRONG>支付方式</STRONG> </DT>
  <DD>
  <DIV><A href="http://help.360buy.com/help/question-67.html" 
  target=_blank>货到付款</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-68.html" 
  target=_blank>在线支付</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-71.html" 
  target=_blank>分期付款</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-69.html" 
  target=_blank>邮局汇款</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-70.html" 
  target=_blank>公司转账</A></DIV></DD></DL>
<DL class=fore4>
  <DT><B></B><STRONG>售后服务</STRONG> </DT>
  <DD>
  <DIV><A href="http://help.360buy.com/help/question-97.html" 
  target=_blank>售后服务政策</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-98.html" 
  target=_blank>售后服务流程</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-99.html" 
  target=_blank>价格保护</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-100.html" 
  target=_blank>退款说明</A></DIV>
  <DIV><A href="http://myjd.360buy.com/repair/repairs.action" 
  target=_blank>返修/退换货</A></DIV>
  <DIV><A href="http://bankws.360buy.com/refund/processapply.aspx" 
  target=_blank>退款申请</A></DIV></DD></DL>
<DL class=fore5>
  <DT><B></B><STRONG>特色服务</STRONG> </DT>
  <DD>
  <DIV><A href="http://help.360buy.com/help/question-79.html" 
  target=_blank>夺宝岛</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-86.html" 
  target=_blank>DIY装机</A></DIV>
  <DIV><A href="http://market.360buy.com/hd/yanbao090702/ind.html" 
  target=_blank>延保服务</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-92.html" 
  target=_blank>家电下乡</A></DIV>
  <DIV><A href="http://market.360buy.com/giftcard/index.html" 
  target=_blank>京东礼品卡</A></DIV>
  <DIV><A href="http://help.360buy.com/help/question-91.html" 
  target=_blank>能效补贴</A></DIV></DD></DL><SPAN class=clr></SPAN></DIV></DIV><!-- service end -->
<DIV class=w>
<DIV id=footer>
<DIV class=links><A href="http://www.360buy.com/intro/about.aspx" 
target=_blank>关于我们</A>|<A href="http://www.360buy.com/contact/" 
target=_blank>联系我们</A>|<A href="http://zhaopin.360buy.com/" 
target=_blank>人才招聘</A>|<A href="http://www.360buy.com/contact/joinin.aspx" 
target=_blank>商家入驻</A>|<A href="http://www.minitiao.com/" 
target=_blank>迷你挑</A>|<A href="http://www.360top.com/" target=_blank>奢侈品网</A>|<A 
href="http://www.360buy.com/intro/service.aspx" target=_blank>广告服务</A>|<A 
href="http://app.360buy.com/" target=_blank>移动终端</A>|<A 
href="http://club.360buy.com/links.aspx" target=_blank>友情链接</A>|<A 
href="http://cps.360buy.com/" target=_blank>销售联盟</A>|<A 
href="http://bbs.360buy.com/" target=_blank>京东论坛</A></DIV>
<DIV 
class=copyright>北京市公安局朝阳分局备案编号110105014669&nbsp;&nbsp;|&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;|&nbsp;&nbsp;互联网药品信息服务资格证编号(京)-非经营性-2011-0034<BR><A 
href="http://misc.360buyimg.com/skin/df/i/com/f_music.jpg" 
target=_blank>音像制品经营许可证苏宿批005号</A>&nbsp;&nbsp;|&nbsp;&nbsp;出版物经营许可证编号新出发(苏)批字第N-012号&nbsp;&nbsp;|&nbsp;&nbsp;互联网出版许可证编号新出网证(京)字150号<BR>Copyright&copy;2004-2012&nbsp;&nbsp;360buy京东商城&nbsp;版权所有</DIV>
<DIV class=authentication><A 
href="http://www.hd315.gov.cn/beian/view.asp?bianhao=010202007080200026" 
target=_blank><IMG height=40 alt=经营性网站备案中心 width=108 src="image/d1.jpg"></A>
<SCRIPT>function change(eleId){var str= document.getElementById(eleId).href;var str1 =str.substring(0,(str.length-6));str1+=RndNum(6);document.getElementById(eleId).href=str1;}function RndNum(k){var rnd="";for (var i=0;i<k;i++){rnd+=Math.floor(Math.random()*10);}return rnd;}</SCRIPT>
<A id=urlknet tabIndex=-1 
href="https://ss.cnnic.cn/verifyseal.dll?sn=2008070300100000031&amp;pa=294005" 
target=_blank><IMG oncontextmenu="return false;" onclick="change('urlknet')" 
height=40 alt=可信网站 width=112 border=true name=seal 
src="image/d2.jpg"></A><A 
href="http://fzp.bjhd.gov.cn/Default.aspx?TabId=105" target=_blank><IMG 
height=40 alt=海淀网络警察 width=108 
src="image/d3.jpg"></A><A 
href="https://search.szfw.org/cert/l/CX20120111001803001836" target=_blank><IMG 
height=40 width=112 
src="image/d4.jpg"></A></DIV></DIV></DIV><!-- footer end -->
<SCRIPT type=text/javascript>
	(function(){var hotwords="<strong>热门搜索：</strong><a href='http://search.360buy.com/Search?keyword=尼康S5100' target='_blank'>尼康S5100</a><a href='http://search.360buy.com/Search?keyword=华为T8828'target='_blank'>华为T8828</a><a href='http://search.360buy.com/Search?keyword=数码相框' target='_blank'>数码相框</a><a href='http://search.360buy.com/Search?keyword=OT 979' target='_blank'>OT 979</a><a href='http://search.360buy.com/Search?keyword=RCA播放器' target='_blank'>RCA播放器</a><a href='http://search.360buy.com/Search?keyword=ME525+' target='_blank'>ME525+</a><a href='http://search.360buy.com/Search?keyword=三星I569' target='_blank'>三星I569</a><a href='http://search.360buy.com/Search?keyword=i5508' target='_blank'>i5508</a><a href='http://search.360buy.com/Search?keyword=C6' target='_blank'>C6</a>";
	var keywords="诺基亚手机";
	$("#hotwords").html(hotwords);
	$("#key").val(keywords).bind("focus",function(){
		if (this.value==keywords){this.value="";this.style.color="#333"}
	}).bind("blur",function(){
		if (this.value==""){this.value=keywords;this.style.color="#999"}
	});
})();

	</SCRIPT>

<SCRIPT src="js/lib-v1.js" type=text/javascript></SCRIPT>

<SCRIPT src="js/p.pshow20110623.js" type=text/javascript></SCRIPT>

<SCRIPT src="js/promotion.js" type=text/javascript></SCRIPT>

<SCRIPT type=text/javascript>GetSingleAdWord('0D16CDDBE79F119FEFFD5A381EA0738A');</SCRIPT>

<SCRIPT src="js/ref_spider.min.js" type=text/javascript></SCRIPT>

<SCRIPT type=text/javascript>
	(function() {
	    if (!!jdSref && !!searchEngineSource) {
	        var keyword = searchEngineSource.k;
	        var dSource = searchEngineSource.d;
	        $.getJSON("http://search.360buy.com/ms?keyword=" + keyword + "&cid=832&returntype=json&pagesize=3&callback=?", function(data) {
	            if (!data && data.length <= 30) return;
	            var val = "";
	            var Rekeyword = "";
	            var html = "<dl><dt><a href='{url}'><img width='100' height='100' alt='' src='http://img1{domain}.360buyimg.com/n4/{img}'></a></dt><dd><div class='p-name'><a href='{url}'>{wname}</a></div><div class='p-price'><img src='http://price.360buyimg.com/gp{wid},1.png'></div><div class='btns'><a href='http://gate.360buy.com/InitCart.aspx?pid={wid}&pcount=1&ptype=1'>立即抢购</a></div></dd></dl>";
	            for (var i = 0; i < data.length; i++) {
	                val += html.replace(/{url}/g, data[i].url).replace(/{wname}/g, data[i].wname).replace(/{img}/g, data[i].img).replace(/{wid}/g, data[i].wid).replace(/{domain}/g, data[i]["img-domain"]);
	                Rekeyword = data[i].keyword;
	            }
	            $("#search-result").html("<div class='mt'>京东还有更多<a href='http://search.360buy.com/search?keyword=" + keyword + "' target='_blank'>" + Rekeyword + "</a>搜索结果</div><div class='mc'>" + val + "<div class='clr'></div><a href='http://search.360buy.com/search?keyword=" + keyword + "' target='_blank' class='more'>查看更多搜索结果&gt;&gt;</a></div>");
	            $("#search-result").show();
	        });
	    }
	})();
	</SCRIPT>

<SCRIPT src="js/BiForWeb.T.js" type=text/javascript></SCRIPT>
<!--推荐-->
<SCRIPT type=text/javascript>ThreeCCRecommend(288725);</SCRIPT>

<SCRIPT src="html/loadFa_toJson.htm" type=text/javascript></SCRIPT>

<SCRIPT src="html/aclk.htm" type=text/javascript></SCRIPT>

<SCRIPT type=text/javascript>
	asyncScript(function(){mark(288725,1);})
	</SCRIPT>

<SCRIPT src="js/wl.js" type=text/javascript></SCRIPT>

<SCRIPT type=text/javascript>
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
</SCRIPT>
<!-- Google Code for &#22270;&#20070;&#38899;&#20687;-&#35814;&#24773;&#39029; 90&#22825; Remarketing List -->
<SCRIPT type=text/javascript>
    /* <![CDATA[ */
    var google_conversion_id = 1066677870;
    var google_conversion_language = "en";
    var google_conversion_format = "3";
    var google_conversion_color = "666666";
    var google_conversion_label = "m94uCPbggwIQ7uzQ_AM";
    var google_conversion_value = 0;
    /* ]]> */
    </SCRIPT>

<SCRIPT src="js/conversion.js" type=text/javascript>
    </SCRIPT>
<NOSCRIPT>
<DIV style="DISPLAY: inline"><IMG 
style="BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: none" 
height=1 alt="" src="image/1066677870.gif" width=1> </DIV></NOSCRIPT><!-- pshow_ok --></BODY></HTML>
