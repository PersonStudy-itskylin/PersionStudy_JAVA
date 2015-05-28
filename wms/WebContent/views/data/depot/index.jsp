<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    

<head>
    <script src="<c:url value="/js/jquery.edatagrid.js"/>"></script>
    <script src="<c:url value="/js/jquery.edatagrid.lang.js"/>"></script>
	<script type="text/javascript">
		var edg;
		$(function(){
			edg = $('#dt-depots').edatagrid({
				url:'<c:url value="/data/depot/getItems"/>',
				saveUrl:'<c:url value="/data/depot/save"/>',
				updateUrl:'<c:url value="/data/depot/update"/>',
				destroyUrl:'<c:url value="/data/depot/destroy"/>'
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">仓库资料</div>
			<div class="toolbar">
				<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="edg.edatagrid('reload')">刷新</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="edg.edatagrid('addRow')">新增</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="edg.edatagrid('saveRow')">保存</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="edg.edatagrid('cancelRow')">取消</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="edg.edatagrid('destroyRow')">删除</a>
			</div>
		</div>
		<div region="center" border="false" style1="padding:0 5px 5px 5px">
			<table id="dt-depots" fit="true" fitColumns="true" singleSelect="true" rownumbers="true" border="false">
				<thead>
					<tr>
						<th field="code" width="100" editor="text">仓库编码</th>
						<th field="name" width="200" editor="{type:'validatebox',options:{required:true}}">仓库名称</th>
						<th field="remark" width="300" editor="text">说明</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
