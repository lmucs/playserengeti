<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Location Updated</title>
    </head>

    <body>
        <p>The location <strong><c:out value="${locationId}"/></strong> has been updated
        to these values:
        <p>location name = <strong><c:out value="${locationName}"/></strong>.</p>
        <p>latitude = <strong><c:out value="${latitude}"/></strong>.</p>
	    <p>longitude = <strong><c:out value="${longitude}"/></strong>.</p>
	    <p>team Owner Id = <strong><c:out value="${teamOwnerId}"/></strong>.</p>

       <p><a href="list">View all locations.</a></p>
    </body>
</html>