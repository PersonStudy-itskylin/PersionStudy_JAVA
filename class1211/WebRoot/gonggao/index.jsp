<%@page import="java.sql.ResultSet"%>
<%@page import="cn.gonggao.DBGonggao"%>
<%@page import="cn.liuyan.DBLiuyan"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>软件1211—公告</title>
	<link rel="stylesheet" href="css/gonggao.css">
    <style type="text/css">
    	body{background-color:#09F; margin:0;padding:0;font-size:12px;}
    	.main{width:780px;background-color: #fff;margin:0 auto;margin-top: -30px;}
    	.main h1{text-align:center;color: #f00;font-size: 60px;}
    	.top{border-bottom: 1px groove #ddd;}
    	.content{width:85%;margin:0 auto;margin-top: 100px; }
    	table{border: 1px groove #666;width: 100%;}
    	table tr{border-bottom: 1px groove #666;}
    	a{text-decoration: none;}
    </style>
  </head>
  
  <body>
  	<div class="main">
  		<div class="top"><!---头部----->
        	<ul>
            	<li><a href="#">设为首页</a></li>
            	<li><a href="#">加入收藏</a></li>
            	<li><a href="#">联系我们</a></li>
            </ul>
            <div class="login">
            	<span class="user">您好，<a href="../tongxue/person.jsp"><%=session.getAttribute("username")%> </a></span>
            	<span onclick="exit()" style="cursor: pointer;"><a>退出</a></span>
            </div>
        </div>
    	<div class="content">
    		<table border="1" cellpadding="0" cellspacing="0">
    			<tr>
    				<th>编号</th>
    				<th>通告</th>
    				<th>时间</th>
    			</tr>
    			<%
    				DBGonggao gonggao = new DBGonggao();
    				ResultSet rs = gonggao.queryGonggao();
					try {
						while(rs.next()){
							String time = new String(rs.getString(3)).substring(0,16);
							String content = new String(rs.getString(2)).substring(0,30);				
				%>
						<tr>
							<td align="center"><a href="content.jsp?id=<%= rs.getInt(1) %>"><%= rs.getInt(1) %></a></td>
							<td><a href="content.jsp?id=<%= rs.getInt(1) %>"><%= content %></a></td>
							<td align="center"><%= time %></td>
						</tr>
				<%
						}
					} catch (Exception e) {
						// TODO: handle exception
						
					}
    			 %>
    		</table>
    	</div>
    	<div>
  			<h1>页面头部部分留的位置</h1>     	
    	</div>   	
    </div>
  </body>
</html>
