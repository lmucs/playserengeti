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
	                    <td><strong><c:out value="${teamCommand.name}"/></strong></td>
	                </div>
	                
	                <div class="clear">&nbsp;</div>
	                <div id="teamInfo">
		                <div class="grid_4">
		                	<td><strong>Home Base:</strong></td>
		                	<td><c:out value="${teamCommand.homeBase}"/></td>
		                </div>
		            
		                <div class="clear">&nbsp;</div>
		                
		                <div class="grid_4">
		                    <td><strong>Team Leader:</strong></td>
		                    <td><c:out value="${teamCommand.leader.firstName} ${teamCommand.leader.lastName}"/></td>
		                </div>
		            </div>
	            </div>

	            <div class="clear">&nbsp;</div>
	                
	            <div class="grid_2">
                    <td><strong>Description:</strong></td>
                </div>	
                
                <div class="clear">&nbsp;</div>
                
                <div class="grid_8 round_Box_Container">
                    <td><c:out value="${teamCommand.description}"/></td>
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
                    <td><strong>Activity:</strong></td>
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
                            <div id="territoryAddress">
                                <c:out value="${loc.street}"/><br/><c:out value="${loc.city}, ${loc.state} ${loc.zipcode}"/>
                            </div>
                        </li>
                    </c:forEach>
                    </ul>
                </div>
                <hr>
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
<script>
    $(function() {
        var latlng = new google.maps.LatLng(google.loader.ClientLocation.latitude,
            google.loader.ClientLocation.longitude);
        var myOptions = {
            zoom: 10,
            center: latlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
       
        var data = JSON.parse('${jsonData}');
        var paths = new Array(data.territory.length);
       
        for (var i = 0; i < data.territory.length; i++) {
            var pos = new google.maps.LatLng(data.territory[i].latitude, data.territory[i].longitude);
            paths[i] = pos;
            var marker = new google.maps.Marker({
                position: pos,
                map: map, 
                title: data.territory[i].name
            });
        };
        var polygon = new google.maps.Polygon({
            paths: paths,
            strokeColor: "#FF0000",
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: "#FF0000",
            fillOpacity: 0.35
        });
        polygon.setMap(map)
        
    });
    
    
    
    
</script>