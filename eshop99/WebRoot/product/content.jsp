<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
/* String productid=request.getAttribute("product").toString();     //取得产品id
ProductDAOImpl  dao=new ProductDAOImpl();
Product p=dao.findByID(Integer.parseInt(productid));
 */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title> 京东图书</title><meta name="description" content="" />  
      <link rel="canonical" href="http://item.jd.com/11447263.html"/>
    <link rel="stylesheet" type="text/css" href="http://misc.360buyimg.com/lib/skin/2013/base.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="http://misc.360buyimg.com/book/skin/df/book.base20120321.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="http://misc.360buyimg.com/channel/book/css/item.main.css"/>
    <script type="text/javascript">
        window.pageConfig={compatible:true,searchType: 1,product:{"skuid":"11447263","name":"\u767d\u5ca9\u677e\uff1a\u884c\u8d70\u5728\u7231\u4e0e\u6068\u4e4b\u95f4","skuidkey":"6C76C67C49545200F30E77F8BF519832","href":"http:\/\/item.jd.com\/11447263.html","src":"jfs\/t7\/281\/4851903042\/651776\/7f128a45\/537c2204Nf3db1064.jpg","jqimg":"http:\/\/img11.360buyimg.com\/n0\/jfs\/t7\/281\/4851903042\/651776\/7f128a45\/537c2204Nf3db1064.jpg","wMaprice":"39.80","wMeprice":"27.70","cat":[1713,3259,3333],"brand":"","tips":false,"type":1,"n":false,"g":false}};
    </script>
</head>
<body>
<div class="w">
    <div class="breadcrumb">
        <strong ><a href="http://book.jd.com">图书</a></strong><span >&gt;&nbsp;<a target="_blank" href="http://channel.jd.com/1713-3259.html" >文学</a>&nbsp;&gt;&nbsp;<a target="_blank" href="http://list.jd.com/1713-3259-3333.html" >散文/随笔/书信</a></span>
        <div id="hotkeywords"  clstag="shangpin|keycount|bookitemnew|05"></div>
    </div>
    <!--breadcrumb end -->
    <div class="clr"></div>
    <div class="w">
        <div id="search-recommend" class="m">
            <div class="mt"><h2></h2></div>
            <div class="mc">
                <div class="clr"></div>
            </div>
        </div>
    </div>
</div>

<div class="w" >
<div id="product-intro">
    <div id="name" >
        <h1>白岩松：行走在爱与恨之间  <br />
            <font id="advertiseWord" style="color:#ff0000"></font>
        </h1>
        <div id="product-authorinfo" ><a target="_blank" href="http://book.jd.com/writer/白岩松_1.html" target="_blank">白岩松</a> 著</div>
        <div id="product-grade" >
            <span class="star">
                <span class="star-white">
                    <span class="star-yellow h5"></span>
                </span>
            </span>
            <span class="comments"></span>
        </div>
    </div>
    <div class="clearfix" >
        <ul id="summary">
 	<li id="summary-price" >
                <div class="dt">京 东 价：</div>
                <div class="dd">
                    <strong>￥27.70</strong><span class="p-discount-"> [7.0折]</span>                    <em>[定价：<s>￥39.80  </s>]</em>
                    <a class="price-notify" " data-type="1" href="#" >(降价通知)</a>
                </div>
            </li>
            <li id="summary-promotion" clstag="shangpin|keycount|bookitemnew|1102">
                <div class="dt">促销信息：</div>
                <div class="dd"></div>
            </li>
            <li id="summary-gifts" class="hide" clstag="shangpin|keycount|bookitemnew|1203">
                <div class="dt">赠&#x3000;&#x3000;品：</div>
                <div class="dd"></div>
            </li>
            <li id="summary-stock" clstag="shangpin|keycount|bookitemnew|1201">
                <div class="dt">配&nbsp;送&nbsp;至：</div>
                <div class="dd">
                    <div  id="store-selector">
                        <div class="text"><div></div><b></b></div>
                        <div class="close" onclick="$('#store-selector').removeClass('hover')"></div>
                    </div><!--store-selector end-->
                    <div id="store-prompt"><strong></strong></div><!--store-prompt end--->
                </div>
            </li>
                        <li id="summary-service" clstag="shangpin|keycount|bookitemnew|1202">
                <div class="dt">服&#x3000;&#x3000;务：</div>
                <div class="dd">由 京东 发货并提供售后服务</div>
            </li>
            <li id="summary-promotion-extra" class="hide" clstag="shangpin|keycount|bookitemnew|1204">
                <div class="dt">温馨提示：</div>
                <div class="dd"></div>
            </li>
        </ul>

                <ul id="choose" clstag="shangpin|keycount|bookitemnew|13">
            <li id="choose-info"></li>
            <li id="choose-amount" clstag="shangpin|keycount|bookitemnew|1301">
                <div class="dt">购买数量：</div>
                <div class="dd" >
                    <div class="wrap-input">
                        <a onclick="setAmount.reduce('#buy-num')" href="javascript:;" class="btn-reduce">减少数量</a>
                        <a onclick="setAmount.add('#buy-num')" href="javascript:;" class="btn-add">增加数量</a>
                        <input onkeyup="setAmount.modify('#buy-num');" value="1" id="buy-num" class="text">
                    </div>
                </div>
            </li>
            <li id="choose-btns">
                <div class="btn" id="choose-btn-append">
                    <a id="InitCartUrl" class="btn-append" href="http://cart.jd.com/cart/dynamic/gate.action?pid=11447263&pcount=1&ptype=1"  onclick="BuyUrl(11447263);" title="">加入购物车<b></b></a>
                </div>
                <div class="btn hide" id="choose-btn-easybuy" clstag="shangpin|keycount|bookitemnew|1304"><a href="#" class="btn-easybuy" >轻松购<b></b></a></div>
                <div class="btn hide" id="choose-btn-notice" clstag="shangpin|keycount|bookitemnew|1305"><a href="#none" class="btn-notice" id="notify-btn">到货通知<b></b></a></div>
                <div class="btn" id="choose-btn-coll" clstag="shangpin|keycount|bookitemnew|1303"><a class="btn-coll" id="coll11447263" href="#none">加关注<b></b></a></div>
                            </li>
        </ul>
    </div>
    <div class="clr"></div>
    <div id="preview" clstag="shangpin|keycount|bookitemnew|09">
        <div id="spec-n1" clstag="shangpin|keycount|bookitemnew|0901" >
            <img width="350" height="350"  data-img="1" src=" http://img11.360buyimg.com/n1/jfs/t7/281/4851903042/651776/7f128a45/537c2204Nf3db1064.jpg" alt="白岩松：行走在爱与恨之间" />
        </div>
        <!-- 小图 start -->
                <!-- 小图 end -->

        <div class="group">
            <div class="clearfix"  clstag="shangpin|keycount|bookitemnew|0903">
                <a class="btn-enterprise" target="_blank" href="http://sale.jd.com/act/v01UxfFtaXoyH.html">企业批量购书</a>
                <a  class="btn-onlineread" target="_blank" href="http://read.jd.com/16438/index.html"  clstag="shangpin|keycount|bookitemnew|0904">在线试读</a>            </div>
            <div  clstag="shangpin|keycount|bookitemnew|0905"><a  target="_blank" href="http://en.jd.com/books.html">Click here for international delivery</a></div>
        </div>
        <div id="short-share"  clstag="shangpin|keycount|bookitemnew|0906">
            <div class="share-list" id="share-list" >
                <div class="share-bd"> <em class="share-hd">分享到：</em>
                    <ul class="share-list-item clearfix share-list-item-all">
                        <li><a title="分享到新浪微博" id="site-sina" href="javascript:;">新浪微博</a></li>
                        <li><a title="分享到给QQ好友" id="site-qq" href="javascript:;">QQ</a></li>
                        <li><a title="分享到腾讯微博" id="site-qzone" href="javascript:;">腾讯微博</a></li>
                        <li><a title="分享到人人网" id="site-renren" href="javascript:;">人人网</a></li>
                        <li><a title="分享到开心网" id="site-kaixing" href="javascript:;">开心网</a></li>
                        <li><a title="分享到豆瓣" id="site-douban" href="javascript:;">豆瓣</a></li>
                        <li><a title="分享给MSN好友" id="site-msn" href="javascript:;">MSN</a></li>
                        <li><a title="邮件分享给好友" id="site-email" href="javascript:;">邮件</a></li>
                    </ul>
                </div>
                <div class="share-ft share-ft-open hide">
                    <b></b>
                </div>
            </div>
            <div class="clr"></div>
        </div>
    </div>
</div>
</body>
</html>

