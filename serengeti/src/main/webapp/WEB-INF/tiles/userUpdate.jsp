<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Manage User Profile</title>
    </head>
  
    <body>
        Stub page for management of user ID
    	<c:if test='${ !empty userID }'>
      		<strong><c:out value="${userID}"/></strong>...</p>
    	</c:if>
        </p>
        
        <c:if test='${ empty userID }'>    
    	<p>Which ID would you like to manage?</p>
        <p>
			<form method="get" action="manage">
				<label for="userID"> User ID </label><input type="text" name="userID"/><br/>
				<input type="submit" value="Manage ID"/>
			</form>
        </p>
        </c:if>
        
    </body>
</html>

