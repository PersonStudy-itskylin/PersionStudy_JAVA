<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<head>
	<style type="text/css">
		.e-input{
			border:1px solid #ccc;
			width:300px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			init();
		});
		function init(){
			$('#t-types').tree({
				onClick:function(node){
					$('#t-privileges').datagrid('reload', {privilegeTypeId:node.id});
				}
			});
			$('#t-privileges').datagrid({
				loadMsg:'',
				onRowContextMenu:function(e,index,row){
					e.preventDefault();
					$('#t-privileges').datagrid('clearSelections');
					$('#t-privileges').datagrid('selectRow', index);
					$('#mm').menu('show', {
						left:e.pageX,
						top:e.pageY
					});
				}
			});
		}
		function formatUrls(value, row){
			return '<pre style="margin:0">'+value+'</pre>';
		}
		function formatType(value, row){
			if (row.privilegeType) return row.privilegeType.name;
			return value;
		}

		var actionUrl;
		function newItem(){
			$('#dlg').dialog('setTitle', '新增权限').dialog('open');
			$('#myform').form('clear');
			actionUrl = '<c:url value="/system/privilege/save"/>';
		}
		function editItem(){
			var t = $('#t-privileges');
			var row = t.datagrid('getSelected');
			if (row){
				$('#myform').form('load', row);
				$('#dlg').dialog('setTitle', '修改权限').dialog('open');
				actionUrl = '<c:url value="/system/privilege/update"/>?id=' + row.id;
			}
		}
		function saveItem(){
			$('#myform').form('submit', {
				url:actionUrl,
				onSubmit:function(){
					return $('#myform').form('validate');
				},
				success:function(data){
					$('#dlg').dialog('close');
					$('#t-privileges').datagrid('reload');
				}
			});
		}
		function move(dir){
			var row = $('#t-privileges').datagrid('getSelected');
			$.getJSON('<c:url value="/system/privilege/move"/>', {id:row.id,dir:dir}, function(){
				$('#t-privileges').datagrid('reload');
			});
		}
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">权限管理</div>
			<div class="toolbar">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newItem()">新增权限</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editItem()">修改权限</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="move('up')">上移</a>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="move('down')">下移</a>
			</div>
		</div>
		<div region="west" border="false" style="border-right:1px solid #92B7D0;width:150px;">
			<div style="background:#fafafa;padding:5px;">
				权限分类
				<a href="<c:url value='/system/privilegeType/index'/>">修改</a>
			</div>
			<div style="padding:5px;">
				<ul id="t-types" url="<c:url value='/system/privilegeType/getTypes'/>"></ul>
			</div>
		</div>
		<div region="center" border="false">
			<table id="t-privileges"
					url="<c:url value='/system/privilege/getPrivileges'/>"
					singleSelect="true" rownumbers="true"
					idField="id"
					border="false" fit="true" fitColumns="true">
				<thead>
					<tr>
						<th field="name" width="100" sortable="true">权限名称</th>
						<th field="description" width="300">权限描述</th>
						<th field="urls" width="300" formatter="formatUrls">可访问路径</th>
						<th field="privilegeTypeId" width="100" sortable="true" formatter="formatType">分类</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" closed="true" modal="true" buttons="#dlg-buttons" style="padding:10px;width:480px;height:280px;">
		<form id="myform" method="post">
			<table>
				<tr>
					<td style="width:80px;">权限分类</td>
					<td>
						<input type="text" name="privilegeTypeId" class="easyui-combotree"
								url="<c:url value='/system/privilegeType/getTypes'/>"
								>
					</td>
				</tr>
				<tr>
					<td>权限名称</td>
					<td><input type="text" name="name" class="easyui-validatebox e-input" required="true"></input></td>
				</tr>
				<tr>
					<td>权限描述</td>
					<td><input type="text" name="description" class="e-input"></input></td>
				</tr>
				<tr>
					<td>可访问路径</td>
					<td><textarea name="urls" class="e-input" style="height:80px;"></textarea></td>
				</tr>
			</table>
		</form>
		<div id="dlg-buttons" style="text-align:center;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="saveItem()">保存</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
	</div>
	
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div iconCls="icon-add" onclick="newItem()">新增权限</div>
		<div iconCls="icon-edit" onclick="editItem()">修改权限</div>
		<div class="menu-sep"></div>
		<div onclick="move('up')">上移</div>
		<div onclick="move('down')">下移</div>
	</div>
</body>
