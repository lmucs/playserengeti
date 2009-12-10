<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <c:choose>
            <c:when test='${ !empty locationCommand }'>

				
				<div class = "grid_12">
                   	<div class = "grid_12"> 
                       	<td><strong><c:out value="${locationCommand.name}"/></strong></td>
                    </div>
                    	
                    <div class="clear">&nbsp;</div>

                    <div class = "grid_12" >
                       	<td><c:out value="${locationCommand.street}"/><br/>
                           	<c:out value="${locationCommand.city}"/>
                           	<c:out value="${locationCommand.state}"/>
                           	<c:out value="${locationCommand.zipcode}"/></td>
                    </div>
                    	
                    <div class="clear">&nbsp;</div>
                    	
                    <div class = "grid_6">
                       	<td><c:out value="${locationCommand.phoneNumber}"/></td>
                    </div>

					<div class="clear">&nbsp;</div>

                    <div class = "grid_4">
                        <td><strong>Owned by Team:</strong></td>
                    </div>
                    
                    <div class="clear">&nbsp;</div>
                    
                    <c:choose>
            			<c:when test='${ !empty locationCommand.owner }'>
                    
                    <div class = "grid_3 round_Box_Container">
                        <a href="../team/${locationCommand.owner.id}"><img
			src="${pageContext.request.contextPath}/images/default_team.png" alt="team"
			title="${locationCommand.owner.name}" width="50" height="50"/></a>
		    <a href="../team/${locationCommand.owner.id}"><c:out value="${locationCommand.owner.name}"/></a>
                    </div>
                    
                        </c:when>
                        <c:otherwise>
                        	<div class = "grid_3 round_Box_Container">
                        	<p>NOT OWNED</p>
                        	</div>
                        </c:otherwise>
                    </c:choose>
                    <div class="clear">&nbsp;</div>
                    
                    
				</div>
            </c:when>
            <c:otherwise>
                <p>The location you requested does not exist.</p>
            </c:otherwise>
        </c:choose>
<div class="clear">&nbsp;</div>
<div class="grid_2" id="map_canvas"></div>

<div class = "grid_4">
   	<strong>Competing Teams:</strong>
  	<ul>
   		<c:forEach var="team" items="${competingTeams}">
       		<li><a href="../team/${team.id}"><c:out value="${team.name}"/></a></li>
   		</c:forEach>
   	</ul>
</div>                


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