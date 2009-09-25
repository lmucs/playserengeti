<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Sign up for Serengeti!</title>
        <style type="text/css">
        	#thanks {
        		padding: 1em;
        		background-color: yellow
        	}
        </style>
    </head>
  
    <body>
    	<c:if test='${ !empty login && !empty password }'>
    		<p id="thanks">Thank you <strong><c:out value="${login}"/></strong>
    		for signing up with password
    		<strong><c:out value="${password}"/></strong>...</p>
    	</c:if>
    
    	<p>Sign up below.  Bear in mind, you're not actually signing up for
    	anything so you need not enter a real password!</p>
    	
        <p>
			<form method="get" action="">
				<label for="login">login: </label><input type="text" name="login"/><br/>
				<label for="password">password: </label><input type="password" name="password"/><br/>
				<input type="submit" value="Sign up!"/>
			</form>
        </p>
    </body>
</html>