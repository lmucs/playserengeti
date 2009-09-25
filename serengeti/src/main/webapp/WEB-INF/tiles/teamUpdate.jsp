<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

	<head>
		<title>Modify Group</title>
	</head>
	
	<body>
		<p>Modify your team's settings.</p>
		
		<p>
			<form method="get" action="">
				<label for="name">Team Name: </label><input type="text" name="name"/><br/>
				<label for="color">Preferred Color: </label><input type="text" name="color"/><br/>
				<p>etc.</p>
				<input type="submit" value="Save Changes"/>
			</form>
        </p>
	</body>

</html>