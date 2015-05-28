<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div style="padding:5px;background:#fafafa;border-bottom:1px solid #eee;">
	<table cellpadding="0" cellspacing="0" style="width:100%">
		<tr>
			<td>
				<c:if test="${editable==true }">
					<a id="btn-submit1" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-save" onclick="javascript:submitBill(1)">保存单据</a>
					<a id="btn-submit2" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-saves" onclick="javascript:submitBill(2)">保存并新建</a>
				</c:if>
				<c:if test="${checkable==true }">
					<a id="btn-check" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-check" onclick="javascript:checkBill(${bill.id})">审核单据</a>
				</c:if>
				<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="javascript:$('#dlg-bill').dialog('close')">关闭</a>
			</td>
			<td style="text-align:right">
				<c:if test="${editable==true }">
					<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="javascript:$('#dg-details').detailgrid('addGood')">添加商品</a>
					<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="javascript:$('#dg-details').detailgrid('delGood')">删除商品</a>
				</c:if>
			</td>
		</tr>
	</table>
</div>

<div style="padding:10px">
	<div style="padding-left:90px">
		<table cellpadding="0" cellspacing="0" class="form-table">
			<tr>
				<td style="width:60px">单据编号</td>
				<td style="width:260px"><input name="code" value="${bill.code }" readOnly="true" style="width:174px"></input></td>
				<td style="width:60px">单据日期</td>
				<td><input name="billDate" class="easyui-datebox" value="${bill.billDate }"></input></td>
			</tr>
			<tr>
				<td>往来单位</td>
				<td>
					<input id="intercourseId" name="intercourseId" value="${bill.intercourseId }" required="true" style="width:180px"></input>
				</td>
				<td>入库仓库</td>
				<td>
					<input name="depotId" class="easyui-combobox" style="width:180px"
							value="${bill.depotId }"
							url="<c:url value='/data/depot/getItems'/>"
							valueField="id" textField="name"
							required="true"></input>
				</td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><input name="remark" value="${bill.remark }" style="width:494px"></input></td>
			</tr>
		</table>
	</div>
	<div style="margin:10px 0;">
		<table id="dg-details" style="height:200px"
				url="<c:url value="${detailUrl}"/>"
				fitColumns="true" singleSelect="true"
				rownumbers="true" showFooter="true">
			<thead>
				<tr>
					<th field="code" width="100">商品编码</th>
					<th field="name" width="120">商品名称</th>
					<th field="model" width="100">型号</th>
					<th field="spec" width="100">规格</th>
					<th field="unit" width="60">单位</th>
					<th field="billCount" width="80" align="right" editor="numberbox">数量</th>
					<th field="billPrice" width="100" align="right" formatter="formatDecimal" editor="{type:'numberbox',options:{precision:2}}">单价</th>
					<th field="billCost" width="100" align="right" formatter="formatDecimal">合价</th>
				</tr>
			</thead>
		</table>
	</div>
	<div style="margin-top:10px">
		<table cellpadding="0" cellspacing="0" style="width:100%">
			<tr>
				<td style="width:50px;text-align:right">制单人：</td>
				<td style="width:50px;text-align:center;border-bottom:1px solid #ccc">${bill.writeUser.name }</td>
				<td style="width:80px;text-align:right">制单时间：</td>
				<td style="width:130px;text-align:center;border-bottom:1px solid #ccc">${bill.writeDate }</td>
				<td>&nbsp;</td>
				<td style="width:50px;text-align:right">审核人：</td>
				<td style="width:50px;text-align:center;border-bottom:1px solid #ccc">${bill.checkUser.name }</td>
				<td style="width:80px;text-align:right">审核时间：</td>
				<td style="width:130px;text-align:center;border-bottom:1px solid #ccc">${bill.checkDate }</td>
			</tr>
		</table>
	</div>
</div>
<input id="goods" name="goods" type="hidden"></input>
<input id="bill-editable" type="hidden" value="${editable }"></input>

<script type="text/javascript">
	$('#intercourseId').combointercourse({
		url:'<c:url value="/data/intercourse/getItems"/>',
		pageSize:2,
		pageList:[2,5,10,20]
	});
	$('#intercourseId').combogrid('setText','${bill.intercourse.shortName}');
	$('#dg-details').detailgrid({
		editable: ($('#bill-editable').val()=='true')
	});
</script>
