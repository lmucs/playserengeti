<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html>

	<head>
		<title>Delete Team</title>
	</head>
	
	<body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>

		<p>
			<form method="post" action="delete">
				<p>Are you sure you want to delete team <c:out value="${deleteTeam.name}"/>?</p>
				<input type="submit" value="Delete Team!"/>
			</form>
        </p>
	</body>

</html>