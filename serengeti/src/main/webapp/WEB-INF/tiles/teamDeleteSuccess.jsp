<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Team Delete</title>
    </head>
  
    <body>
        <p>The team <strong><c:out value="${name}"/></strong> has just been deleted.</p>
        
       <p><a href="list">View all teams.</a></p>
    </body>
</html>