<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <p>The location <strong><c:out value="${locationName}"/></strong> with a latitude of
        <strong><c:out value="${latitude}"/></strong> and a longitude of
        <strong><c:out value="${longitude}"/></strong> has just been created with a
        locationId of <strong><c:out value="${locationId}"/></strong></p>

       <p><a href="list">View all locations.</a></p>
