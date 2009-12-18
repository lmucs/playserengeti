<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
    <c:when test='${ !empty teamCommand }'>
        <div class="grid_3 teamImage">
    	    <img src="${pageContext.request.contextPath}/images/default_team.png" height="150" width="150" alt="teamImage"
            title="teamImage"/>               
        </div>
		<div class="grid_9">
	        <div class="grid_9" id="teamName">
	            <td><strong><c:out value="${teamCommand.name}"/></strong></td>
	        </div>
            <div id="teamInfo">
	            <div class="grid_8">
	            	<strong>Home Base:</strong>
	               	<c:out value="${teamCommand.homeBase}"/>
	            </div>
	            <div class="clear">&nbsp;</div>
	            <div class="grid_8">
	                <strong>Team Leader:</strong>
	                <c:out value="${teamCommand.leader.firstName} ${teamCommand.leader.lastName}"/>
	            </div>
	        </div>
        </div>
        <c:if test="${session.user.id == teamCommand.leader.id}">
            <div class="clear">&nbsp;</div>
            <div class="graphic-button" id="team-modify-button">
                <a href="update/${teamCommand.teamId}">Modify team's profile</a>
            </div> 
        </c:if>
        <div class="clear">&nbsp;</div>
		<div class="grid_2" id="teamDescriptionTitle">
            <strong>Description:</strong>
        </div>
        <div class="clear">&nbsp;</div>
        <div class="grid_7">    
            <div class="grid_7 round_Box_Container">
                <c:out value="${teamCommand.description}"/>
            </div>
            <div class="grid_4 round_Box_Container">
	            <div class="grid_3">
	                <strong>Team Members:</strong>
	            </div>
	            <div class="grid_4 teamMemberScroller">
	                <ul>
	                    <c:forEach var="user" items="${teamCommand.members}">
	                        <li><a href="../user/${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a></li>
	                    </c:forEach>
	                </ul>	
	            </div>
	        </div>
            <div class="clear">&nbsp;</div>
	        <div class="grid_2">
                <strong>Activity:</strong>
            </div>	
            <div class="clear">&nbsp;</div>
            <div class="grid_7 round_Box_Container activityScroller">
                <ul>
                    <c:forEach var="visit" items="${activity}">
                        <li><a href="../user/${visit.user.id}"><c:out value="${visit.user.firstName} ${visit.user.lastName}"/></a> @ 
                            <a href="../location/${visit.location.id}"><c:out value="${visit.location.name}"/></a>
                            (<fmt:formatDate pattern="MMM dd, yyyy hh:mma" value="${visit.date}"/>)</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="grid_4 round_Box_Container" id="territoryScroller">
            <div class="grid_3">
                <p><strong>Controlled Territory</strong> (${fn:length(territory)}) <strong>:</strong></p>
            </div>
            <div class="clear">$nbsp;</div>
            <ul>
                <c:forEach var="loc" items="${territory}">
                    <li><a href="../location/${loc.id}"><c:out value="${loc.name}"/></a>
                        <div class="territoryAddress">
                            <c:out value="${loc.street}"/><br/><c:out value="${loc.city}, ${loc.state} ${loc.zipcode}"/>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="clear">$nbsp;</div>
        <c:if test="${session.loggedIn && (session.user.id == teamCommand.leader.id)}">
            <a href="update/${teamCommand.teamId}">Modify Team</a><br/>
        </c:if>
    </c:when>
    <c:otherwise>
        <p>The team you requested does not exist.</p>
    </c:otherwise>
</c:choose>
<div class="grid_8 round_Box_Container" id="map_canvas"></div>
        
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/teamMap.js"></script>
<script type="text/javascript">
    $(function() {      
        setup(JSON.parse('${jsonData}'), "${teamCommand.color}");
    });
</script>
