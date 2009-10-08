<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>View World Map</title>
        <meta name="viewport" content="initial-scale=0.5, user-scalable=no" />
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript">
          function initialize() {
              var latlng = new google.maps.LatLng(google.loader.ClientLocation.latitude, 
                google.loader.ClientLocation.longitude);
              var location = "Your ip-based location: " + google.loader.ClientLocation.address.city;  
              var myOptions = {
                zoom: 13,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
              };
              var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
              document.getElementById("location").innerHTML = location;
          }

        </script>
    </head>
  
    <body onload="initialize()">
    	<a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>
        <div id="map_canvas" style="width:50%; height:50%"></div>
        <div id="location"></div>
    </body>
</html>

