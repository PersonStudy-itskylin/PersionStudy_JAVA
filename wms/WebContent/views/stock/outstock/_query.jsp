<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div style="padding:10px">
	<div class="subtitle" style="border-bottom:1px solid #ccc">请输入查询参数：</div>
	<div style="padding:10px 0 10px 30px">
		<table cellpadding="0" cellspacing="2">
			<tr>
				<td>单据编号从：</td>
				<td style="width:125px"><input name="codeFrom" class="query" style="width:100px"></input></td>
				<td>到：</td>
				<td><input name="codeTo" class="query" style="width:100px"></input></td>
			</tr>
			<tr>
				<td>日期从：</td>
				<td><input name="dateFrom" class="query easyui-datebox" style="width:106px"></input></td>
				<td>到：</td>
				<td><input name="dateTo" class="query easyui-datebox" style="width:106px"></input></td>
			</tr>
			<tr>
				<td>往来单位：</td>
				<td><input name="intercourseId" class="query" style="width:106px"></input></td>
				<td>仓库：</td>
				<td>
					<input name="depotId" class="query easyui-combobox" style="width:106px"
							url="<c:url value='/data/depot/getItems'/>"
							valueField="id" textField="name"></input>
				</td>
			</tr>
			<tr>
			</tr>
		</table>
	</div>
</div>
<script>
	$('#dlg-query').find('input[name=intercourseId]').combointercourse({
		url:'<c:url value="/data/intercourse/getItems"/>'
	});
</script>