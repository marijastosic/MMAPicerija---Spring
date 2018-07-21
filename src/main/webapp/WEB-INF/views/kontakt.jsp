<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="map" style="width:100%;height:400px;"></div>

<script>
    function myMap() {
        // The location of Uluru
        var uluru = {lat: 43.3209022, lng: 21.8957589};
        // The map, centered at Uluru
        var map = new google.maps.Map(
            document.getElementById('map'), {zoom: 10, center: uluru});
        // The marker, positioned at Uluru
        var marker = new google.maps.Marker({position: uluru, map: map});
        
//        var mapCanvas = document.getElementById("map");
//        var mapOptions = {
//            center: new google.maps.LatLng(43.3209022, 21.8957589), zoom: 10
//        };
//        var map = new google.maps.Map(mapCanvas, mapOptions);
    }
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2q8lHi8hVcEDKnYbrBJqT7wOgTWDYNf8&callback=myMap"></script>

<center>
    <br>
    <h2>Za sve informacije slobodno nas kontaktirajte</h2>
    <br>
    <img src="<c:url value="/resources/images/marija.jpg"/>" style="width: 170px; height: 170px;"class="rounded float-left"/>
    <h3>Marija Stošić <br></h3>
    <h4><span class="glyphicon glyphicon-earphone btn btn-lg"></span>061/285-73-40 </h4>
    <h4><span class="glyphicon glyphicon-envelope btn btn-lg"></span> mary.mary_94@hotmail.com </h4>
    
</center>

<%@include file="template/footer.jsp"%>
