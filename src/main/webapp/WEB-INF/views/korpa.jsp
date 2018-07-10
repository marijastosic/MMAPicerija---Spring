<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Korpa</h1>
					<p>U tabeli ispod možete videti sve stavke koje se nalaze u Vašoj korpi.</p>
				</div>
			</div>
		</section>
		
		<section>
			<div>
				<div>
					<c:if test="${fn:length(listaStavkiKorpe) > 0}">
						<a href="<c:url value="/ocistiKorpu"/>"  class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign"></span> Očisti korpu</a>
						<a href="<c:url value="/proveraPodataka"/>" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Završi kupovinu</a>
					</c:if>
				</div>
				<br><br>
				<table class="table table-hover">
					<tr>
						<th>Naziv pice</th>
						<th>Cena</th>
						<th>Količina</th>
						<th>Ukupna cena</th>
						<th>Obriši iz korpe</th>
					</tr>
					<c:forEach items="${listaStavkiKorpe}" var="stavka">
						<tr>
							<td><a href="<c:url value="/meni/${stavka.picaId.id}"/>">${stavka.picaId.naziv}</a></td>
							<td>${stavka.picaId.cena}</td>
							<td>${stavka.kolicina}</td>
							<td>${stavka.picaId.cena * stavka.kolicina}</td>
							<td><a href="<c:url value="/obrisiStavku/${stavka.id}"/>" class="label label-danger" ><span class="glyphicon glyphicon-remove"></span> obriši</a></td>
						</tr>
					</c:forEach>
					<tr>
						<th></th>
						<th></th>
						<th>Ukupan iznos</th>
						<th>${ukupanIznos} Din</th>
						<th></th>
					</tr>
				</table>
				
				<a href="<c:url value="/meni"/>" class="btn btn-primary active">Nastavite kupovinu</a>
			
			</div>
		</section>
	</div>
</div>
<br/><br/>
<script src="/resources/js/controller.js"></script>


 
<%@include file="template/footer.jsp"%>
