<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>添加留言</title>
  </head>
  
  <body>
  	<form action="isAddliuyan" method="post">
  		留言内容：
  		<br />
  		<textarea rows="6" cols="30" name="content" >请输入你要留言...</textarea>
  		<br />
  		留言作者：<input type="text" name="userno"  value="<%= session.getAttribute("username") %>" />
  		<br /><br />&nbsp;&nbsp;&nbsp;
  		<input type="submit" value="提交" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" >
  	</form>
  </body>
</html>
