<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<p>Sign up below!</p>

<c:if test="${ empty message}">
<form:form method="post" action="create">
    <div>
        <label for="userName">User Name: </label> <input type="text" name="userName"/>
    </div>

    <div>
        <label for="password">Password: </label> <input type="text" name="password"/>
    </div>

    <div>
        <label for="email">Email Address: </label> <input type="text" name="email"/><br/>
    </div>

    <div>
        <input type="submit" value="Sign up!"/>
    </div>
</form:form>
</c:if>

<c:if test="${ !empty message}">
    <p><c:out value="${message}"/></p>
</c:if>
