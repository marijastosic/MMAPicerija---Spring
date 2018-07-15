<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@include file="template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="fullscreen_bg" class="fullscreen_bg">
	<div class="container">
		<h1>Porudžbina</h1>
		<br>
		<h4>Kupac: ${porudzbina.korisnikId.ime} ${porudzbina.korisnikId.prezime}</h4>
		<h4>Adresa: ${porudzbina.adresa}</h4>
		<h4>Telefon: ${porudzbina.telefon}</h4>
		<h4>Datum: ${porudzbina.datumString}</h4>
		<hr>
		<table class="table table-hover table-striped">
			<thead>
				<th>Pica</th>
				<th>Cena</th>
				<th>Količina</th>
				<th>Ukupno</th>
			</thead>
			<tbody>
				<c:forEach items="${porudzbina.stavkaPorudzbineList}" var="stavka">
					<tr>
						<td>${stavka.picaId.naziv}</td>
						<td>${stavka.picaId.cena}</td>
						<td>${stavka.kolicina}</td>
						<td>${stavka.ukupanIznos}</td>
					</tr>
										
				</c:forEach>
			</tbody>
		</table>
		<div class="row container">
			<a href="<c:url value="/admin/svePorudzbine"/>" class="btn btn-default" style="float: left;">Nazad</a>
			<h4 style="float: right;"> Ukupan iznos: ${porudzbina.ukupanIznos}</h4>
		</div>
		
	</div>
	<br><br><br><br><br><br><br><br><br><br><br>
</div>

<%@include file="template/footer.jsp"%>
