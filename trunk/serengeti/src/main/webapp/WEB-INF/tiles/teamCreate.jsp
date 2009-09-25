<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

	<head>
		<title>Create a Group!</title>
	</head>
	
	<body>
		<p>Create your own team and start marking your territory.  
		   Just fill in the information below.</p>
		
		<p>
			<form method="get" action="">
				<label for="name">Team Name: </label><input type="text" name="name"/><br/>
				<label for="color">Preferred Color: </label><input type="text" name="color"/><br/>
				<p>etc.</p>
				<input type="submit" value="Create Team!"/>
			</form>
        </p>
	</body>

</html>