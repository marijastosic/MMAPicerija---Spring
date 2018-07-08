<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Import ceo za javu skript -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!---------------------------------------------------------------------------------------------------------------->
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1 style="font: 40px;">Detalji pice</h1>

			<p class="lead">Možete videti detalje pice kako biste olakšano
				odlučili koju picu da odaberete i poručite!</p>
		</div>
		<br />
		<div class="container" ng-app="cartApp" use-expressions="true">
			<div class="row">
				<div class="col-md-5">
					<img alt="image" src="${pica.slikaUrl}" style="width: 100%" />
				</div>

				<div class="col-md-5">
					<h3 style="font-size: 35px; font-family: cursive;">${pica.naziv}</h3>
					<textarea disabled="disabled" rows="3" cols="55"
						style="font-size: 18px; font-family: cursive;">${pica.opis}</textarea>
					<p style="font-size: 18px; font-family: cursive;">Sastojci:
						${pica.sastojci}</p>
					<p style="font-size: 18px; font-family: cursive;">Cena:
						${pica.cena} Din.</p>
					<p style="font-size: 18px; font-family: cursive;">Tezina:
						${pica.tezina} gr</p>
					<p style="font-size: 18px; font-family: cursive;">Ocena:
						${pica.ocena}</p>

					<br>

					<c:set var="role" scope="page" value="${role}" />
					<c:set var="url" scope="page" value="/product/productList" />
					<c:if test="${role}">
						<c:set var="url" scope="page" value="/admin/productInventory" />
					</c:if>

					<p>
						<a href="<c:url value="/meni"/>" class="btn btn-default">Nazad</a>
				
						<input max="10" min="1" type="number" name="kolicina" value="${kolicina}">
						<a href="<c:url value="/dodajUKorpu/${pica.id}/${kolicina}"/>" 
							class="btn btn-warning btn-large" onclick="myFunction()"><span
							class="glyphicon glyphicon-shopping-cart"></span> Dodaj u korpu</a> <a
							href="<c:url value="/korpa" />" class="btn btn-default"><span
							class="glyphicon glyphicon-hand-right"></span> Vidite korpu</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<br /> <br />
	<script>
		function myFunction() {
			var txt;
			if (confirm("Pica je uspešno dodata u korpu")) {
				txt = "You pressed OK!";
			} else {
				txt = "You pressed Cancel!";
			}
			//document.getElementById("demo").innerHTML = txt;
		}
	</script>
	<%@include file="template/footer.jsp"%>