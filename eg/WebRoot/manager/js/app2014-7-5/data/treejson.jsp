<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String json="";
	json +="["
			+"{id:1,text:'系统设置',children:["
				+"	{id:11,text:'用户管理',icon:'images/user.png',leaf:true},"
				+"	{id:12,text:'FTP管理',icon:'images/database.png',leaf:true},"
				+"	{id:13,text:'SMTP管理',icon:'images/email.png',leaf:true},"
				+"	{id:14,text:'WEB管理',icon:'images/server.png',leaf:true},"
				+"	{id:15,text:'MYSQL管理',icon:'images/server_database.png',leaf:true},"
				+"	{id:16,text:'系统日志',icon:'images/icon_settings.gif',leaf:true}"
			+"]},{"
			+" id:2,text:'商品管理',children:["
				+"	{id:21,text:'商品类别',icon:'images/box_picture.png',children:["
				+"	{id:211,text:'食品零食',icon:'images/icon_user.gif',leaf:true},"
				+"	{id:212,text:'电子数码',icon:'images/camera.png',leaf:true},"
				+"	{id:213,text:'家电',icon:'images/television.png',leaf:true},"
				+"	{id:214,text:'户外',icon:'images/icon_user.gif',leaf:true},"
				+"	{id:215,text:'运动',icon:'images/icon_user.gif',leaf:true}"
			+"	]},"
			+"	{id:22,text:'商品分类管理',icon:'images/box_world.png',leaf:true},"
			+"]},{"
			+"id:3,text:'广告管理',children:["
				+"	{id:21,text:'查看广告',icon:'images/rainbow.png',leaf:true},"
				+"	{id:22,text:'广告商管理',icon:'images/plugin.png',leaf:true}"
			+"	]"
			+"}]";
		
	response.getWriter().print(json);	
%>