<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <p>Welcome to Team Central!</p>

        <p>Teams With the Most Territory</p>
        <ul>
            <c:forEach var="team" items="${leaders}">
               <li><a href="view?teamId=${team.id}"><c:out value="${team.name}"/></a></li>
            </c:forEach>
        </ul>
        
        <p>Most Active Teams</p>
        <ul>
            <c:forEach var="team" items="${mostActive}">
               <li><a href="view?teamId=${team.id}"><c:out value="${team.name}"/></a></li>
            </c:forEach>
        </ul>
        
        <p>Newest Teams</p>
        <ul>
            <c:forEach var="team" items="${newest}">
               <li><a href="view?teamId=${team.id}"><c:out value="${team.name}"/></a></li>
            </c:forEach>
        </ul>
        <c:if test="${session.loggedIn}">
            <p><a href="create">Create a new team?</a></p>
        </c:if>