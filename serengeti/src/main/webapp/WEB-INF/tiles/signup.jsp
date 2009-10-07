<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <title>Sign up for Serengeti!</title>
    </head>
  
    <body>
        <p>Sign up below!</p>
    	
    	<form:form method="post">
    	    <div>
			    <label for="login">Login Name: </label>
			    <form:input path="login"/>
                <form:errors path="login"/>
            </div>
			
			<div>
			    <label for="display">Display Name: </label>
			    <form:input path="display"/>
                <form:errors path="display"/>
			</div>
			
			<div>
			    <input type="submit" value="Sign up!"/>
			</div>
		</form:form>
        
        <c:if test="${not empty message}">
            <p><c:out value="${message}"/></p>
        </c:if>        
    </body>
</html>
