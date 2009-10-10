<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Thank you!</title>
    </head>
  
    <body>
        <p>Thank you <strong><c:out value="${userName}"/></strong> for signing up!</p>
        
        <p><a href="list">View your entry!</a></p>
    </body>
</html>