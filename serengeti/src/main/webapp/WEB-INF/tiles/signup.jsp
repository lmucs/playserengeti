<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
    <head>
        <title>Sign up for Serengeti!</title>
    </head>
  
    <body>
        <p>Sign up below!</p>
    	
        <p>
			<form method="post" action="create">
				<label for="login">login: </label><input type="text" name="login"/><br/>
				<label for="display">display: </label><input type="text" name="display"/><br/>
				<input type="submit" value="Sign up!"/>
			</form>
        </p>
        
        <c:if test="${not empty message}">
            <p><c:out value="${message}"/></p>
        </c:if>        
    </body>
</html>
