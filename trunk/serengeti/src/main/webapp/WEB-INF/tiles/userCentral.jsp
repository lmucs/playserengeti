<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <p>Welcome to User Central!</p>

        <p>Recently Checked In</p>
        <ul>
            <c:forEach var="user" items="${recent}">
               <li><a href="view?userId=${user.userId}"><c:out value="${user.displayName}"/></a></li>
            </c:forEach>
        </ul>
        
        <p>Most Active Users</p>
        <ul>
            <c:forEach var="user" items="${mostActive}">
               <li><a href="view?userId=${user.userId}"><c:out value="${user.displayName}"/></a></li>
            </c:forEach>
        </ul>
        
        <p>Newest Users</p>
        <ul>
            <c:forEach var="user" items="${newest}">
               <li><a href="view?userId=${user.userId}"><c:out value="${user.displayName}"/></a></li>
            </c:forEach>
        </ul>