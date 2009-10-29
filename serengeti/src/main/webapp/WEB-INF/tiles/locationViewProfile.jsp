<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <c:choose>
            <c:when test='${ !empty locationCommand }'>
                <p>Here's the location you requested</p>
                <table>
                    <tr>
                        <td><strong>Location Name</strong></td>
                        <td><c:out value="${locationCommand.locationName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Phone Number</strong></td>
                        <td><c:out value="${locationCommand.phoneNumber}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Address</strong></td>
                        <td><c:out value="${address[0]}"/><br/>
                            <c:out value="${address[1]}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Owned by Team</strong></td>
                        <td><c:if test='${ !empty location.teamOwnerId }'>
                                <c:out value="${location.teamOwner.id}"/>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Description</strong></td>
                        <td><c:out value="${locationCommand.description}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Image</strong></td>
                        <td><c:out value="${locationCommand.image}"/></td>
                    </tr>
                    <strong>Competing Teams</strong>
                    <ul>
                        <c:forEach var="team" items="${competingTeams}">
                            <li><a href="../team/view?teamId=${team.id}"><c:out value="${team.name}"/></a></li>
                        </c:forEach>
                    </ul>
                </table>
            </c:when>
            <c:otherwise>
                <p>The location you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

<div id="map_canvas" style="width:50%; height:50%"></div>

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
            title:"${locationCommand.locationName}"
        });
    }
</script>