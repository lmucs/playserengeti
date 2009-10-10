<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>View Team Profile</title>
    </head>
  
    <body>
	    <a href="/serengeti"><img src="../images/serengeti-logo-full.png" alt="logo" style="float:right" height="20%" width="20%" border="0"/></a>

        <c:choose>
            <c:when test='${ !empty teamId }'>
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
                    <tr>
                        <td><strong>Team Leader</strong></td>
                        <td><c:out value="${team.leader.userName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Home Location</strong></td>
                        <td><c:out value="${team.homeLocation.locationName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Team Image</strong></td>
                        <td><c:out value="${team.image}"/></td>
                    </tr>
                    <tr>
                      <td><strong>Team Members:</strong><br/></td>
                      <c:forEach var="user" items="${team.members}">
                        <tr>
                          <td><a href="../user/view?userId=${user.userId}"><c:out value="${user.userName}"/></a></td>                    
                        </tr>
                      </c:forEach>
                    </tr>
                </table>
                <hr>                
                <!-- These will only display if team.leader.id == userId  and pass in the userId -->
                <a href="update?teamId=${team.id}">Modify Team</a><br/>
                <a href="delete?teamId=${team.id}">Delete Team</a><br/>
                <a href="invite?teamId=${team.id}">Invite People</a><br/>
            </c:when>
            <c:otherwise>
                <p>The team you requested does not exist.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>

