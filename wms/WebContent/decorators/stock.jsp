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
    	<div id="loading-mask"><div id="loading-msg">正在加载...</div></div>
   		<div class="mainwrap">
   			<div id="mainlayout" class="easyui-layout" fit="true">
   				<div region="north" border="false" style="height:94px;background:#A1C4ff">
   					<jsp:include page="_north.jsp"></jsp:include>
   				</div>
   				<div region="east" border="false" style="padding:5px;width:170px;border-left:1px solid #92B7D0">
   					<div class="subtitle">相关单据</div>
					<div class="submenu" style="padding:0 20px;">
						<a href="<c:url value='/stock/inStock/index'/>">采购入库单</a>
						<a href="<c:url value='/stock/rtnPurchase/index'/>">采购退货单</a>
						<a href="<c:url value='/stock/outStock/index'/>">销售出库单</a>
						<a href="<c:url value='/stock/transfer/index'/>">商品调拨单</a>
						<a href="<c:url value='/stock/inStock/index'/>">盘点单</a>
					</div>
					<div class="subtitle">相关查询</div>
					<div class="submenu" style="padding:0 20px;">
						<a href="<c:url value='/stock/stock/index1'/>">库存数量表</a>
						<a href="<c:url value='/stock/stock/index2'/>">库存状况表</a>
					</div>
   				</div>
    			<div region="center" border="false" style="overflow:hidden">
    				<decorator:body />
    			</div>
   			</div>
   		</div>
    </body>
</html>
