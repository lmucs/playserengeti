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
	
	
	<div class="shadowText">
<p>Locations Near You</p>
</div>

<div class="verticalMenu">
</div>
	
	
	<!--
 
 <div class="shadowText">
<p>Locations Near You</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows"> <a id="leftArrow1" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a> 
</span>

<span class="centralScrollSpan">

<div id="scrollContainer">
<div id="nearbyLocations"
	style="position: absolute; width: 400px; left: 0; top: 0;">


<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden>INSERT CONTENT HERE

<ul class="hor_menu">
	<c:forEach var="location" items="${nearbyLocations}">
		<li> <a href="${location.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="location"
			title="${location.name}" /></a>  <span><c:out value="${location.name}" />
		</span><a href="${location.id}" ><c:out value="${location.name}"/></a></li>
		
	</c:forEach>
</ul>

END CONTENT</div>
</div>
</div>
</div>

</span>

<span class="allRightArrows"><a
	id="rightArrow1" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="160px" width="80px"></a>
</span>
</div>

<script type="text/javascript">
	scrollbar(["leftArrow1"],['nearbyLocations'],["rightArrow1"]);
	scrollbar(["leftArrow1"],['nearbyLocations'],["rightArrow1"]);
</script>
         
        --><c:if test="${session.loggedIn}">
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
        jQuery.each(data, function(i, val) {
            verticalMenu.append("<div class=miniProfile>" +
		            "<span class=miniProfilePicHidden>" +
			            "<a href=" + val.id + "><img src=${pageContext.request.contextPath}" + 
			                "/images/default_team.png alt=location title=" + val.id + " width=50 height=50/></a>" +
			        "</span>" +
		            "<span class=miniProfileName>" +	
			            "<a href=" + val.id + ">" + val.name + "</a>" +
			        "</span>" +
        		"</div>"
        	);
        });
    };
</script>
