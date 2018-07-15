<%@include file="template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="fullscreen_bg" class="fullscreen_bg">
	<div class="container">
		<table class="table table-hover table-striped">
			<thead>
				<th>Korisnik</th>
				<th>Adresa</th>
				<th>Telefon</th>
				<th>Datum</th>
				<th>Iznos</th>
				<th>Vidi porudžbinu</th>
			</thead>
			<tbody>
				<c:forEach items="${listaPorudzbina}" var="porudzbina">
					<tr>
						<td>${porudzbina.korisnikId.ime} ${porudzbina.korisnikId.prezime}</td>
						<td>${porudzbina.adresa}</td>
						<td>${porudzbina.telefon}</td>
						<td>${porudzbina.datumString}</td>
						<td>${porudzbina.ukupanIznos}</td>
						<td><a href="<c:url value="/admin/porudzbina/${porudzbina.id}"/>">Vidi porudžbinu</a></td>
					</tr>
										
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<%@include file="template/footer.jsp"%>
