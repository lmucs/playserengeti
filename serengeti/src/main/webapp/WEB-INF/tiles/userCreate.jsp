<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="signUpCenter">
	Sign up below!
</div>

<form:form method="POST" action="${pageContext.request.contextPath}/user/create">
    <div>
        <div class="formLabel">
            <label for="email">Email Address: </label>
        </div>
        <div class="spaceInputBox">
	        <form:input path="email"/>
	        <form:errors path="email"/>
	    </div>
    </div>
    <div>
        <div class="formLabel">
            <label for="firstName">First Name: </label>
        </div>
        <div class="spaceInputBox">
            <form:input path="firstName"/>
            <form:errors path="firstName"/>
        </div>
    </div>
    <div>
        <div class="formLabel">
            <label for="lastName">Last Name: </label>
        </div>
        <div class="spaceInputBox">
            <form:input path="lastName"/>
            <form:errors path="lastName"/>
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

    <div class="signUpCenter">
        <input type="submit" value="Sign up!"/>
    </div>
</form:form>

