<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" xml:lang="en" lang="en">
	<head>
		<title>MyXhtml.xhtml</title>
		<meta http-equiv="keywords" content="enter,your,keywords,here"/>
		<meta http-equiv="description" content="A short description of this page."/>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
    </head>
	<body>
		<p>
			This is my XHTML page.
		</p>
	</body>
</html>