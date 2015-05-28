<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>京东广告</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">///////// k09lkklllkokli22as1qas1111qqqq2zasww 
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{margin:0;padding:0}
		img{display:none;}
		
	</style>
	
	<script type="text/javascript">

		//当前值
		var currentIndex = 1;
		//最大值
		var maxIndex = 4;

		function show(){

			//下一个值
			var nextIndex = currentIndex + 1;

			//判断下 如果下一个值超过最大值 则 回到 第一个值
			if(nextIndex == maxIndex + 1){
				nextIndex = 1;
			}

			document.getElementById("img" + nextIndex).style.display = "block";
			document.getElementById("img" + currentIndex).style.display = "none";

			//判断 如果当前值等于最大值 则 回到初始值 否则 递增
			if(currentIndex == maxIndex){
				currentIndex = 1;
			}else{
				currentIndex ++;
			}
			
			window.setTimeout("show()","1000");
		}
	</script>
	
  </head>
  
  <body onLoad="show()">
  		
  		<img id="img1" src="image/o2.jpg">
  		<img id="img2" src="image/o1.gif">
  		<img id="img3" src="image/o3.jpg">
  		<img id="img4" src="image/o4.jpg">
  		
  </body>
</html>
