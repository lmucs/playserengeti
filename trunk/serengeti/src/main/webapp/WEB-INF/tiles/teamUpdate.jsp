<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

	<head>
		<title>Modify Team</title>
	</head>
	
	<body>
	    <c:choose>
            <c:when test='${ !empty updateTeam.teamId }'>
		        <p>Modify your team's settings.</p>
		        <p><strong><c:out value="${updateTeam.name}"/></strong></p>
		        <p>
			        <form method="post" action="update">
				        <label for="color">Preferred Color: </label>
				            <select name="color">
				                <option value="Red">Red</option>
				                <option value="Green">Green</option>
				                <option value="Blue">Blue</option>
				                <option value="Yellow">Yellow</option>
				                <option value="Magenta">Magenta</option>
				                <option value="Cyan">Cyan</option>
				            </select><br/>
				        <p>etc.</p>
				        <input type="submit" value="Modify Team!"/>
			        </form>
                </p>
            </c:when>
            <c:otherwise>
                <p>Something went wrong when retrieving your team.</p>
            </c:otherwise>
        </c:choose>
        
	</body>

</html>