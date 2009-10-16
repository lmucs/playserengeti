<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <c:if test="${deleted == 'true'}">
            <p><strong>The team <c:out value="${deletedName}"/> has been deleted.</strong></p>
        </c:if>
        <p>All of the teams registered with Serengeti.</p>

        <table>
            <tr>
                <th>Id</th>
                <th>Team Name</th>
            </tr>
            <c:forEach var="team" items="${allTeams}">
                <tr>
                    <td>${team.id}</td>
                    <td>
                        <a href="view?teamId=${team.id}"><c:out value="${team.name}"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="create">Create a new team?</a></p>
