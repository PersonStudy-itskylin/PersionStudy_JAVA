<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	String dateFrom = new java.text.SimpleDateFormat("yyyy-MM").format(new java.util.Date(System.currentTimeMillis())) + "-01";
	String dateTo = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis()));
%>

<div class="easyui-layout" fit="true">
	<div region="north" border="false" style="background:#fafafa;height:40px;padding:5px;border-bottom:1px solid #92B7D0;text-align:right;overflow:hidden">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>日期从：</td>
				<td><input id="queryGood-dateFrom" class="easyui-datebox" value="<%=dateFrom %>" style="width:100px"></input></td>
				<td style="width:40px">到：</td>
				<td><input id="queryGood-dateTo" class="easyui-datebox" value="<%=dateTo %>" style="width:100px"></input></td>
				<td style="padding-left:5px">
					<a id="queryGood-search" href="#" onclick="javascript:queryGood_query()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
					<a id="queryGood-ok" href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true">选定</a>
				</td>
			</tr>
		</table>
	</div>
	<div region="center" border="false">
		<table id="queryGood-dt-goods" class1="easyui-datagrid"
				url="<c:url value='/stock/inStock/getRtnGoods'/>"
				fit="true" fitColumns="true" border="false" 
				pagination="true">
			<thead>
				<tr>
					<th field="ck" checkbox="true"></th>
					<th field="billCode" width="100">入库单号</th>
					<th field="billDate" width="80">单据日期</th>
					<th field="code" width="80">编码</th>
					<th field="name" width="130">名称</th>
					<th field="unit" width="60">单位</th>
					<th field="model" width="100">型号</th>
					<th field="spec" width="100">规格</th>
					<th field="billCount" width="80" align="right">入库数量</th>
					<th field="rtnCount" width="80" align="right">退货数量</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<input id="queryGood-intercourseId" type="hidden"></input>
<input id="queryGood-depotId" type="hidden"></input>

<script type="text/javascript">
	function queryGood_query(){
		$('#queryGood-dt-goods').datagrid('load',{
			intercourseId: $('#intercourseId').combogrid('getValue'),
			depotId: $('#depotId').combobox('getValue'),
			dateFrom: $('#queryGood-dateFrom').datebox('getValue'),
			dateTo: $('#queryGood-dateTo').datebox('getValue')
		});
	}
</script>