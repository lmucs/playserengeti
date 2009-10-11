<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <p>The team <strong><c:out value="${team.name}"/></strong> with the color of
        <strong><c:out value="${team.color}"/></strong> has just been created.</p>

       <p><a href="list">View all teams.</a></p>
