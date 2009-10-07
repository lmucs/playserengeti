<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>View Team Profile</title>
    </head>
  
    <body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>
    
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
                <a href="update?teamId=${team.id}">Modify Team</a><br/>
                <a href="delete?teamId=${team.id}">Delete Team</a><br/>
                <a href="list">View All Teams</a>
            </c:when>
            <c:otherwise>
                <p>The team you requested does not exist.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>

