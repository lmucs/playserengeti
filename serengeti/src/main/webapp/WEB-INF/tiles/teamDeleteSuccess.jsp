<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Team Delete</title>
    </head>
  
    <body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>

        <p>The team <strong><c:out value="${name}"/></strong> has just been deleted.</p>
        
       <p><a href="list">View all teams.</a></p>
    </body>
</html>