<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form method="POST" action="${pageContext.request.contextPath}/user/create">
    <div class="round_Box_Container extraPadding">
        <div class="grid_2">
            <label for="email">Email Address:</label>
        </div>
        <div class="grid_3">
            <form:input path="email"/>
            <form:errors path="email"/>
        </div>
        <div class="clear">&nbsp;</div>
        <div class="grid_2">
            <label for="firstName">First Name:</label>
        </div>
        <div class="grid_3">
            <form:input path="firstName"/>
            <form:errors path="firstName"/>
        </div>
        <div class="clear">&nbsp;</div>
        <div class="grid_2">
            <label for="lastName">Last Name:</label>
        </div>
        <div class="grid_3">
            <form:input path="lastName"/>
            <form:errors path="lastName"/>
        </div>
        <div class="clear">&nbsp;</div>
        <div class="grid_2">
            <label for="password">Password:</label>
        </div>
        <div class="grid_3">
            <form:password path="password"/>
            <form:errors path="password"/>
        </div>
        <div class="clear">&nbsp;</div>
        <div class="grid_2">&nbsp;</div>
        <div class="grid_3">
            <input type="submit" value="Sign up"/>
        </div>
    </div>
</form:form>
