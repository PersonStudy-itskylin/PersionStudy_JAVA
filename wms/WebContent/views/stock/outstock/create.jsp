<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="fm-bill" method="post" action="<c:url value='/stock/outStock/save'/>">
	<jsp:include page="_form.jsp"></jsp:include>
</form>

