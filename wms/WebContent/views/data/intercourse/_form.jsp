<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div style="padding:20px">
	<table cellpadding="0" cellspacing="0" class="form-table">
		<tr>
			<td style="width:60px">单位编码</td>
			<td style="width:200px"><input name="code" style="width:150px"></input></td>
			<td style="width:60px">单位类别</td>
			<td>
				<input id="intercourseTypeId" name="intercourseTypeId" style="width:156px"
						class="easyui-combotree"
						url="<c:url value='/data/intercourseType/getTree'/>"></input>
			</td>
		</tr>
		<tr>
			<td>单位简称</td>
			<td><input name="shortName" class="easyui-validatebox" required="true" style="width:150px"></input></td>
			<td>单位全称</td>
			<td><input name="fullName" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>地址</td>
			<td colspan="3"><input name="addr" style="width:410px"></input></td>
		</tr>
		<tr>
			<td>邮编</td>
			<td><input name="postcode" style="width:150px"></input></td>
			<td>电话</td>
			<td><input name="phone" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>传真</td>
			<td><input name="fax" style="width:150px"></input></td>
			<td>网址</td>
			<td><input name="www" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td><input name="email" class="easyui-validatebox" validType="email" style="width:150px"></input></td>
			<td>负责人</td>
			<td><input name="answerMan" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>联系人</td>
			<td><input name="contactMan" style="width:150px"></input></td>
			<td>营业执照号</td>
			<td><input name="licence" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>开户银行</td>
			<td><input name="bank" style="width:150px"></input></td>
			<td>税务编码</td>
			<td><input name="taxCode" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>银行帐号</td>
			<td><input name="account" style="width:150px"></input></td>
			<td>助记码</td>
			<td><input name="help" style="width:150px"></input></td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="3"><input name="remark" style="width:410px"></input></td>
		</tr>
	</table>
</div>
