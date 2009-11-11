<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <c:choose>
            <c:when test='${ !empty teamCommand }'>
                <div class="grid_6">
	                <div class="grid_2">
	                    <td><strong>Team Image</strong></td>
	                </div>
	                <div class="grid_3"> 
	                    <td><c:out value="${teamCommand.image}"/></td>
	                </div>
	                
	                <div class="clear">&nbsp;</div>
	                
	                <div class="grid_2">
	                    <td><strong>Team Name</strong></td>
	                </div>
	                <div class="grid_3">
	                    <td><c:out value="${teamCommand.name}"/></td>
	                </div>
	            
	                <div class="clear">&nbsp;</div>
	                
	                <div class="grid_2">
	                    <td><strong>Team Color</strong></td>
	                </div>
	                <div class="grid_3">
	                    <td><c:out value="${teamCommand.color}"/></td>
	                </div>
	                
	                <div class="clear">&nbsp;</div>
	                
	                <div class="grid_2">
	                    <td><strong>Team Leader</strong></td>
	                </div>
	                <div class="grid_3">
	                    <td><c:out value="${teamCommand.leaderId}"/></td>
	                </div>
	                
	                <div class="clear">&nbsp;</div>
	                
	                <div class="grid_2">
	                	<td><strong>Home Base:</td>
	                </div>
	                <div class="grid_3">
	                	<td><c:out value="${teamCommand.homeBase}"/></td>
	                </div>
	                
	                <div class="clear">&nbsp;</div>
	                
		            <div class="grid_2">
	                    <td><strong>Team Description:</td>
	                </div>	
	                <div class="grid_3">
	                    <td><c:out value="${teamCommand.description}"/></td>
	                </div>
	            </div>
	            <div class="grid_6">
	                <div class="grid_2">
	                    <strong>Team Members:</strong>
	                </div>
	                <div class="grid_4">
	                    <ul>
	                      <c:forEach var="user" items="${members}">
	                          <li><a href="../user/${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a></li>
	                      </c:forEach>
	                    </ul>	
	                </div>
	            </div>
                <hr>
                <c:if test="${session.loggedIn && (session.user.id == teamCommand.leaderId)}">
                    <a href="update/${teamCommand.teamId}">Modify Team</a><br/>
                </c:if>
            </c:when>
            <c:otherwise>
                <p>The team you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

