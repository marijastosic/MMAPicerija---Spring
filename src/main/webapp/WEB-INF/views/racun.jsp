<%@page import="com.demo.mmapicerija.entities.Korisnik"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
	<div
		class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

		<div class="text-center">
			<h1>Porudžbina</h1>
		</div>
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6">
				<address>
					<p><strong>Kupac:</strong></p> 
					${korisnik.ime} ${korisnik.prezime}
					<br> ${korisnik.telefon} <br> ${korisnik.adresa}
				</address>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 text-right">
			<img src="<c:url value="/resources/images/logo_porudzbina.PNG"/>"
                         style="position: relative; height:70px; margin-top: -80px;" />
				<p>Datum:
				${datum}</p>
				
			</div>
		</div>

		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Pica</th>
						<th class="text-center">Količina</th>
						<th class="text-center">Cena</th>
						<th class="text-right">Ukupno</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stavka" items="${listaStavkiKorpe}">
						<tr>
							<td class="col-md-9"><em>${stavka.picaId.naziv}</em></td>
							<td class="col-md-1" style="text-align: center;">${stavka.kolicina}</td>
							<td class="col-md-1" style="text-align: center;">${stavka.picaId.cena}</td>
							<td class="col-md-1" style="text-align: right;">${stavka.picaId.cena * stavka.kolicina}</td>
						</tr>
					</c:forEach>

					<tr>
						<td></td>
						<td></td>
						<td class="text-right">
							<h4>
								<strong>Ukupno: </strong>
							</h4>
						</td>
						<td class="text-center text-danger">
							<h4>
								<strong>${ukupanIznos}</strong>
							</h4>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<br>

		<div class="row">
			<input style="float: right;" type="submit" value="Potvrdi porudžbinu"
				class="btn btn-default" /> <a style="float: left;"
				href="<c:url value="/" />" class="btn btn-default">Odustani</a>
		</div>

	</div>
</div>

<%@include file="template/footer.jsp"%>