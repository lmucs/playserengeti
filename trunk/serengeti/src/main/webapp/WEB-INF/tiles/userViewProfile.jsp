<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>View User Profile</title>
    </head>
  
    <body>
        Stub page for viewing of profile for user ID
    	<c:if test='${ !empty userID }'>
      		<strong><c:out value="${userID}"/></strong>...</p>
    	</c:if>
        </p>
        
        <c:if test='${ empty userID }'>    
    	<p>Which ID would you like to view?</p>
        <p>
			<form method="get" action="viewProfile">
				<label for="userID"> User ID </label><input type="text" name="userID"/><br/>
				<input type="submit" value="View User Profile ID"/>
			</form>
        </p>
        </c:if>
    </body>
</html>

