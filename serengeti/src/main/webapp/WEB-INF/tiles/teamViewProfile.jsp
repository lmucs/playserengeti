<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <c:choose>
            <c:when test='${ !empty teamCommand }'>
                
                <div class="clear">&nbsp;</div>
                
            	<div class="grid_3 teamImage">
            	    <img src="${pageContext.request.contextPath}/images/default_team.png" alt="teamImage"
		            title="teamImage"/>               
		        </div>
		        <div class="grid_3">
	                <div class="grid_3" id="teamName">
	                    <strong><c:out value="${teamCommand.name}"/></strong>
	                </div>
	                
	                <div class="clear">&nbsp;</div>
	                <div id="teamInfo">
		                <div class="grid_4">
		                	<strong>Home Base:</strong>
		                	<c:out value="${teamCommand.homeBase}"/>
		                </div>
		            
		                <div class="clear">&nbsp;</div>
		                
		                <div class="grid_4">
		                    <strong>Team Leader:</strong>
		                    <c:out value="${teamCommand.leader.firstName} ${teamCommand.leader.lastName}"/>
		                </div>
		            </div>
	            </div>

	            <div class="clear">&nbsp;</div>
	                
	            <div class="grid_2">
                    <strong>Description:</strong>
                </div>	
                
                <div class="clear">&nbsp;</div>
                
                <div class="grid_8 round_Box_Container">
                    <c:out value="${teamCommand.description}"/>
                </div>
                
                <div class="grid_4 round_Box_Container">
	                <div class="grid_3">
	                    <strong>Team Members:</strong>
	                </div>
	                <div class="grid_4">
	                    <ul>
	                      <c:forEach var="user" items="${members}">
	                          <li><a href="../user/${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a></li>
	                      </c:forEach>
	                    </ul>	
	                </div>
	            </div>
                
                <div class="clear">&nbsp;</div>
	                
	            <div class="grid_2">
                    <strong>Activity:</strong>
                </div>	
                
                <div class="clear">&nbsp;</div>
                
                <div class="grid_8 round_Box_Container">
                    <ul>
                    <c:forEach var="visit" items="${activity}">
                        <li><a href="../user/${visit.user.id}"><c:out value="${visit.user.firstName} ${visit.user.lastName}"/></a> @ 
                          <a href="../location/${visit.location.id}"><c:out value="${visit.location.name}"/></a> (${visit.date})</li>
                    </c:forEach>
                    </ul>
                </div>
                <div class="grid_4 round_Box_Container">
                    <div class="grid_3">
	                    <strong>Controlled Territory:</strong>
	                </div>
                    <ul>
                    <c:forEach var="loc" items="${territory}">
                        <li><a href="../location/${loc.id}"><c:out value="${loc.name}"/></a>
                            <div class="territoryAddress">
                                <c:out value="${loc.street}"/><br/><c:out value="${loc.city}, ${loc.state} ${loc.zipcode}"/>
                            </div>
                        </li>
                    </c:forEach>
                    </ul>
                </div>
                <c:if test="${session.loggedIn && (session.user.id == teamCommand.leader.id)}">
                    <a href="update/${teamCommand.teamId}">Modify Team</a><br/>
                </c:if>
            </c:when>
            <c:otherwise>
                <p>The team you requested does not exist.</p>
            </c:otherwise>
        </c:choose>
        <div class="grid_8 round_Box_Container" id="map_canvas"></div>
        
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
    $(function() {
    
        var latlng = new google.maps.LatLng(google.loader.ClientLocation.latitude,
            google.loader.ClientLocation.longitude);
        var myOptions = {
            zoom: 10,
            center: latlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
       
        var jsonData = JSON.parse('${jsonData}');
        var paths = new Array(jsonData.regions.length);
        
        for (var i = 0; i < jsonData.regions.length; i++) {
             var hull = new Array(jsonData.regions[i].length);
             for (var j = 0; j < jsonData.regions[i].length; j++) {
                var hullPos = new google.maps.LatLng(jsonData.regions[i][j].x, jsonData.regions[i][j].y);
                hull[j] = hullPos;
            }
            paths[i] = hull;
        }
        
        for (var i = 0; i < jsonData.locations.length; i++) {
            var locPos = new google.maps.LatLng(jsonData.locations[i].latitude, jsonData.locations[i].longitude);
            var marker = new google.maps.Marker({
                    position: locPos,
                    map: map, 
                    title: jsonData.locations[i].name
                });
        }
        
        var polygon = new google.maps.Polygon({
            paths: paths,
            strokeColor: "#FF0000",
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: "#FF0000",
            fillOpacity: 0.35
        });
        
        polygon.setMap(map);
        
    });
    
    
    
    
</script>