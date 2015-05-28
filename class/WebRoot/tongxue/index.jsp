<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*,cn.tongxuelu.*"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>软件1211班—同学录</title>
<STYLE type="text/css">
body{background-color:#09F; margin:0;height:850px; padding:0;font-size:13px;}
table{background-color:ccc;}
img {
	width: 80px;
	height: 116px;
}

#p2 {
	border-bottom: 2px solid #333;
}

#p1 {
	border-bottom: 1px solid #666;
}
.xinxi{width: 70%;margin:0 auto;margin-top:50px;}
</STYLE>
</head>

<body>
	<div class="xinxi">
		<table align="center" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<TH>用户名</TH>
			<TH>学号</TH>
			<TH>姓名</TH>
			<TH>性别</TH>
			<TH>生日</TH>
			<TH>电话号码</TH>
			<TH>QQ号</TH>
			<th>微博号</th>
			<th>邮箱地址</th>
			<th>恋爱情况</th>
			<th>恋爱宣言</th>
			<th>兴趣爱好</th>
			<th>职务</th>
			<th>所获荣誉</th>
			<th>地址</th>
			<TH>照片</TH>
		</tr>
		<%
		DBTongxuelu tx = new DBTongxuelu();
			ResultSet rs = tx.queryAll();
			try{
		while(rs.next()){
				String aihao1 = rs.getString("tz_aihao");

				String aihao = aihao1.replace("、", "、<br/>");
	%>
		<tr>
			<td><%=rs.getString("userno")%></td>
			<td><%=rs.getString("gr_no")%></td>
			<td><%=rs.getString("gr_name")%></td>
			<td><%=rs.getString("gr_sex")%></td>
			<td><%=rs.getString("gr_birth")%></td>
			<td><%=rs.getString("gr_tel")%></td>
			<td><%=rs.getString("gr_qq")%></td>
			<td><%=rs.getString("gr_mail")%></td>
			<td><%=rs.getString("tz_weibo")%></td>
			<td><%=rs.getString("love_name")%></td>
			<td><%=rs.getString("tz_lovesay")%></td>

			<td><%= aihao %></td>
			<td><%=rs.getString("zw_name")%></td>
			<td><%=rs.getString("tz_rongyu")%></td>
			<td><%=rs.getString("gr_address")%></td>
			<td><img alt="这个是<%= rs.getString("gr_name") %>" src="<%= rs.getString("gr_photo") %>" /></td>
		</tr>
		<% 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	 %>
	 </table>
	</div>
</body>
</html>
