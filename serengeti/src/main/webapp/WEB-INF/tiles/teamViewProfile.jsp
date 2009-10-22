<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


        <c:choose>
            <c:when test='${ !empty teamCommand }'>
                <p>Here's the team's profile you requested</p>
                <table>
                    <tr>
                        <td><strong>Team Name</strong></td>
                        <td><c:out value="${teamCommand.name}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Team Color</strong></td>
                        <td><c:out value="${teamCommand.color}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Team Leader</strong></td>
                        <td><c:out value="${teamCommand.leaderId}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Team Image</strong></td>
                        <td><c:out value="${teamCommand.image}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Team Description:</td>
                        <td><c:out value="${teamCommand.description}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Home Base:</td>
                        <td><c:out value="${teamCommand.homeBase}"/></td>
                    </tr>
                    
                    <strong>Team Members:</strong>
                    <ul>
                      <c:forEach var="user" items="${members}">
                          <li><a href="../user/view?userId=${user.userId}"><c:out value="${user.userName}"/></a></li>
                      </c:forEach>
                    </ul>

                </table>
                <hr>
                <!-- This will only display if team.leader.id == userId  and pass in the userId -->
                <a href="update?teamId=${teamCommand.teamId}">Modify Team</a><br/>
            </c:when>
            <c:otherwise>
                <p>The team you requested does not exist.</p>
            </c:otherwise>
        </c:choose>
