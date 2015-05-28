<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<head>
	<script src="<c:url value="/js/jquery.edatagrid.js"/>"></script>
	<script src="<c:url value="/js/jquery.edatagrid.lang.js"/>"></script>
	<script type="text/javascript">
		var edg;
		$(function(){
			edg = $('#dt-types').edatagrid({
				url:'<c:url value="/data/goodType/getItems"/>',
				saveUrl:'<c:url value="/data/goodType/save"/>',
				updateUrl:'<c:url value="/data/goodType/update"/>',
				destroyUrl:'<c:url value="/data/goodType/destroy"/>',
				
				tree: '#t-types',
				treeUrl: '<c:url value="/data/goodType/getTree"/>',
				treeDndUrl: '<c:url value="/data/goodType/dnd"/>'
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">商品分类</div>
			<div class="toolbar">
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="edg.edatagrid('reload')">刷新</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="edg.edatagrid('addRow')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="edg.edatagrid('saveRow')">保存</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="edg.edatagrid('cancelRow')">取消</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="edg.edatagrid('destroyRow')">删除</a>
			</div>
		</div>
		<div region="west" border="false" style="width:150px;padding:5px;border-right:1px solid #92B7D0">
			<ul id="t-types" dnd="true"></ul>
		</div>
		<div region="center" border="false">
			<table id="dt-types" fit="true" fitColumns="true" border="false" singleSelect="true" rownumbers="true">
				<thead>
					<tr>
						<th field="code" width="100" editor="text">分类编码</th>
						<th field="name" width="200" editor="{type:'validatebox',options:{required:true}}">分类名称</th>
						<th field="remark" width="200" editor="text">说明</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
