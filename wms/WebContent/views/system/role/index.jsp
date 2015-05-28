<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<head>
	<script type="text/javascript">
		$(function(){
			init();
		});
		function init(){
			$('#dlg').dialog({
				onOpen:function(){
					$('#tabs').tabs('resize');
				}
			});
		}

		var actionUrl;
		function newItem(){
			$('#myform').form('clear');
			$('#dlg').dialog('setTitle', '新增角色').dialog('open');
			actionUrl = '<c:url value="/system/role/save"/>';
		}
		function editItem(){
			var row = $('#t-roles').datagrid('getSelected');
			if (row){
				$('#myform').form('load', row);
				$('input[name=pids]','#myform').attr('checked',false);
				if (row.privilegeIds){
					var ids = row.privilegeIds.split(',');
					for(var i=0; i<ids.length; i++){
						$('#privilege-'+ids[i]).attr('checked',true);
					}
				}
				$('#dlg').dialog('setTitle', '修改角色').dialog('open');
				actionUrl = '<c:url value="/system/role/update"/>?id=' + row.id;
			}
		}
		function saveItem(){
			$('#myform').form('submit', {
				url: actionUrl,
				onSubmit:function(){
					return $('#myform').form('validate');
				},
				success: function(data){
					$('#dlg').dialog('close');
					$('#t-roles').datagrid('reload');
				}
			});
		}
		function move(dir){
			var row = $('#t-roles').datagrid('getSelected');
			if (row){
				$.ajax({
					url:'<c:url value="/system/role/move"/>',
					data:{
						id:row.id,
						dir:dir
					},
					type:'post',
					success:function(){
						$('#t-roles').datagrid('reload');
					}
				});
			}
		}
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">角色管理</div>
			<div class="toolbar">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newItem()">新增角色</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editItem()">修改角色</a>
				<a href="#" class="easyui-linkbutton" plain="true" onclick="move('up')">上移</a>
				<a href="#" class="easyui-linkbutton" plain="true" onclick="move('down')">下移</a>
			</div>
		</div>
		<div region="center" border="false">
			<table id="t-roles" class="easyui-datagrid"
					url="<c:url value='/system/role/getRoles'/>"
					rownumbers="true" singleSelect="true" idField="id"
					fit="true" fitColumns="true" border="false">
				<thead>
					<tr>
						<th field="name" width="100">角色名称</th>
						<th field="description" width="200">角色描述</th>
						<th field="privileges" width="400">授权</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:400px;height:300px;padding:5px;"
			closed="true" modal="true">
		<form id="myform" method="post" style="margin:0;padding:0;width:375px;height:210px;">
			<div id="tabs" class="easyui-tabs" fit="true" plain="true">
				<div title="角色" style="padding:20px;">
					<table>
						<tr>
							<td>角色名称</td>
							<td>
								<input type="text" class="easyui-validatebox"
										style="width:230px;border:1px solid #ccc"
										name="name" required="true">
							</td>
						</tr>
						<tr>
							<td>角色描述</td>
							<td>
								<textarea style="width:230px;height:100px;border:1px solid #ccc;font-size:12px;"
										name="description"></textarea>
							</td>
						</tr>
					</table>
				</div>
				<div title="授权" style="padding:10px;">
					<c:forEach items="${types }" var="type">
						<div>
							<span>${type.name }</span>
							<c:forEach items="${type.privileges }" var="p">
								<div style="padding-left:10px;">
									<input type="checkbox" id="privilege-${p.id }" name="pids" value="${p.id }"></input>
									<span>${p.name }</span>
								</div>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
		</form>
		<div style="margin-top:10px;text-align:center;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="saveItem()">保存</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
	</div>
</body>
