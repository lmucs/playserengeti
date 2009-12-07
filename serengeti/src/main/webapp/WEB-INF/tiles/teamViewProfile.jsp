<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <c:choose>
            <c:when test='${ !empty teamCommand }'>
                
                <div class="clear">&nbsp;</div>
                
            	<div class="grid_3 teamImage">
            	    <img src="${pageContext.request.contextPath}/images/default_team.png" alt="teamImage"
		            title="teamImage"/>               
		        </div>
		        <div class="grid_3">
	                <div class="grid_3" id="teamName">
	                    <td><strong><c:out value="${teamCommand.name}"/></td>
	                </div>
	                
	                <div class="clear">&nbsp;</div>
	                <div id="teamInfo">
		                <div class="grid_4">
		                	<td><strong>Home Base:</td>
		                	<td><c:out value="${teamCommand.homeBase}"/></td>
		                </div>
		            
		                <div class="clear">&nbsp;</div>
		                
		                <div class="grid_4">
		                    <td><strong>Team Leader:</strong></td>
		                    <td><c:out value="${teamCommand.leader.firstName} ${teamCommand.leader.lastName}"/></td>
		                </div>
		            </div>
	            </div>

	            <div class="clear">&nbsp;</div>
	                
	            <div class="grid_2">
                    <td><strong>Description:</td>
                </div>	
                
                <div class="clear">&nbsp;</div>
                
                <div class="grid_8 round_Box_Container">
                    <td><c:out value="${teamCommand.description}"/></td>
                </div>
                
                <div class="grid_4 round_Box_Container">
	                <div class="grid_3">
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
                
                <div class="clear">&nbsp;</div>
	                
	            <div class="grid_2">
                    <td><strong>Activity:</td>
                </div>	
                
                <div class="clear">&nbsp;</div>
                
                <div class="grid_8 round_Box_Container">
                    <ul>
                    <c:forEach var="visit" items="${activity}">
                        <li><c:out value="${visit.user.firstName} ${visit.user.lastName}"/> checked in to 
                          <c:out value="${visit.location.name}"/> (${visit.date})</li>
                    </c:forEach>
                    </ul>
                </div>
                <div class="grid_4 round_Box_Container">
                    <ul>
                    <c:forEach var="territory" items="${territory}">
                        <li><a href="../location/${location.id}"><c:out value="${location.name}"/></a></li>
                          <c:out value="${visit.location.name}"/> <c:out value="${visit.location.getFormattedAddress}"/>
                    </c:forEach>
                    </ul>
                </div>
                <hr>
                <c:if test="${session.loggedIn && (session.user.id == teamCommand.leader.id)}">
                    <a href="update/${teamCommand.teamId}">Modify Team</a><br/>
                </c:if>
            </c:when>
            <c:otherwise>
                <p>The team you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

