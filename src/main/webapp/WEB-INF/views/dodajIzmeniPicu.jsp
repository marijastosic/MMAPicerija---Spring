<%@include file="template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="fullscreen_bg" class="fullscreen_bg" />
<div id="regContainer" class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">

				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<h1 style="text-align: center;">${dodavanjeIzmenaNaslov}</h1>

							<hr>
							<c:if test="${not empty error}">
								<div class="error" style="color: #ff0000; text-align: center;">${error}</div>
							</c:if>
							<form:form
								action="${pageContext.request.contextPath}/admin/dodajIzmeniPicu"
								method="post" modelAttribute="pica">
								<form:input path="id" id="id" style="display: none;"/>
								<div class="form-group">
									<label for="naziv">Naziv</label>
									<form:errors path="naziv" cssStyle="color: #ff0000" />
									<form:input path="naziv" id="naziv" class="form-control"
										placeholder="Naziv" />
								</div>
								<div class="form-group">
									<label for="opis">Opis</label>
									<form:errors path="opis" cssStyle="color: #ff0000" />
									<form:textarea path="opis" id="opis"
										class="form-control" placeholder="Opis" />
								</div>
								<div class="form-group">
									<label for="sastojci">Sastojci</label>
									<form:errors path="sastojci" cssStyle="color: #ff0000" />
									<form:input path="sastojci" id="sastojci" class="form-control"
										placeholder="Sastojci" />
								</div>
								<div class="form-group">
									<label for="cena">Cena</label>
									<form:errors path="cena" cssStyle="color: #ff0000" />
									<form:input path="cena" id="cena" class="form-control"
										placeholder="Cena" />
								</div>
								<div class="form-group">
									<label for="tezina">Težina</label>
									<form:errors path="tezina" cssStyle="color: #ff0000" />
									<form:input path="tezina" id="tezina" class="form-control"
										placeholder="Težina" />
								</div>
								<div class="form-group">
									<label for="ocena">Ocena</label>
									<form:errors path="ocena" cssStyle="color: #ff0000" />
									<form:input path="ocena" id="ocena" class="form-control"
										placeholder="Ocena" />
								</div>
								<div class="form-group">
									<label for="aktivna">Aktivna</label>
									<form:errors path="aktivna" cssStyle="color: #ff0000" />
									<form:checkbox path="aktivna" id="aktivna" class="form-control"/>
								</div>
								<div class="form-group">
									<label for="slikaUrl">URL slike</label>
									<form:errors path="slikaUrl" cssStyle="color: #ff0000" />
									<form:input path="slikaUrl" id="slikaUrl" class="form-control"
										placeholder="URL slike" />
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<input type="submit" class="form-control btn btn-success"
												value="${dodajIzmeni}">
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
