<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Team Created</title>
    </head>
  
    <body>
        <p>The team <strong><c:out value="${name}"/></strong> with the color of 
        <strong><c:out value="${color}"/></strong> has just been created.</p>
        
       <p><a href="list">View all teams.</a></p>
    </body>
</html>