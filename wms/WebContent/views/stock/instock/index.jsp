<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<head>
	<script type="text/javascript" src="<c:url value='/js/jquery.combointercourse.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jquery.billgrid.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jquery.detailgrid.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/commons.js'/>"></script>
	<script type="text/javascript">
		$(function(){
			$('#dg-bills').billgrid({
				createUrl:'<c:url value="/stock/inStock/create"/>',
				editUrl:'<c:url value="/stock/inStock/edit"/>',
				destroyUrl:'<c:url value="/stock/inStock/destroy"/>',
				query:{
					title:'查询采购入库单',
					form:'<c:url value="/views/stock/instock/_query.jsp"/>',
					width:450,
					height:230,
					callback:function(){$('#q').searchbox('setValue','');}
				}
			});
		});
		function normalQuery(value){
			$('#dg-bills').billgrid('load',{
				code: value
			});
		}
		function formatDecimal(value){
			var val = parseFloat(value);
			return isNaN(val) ? value : val.toFixed(2);
		}
		function formatStatus(value,row){
			if (value == 0){
				return '编制';
			} else if (value == 1){
				return '审核';
			} else {
				return value;
			}
		}
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">采购入库单管理</div>
			<div class="toolbar">
				<table cellpadding="0" cellspacing="0" style="width:100%">
					<tr>
						<td>
							<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#dg-bills').billgrid('create')">增加</a>
							<a href="#" class="easyui-linkbutton" iconCls="icon-open" plain="true" onclick="$('#dg-bills').billgrid('edit')">打开</a>
							<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="$('#dg-bills').billgrid('destroy')">删除</a>
						</td>
						<td style="text-align:right">
							<input id="q" class="easyui-searchbox" prompt="按单据编号查询" searcher="normalQuery" style="width:200px"></input>
							<a href="#" class="easyui-linkbutton" plain="true" onclick="$('#dg-bills').billgrid('query')">高级查询</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div region="center" border="false">
			<table id="dg-bills" 
					url="<c:url value='/stock/inStock/getItems'/>"
					idField="id" fit="true" fitColumns="true" singleSelect="true"
					pagination="true" border="false" rownumbers="true">
				<thead>
					<tr>
						<th field="code" width="80">单据编号</th>
						<th field="billDate" width="60">单据日期</th>
						<th field="intercourseName" width="80">往来单位</th>
						<th field="depotName" width="60"">入库库房</th>
						<th field="remark" width="100"">备注</th>
						<th field="billCount" width="60" align="right">入库数量</th>
						<th field="billCost" width="80" align="right" formatter="formatDecimal">入库金额</th>
						<th field="status" width="40" align="center" formatter="formatStatus">状态</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	<div id="dlg-bill" class="easyui-dialog" title="入库单" style="width:800px;height:410px;position:relative"
			closed="true">
	</div>
</body>
