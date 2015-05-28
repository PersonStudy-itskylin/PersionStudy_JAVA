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
			$('#dt-goods').datagrid('load',{
				goodTypeId: (node?node.id:0),
				q: value
			});
		}
		function advanceQuery(){
			showQueryDialog({
				width:350,
				height:250,
				form:'<c:url value="/views/data/good/_query.jsp"/>',
				callback:function(data){
					var node = $('#t-types').tree('getSelected');
					data.goodTypeId = (node?node.id:0);
					//$('#q').val(data.name);
					$('#q').searchbox('setValue',data.name);
					$('#dt-goods').datagrid('load',data);
				}
			});
		}
		
		var url;
		function newItem(){
			$('#dlg').dialog('setTitle','新增商品资料').dialog('open');
			$('#myform').form('clear');
			var node = $('#t-types').tree('getSelected');
			if (node){
				$('#goodTypeId').combotree('setValue',node.id);
			}
			url = '<c:url value="/data/good/save"/>';
		}
		function editItem(){
			var row = $('#dt-goods').datagrid('getSelected');
			if (row){
				$('#dlg').dialog('setTitle','修改商品资料').dialog('open');
				$('#myform').form('load',row);
				url = '<c:url value="/data/good/update"/>?id=' + row.id;
			} else {
				$.messager.show({
					title:'提示',
					msg:'请先选择商品资料，再进行修改。'
				});
			}
		}
		function saveItem(){
			$('#myform').form('submit',{
				url:url,
				onSubmit:function(){return $(this).form('validate');},
				success:function(){
					$('#dlg').dialog('close');
					$('#dt-goods').datagrid('reload');
				}
			});
		}
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">商品资料</div>
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
			<ul id="t-types" url="<c:url value='/data/goodType/getTree'/>"></ul>
		</div>
		<div region="center" border="false">
			<table id="dt-goods" class="easyui-datagrid"
					url="<c:url value='/data/good/getItems'/>"
					fit="true" border="false" 
					pagination="true"
					singleSelect="true">
				<thead>
					<tr>
						<th field="goodTypeId" width="80" formatter="formatType" sortable="true">类别</th>
						<th field="code" width="80" sortable="true">编码</th>
						<th field="name" width="100" sortable="true">名称</th>
						<th field="unit" width="60">单位</th>
						<th field="model" width="100">型号</th>
						<th field="spec" width="100">规格</th>
						<th field="color" width="100">颜色</th>
						<th field="brand" width="100">品牌</th>
					</tr>
				</thead>
			</table>
			<script type="text/javascript">
				function formatType(value,row){
					if (row.goodType){
						return row.goodType.name;
					} else {
						return value;
					}
				}
			</script>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:550px;height:320px;"
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
