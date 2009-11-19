<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



	<div class = "grid_10 prefix_3">

        <div class="grid_3">
        	<p id="location"></p>
        </div>
	    
	    <div class="clear">&nbsp;</div>
        
		<div class="grid_6" id="map_canvas"></div>
        
        <div class="clear">&nbsp;</div>
        
        <div class="grid_3">
	        <p>Locations near you</p>
	    </div>

	</div>
	
	<div class="clear">&nbsp;</div>

<!-- 	
	<div class="grid_3 prefix_3">    
        <div class="hor_menu Locations">
	        <ul class="hor_menu">
	            <c:forEach var="location" items="${nearbyLocations}">
	               <li>
	                   <a href="${location.id}" > <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="location" title="${location.name}" <c:out value="${location.name}"/></a>
	               </li>
	            </c:forEach>
	        </ul>
	    </div>
	    
	    </div>
	    <div class="clear">&nbsp;</div>
<script type="text/javascript">
            scrollbar(["Locations"]);
        </script>
 -->
 
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
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->

<ul class="hor_menu">
	<c:forEach var="location" items="${nearbyLocations}">
		<li><a href="${location.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="team"
			title="${location.name}" /></a> <span><c:out value="${location.name}" />
		</span></li>
	</c:forEach>
</ul>

<!--END CONTENT--></div>
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
    }
</script>
