<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'comments.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
	<style type="text/css">
		*{margin: 0;padding:0;}
		body{background:#aaa;}
		.container{
			width:75%;
			margin:0 auto;
			margin-top:20px;
			height: 850px;
			background:#ccc;
			}
		.up{
			width:100px;
		}
		.down{
			width:100px;
		}
		.context{
			height:150px;
		}
	</style>
	<script type="text/javascript">


	$(function() {
		$('#btn_submit').click(
				function() {
					/* var _name=$(':input[name]').val();  */
					$.post('<%=basePath%>comlist?id=1&t=' + new Date().getTime(), function(data) {
						alert(data);
						
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
						$('table').css('border', '1px').width(500).height(150);
					});

				});
	});
	</script>
  </head>
  
  <body>
    <div class="container">
    	<div id="up">
    		<h1>头部导航栏...</h1>
    	</div>
    	
    	<div id="center">
    		<div id="context">
    			<p>
    				<%@include file="news.txt" %>
    			</p>
    		</div>
    		<button id="btn_submit">提交</button>
    		<div id="comments">
    			
    		</div>
    		<div id="ckeditor">
    			
    		</div>
    	</div>
    	
    </div>
  </body>
</html>
