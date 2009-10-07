<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>All of the Teams</title>
    </head>

    <body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>
    
        <c:if test="${deleted == 'true'}">
            <p><strong>The team <c:out value="${deletedName}"/> has been deleted.</strong></p>
        </c:if>
        <p>All of the teams registered with Serengeti.</p>

        <table>
            <tr>
                <th>Id</th>
                <th>Team Name</th>
                <th>Team Color</th>
            </tr>
            <c:forEach var="team" items="${allTeams}">
                <tr>
                    <td>${team.id}</td>
                    <td>
                        <a href="view?teamId=${team.id}"><c:out value="${team.name}"/></a>
                    </td>
                    <td><c:out value="${team.color}"/></td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="create">Create a new team?</a></p>
    </body>
</html>
