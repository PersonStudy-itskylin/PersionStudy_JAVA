<%@page import="com.ssi.depot.entity.ProductInOut"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>library.jsp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 
	 <script type="text/javascript">
	 		
	 </script>
	 
  </head>

 <%
	
		ProductInOut p = (ProductInOut) session.getAttribute("pro");
		
%>

<body >
	<div align="center">

		<h2>产品出入库单</h2>

		<table width="998" height="431" border="1" cellspacing="0"
			style="border-style:none;border-color: black">
			<s:iterator value="#session.pro">
			<tr>
				<td>硬件编号</td>
				<td><input type="text" style="border: none;" name="pioid"
					value="<s:property value="pioid"/>" /></td>
					
				<td>型号</td>
				<td><input type="text" style="border: none;" name="proid"
					value="<s:property value="proid"/>" /></td>
					
				<td>采购成本</td>
				<td><input type="text" style="border: none;" /></td>
			</tr>
			<tr>
				<td>产品类型</td>
				<td><input type="text" style="border: none;" name="piotype"
					value="<s:property value="piotype"/>" /></td>
				<td>灌机人</td>
				<td><input type="text" style="border: none;"
					name="piooperation" value="<s:property value="piooperation"/>" /></td>
				<td>灌机点数</td>
				<td><input type="text" style="border: none;"
					name="piooperationnum" value="<s:property value="piooperationnum"/>" /></td>
			</tr>
			<tr>
				<td>出库种类</td>
				<td>正式发货</td>
				<td rowspan="2">状态</td>
				<td rowspan="2" colspan="4"><input type="checkbox" id="state"
					value="1" /> 借出测试 <input type="checkbox" id="state" value="2" />
					送出维修 <input type="checkbox" id="state" value="3" /> 归还外来厂商设备 <input
					type="checkbox" id="state" value="4" /> 其他</td>
			</tr>
			<tr>
				<td>合同编号</td>
				<td><input type="text" style="border: none;"
					name="pioagreementid" value="<s:property value="pioagreementid"/>" /></td>
			</tr>
			<tr>
				<td>项目编号</td>
				<td><input type="text" style="border: none;"
					name="pioprojectid" value="<s:property value="pioprojectid"/>" /></td>
				<td colspan="2" style="padding-left: 100px">项目名称</td>
				<td colspan="2"><input type="text"
					style="border: none;width:100%;" name="pioprojectname"
					value="<s:property value="pioprojectname"/>" /></td>
			</tr>
			<tr>
				<td height="42">出库时间</td>
				<td><input type="text" style="border: none;width:100%;"
					name="piouttime" value="<s:property value="piouttime"/>" /></td>
				<td>&nbsp;&nbsp;签约公司<br /> (或最终用户)
				</td>
				<td colspan="3"><input type="text"
					style="border: none;width:100%;" name="piosign"
					value="<s:property value="piosign"/>" /></td>
			</tr>
			<tr>
				<td>申请人</td>
				<td colspan="5"><input type="text"
					style="border: none;width:100%;" name="pioapply"
					value="<s:property value="pioapply"/>" /></td>
			</tr>
			<tr>
				<td>提货人</td>
				<td colspan="5"><input type="text"
					style="border: none;width:100%;" name="piodelivery"
					value="<s:property value="piodelivery"/>" /></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="5"><input type="text"
					style="border: none;width:100%;" name="pioremark"
					value="<s:property value="pioremark"/>" /></td>
			</tr>
			<tr>
				<td>库管签字</td>
				<td colspan="5"><input type="text"
					style="border: none;width:100%;" name="pioadminsign"
					value="<s:property value="pioadminsign"/>" /></td>
			</tr>
			</s:iterator>
		</table>

	</div>


  </body>
</html>
