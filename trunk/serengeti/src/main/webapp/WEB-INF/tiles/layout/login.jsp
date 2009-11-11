<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="loginbar">
    <c:choose>
    <c:when test="${session.loggedIn}">
    </c:when>
    <c:otherwise>
    <form action="${pageContext.request.contextPath}/user/login" method="POST">
        <label for="email">email:</label> <input type="text" name="email"/>
        <label for="password">password:</label> <input type="password" name="password"/>
        <input type="submit" value="Log In!"/>
    </form>
    </c:otherwise>
    </c:choose>
</div>