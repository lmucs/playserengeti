<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <c:choose>
            <c:when test='${ !empty locationCommand }'>

				
				<div class = "grid_5">
                   	<div class = "grid_4"> 
                       	<td><strong>Location Name:</strong></td>
                       	<td><c:out value="${locationCommand.name}"/></td>
                    </div>
                    	
                    <div class="clear">&nbsp;</div>

                    <div class = "grid_4" >
                       	<td><strong>Address:</strong></td>
                       	<td><c:out value="${locationCommand.street}"/><br/>
                           	<c:out value="${locationCommand.city}"/>
                           	<c:out value="${locationCommand.state}"/>
                           	<c:out value="${locationCommand.zipcode}"/></td>
                    </div>
                    	
                    <div class="clear">&nbsp;</div>
                    	
                    <div class = "grid_4">
                       	<td><strong>Phone Number:</strong></td>
                       	<td><c:out value="${locationCommand.phoneNumber}"/></td>
                    </div>
                    	
                    <div class="clear">&nbsp;</div>
                    	
                    <div class = "grid_4">
                       	<td><strong>Description:</strong></td>
                       	<td><c:out value="${locationCommand.description}"/></td>
                    </div>
                    	

					<div class="clear">&nbsp;</div>

                    <div class = "grid_4">
                        <td><strong>Owned by Team:</strong></td>
                        <td><c:if test='${ !empty location.ownerId }'>
                            <c:out value="${location.owner.id}"/>
                            </c:if>
                        </td>
                    </div>
                    
                    <div class="clear">&nbsp;</div>
                    
                    <div class = "grid_4">
                    	<strong>Competing Teams:</strong>
                    	<ul>
                       		<c:forEach var="team" items="${competingTeams}">
                           		<li><a href="../team/${team.id}"><c:out value="${team.name}"/></a></li>
                       		</c:forEach>
                    	</ul>
                    </div>                
				</div>
            </c:when>
            <c:otherwise>
                <p>The location you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

<div id="map_canvas"></div>

<!--  meta name="viewport" content="initial-scale=0.5, user-scalable=no"/  -->

<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
    onload = function () {
        var latlng = new google.maps.LatLng(${locationCommand.latitude},
            ${locationCommand.longitude});
        var myOptions = {
            zoom: 13,
            center: latlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
         
        var marker = new google.maps.Marker({
            position: latlng, 
            map: map, 
            title:"${locationCommand.name}"
        });
    }
</script>