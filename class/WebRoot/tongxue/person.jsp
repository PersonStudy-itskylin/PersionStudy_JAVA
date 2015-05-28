<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>幽蓝</title>

<style type="text/css">
body{
	background-color:#fff;
	margin:0;
	padding:0;
	font-size:16px;
	}
.top{
	width:100%;
	margin:0 auto;
	height:40px;
	background-color:#000;
	}
.nav{
	margin:0 auto;
	color:#CCC;
	list-style-type:none;
	line-height:40px;
	overflow:hidden;
	display:inline-block;
	/*border:1px solid #505255;
	border-bottom: 1px solid #282C2F;*/
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	-webkit-box-shadow:1px 1px 3px #292929;
    -moz-box-shadow:1px 1px 3px #292929;
	}
.nav li{
	color:#000;
	list-style:none;
	float:left;
	border-right: 1px solid #2E3235;
	position: relative;
	/*background: -moz-linear-gradient(top, #fff, #555D5F 2% ,#555D5F  50%,#3E4245 100%);
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#fff), color-stop(2%, #555D5F), color-stop(50%, #555D5F),to

(#3E4245));*/
	background-color:#000;
	}
li:hover{
	/*background: -moz-linear-gradient(top, #fff, #3E4245 2% ,#555D5F  80%,#555D5F 100%);
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#fff), color-stop(2%, #3E4245), color-stop(80%, #3E4245),to

(#555D5F));*/
	color:#000;
	background:#fff;
	-moz-transition: background 1s ease-out;
	-webkit-transition: background 1s ease-out;
}

li a{
	font:14px bold; 
	text-decoration:none;
	padding:12px 20px;
	color:#CCC;
	display:block;
	height:15px;
	line-height:20px;
	font-size:12px;
	text-shadow: 0px -1px 0px #000;
	text-decoration:none;
	white-space:nowrap;
	border-left: 1px solid #999E9F;
    border-top: 1px solid #999E9F;
	-moz-border-top-left-radius: 2px;
	-webkit-border-top-left-radius: 2px;
	
	z-index:100;
}

li > a{
	position:relative;
}

li.first a{
	-moz-border-radius-topleft: 4px;
	-moz-border-radius-bottomleft: 4px;
	-webkit-border-top-left-radius: 4px;
	-webkit-border-bottom-left-radius: 4px;
}
li.last{
	border-right: 0 none;
}

tr{
	position:absolute;
	display:block;
	top:40px;
	left: -25px;
	
	width:100px;
	
	background:#222222;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	
	-webkit-box-shadow:1px 1px 3px #292929;
    -moz-box-shadow:1px 1px 3px #292929;
	
	z-index:10;
            
}



/*
.top a{
	font:14px bold; 
	text-decoration:none;
	padding:12px 20px;
	color:#CCC;
	}
.top a:hover{
	background-color:#ddd;
	color:#000;
	display:block;
	}
	*/

</style>
</head>

<body>
	<div class="top">
    	<!--	<ul class="clear">
    	<li class="first"><a href="#">菜单一</a></li>
        <li>
        	<span class="Darrow"></span>
            <a href="#">菜单二</a>
        	<dl>
            	<dt><span class="arrow"></span></dt>
                <dd><a href="#">子菜单一</a></dd>
                <dd><a href="#">子菜单二</a></dd>
                <dd><a href="#">子菜单三子菜单三</a></dd>
            </dl>
        </li>
        <li>
        	<span class="Darrow"></span>
            <a href="#">菜单三</a>
        	<dl>
            	<dt><span class="arrow"></span></dt>
                <dd><a href="#">子菜单一</a></dd>
                <dd><a href="#">子菜单二</a></dd>
                <dd><a href="#">子菜单三子菜单三</a></dd>
            </dl>
        </li>
        <li>
        	<span class="Darrow"></span>
            <a href="#">菜单四</a>
        	<dl>
            	<dt><span class="arrow"></span></dt>
                <dd><a href="#">子菜单一</a></dd>
                <dd><a href="#">子菜单二</a></dd>
                <dd><a href="#">子菜单三</a></dd>
                <dd><a href="#">子菜单四</a></dd>
            </dl>
        </li>
        <li><a href="#">菜单五</a></li>
        <li><a href="#">菜单六</a></li>
        <li><a href="#">菜单七</a></li>
        <li class="last"><a href="#">菜单八</a></li>
    </ul>	-->
          <ul class="nav">
          	<li><a href="#">班级网站logo</a></li>
            <li><a href="#">个人中心</a></li>
           	<li class="first">
            	<span class="Menu"></span>
                <a>我的主页◢</a>
                <table>
                  <tr class="menu">
                      <td rowspan="2"><a href="#">主页</a></td>
                      <td><a href="#">日志</a></td>
                      <td><a href="#">相册</a></td>
                      <td><a href="#">说说</a></td>
                  </tr>
                  <tr>
                      <td><a href="#">留言板</a></td>
                      <td><a href="#">个人档</a></td>
                      <td><a href="#">收藏</a></td>
                  </tr>
             	</table>
           	</li>
            <li><a href="#">同学录</a></li>
            <li><a href="#">班级通知</a></li>
          </ul>
    </div>
    <div class="main">
    
    
    </div>
</body>
</html>
