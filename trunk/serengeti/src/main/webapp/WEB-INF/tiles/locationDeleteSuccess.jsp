<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Location Delete</title>
    </head>

    <body>
        <p>The location <strong><c:out value="${locationName}"/></strong> has just been deleted.</p>

       <p><a href="list">View all Locations.</a></p>
    </body>
</html>