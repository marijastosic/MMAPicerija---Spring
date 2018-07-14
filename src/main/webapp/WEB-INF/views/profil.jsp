<%@include file="template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="fullscreen_bg" class="fullscreen_bg" />
<div id="regContainer" class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<section>
					<div class="jumbotron">
						<div class="container">
							<h1>Profil</h1>
						</div>
					</div>
				</section>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">


							<hr>
							<c:if test="${not empty msg}">
								<div class="error" style="color: green; text-align: center;">${msg}</div>
							</c:if>
							<form:form id="register-form"
								action="${pageContext.request.contextPath}/azurirajProfil"
								method="post" role="form" modelAttribute="korisnik" accept-charset="UTF-8">
								<form:input path="id" id="id" class="form-control" style="display: none;" />
								<form:input path="username" id="username" class="form-control" style="display: none;" />
								<form:input path="email" id="email" class="form-control" style="display: none;" />
								<form:input path="password" id="password" class="form-control" style="display: none;" />
								<div class="form-group">
									<label for="username">Username</label>
									<form:errors path="username" cssStyle="color: #ff0000" />
									<form:input path="username" id="username" class="form-control"
										placeholder="Username" disabled="true" />
								</div>
								<div class="form-group">
									<label for="email">Email</label>
									<form:errors path="email" cssStyle="color: #ff0000" />
									<form:input path="email" id="email" class="form-control"
										placeholder="Email" disabled="true" />
								</div>
								<div class="form-group">
									<label for="ime">Ime</label>
									<form:errors path="ime" cssStyle="color: #ff0000" />
									<form:input path="ime" id="ime" class="form-control"
										placeholder="Ime" />
								</div>
								<div class="form-group">
									<label for="prezime">Prezime</label>
									<form:errors path="prezime" cssStyle="color: #ff0000" />
									<form:input path="prezime" id="prezime" class="form-control"
										placeholder="Prezime" />
								</div>
								<div class="form-group">
									<label for="pol">Pol</label>
									<form:errors path="pol" cssStyle="color: #ff0000" />
									<form:select path="pol" id="pol" class="form-control">
										<form:option value="Odaberite pol..." disabled="disabled" />
										<form:option value="Ženski" />
										<form:option value="Muški" />
									</form:select>
								</div>
								<div class="form-group">
									<label for="telefon">Telefon</label>
									<form:errors path="telefon" cssStyle="color: #ff0000" />
									<form:input path="telefon" id="telefon" class="form-control"
										placeholder="Telefon" />
								</div>
								<div class="form-group">
									<label for="adresa">Adresa</label>
									<form:errors path="adresa" cssStyle="color: #ff0000" />
									<form:input path="adresa" id="adresa" class="form-control"
										placeholder="Adresa" />
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<input type="submit" class="form-control btn btn-success"
												value="Ažuriraj profil">
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="template/footer.jsp"%>
