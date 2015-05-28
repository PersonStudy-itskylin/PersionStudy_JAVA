<%@page import="com.bolo.examples.service.base.CommentsManager"%>
<%@page import="com.bolo.examples.entity.base.Comments"%>
<%@page import="com.bolo.examples.web.base.CommentsAction"%>
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

<title>新闻评论框</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="ckeditor/config.js"></script>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<style type="text/css">
	* {
		margin: 0px;
		padding: 0px;
	}
	
	#editor1 {
		height: 80%;
		width: 100%;
	}
</style>
<SCRIPT type="text/javascript">


	$(function() {
		$('#btn_submit').click(
				function() {
					alert(156156);
					/* var _name=$(':input[name]').val();  */
					$.post('comlist?id=1&t=' + new Date().getTime(), function(
							data) {
						var_lhtml = "<table>";
						var _tr = "";
						$.each(data.list, function(e) {
							_tr += "<tr><td>评论主题：" + e.comarticleName
									+ "</td><td>用户：" + e.comcontent
									+ "</td></tr>";
							_tr += "<tr><td rowspan='2'>评论时间：" + e.comcreated
									+ "</td></tr>";
						});
						var _table = _html + _tr + "</table>";
						$('#comments').html(_table);
						$('table').css('border', '1px');
					});

				});
	});
</SCRIPT>
</head>

<body>
	<div id="main"
		style="border: 4px solid red ;width:60%; margin: 10px auto;  ">

		<div id="article"
			style="border: 4px solid green; padding: 4px;height:40%;">
			<h1 id="artical_topic" style="text-align: center;">日媒：安倍不懂奥巴马的心
				美不会为日打中国</h1>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;“奥巴马眼里连安倍的影子都没有”，日本news-postseven网站12日发表评论文章称，尽管安倍处处看奥巴马脸色行事，但他根本不懂奥巴马的心。</p>
			<p>最新美国舆论调查结果显示，奥巴马的支持率降至33%，成为“战后支持率最低”的美国总统。报道称，奥巴马在处理伊拉克问题上的无能表现说明，世界级领导者的能力正在下降，日本首相安倍晋三也不例外。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;news-postseven网站称，安倍一味依赖并追随奥巴马的行为实属愚昧，他在解释解禁集体自卫权的必要性时反复强调“一旦日本有什么闪失，美国会出面摆平的”。不仅如此，安倍甚至抱有这样的幻想：万一中国对钓鱼岛动武，美国也一定会出手营救。对此，该报道持不同意见称，美国议会不会同意这么做，美国人民也不会点头。就算有一天安倍敢对奥马巴说“不”了，美国人或许也不会太在意。</p>

			<div id="advertise"
				style="width:40%;margin:0px,0px,0xp,10xp;border: 5px solid rgb(205, 205, 205);float: left">这是广告区</div>

			<p>&nbsp;&nbsp;&nbsp;&nbsp;与此同时，安倍却不断向奥巴马大献殷勤。今年4月奥巴马访日时，安倍就曾出手阔绰地在银座高级寿司店里设宴欢迎。虽然奥巴马口口声声说“吃到人生中最美味的寿司”，但随后却被爆料剩下一半没吃完。因为地球人都知道奥巴马曾说过“最爱的食物是汉堡”。“但两人的政治风格却极其相似，”该报道评论称，“都属于嘴上能说，实际表现平平的类型”。
			</p>
			<div style="clear: none;"></div>
		</div>

		<form id="critical" style="border: 4px solid blue;height:20%;"
			name="testForm" method="post" action="<%=basePath%>index.jsp">
			    
			<textarea cols="100" id="editor1" name="editor1" rows="10">
            在此添加内容
               </textarea>
			    
			<button id="btn_submit">提交</button>
			<div style="clear: none;"></div>
			    
		</form>
		<div id="comments">
		
		</div>
	</div>
</body>
</html>
