
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图片变换</title>
	<meta name="author" content="hglq4 Team" />
    <meta name="copyright" content="hglq4" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=GB18030">
    
    <link href="<%=basePath%>css/datouwang.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/koala.min.1.5.js"></script> 
    
    <script type="text/javascript">
	Qfast.add('widgets', { path: "<%=basePath%>js/terminator2.2.min.js", type: "js", requires: ['fx'] });  
	Qfast(false, 'widgets', function () {
		K.tabs({
			id: 'fsD1',   //焦点图包裹id  
			conId: "D1pic1",  //** 大图域包裹id  
			tabId:"D1fBt",  
			tabTn:"a",
			conCn: '.fcon', //** 大图域配置class       
			auto: 1,   //自动播放 1或0
			effect: 'fade',   //效果配置
			eType: 'click', //** 鼠标事件
			pageBt:true,//是否有按钮切换页码
			bns: ['.prev', '.next'],//** 前后按钮配置class                          
			interval: 3000  //** 停顿时间  
		}) 
	})  
</script>

  </head>
  
  <body>
   
  <div id="fsD1" class="focus" >  
    <div id="D1pic1" class="fPic">  
        <div class="fcon" style="display: none;">
            <a target="_blank"  href="http://www.baidu.com/"><img src="<%=basePath%>images/01.jpg" style="opacity: 1; "></a>
            <span class="shadow"><a target="_blank"  href="http://www.baidu.com/" >黄冈蓝桥4期电子商城</a></span>
        </div>
        
        <div class="fcon" style="display: none;">
            <a target="_blank"  href="http://www.baidu.com/"><img src="<%=basePath%>images/02.jpg" style="opacity: 1; "></a>
            <span class="shadow"><a target="_blank"  href="http://www.baidu.com/" >黄冈蓝桥4期电子商城</a></span>
        </div>
        
        <div class="fcon" style="display: none;">
            <a target="_blank"  href="http://www.baidu.com/" ><img src="<%=basePath%>images/03.jpg" style="opacity: 1; "></a>
            <span class="shadow"><a target="_blank" href="http://www.baidu.com/">黄冈蓝桥4期电子商城</a></span>
        </div>
        
        <div class="fcon" style="display: none;">
            <a target="_blank"  href="http://www.baidu.com/" ><img src="<%=basePath%>images/04.jpg" style="opacity: 1; "></a>
            <span class="shadow"><a target="_blank" href="http://www.baidu.com/" >黄冈蓝桥4期电子商城</a></span>
        </div>    
    </div>
    <div class="fbg">  
    <div class="D1fBt" id="D1fBt">  
        <a href="javascript:void(0)" hidefocus="true" target="_self" class=""><i>1</i></a>  
        <a href="javascript:void(0)" hidefocus="true" target="_self" class=""><i>2</i></a>  
        <a href="javascript:void(0)" hidefocus="true" target="_self" class="current"><i>3</i></a>  
        <a href="javascript:void(0)" hidefocus="true" target="_self" class=""><i>4</i></a>  
    </div>  
    </div>  
    <span class="prev"></span>   
    <span class="next"></span>    
</div>  

  
  </body>
</html>
