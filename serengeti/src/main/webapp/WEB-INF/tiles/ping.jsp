<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Show</title>
    </head>
  
    <body>
        Stub page to turn on pinging from userID 
    	<c:if test='${ !empty userID }'>
      		<strong><c:out value=" ${userID}"/></strong>...</p>
    	</c:if>
        </p>
    </body>
</html>

