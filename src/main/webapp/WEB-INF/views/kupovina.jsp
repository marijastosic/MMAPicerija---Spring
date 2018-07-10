<%@include file="template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="container" style="text-align: center">
	<div class="page-header">
		<h1 style="font: 40px;">Poštovani/a, ${k.ime}</h1>
		<h1>uspešno ste poručili Vašu picu</h1>
		<br />
		<br />

		<p class="lead">Porudžbina biće dostavljena u što kraćem roku.</p>
	</div>
    <img alt="image" src="<c:url value="/resources/images/pizza_cat.jpg"/>" style="width: 25%" />
	<br />
	<br />

	<h2>Hvala na ukazanom poverenju.</h2>
	<br /><br/>
</div>

<br />
<br />

<%@include file="template/footer.jsp"%>