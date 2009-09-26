<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>View World Map</title>
    </head>
  
    <body>
        Stub page to show world map for userID 
    	<c:if test='${ !empty userID }'>
      		<strong><c:out value=" ${userID}"/></strong>...</p>
    	</c:if>
        </p>
    </body>
</html>

