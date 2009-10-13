<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${deleted == 'true'}">
    <p><strong>The location <c:out value="${deletedName}"/> has been deleted.</strong></p>
</c:if>

<p>All currently registered locations:</p>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Latitude</th>
        <th>Longitude</th>
        <th>Owner (Team)</th>
    </tr>
    <c:forEach var="location" items="${allLocations}">
        <tr>
            <td>${location.locationId}</td>
            <td>
                <a href="view?locationId=${location.locationId}"><c:out value="${location.locationName}"/></a>
            </td>
            <td><c:out value="${location.latitude}"/></td>
            <td><c:out value="${location.longitude}"/></td>
            <td><c:out value="${location.teamOwnerId.id}"/></td>
        </tr>
    </c:forEach>
</table>

 <p><a href="create">Create new location</a></p>
