<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <c:choose>
            <c:when test='${!empty userCommand}'>
                <p>Here's the user profile you requested</p>
                <table>
                    <tr>
                        <td><strong>User Name: </strong></td>
                        <td><c:out value="${userCommand.userName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>First Name: </strong></td>
                        <td><c:out value="${userCommand.firstName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Last Name: </strong></td>
                        <td><c:out value="${userCommand.lastName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Email: </strong></td>
                        <td><c:out value="${userCommand.email}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Date of Birth: </strong></td>
                        <td><c:if test='${ !empty user.dateOfBirth }'>
                                <c:out value="${userCommand.dateOfBirth}"/>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Image: </strong></td>
                        <td><c:out value="${userCommand.image}"/></td>
                    </tr>
                    
                    <strong>Friends: </strong>
                      <ul>
                          <c:forEach var="user" items="${friends}">
                              <li><a href="view?userId=${user.userId}"><c:out value="${user.userName}"/></a></li>
                          </c:forEach>
                      </ul>
                   
                   <strong>Teams: </strong>
                   <ul>   
                     <c:forEach var="team" items="${teams}">
                          <li><a href="../team/view?teamId=${team.id}"><c:out value="${team.name}"/></a></li>
                      </c:forEach>
                   </ul> 
                </table>
                <a href="update?userId=${userCommand.userId}">Modify Users</a><br/>
                <a href="delete?userId=${userCommand.userId}">Delete Users</a><br/>
            </c:when>
            <c:otherwise>
                <p>The user you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

