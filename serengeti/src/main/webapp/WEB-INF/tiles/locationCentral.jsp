<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



	<div class = "grid_10 prefix_3">

        <div class="grid_3">
        	<p id="location"></p>
        </div>
	    
	    <div class="clear">&nbsp;</div>
        
		<div class="grid_6" id="map_canvas"></div>
        
        <div class="clear">&nbsp;</div>

	</div>
	
	<div class="clear">&nbsp;</div>
	
	
	<div class="shadowTextMargin">
<p>Locations Near You</p>
</div>

<div class="verticalMenu">
</div>
	
	
	<c:if test="${session.loggedIn}">
            <p>Don't see your current location?  <a href="create">Add it.</a></p>
        </c:if>
        

<p id="location"></p>

<!--  meta name="viewport" content="initial-scale=0.5, user-scalable=no"/  -->

<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
    onload = function () {

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
        
        var request = $.get("../location/getNearbyLocations", {latitude : google.loader.ClientLocation.latitude, 
            longitude : google.loader.ClientLocation.longitude}, function(data) {
                var jsonData = JSON.parse(request.responseText);
                handleLocations(jsonData.locations);
            }); 
            
    };
    
    var handleLocations = function(data) {
        var verticalMenu = $(".verticalMenu");
        
        var latlng = new google.maps.LatLng(google.loader.ClientLocation.latitude,
            google.loader.ClientLocation.longitude);
        var myOptions = {
            zoom: 13,
            center: latlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
        jQuery.each(data, function(i, val) {
            var locs = new google.maps.LatLng(val.latitude, val.longitude);
        	var marker = new google.maps.Marker({
                position: locs,
                map: map, 
                title: val.name
            });
        
        
            verticalMenu.append("<div class=miniProfile>" +
		            "<span class=miniProfilePicHidden>" +
			            "<a href=" + val.id + "><img src=${pageContext.request.contextPath}" + 
			                "/images/default_team.png alt=location title=" + val.id + " width=50 height=50/></a>" +
			        "</span>" +
		            "<span class=miniProfileName>" +	
			            "<a href=" + val.id + ">" + val.name + "</a><br/>" +
			        "</span>" +
			        "<span class=miniProfileInfo>" +
			        	"<a>" + val.street + "</a><br/>" +
			            "<a>" + val.city + "</a><a>" +  " " + val.state + "</a>" +
			        "</span>" +
        		"</div>"
        	);

        });
    };
    
    
    
</script>
