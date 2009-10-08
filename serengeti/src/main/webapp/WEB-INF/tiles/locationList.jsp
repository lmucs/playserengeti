<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>All of the Locations</title>
    </head>

    <body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>

        <c:if test="${deleted == 'true'}">
            <p><strong>The location <c:out value="${deletedName}"/> has been deleted.</strong></p>
        </c:if>
        <p>All of the locations registered with Serengeti.</p>

        <table>
            <tr>
                <th>Location Id</th>
                <th>Location Name</th>
                <th>Location Latitude</th>
                <th>Location Longitude</th>
                <th>Location Owner (Team)</th>
            </tr>
            <c:forEach var="location" items="${allLocations}">
                <tr>
                    <td>${location.locationId}</td>
                    <td>
                        <a href="view?locationId=${location.locationId}"><c:out value="${location.locationName}"/></a>
                    </td>
                    <td><c:out value="${location.locationName}"/></td>
                    <td><c:out value="${location.latitude}"/></td>
                    <td><c:out value="${location.longitude}"/></td>
                    <td><c:out value="${location.teamOwner}"/></td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="create">Create a new location?</a></p>
    </body>
</html>
