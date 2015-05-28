<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div style="padding:20px">
	<table cellpadding="0" cellspacing="0" class="form-table">
		<tr>
			<td style="width:60px">商品编码</td>
			<td style="width:200px"><input name="code" style="width:150px"></input></td>
			<td style="width:60px">商品分类</td>
			<td>
				<input id="goodTypeId" name="goodTypeId" class="easyui-combotree" style="width:154px"
						url="<c:url value='/data/goodType/getTree'/>"
						required="true"></input>
			</td>
		</tr>
		<tr>
			<td>商品名称</td>
			<td><input name="name" class="easyui-validatebox" required="true" style="width:150px"></input></td>
			<td>商品规格</td>
			<td><input name="spec" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>计量单位</td>
			<td>
				<input name="unit" class="easyui-combobox" style="width:154px"
						url="<c:url value='/data/measureUnit/getItems'/>"
						valueField="name" textField="name" required="true"></input>
			</td>
			<td>型号</td>
			<td><input name="model" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>颜色</td>
			<td><input name="color" style="width:150px"></input></td>
			<td>品牌</td>
			<td><input name="brand" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>产地</td>
			<td><input name="place" style="width:150px"></input></td>
			<td>厂家</td>
			<td><input name="vender" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>助记码</td>
			<td><input name="help" style="width:150px"></input></td>
			<td>条形码</td>
			<td><input name="barcode" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>库存上限</td>
			<td><input name="countUp" class="easyui-numberbox" style="width:150px"></input></td>
			<td>库存下限</td>
			<td><input name="countDown" class="easyui-numberbox" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="3"><input name="remark" style="width:410px"></input></td>
		</tr>
	</table>
</div>