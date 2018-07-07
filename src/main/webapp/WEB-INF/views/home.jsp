<%-- 
    Document   : home
    Created on : Jun 24, 2018, 10:41:45 AM
    Author     : Marija
--%>
<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Banner header section -->
<div class="intro-banner">
    <div class="container">
        <div class="row">

            <div class="col-lg-12">
                <div class="intro-inner">
                    <h1 style=" background-color: #9b9774; opacity: 0.75; color: white;">DOBRODOŠLI NA SAJT MMA PICERIJE</h1>
                    <h3 style=" background-color: #9b9774; opacity: 0.75; color: white;">PICERIJA NIŠ</h3>
                    <hr class="intro-divider">
                    <ul class="list-inline intro-social-buttons">
                        <li>
                            <a href="#" class="btn btn-default btn-sm">
<!--                                <i class="fa fa-youtube-play"></i>-->
<!--                                <span class="button-title">Video</span>-->
<!--                                <iframe width="560" height="315" src="https://www.youtube.com/embed/c2nOiOaVA3Y" -->
                                    <iframe width="100%" height="315" src="https://www.youtube.com/embed/c2nOiOaVA3Y"
                                        frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
                                </br>
                                <span class="button-title">Video</span>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- RED 1 SADRZAJ -->
<div class="content-section-a">
    <div class="container">
        <div class="row">

            <div class="col-lg-5 col-sm-6">
                <hr class="section-heading-spacer">

                <!-- clearfix makes it so elements are not side by side -->
                <div class="clearfix"></div>

                <h2 class="section-heading">Za one koji vole meso</h2>
                <p class="lead">
                    Nije bitno koje doba dana ili noći...
                    da li je napolju nepodnošljiva vrelina ili sibirska hladnoća, sneg ili kiša...
                    nije bitno da li ste kod kuće ili na poslu...
                    Dovoljno je da imate pristup internetu i možete detaljno pregledati naš onlajn meni,
                    a onda i naručiti vašu omiljenu picu sa mesom.
                </p>
            </div>

            <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                <img class="img-responsive img-rounded" src="<c:url value="/resources/images/pizza1.jpg"/>">
            </div>

        </div>
    </div>
</div>


<!-- RED 2 SADRZAJ  -->
<div class="content-section-b">
    <div class="container">
        <div class="row">

            <div class="col-lg-5 col-lg-offset-1 col-sm-push-6 col-sm-6">
                <hr class="section-heading-spacer">
                <div class="clearfix"></div>
                <h2 class="section-heading">Za one bez mesa</h2>
                <p class="lead">
                    Za sve one koji ne vole meso a vole pice...
                    za one koji poste...
                    imamo veliki izbor pica koje će u potpunosti zadovoljiti sve vaše ukuse.
                </p>
            </div>

            <div class="col-lg-5 col-sm-pull-6 col-sm-6">
                <img class="img-responsive img-rounded" src="<c:url value="/resources/images/pizza2.jpg"/>">
            </div>

        </div>

    </div>
</div>
<%@include file="template/footer.jsp" %>

