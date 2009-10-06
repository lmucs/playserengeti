<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>View Team Profile</title>
    </head>
  
    <body>
        <c:choose>
            <c:when test='${ !empty team }'>
                <p>Here's the team's profile you requested</p>
                <table>
                    <tr>
                        <td><strong>Team Name</strong></td>
                        <td><c:out value="${team.name}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Team Color</strong></td>
                        <td><c:out value="${team.color}"/></td>
                    </tr>
                </table>
                <a href="update?teamId=${team.id}">Modify Team</a>
            </c:when>
            <c:otherwise>
                <p>That team does not exist.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>

