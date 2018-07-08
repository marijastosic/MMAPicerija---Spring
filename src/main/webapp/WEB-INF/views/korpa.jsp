<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Porudzbina</h1>
					<p>Mozete videti sve porudzbine koje ste napravili</p>
				</div>
			</div>
		</section>
		
		<section class="container">
			<div>
				<div>
					<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign"></span> Očisti korpu</a>
					<a class="btn btn-success pull-right" href=""<c:url value="/placanje"/>""><span class="glyphicon glyphicon-shopping-cart"></span> Završi kupovinu</a>
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
					<c:forEach items="${listaStavki}" var="stavka">
						<tr>
							<td>${stavka.picaId.naziv}</td>
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
						<th>${ukupanIznos}</th>
						<th></th>
					</tr>
				</table>
				
				<a href="<c:url value="/meni"/>" class="btn btn-default">Nastavite kupovinu</a>
			
			</div>
		</section>
	</div>
</div>
<br/><br/>
<script src="/resources/js/controller.js"></script>


 
<%@include file="template/footer.jsp"%>
