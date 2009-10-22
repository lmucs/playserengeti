<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<p>Sign up below!</p>

<form:form method="post">
    <div>
        <div class="formLabel">
            <label for="userName">User Name: </label>
        </div>
        <div class="spaceInputBox">
	        <form:input path="userName"/>
	        <form:errors path="userName"/>
	    </div>
    </div>
    <div>
        <div  class="formLabel">
            <label for="password">Password: </label>
        </div>
        <div class="spaceInputBox">
	        <form:password path="password"/>
	        <form:errors path="password"/>
	    </div>
    </div>
    <div>
        <div  class="formLabel">
            <label for="email">Email Address: </label>
        </div>
        <div class="spaceInputBox">
	        <form:input path="email"/>
	        <form:errors path="email"/>
	    </div>
    </div>

    <div>
        <input type="submit" value="Sign up!"/>
    </div>
</form:form>

<c:if test="${not empty message}">
    <p><c:out value="${message}"/></p>
</c:if>