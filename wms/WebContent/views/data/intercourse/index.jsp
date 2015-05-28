<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<head>
	<script type="text/javascript" src="<c:url value='/js/commons.js'/>"></script>
	<script type="text/javascript">
		$(function(){
			$('#t-types').tree({
				onClick:function(){
					normalQuery();
				}
			});
		});
		function normalQuery(value){
			var node = $('#t-types').tree('getSelected');
			$('#dt-intercourses').datagrid('load',{
				intercourseTypeId: (node?node.id:0),
				q: value
			});
		}
		function advanceQuery(){
			showQueryDialog({
				width:350,
				height:230,
				form:'<c:url value="/views/data/intercourse/_query.jsp"/>',
				callback:function(data){
					var node = $('#t-types').tree('getSelected');
					data.intercourseTypeId = (node?node.id:0);
					$('#q').searchbox('setValue',data.name);
					$('#dt-intercourses').datagrid('load',data);
				}
			});
		}
		
		var url;
		function newItem(){
			$('#dlg').dialog('setTitle','新增往来单位').dialog('open');
			$('#myform').form('clear');
			var node = $('#t-types').tree('getSelected');
			if (node){
				$('#intercourseTypeId').combotree('setValue',node.id);
			}
			url = '<c:url value="/data/intercourse/save"/>';
		}
		function editItem(){
			var row = $('#dt-intercourses').datagrid('getSelected');
			if (row){
				$('#dlg').dialog('setTitle','修改往来单位').dialog('open');
				$('#myform').form('load',row);
				url = '<c:url value="/data/intercourse/update"/>?id=' + row.id;
			} else {
				$.messager.show({
					title:'提示',
					msg:'请先选择往来单位，再进行修改。'
				});
			}
		}
		function saveItem(){
			$('#myform').form('submit',{
				url:url,
				onSubmit:function(){return $(this).form('validate');},
				success:function(){
					$('#dlg').dialog('close');
					$('#dt-intercourses').datagrid('reload');
				}
			});
		}
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">往来单位</div>
			<div class="toolbar">
				<table cellpadding="0" cellspacing="0" style="width:100%">
					<tr>
						<td>
							<a href="javascript:newItem()" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
							<a href="javascript:editItem()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
						</td>
						<td style="text-align:right">
							<input id="q" class="easyui-searchbox" prompt="按编码|名称|助记码查询" searcher="normalQuery" style="width:200px"></input>
							<a href="javascript:advanceQuery()" class="easyui-linkbutton" plain="true">高级查询</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div region="west" border="false" style="width:150px;padding:5px;border-right:1px solid #92B7D0">
			<ul id="t-types" url="<c:url value='/data/intercourseType/getTree'/>"></ul>
		</div>
		<div region="center" border="false">
			<table id="dt-intercourses" class="easyui-datagrid"
					url="<c:url value='/data/intercourse/getItems'/>"
					fit="true" border="false" 
					pagination="true"
					singleSelect="true">
				<thead>
					<tr>
						<th field="intercourseTypeId" width="80" sortable="true" formatter="formatType">类别</th>
						<th field="code" width="80" sortable="true">编码</th>
						<th field="shortName" width="100" sortable="true">名称</th>
						<th field="postcode" width="60" sortable="true">邮编</th>
						<th field="addr" width="200" sortable="true">地址</th>
						<th field="phone" width="100" sortable="true">电话</th>
						<th field="fax" width="100" sortable="true">传真</th>
						<th field="contactMan" width="100" sortable="true">联系人</th>
					</tr>
				</thead>
			</table>
			<script type="text/javascript">
				function formatType(value,row){
					if (row.intercourseType){
						return row.intercourseType.name;
					} else {
						return value;
					}
				}
			</script>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:550px;height:360px"
			closed="true" modal="true" buttons="#dlg-buttons">
		<form id="myform" method="post">
			<jsp:include page="_form.jsp"></jsp:include>
		</form>
		<div id="dlg-buttons" style="text-align:center">
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="saveItem()">保存</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
	</div>
</body>
