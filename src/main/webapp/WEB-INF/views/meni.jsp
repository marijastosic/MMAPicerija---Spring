<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container marketing">

	<security:authorize access="hasRole('ROLE_ADMIN')">
		<div class="row" style="text-align: center;">
			<a href="<c:url value="/admin/dodajPicu" />"
				class="btn btn-success btn-lg center"><strong>Dodaj
					novu picu</strong></a>
			<hr>
		</div>
		<div class="row">
			<div
				style="width: 150px; padding: 20px; margin-left: 20px; background-color: #ceffce; text-align: center; float: left; border: 1px solid gray;">
				<strong>AKTIVNA</strong>
			</div>
			<div
				style="width: 150px; padding: 20px; margin-right: 20px; background-color: #fb8484; text-align: center; float: right; border: 1px solid gray;">
				<strong>NEAKTIVNA</strong>
			</div>
		</div>
	</security:authorize>
	<c:forEach items="${listaPica}" var="pica">

		<security:authorize access="hasRole('ROLE_ADMIN')">
			<c:if test="${pica.aktivna == true}">
				<div class="col-lg-4"
					style="margin-top: 20px; border: 10px dashed gray; background: #ceffce;">
			</c:if>
			<c:if test="${pica.aktivna == false}">
				<div class="col-lg-4"
					style="margin-top: 20px; border: 10px dashed gray; background: #fb8484;">
			</c:if>
		</security:authorize>
		<security:authorize access="!hasRole('ROLE_ADMIN')">
			<div class="col-lg-4"
				style="margin-top: 20px; border: 10px dashed gray; background: #E2F6F7;">
		</security:authorize>
		<div style="text-align: center;">
			<img class="img-circle" width="140" height="140"
				src="${pica.slikaUrl}" style="margin-top: 10px" />
			<h2>${pica.naziv}</h2>
		</div>

		<p style="height: 80px">${pica.opis}</p>
		<p style="text-align: center;">
			


			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a class="btn btn-default" href="<c:url value="/admin/meni/${pica.id}"/>"
					role="button">Vidi detalje &raquo;</a>
				<a href="<c:url value="/admin/izmeniPicu/${pica.id}" />" class="btn btn-primary"><strong>Izmeni</strong></a>
				<a href="<c:url value="/admin/obrisiPicu/${pica.id}" />" class="btn btn-danger"><strong>Obriši</strong></a>
			</security:authorize>
			<security:authorize access="!hasRole('ROLE_ADMIN')">
				<a class="btn btn-default" href="<c:url value="/meni/${pica.id}"/>"
					role="button">Vidi detalje &raquo;</a>
			</security:authorize>
		</p>
</div>


</c:forEach>


</div>
<br>

<%@include file="template/footer.jsp"%>
