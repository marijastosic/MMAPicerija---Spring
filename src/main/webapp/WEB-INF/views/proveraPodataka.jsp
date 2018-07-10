<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
	<div class="page-header">
		<h1 style="font: 40px;">Vaši podaci:</h1>
		<br>
		<p class="lead">Molimo proverite Vaše podatke kako bi porudžbina
			bila dostavljena na pravu adresu!</p>
	</div>
	<form:form action="${pageContext.request.contextPath}/racun"
								method="post" role="form" modelAttribute="korisnik">
		<div class="form-group">
			<label for="email">Ime</label> <input type="text" name="ime"
				value="${korisnik.ime}" id="confirm-password" tabindex="2"
				class="form-control" disabled="disabled">
		</div>
		<div class="form-group">
			<label for="email">Prezime</label> <input type="text" name="prezime"
				value="${korisnik.prezime}" id="confirm-password" tabindex="2"
				class="form-control" disabled="disabled">
		</div>
		<div class="form-group">
			<label for="email">Telefon</label> <input type="text" name="telefon"
				value="${korisnik.telefon}" id="confirm-password" tabindex="2"
				class="form-control" placeholder="Telefon">
		</div>
		<div class="form-group">
			<label for="email">Adresa</label> <input type="text" name="adresa"
				value="${korisnik.adresa}" id="confirm-password" tabindex="2"
				class="form-control" placeholder="Adresa">
		</div>
		<hr>
		<div class="row col-lg-12">
			<a href="<c:url value="/korpa" />" class="btn btn-default"
				style="float: left;">&laquo Povratak na korpu</a> 
			<button type="submit" class="btn btn-default"
				style="float: right; margin-right: -30px;">Nastavak &raquo</button>
		</div>
	</form:form>
</div>
<br />
<br />



















<%@include file="template/footer.jsp"%>