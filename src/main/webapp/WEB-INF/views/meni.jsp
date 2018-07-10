<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container marketing">

	<c:forEach items="${listaPica}" var="pica">

		<div class="col-lg-4"
			style="margin-top: 20px; border: 10px dashed gray; background: #E2F6F7; ">
			<div style="text-align: center;">
				<img class="img-circle" width="140" height="140"
					src="${pica.slikaUrl}" style="margin-top: 10px"/>
				<h2>${pica.naziv}</h2>
			</div>

			<p style="height: 80px">${pica.opis}</p>
			<p style="text-align: center;">
				<a class="btn btn-default"
					href="<c:url value="/meni/${pica.id}"/>" role="button">Vidi
					detalje &raquo;</a>
			</p>
		</div>


	</c:forEach>
	

</div>
<br>

<%@include file="template/footer.jsp"%>
