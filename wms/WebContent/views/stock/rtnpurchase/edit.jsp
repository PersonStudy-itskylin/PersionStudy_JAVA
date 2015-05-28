<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="fm-bill" method="post" action="<c:url value='/stock/rtnPurchase/update'/>/${bill.id}">
	<jsp:include page="_form.jsp"></jsp:include>
</form>

