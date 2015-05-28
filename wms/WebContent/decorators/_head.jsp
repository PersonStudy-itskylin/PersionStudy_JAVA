<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>仓库管理系统</title>
        <link rel="stylesheet" href="<c:url value="/easyui/themes/default/easyui.css"/>" type="text/css" media="screen" />
        <link rel="stylesheet" href="<c:url value="/easyui/themes/icon.css"/>" type="text/css" media="screen" />
        <link rel="stylesheet" href="<c:url value="/css/main.css"/>" type="text/css" media="screen" />
        <script src="<c:url value="/easyui/jquery-1.6.2.min.js"/>"></script>
        <script src="<c:url value="/easyui/jquery.easyui.min.js"/>"></script>
        <script src="<c:url value="/easyui/locale/easyui-lang-zh_CN.js"/>"></script>
        <script type="text/javascript">
        	var contextPath = '<%=request.getContextPath()%>';
        	$.parser.onComplete = function(){
            	$('body').css('visibility','visible');
            	setTimeout(function(){
	            	$('#loading-mask').remove();
            	},50);
        	};
        	$(function(){
            	$(window).resize(function(){
                	$('#mainlayout').layout('resize');
            	});
        	});
        </script>
