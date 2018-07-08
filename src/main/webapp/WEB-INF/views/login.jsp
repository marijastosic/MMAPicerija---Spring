<%@include file="template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="fullscreen_bg" class="fullscreen_bg"/>
<div id="regContainer" class="container">
      <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-login">
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
              <br><br><br>
              <h1 style="text-align: center;">Prijavljivanje</h1>
              
              <hr>
              <c:if test="${not empty msg}">
                <div style="text-align: center; color: green;">${msg}</div>
                <hr>
           	  </c:if>
           	  <c:if test="${not empty error}">
                  <div class="error" style="color: #ff0000; text-align: center;">${error}</div>
              </c:if>
            
                <form id="login-form" action="<c:url value="/j_spring_security_check" />" method="post" role="form" style="display: block;">
	                
                  <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="${username}">
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                  </div>
                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-success" value="Uloguj se">
                      </div>
                    </div>
                  </div>
                  
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
	
<%@include file="template/footer.jsp"%>
