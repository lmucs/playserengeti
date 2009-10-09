<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Location Updated</title>
    </head>

    <body>
        <p><strong><c:out value="${location.locationName}"/></strong> has been modified.</p>

        <p><a href="list">View all Locations.</a></p>
    </body>
</html>