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
				<label for="leaderId">Team Leader: </label>
				    <select name="leaderId">
				        <c:forEach var="user" items="${createTeam.allUsers}">
				            <option value="${user.id}"><c:out value="${user.displayName}"/></option>
				        </c:forEach>
				    </select><br/>				        
				<label for="homeLocation">Home Location: </label>
		            <select name="homeLocation">
				        <c:forEach var="location" items="${createTeam.allLocations}">
				            <option value="${location.locationId}"><c:out value="${location.locationName}"/></option>
				        </c:forEach>
				    </select><br/>	
				<label for="image">Team Image URL: </label><input type="text" name="image"/><br/>
				
				<input type="submit" value="Create Team!"/>
			</form>
        </p>
	</body>

</html>