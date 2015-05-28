<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="product/updateProduct.action">
  		产品ID<input type="text" name="proid"><br />
  		用户ID<input type="text" name="accid"><br />
  		产品名<input type="text" name="proname"><br />
  		产品型号<input type="text" name="promodel"><br />
  		产品价格<input type="text" name="proprice"><br />
  		产品类型<input type="text" name="protype"><br />
  		产品数量<input type="text" name="proquantity"><br />
  		产品来源<input type="text" name="prosource"><br />
  		产品修改者<input type="text" name="proeditor"><br />
  		产品备注<input type="text" name="proremark"><br />
  		<input type="submit" value="提交..." />
  	</form>
  </body>
</html>
