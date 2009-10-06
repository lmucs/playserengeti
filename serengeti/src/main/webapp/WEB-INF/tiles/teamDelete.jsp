<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

	<head>
		<title>Delete Team</title>
	</head>
	
	<body>
		<p>Which team would you like to do.</p>
		
		<p>
			<form method="post" action="delete">
				<label for="teamId">Team ID: </label><input type="text" id="teamId"/><br/>
				<p>etc.</p>
				<input type="submit" value="Delete Team!"/>
			</form>
        </p>
	</body>

</html>