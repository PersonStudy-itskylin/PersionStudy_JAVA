<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<head>
	<script type="text/javascript">
		$(function(){
			init();
		});
		function init(){
			$('#mytree').tree({
				onClick: function(node){
					$(this).tree('expand', node.target);
				},
				onContextMenu: function(e, node){
					e.preventDefault();
					$('#mytree').tree('select', node.target);
					$('#mm').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				},
				onDrop: function(target, source, point){
					var targetId = $('#mytree').tree('getNode', target).id;
					$.ajax({
						url: '<c:url value="/system/department/dnd"/>?id=' + source.id,
						data: {
							targetId: targetId,
							point: point
						},
						dataType: 'json',
						method: 'post',
						success: function(data){
						}
					});
				}
			});
		}
		function expandAll(){
			var node = $('#mytree').tree('getSelected');
			$('#mytree').tree('expandAll', node ? node.target : null);
		}
		function collapseAll(){
			var node = $('#mytree').tree('getSelected');
			$('#mytree').tree('collapseAll', node ? node.target : null);
		}
		
		var actionUrl;
		function createItem(){
			$('#myform').form('clear');
			$('#dlg').dialog('setTitle', '新建部门').dialog('open');
			var node = $('#mytree').tree('getSelected');
			if (node){
				$('#pname').html(node.text);
				actionUrl = '<c:url value="/system/department/save"/>' + '?parentId=' + node.id;
			} else {
				$('#pname').html('');
				actionUrl = '<c:url value="/system/department/save"/>' + '?parentId=0';
			}
		}
		function editItem(){
			var node = $('#mytree').tree('getSelected');
			if (node){
				var pnode = $('#mytree').tree('getParent', node.target);
				$('#pname').html(pnode ? pnode.text : '');
				$('#myform input[name=name]').val(node.text);
				$('#dlg').dialog('open').dialog('setTitle', '修改部门');
				actionUrl = '<c:url value="/system/department/update"/>?id=' + node.id;
			}
		}
		function saveItem(){
			$('#myform').form('submit', {
				url:actionUrl,
				onSubmit: function(){
					return $('#myform').form('validate');
				},
				success:function(data){
					var data = eval('(' + data + ')');
					var node = $('#mytree').tree('getSelected');
					if (node){
						if (data.action == 'append'){
							$('#mytree').tree('append', {
								parent: node.target,
								data: [data]
							});
						} else {
							node.text = data.text;
							$('#mytree').tree('update', node);
						}
					} else {
						$('#mytree').tree('reload');
					}
					$('#dlg').dialog('close');
				}
			});
		}
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">组织机构</div>
			<div class="toolbar">
				<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="createItem()">新增部门</a>
				<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="editItem()">修改部门</a>
			</div>
		</div>
		<div region="center" border="false" style="padding:10px;">
			<ul id="mytree" dnd="true" url="<c:url value='/system/department/getItems'/>"></ul>
		</div>
	</div>
	
	<div id="dlg" style="width:300px;height:180px;padding:20px 0px 10px 20px;"
			class="easyui-dialog"
			title="添加" closed="true" modal="true">
		<form id="myform" method="post" enctype="application/x-www-form-urlencoded">
			<table style="font-size:12px;">
				<tr>
					<td>上级部门：</td>
					<td><span id="pname"></span></td>
				</tr>
				<tr>
					<td>部门名称：</td>
					<td><input type="text" name="name" class="easyui-validatebox" required="true"></input></td>
				</tr>
			</table>
		</form>
		<div style="text-align:center;margin-top:20px;">
			<a href="#" class="easyui-linkbutton" onclick="saveItem()">保存</a>
			<a href="#" class="easyui-linkbutton" onclick="$('#dlg').dialog('close')">取消</a>
		</div>
	</div>
	
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div iconCls="icon-add" onclick="createItem()">新增类型</div>
		<div iconCls="icon-edit" onclick="editItem()">修改类型</div>
		<div class="menu-sep"></div>
		<div onclick="expandAll()">全部展开</div>
		<div onclick="collapseAll()">全部收缩</div>
	</div>

</body>
