<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Location Created</title>
    </head>

    <body>
        <p>The location <strong><c:out value="${locationId}"/></strong> with a latitude of
        <strong><c:out value="${lat}"/></strong> and a longitude of
        <strong><c:out value="${longitude}"/></strong> has just been created.</p>

       <p><a href="list">View all locations.</a></p>
    </body>
</html>