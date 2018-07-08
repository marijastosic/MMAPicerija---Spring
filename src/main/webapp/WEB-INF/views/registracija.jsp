<%@include file="template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="fullscreen_bg" class="fullscreen_bg"/>
<div id="regContainer" class="container">
      <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-login">
          
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
              <h1 style="text-align: center;">Registracija</h1>
              
              <hr>
                <form:form id="register-form" action="${pageContext.request.contextPath}/registracija" method="post" role="form" commandName="korisnik">
                  <div class="form-group">
                    <label for="username">Username</label> <form:errors path="username" cssStyle="color: #ff0000" />
                    <form:input path="username" id="username" class="form-control" placeholder="Username"/>
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label> <form:errors path="password" cssStyle="color: #ff0000" />
                    <form:password path="password" id="password" class="form-control" placeholder="Password"/>
                  </div>
                  <div class="form-group">
                    <label for="email">Email</label> <form:errors path="email" cssStyle="color: #ff0000" />
                    <form:input path="email" id="email" class="form-control" placeholder="Email"/>
                  </div>
                    <div class="form-group">
                    <label for="ime">Ime</label> <form:errors path="ime" cssStyle="color: #ff0000" />
                    <form:input path="ime" id="ime" class="form-control" placeholder="Ime"/>
                  </div>
                    <div class="form-group">
                    <label for="prezime">Prezime</label> <form:errors path="prezime" cssStyle="color: #ff0000" />
                    <form:input path="prezime" id="prezime" class="form-control" placeholder="Prezime"/>
                  </div>
                    <div class="form-group">
                    <label for="telefon">Telefon</label> <form:errors path="telefon" cssStyle="color: #ff0000" />
                    <form:input path="telefon" id="telefon" class="form-control" placeholder="Telefon"/>
                  </div>
                    <div class="form-group">
                    <label for="adresa">Adresa</label> <form:errors path="adresa" cssStyle="color: #ff0000" />
                    <form:input path="adresa" id="adresa" class="form-control" placeholder="Adresa"/>
                  </div>
                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" class="form-control btn btn-success" value="Registruj se">
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
