<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Team Created</title>
    </head>
  
    <body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>
        
        <p>The team <strong><c:out value="${team.name}"/></strong> with the color of 
        <strong><c:out value="${team.color}"/></strong> has just been created.</p>
        
       <p><a href="list">View all teams.</a></p>
    </body>
</html>