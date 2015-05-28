<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<head>
	<script type="text/javascript">
		function formatDecimal(value){
			var val = parseFloat(value);
			return isNaN(val) ? value : val.toFixed(2);
		}
		function doQuery(){
			$('#dg-stocks').datagrid('load',{
				depotId: $('#depot').combobox('getValue'),
				goodTypeId: $('#goodType').combotree('getValue'),
				q: $('#q').val()
			});
		}
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">库存数量表</div>
			<div class="toolbar">
				<table cellpadding="0" cellspacing="0">
					<tr>
						<td>仓库：</td>
						<td>
							<input id="depot" class="easyui-combobox"
									url="<c:url value='/data/depot/getItems'/>"
									valueField="id" textField="name"></input>
						</td>
						<td style="width:30px">&nbsp;</td>
						<td>分类：</td>
						<td>
							<input id="goodType" class="easyui-combotree"
									url="<c:url value='/data/goodType/getTree'/>"></input>
						</td>
						<td style="width:30px">&nbsp;</td>
						<td>商品：</td>
						<td><input id="q"></input></td>
						<td style="width:30px">&nbsp;</td>
						<td>
							<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doQuery()">查询</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div region="center" border="false">
			<table id="dg-stocks" class="easyui-datagrid"
					url="<c:url value='/stock/stock/getItems'/>"
					rownumbers="true" fit="true" fitColumns="true" singleSelect="true" border="false"
					pagination="true" showFooter="true">
				<thead>
					<tr>
						<th field="code" width="80" sortable="true">编码</th>
						<th field="name" width="100" sortable="true">名称</th>
						<th field="model" width="100">型号</th>
						<th field="spec" width="100">规格</th>
						<th field="unit" width="60">单位</th>
						<th field="depotName" width="80">仓库</th>
						<th field="count" width="60" align="right">数量</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
