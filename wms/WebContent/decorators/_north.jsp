<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="header">
	<div style="padding:10px;text-align:right;">
		<span style="color:#ddd">欢迎你，${rbac.currentUser.name }</span>
		<a href="<c:url value='/home/logout'/>" style="color:#fff">退出</a>
	</div>
	<div class="toptitle">仓库管理系统</div>
</div>
<div class="topmenu">
	<a href="#" class="easyui-linkbutton" plain="true">首页</a>
	<a href="#" class="easyui-menubutton" menu="#menu-stock">业务单据</a>
	<a href="#" class="easyui-menubutton" menu="#menu-data">数据维护</a>
	<a href="#" class="easyui-menubutton" menu="#menu-system">系统管理</a>
</div>

<div id="menu-stock" class="easyui-menu" style="width:150px">
	<div href="<c:url value="/stock/inStock/index"/>">采购入库单</div>
	<div href="<c:url value="/stock/outStock/index"/>">销售出库单</div>
	<div href="<c:url value="/stock/transfer/index"/>">商品调拨单</div>
</div>
<div id="menu-data" class="easyui-menu" style="width:150px">
	<div href="<c:url value="/data/depot/index"/>">仓库资料</div>
	<div href="<c:url value="/data/measureUnit/index"/>">计量单位</div>
	<div class="menu-sep"></div>
	<div href="<c:url value="/data/goodType/index"/>">商品分类</div>
	<div href="<c:url value="/data/good/index"/>">商品资料</div>
	<div class="menu-sep"></div>
	<div href="<c:url value="/data/intercourseType/index"/>">往来单位分类</div>
	<div href="<c:url value="/data/intercourse/index"/>">往来单位</div>
</div>
<div id="menu-system" class="easyui-menu" style="width:150px">
	<div href="<c:url value='/system/user/index'/>">用户管理</div>
	<div href="<c:url value='/system/role/index'/>">角色管理</div>
	<div href="<c:url value='/system/privilege/index'/>">权限管理</div>
	<div href="<c:url value='/system/department/index'/>">组织机构</div>
</div>
					