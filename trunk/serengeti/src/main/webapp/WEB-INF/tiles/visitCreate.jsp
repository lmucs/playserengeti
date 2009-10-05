<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Check In!</title>
    </head>

    <body>
    	<p>Check in UserId at LocationId</p>
        <p>
			<form method="get" action="">
				<label for="userId">userId: </label><input type="text" name="userId"/><br/>
				<label for="locationId">locationId: </label><input type="locationId" name="locationId"/><br/>
				<input type="submit" value="Check In!"/>
			</form>
        </p>
    </body>
</html>