<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html>

	<head>
		<title>Create a Group!</title>
	</head>
	
	<body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>
	
		<p>Create your own team and start marking your territory.  
		   Just fill in the information below.</p>
		
		<p>
			<form method="post" action="create">
				<label for="name">Team Name: </label><input type="text" name="name"/><br/>
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
				<input type="submit" value="Create Team!"/>
			</form>
        </p>
	</body>

</html>