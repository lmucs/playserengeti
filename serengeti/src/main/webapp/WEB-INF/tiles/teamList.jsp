<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>All of the Teams</title>
    </head>

    <body>
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
                    <td><c:out value="${team.name}"/></td>
                    <td><c:out value="${team.color}"/></td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="create">Create a new team?</a></p>
    </body>
</html>
