<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <p>The user <strong><c:out value="${userName}"/></strong> with an email of
        <strong><c:out value="${email}"/></strong> has just been created with a
        userId of <strong><c:out value="${userId}"/></strong>
        </p>


       <p><a href="list">View all users.</a></p>