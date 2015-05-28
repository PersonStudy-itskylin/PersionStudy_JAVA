<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="jquery-1.11.1.min.js"></script>
    <script type="text/javascript" >
    
      $(function(){
        $('#search').click(function(){
          var _name=$(':input[name]').val();
          $.post('list?x='+_name+'&t='+new Date().getTime(),function(data){
              var _html="<table><tr><th>aaa</th><th>bbb</th><th>ccc</th></tr>";
              var _tr="";
              $.each(data.list,function(i,e){
                _tr+="<tr><td>"+e.x+"</td><td>"+e.y+"</td><td>"+e.z+"</td></tr>";
              });
              var _table=_html+_tr+"</table>";
              $('#userlist').html(_table);
              $('table').css('border','1px').width(500);
          });
        
        });
      });
    
    </script>
  </head>
  
  <body>
    <input type="text" name="name"/><button id="search">Search</button>
    <hr/>78
    <div id="userlist"></div>
    
  </body>
</html>
