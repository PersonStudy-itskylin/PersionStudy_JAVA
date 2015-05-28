<%-- 
    Document   : main
    Created on : 2008-3-21, 19:26:18
    Author     : Administrator
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html style="height:100%">
    <head>
        <jsp:include page="_head.jsp"></jsp:include>
        <decorator:head />
    </head>
    <body style="margin:0;padding:0;height:100%;overflow:hidden;background:#F2FBFF">
   		<div class="mainwrap">
   			<div id="mainlayout" class="easyui-layout" fit="true">
   				<div region="north" border="false" style="height:94px;background:#A1C4ff">
   					<jsp:include page="_north.jsp"></jsp:include>
   				</div>
    			<div region="center" border="false" style="overflow:hidden">
    				<decorator:body />
    			</div>
   			</div>
   		</div>
    </body>
</html>
