<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form method="post" onsubmit="return validateUpdateForm();">
    <div class="grid_2">
        <label for="email">Email Address:</label>
    </div>
    <div class="grid_3">
        <form:input path="email"/>
        <form:errors path="email"/>
    </div>
    <div class="clear"></div>
    <div class="grid_2">
        <label for="password">Password:</label>
    </div>
    <div class="grid_3">
        <form:password path="password"/>
        <form:errors path="password"/>
    </div>
    <div class="clear"></div>
    <div class="grid_2">&nbsp;</div>
    <div class="grid_3">
        <input type="submit" value="Login"/>
    </div>
</form:form>

<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/login.js"></script>
<script>
    var validateUpdateForm = function () {
        var email = document.getElementById("email");
        var password = document.getElementById("password");
        
        if (!email || email.value === '') {
            alert("Email cannot be blank");
            return false;
        }
        if (!password || password.value === '') {
            alert("Password cannot be blank");
            return false;
        }
        return true;
    }
</script>