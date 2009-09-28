<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Delete a User</title>
    </head>
  
    <body>
    	<c:if test='${ !empty userID }'>
    		</p>Stub page - indicates userID <c:out value="${userID}"/> has been deleted.</p>
    	</c:if>
    
		<c:if test='${ empty userID }'>    
    	<p>Which ID would you like to delete?</p>
        <p>
			<form method="get" action="delete">
				<label for="userID"> User ID </label><input type="text" name="userID"/><br/>
				<input type="submit" value="Delete ID"/>
			</form>
        </p>
        </c:if>
        
    </body>
</html>