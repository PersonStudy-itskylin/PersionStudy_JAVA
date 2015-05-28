<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'abouteshop.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/legalnotice.css"/>
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="container header">
		<jsp:include page="head.jsp"></jsp:include>
	</div>
	
	
	<div class="body">
		<div class="pathBar">
			<span>当前位置</span>
			<a href="/">首页</a><a href="<%=basePath %>jsp/legalnotice.jsp">法律申明</a>
		</div>
		<div class="bodyLeft">
			<div class="menu">
				<ul>
					
					<li>
						<a href="#">关于我们</a>
					</li>
					<li>
						<a href="#">联系我们</a>
					</li>
					<li>
						<a href="#">诚聘英才</a>
					</li>
					<li>
						<a href="#">支付方式</a>
					</li>
					<li>
						<a href="#">配送方式</a>
					</li>
					<li class="current">
						<a href="<%=basePath %>jsp/legalnotice.jsp">法律声明</a>
					</li>
					<li>
						<a href="/link.html">友情链接</a>
					</li>
				</ul>
			</div>
		</div>
	
	<div class="bodyRight">
			<div class="content">
				<div class="top"></div>
				<div class="middle">
					<div class="title">法律申明</div>
					<div class="blank"></div>
					<strong>所有权声明：</strong>
					<p>黄师蓝桥官方网站（www.eshop99.com）属于长沙鼎诚软件有限公司所有。</p>
					<strong>商标声明</strong>
					<p>"黄师蓝桥电子商城"系本公司的注册商标，受商标法的保护，未经本公司的许可，任何他人不得以任何形式使用。</p>
					<strong>版权声明</strong>
					<p>本网站上刊载的署名为"ESHOP99"的所有内容，包括但不限于文字、图片、声音、录像、图表、标志、标识、广告、商标、商号、域名、软件、程序、版面设计、专栏目录与名称、内容分类标准以及所有信息，均受《中华人民共和国著作权法》、《中华人民共和国商标法》、《中华人民共和国专利法》及适用之国际公约中有关著作权、商标权、专利权及其它财产所有权法律的保护，为本公司专属所有,对本网站上所有内容进行复制（意指收集、组合和重新组合），本网站享有排他权并受中国及国际版权法的保护。他人将本网站提供的内容与服务用于商业、盈利、广告性目的时，需征得本公司的许可，注明作者及文章出处，并依法向权利人支付报酬.</p>
 					<p>本网站未注明“稿件来源：ESHOP99官方”等稿件均为转载稿，本网站转载出于传递更多信息之目的，并不意味着赞同其观点或证实其内容的真实性。如其他媒体、网站或个人从本网站下载使用，必须保留本网站注明的“稿件来源”并承担相应版权等法律责任。如擅自篡改为“稿件来源：SHOP++”，本网站将依法追究责任。本网站和其它关联企业尊重他人之知识产权。如果你确认你的作品以某种方式被抄袭，该行为触犯了中国及国际版权法，请向本网站做版权投诉。</p>
					<p>本网站社区提供下载的部分下载内容，均取自于互联网，仅供创业者下载学习之用，不得用于商业用途，须在24小时内予以删除。如本网站相关下载内容涉及版权问题，请所有人与我们联系，我们将立即予以删除。</p>
					<p>ESHOP99用户在ESHOP99网站上发布的原创性信息与作品均为ESHOP99与作者共同持有版权。</p>
					<p>本网站开设的论坛，网友可自由发表相关主题信息，但网友观点并不代表本网站的意见和倾向。</p>
					<p>网上用户使用、进入或参与网站上的任何其他具相互影响作用区域，则表示同意所有这些条款。您参与的在线沟通是实时发生的，没有经过任何来自本网站的编辑、压缩、或任何其他形式的控制。本网站不能、也没有甄别所有网站用户提供的内容。但本网站保留对本网站上内容的监控权，并对本网站认为具有危害性，引起争议性的或违反本操作规则的其他内容进行删除的权利。为了提供满足本网站用户需求的高价值信息的服务，并避免本网站用户遭受因对他人权利的不实、恶意攻击或其他有害陈述而引起的损失，本网站有必要建立下列操作规则以避免本网站内容被滥用：</p>
					<p>当您使用本网站服务时，您不可以：</p>
					<p>1） 粘贴或传播任何非法的，具威胁性的，诽谤性的，贬损的，报复的、亵渎的或任何其他法律禁止的信息，包括但不限于传播任何煽动性鼓励犯罪的，或违反公民义务或任何其他违反地方法规、国家法律、法规或国际法律、惯例或公约的内容。</p>
					<p>2） 粘贴或传播任何散布任何他人的私人事件，粘贴或传播带有病毒，或任何带有贬损或损害性特征的内容；</p>
					<p>3） 粘贴或传播任何可能侵害其他人财产权利的数据、图形或程序，包括以非法形式使用未经注册的版权文本、图形或程序，商业秘密及其他保密信息、商标、服务标识等；</p>
					<p>4） 以任何形式干扰本网站的其他用户。</p>
					<strong>豁免条款</strong>
					<p>除注明之服务条款外，对用户使用本网站时发生的下列有关事项依法不负任何责任：</p>
					<p>通过本网站进行的任何属于用户的活动及其结果；</p>
					<p>通过本网站发布的用户言论和资讯内容；</p>
					<p>非本网站可控制之原因而出现的任何意外、疏忽、资料的丢失或毁坏等；</p>
					<p>用户上载或使用有关作品而导致的侵权责任及其损失；</p>
					<p>用户系统感染电脑病毒；</p>
					<p>与本网站链接的任何网站之资讯、产品及服务等信息的真实性、合法性、准确性和完整性；</p>
					<p>因登入信息不准确、不合法或不真实导致的一切不良后果；</p>
					<p>因用户任何非法行为导致的所有不良后果；</p>
					<p>"黑客"以及其他不可抗力因素及其后果；</p>
					<p>其他依法应予免责的情况。</p>
					<strong>用户权利</strong>
					<p>随时随地更改用户注册资料的权利；</p>
					<p>发布信息编辑与停止的权利；</p>
					<p>用户资料注销权利；</p>
					<p>了解本网站用户政策及相关服务条款的权利；</p>
					<strong>网络安全声明</strong>
					<p>本网站公布本法律声明旨在推行公开、知情和同意的原则, 并在此基础上建立互联网用户在网络上的信任和信心。由于本网站旨在向注册用户展示保守信息秘密和提供安全稳定的网络环境的承诺，因此，本网站希望通过披露本网站上安全政策和保护个人信息与稳私权政策的方式遵从互联网行业通行国际惯例，并接受会员和公众的监督。</p>
					<p>ESHOP99欢迎并奖励任何人通过合适的程序对本网站技术安全性提出的合理建议，反对任何人以任何非法、不当或不道德的方法侵入他人网络的黑客行为。</p>
					<p>本网站注册用户应该保护好自己的用户名及密码，对因个人原因造成个人资料、本网站资料的损失，由用户负责。</p>
					<strong>适用法律</strong>
					<p>本网站由长沙鼎诚软件有限公司运营和控制，适用中华人民共和国法律。我们保留随时更改我们的网站和上述免责及条款的权利。</p>
					<p>本网站用户应遵守中华人民共和国有关法律、法规，尊重网上道德，承担一切因您的行为而直接或间接引起的法律责任。</p>
				</div>
				<div class="bottom"></div>
			</div>
		</div>
	
	
	
	
	<div class="container footer">
		<jsp:include page="footpage.jsp"></jsp:include>
	</div>
</body>
</html>
