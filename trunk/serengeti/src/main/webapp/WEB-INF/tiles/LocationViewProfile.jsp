<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>View Location Profile</title>
    </head>

    <body>
        <c:choose>
            <c:when test='${ !empty location }'>
                <p>Here's the location you requested</p>
                <table>
                    <tr>
                    	<td><string>Location Id </strong></td>
                    	<td><c:out value="${location.locationName}</td>
                    </tr>
                    <tr>
                        <td><strong>Location Name</strong></td>
                        <td><c:out value="${location.locationName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Latitude</strong></td>
                        <td><c:out value="${location.latitude}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Longitude</strong></td>
                        <td><c:out value="${location.longitude}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Owned by Team</strong></td>
                        <td><c:if test='${ !empty location.teamOwner }'>
                                <c:out value="${location.latitude}"/>
                            </c:if>
                        </td>
                    </tr>
                </table>
                <a href="update?teamId=${team.id}">Modify Team</a><br/>
                <a href="delete?teamId=${team.id}">Delete Team</a><br/>
                <a href="list">View All Teams</a>
            </c:when>
            <c:otherwise>
                <p>The team you requested does not exist.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>

