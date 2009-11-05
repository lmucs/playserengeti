<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <c:choose>
            <c:when test='${ !empty teamCommand }'>
                <div class="container">
                    <div id="logoNameContainer">
	                    <div>
	                        <td><strong>Team Image</strong></td>
	                        <td><c:out value="${teamCommand.image}"/></td>
	                    </div>
	                    <div>
	                        <td><strong>Team Name</strong></td>
	                        <td><c:out value="${teamCommand.name}"/></td>
	                    </div>
	                </div>
	                <div id="attributeContainer">
		                <div>
	                        <td><strong>Team Color</strong></td>
	                        <td><c:out value="${teamCommand.color}"/></td>
	                    </div>
	                    <div>
	                        <td><strong>Team Leader</strong></td>
	                        <td><c:out value="${teamCommand.leaderId}"/></td>
	                    </div>
	                    <div>
                        	<td><strong>Home Base:</td>
                        	<td><c:out value="${teamCommand.homeBase}"/></td>
                        </div>
	                </div>
	            </div>
                <div id="description">
                    <td><strong>Team Description:</td>
                    <td><c:out value="${teamCommand.description}"/></td>
                </div>
                
                <div id="memberTable">
                    <strong>Team Members:</strong>
                    <ul>
                      <c:forEach var="user" items="${members}">
                          <li><a href="../user/${user.userId}"><c:out value="${user.displayName}"/></a></li>
                      </c:forEach>
                    </ul>	
                </div>
                <hr>
                <c:if test="${session.loggedIn && (session.user.userId == teamCommand.leaderId)}">
                    <a href="update/${teamCommand.teamId}">Modify Team</a><br/>
                </c:if>
            </c:when>
            <c:otherwise>
                <p>The team you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

