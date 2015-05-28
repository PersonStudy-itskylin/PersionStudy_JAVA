<%@page import="java.sql.ResultSet"%>
<%@page import="cn.gonggao.DBGonggao"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>公告详细内容</title>
    <style type="text/css">
    	body{background-color:#09F; margin:0;height:850px; padding:0;font-size:13px;}
    	a{text-decoration: none;}
    	.main{width: 760px;background-color: #fff;margin: 0 auto;margin-top: 10px;}
    	.main h1{width: 100%;margin: 0 auto;color: #f00;font-size: 70px;}
    	.content{margin:50px 50px 20px 200px;margin-top: 50px;position: static;}
    	.content h2{font-size: 30px;text-align: center;}
    	.content span{border-bottom: 1px groove;}
    	.content p{padding-top: 20px;text-indent: 2em;line-height: 25px;}
    </style>
  </head>
  
  <body>
  		<%
  			DBGonggao gonggao = new DBGonggao();
  			ResultSet rs = gonggao.queryGonggaoId(request.getParameter("id")+"");
  			try{
  				rs.next();
  		%>
  	<div class="main">
  		<h1>页面头部部分留的位置</h1>
  		<div>
  			<div class="content">
  				<h2>关于公告测试的通知</h2>
  					<span>时间：<%= rs.getString(3) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：admin</span>
  					<p><%= rs.getString(2) %></p>
  			</div>
  		</div>
  		<div>
  			
  		
  		</div>
  		
  	</div>
  		<% 			
  			}catch(Exception e){
  				e.printStackTrace();
  			}  		
  		%>
  </body>
</html>
