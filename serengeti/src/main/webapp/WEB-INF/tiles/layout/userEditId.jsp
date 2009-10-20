//This is the jsp for the URL serengeti/user/edit/id

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="signUpCenter">
	Sign up below!
</div>

<form:form method="post">
    <div>
        <div class="formLabel">
            <label for="userName">First Name </label>
        </div>
        <div class="spaceInputBox">
	        <form:input path="firstName"/>
	        <form:errors path="firstName"/>
	    </div>
    </div>
    
    
    
    
</form:form>

<c:if test="${not empty message}">
    <p><c:out value="${message}"/></p>
</c:if>