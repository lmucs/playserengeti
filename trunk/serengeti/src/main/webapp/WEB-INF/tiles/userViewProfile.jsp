<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <c:choose>
            <c:when test='${!empty userCommand}'>
                <p>Here's the user profile you requested</p>
                <table>
                    <tr>
                        <td><strong>Email Address: </strong></td>
                        <td><c:out value="${userCommand.email}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Display Name: </strong></td>
                        <td><c:out value="${userCommand.displayName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Profile Picture: </strong></td>
                        <td><c:out value="${userCommand.image}"/></td>
                    </tr>
                    
                    <strong>Friends: </strong>
                      <ul>
                          <c:forEach var="user" items="${friends}">
                              <li><a href="view?userId=${user.userId}"><c:out value="${user.displayName}"/></a></li>
                          </c:forEach>
                      </ul>
                   
                   <strong>Teams: </strong>
                   <ul>   
                     <c:forEach var="team" items="${teams}">
                          <li><a href="../team/view?teamId=${team.id}"><c:out value="${team.name}"/></a></li>
                      </c:forEach>
                   </ul> 
                </table>
                <a href="update?userId=${userCommand.userId}">Edit Profile</a><br/>
            </c:when>
            <c:otherwise>
                <p>The user you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

