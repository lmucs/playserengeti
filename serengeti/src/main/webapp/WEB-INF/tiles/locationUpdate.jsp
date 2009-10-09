<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

	<head>
		<title>Manage Location</title>
	</head>

<body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>

	    <c:choose>
            <c:when test='${ !empty updateLocation}'>
		        <p>Modify your location's settings.</p>
		        <p><strong><c:out value="${updateLocation.locationName}"/></strong></p>
		        <p>
		            <form method="post" action="update">
			            <label for="latitude">Latitude: </label><input type="text" name="latitude"/><br/>
				        <label for="latitude">Longitude: </label><input type="text" name="longitude"/><br/>
				        <label for="teamOwner">Team Owner: </label><input type="text" name="teamOwner"/><br/>
				        <input type="submit" value="Modify Location!"/>
			        </form>
                </p>
            </c:when>
            <c:otherwise>
                <p>Something went wrong when retrieving your team.</p>
            </c:otherwise>
        </c:choose>

	</body>

</html>