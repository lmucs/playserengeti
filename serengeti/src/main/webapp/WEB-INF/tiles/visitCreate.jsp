<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Check In!</title>
    </head>

    <body>
    	<c:if test='${ !empty userId && !empty locationId }'>

    		<p>Stub page for adding a visit from <strong><c:out value="${userId}"/></strong>
    		to location <strong><c:out value="${locationId}"/></strong>...</p>
    	</c:if>

        <c:if test='${ empty userId || empty locationId }'>
    	<p>Check in UserId at LocationId</p>
        <p>
			<form method="get" action="">
				<label for="userId">userId: </label><input type="text" name="userId"/><br/>
				<label for="locationId">locationId: </label><input type="locationId" name="locationId"/><br/>
				<input type="submit" value="Check In!"/>
			</form>
        </p>
        </c:if>
    </body>
</html>