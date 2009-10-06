<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html>

	<head>
		<title>Delete Team</title>
	</head>
	
	<body>
		<p>Which team would you like to delete.</p>
		
		<p>
			<form method="post" action="delete">
				<label for="teamId">Team ID: </label><input type="text" name="teamId"/><br/>
				<p>etc.</p>
				<input type="submit" value="Delete Team!"/>
			</form>
        </p>
	</body>

</html>