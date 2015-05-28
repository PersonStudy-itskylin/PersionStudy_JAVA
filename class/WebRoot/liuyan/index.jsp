<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.sql.*"%>
<%@ page import="cn.dao.*,cn.liuyan.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= utf-8">
<title>班级留言页面</title>

<script type="text/javascript">
	function time(){
		var daytime = new Date();
		var h = daytime.getHours();
		var m = daytime.getMinutes();
		var s = daytime.getSeconds();
		
		document.getElementById('time').innerHTML = "现在时间为：" + h + ":" + m + ":" + s;
		setTimeout(time, 500);
		
	}
</script>
<style type="text/css">
	.time{
		font-size:20px;
		color:#f00;
		/*float:right;*/
	
	}
</style>
</head>
<body class="time" onload="time()">
	<div id='time'></div>
	<table border="1" bordercolor="#f00" cellpadding="0" >
		<tr>
			<th>序号</th>
			<th>作者</th>
			<th>留言内容</th>
			<th>时间</th>
			<th>&nbsp;</th>
		</tr>
		<%
			DBLiuyan db = new DBLiuyan();
			ResultSet rs = null;
			rs = db.queryTop5();
			int count =0;
			try {
				while(rs.next()){
					count++;
			%>
				<tr>
					<td> <%= count %></td>
					<td> <%= rs.getString("users") %> </td>
					<td> <%= rs.getString("content") %> </td>
					<td> <%= rs.getString("times") %> </td>
					<td> <a href="">删除</a> </td>
				</tr>
			<%
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			 %>
	</table>
	<br />
	&nbsp;&nbsp;&nbsp;
	<a href="addliuyan.jsp">留言</a>
	&nbsp;&nbsp;&nbsp;
	<a href="../class_index.jsp">返回</a>
</body>
</html>