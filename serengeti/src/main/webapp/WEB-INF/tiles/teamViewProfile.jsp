<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
    <c:when test='${ !empty teamCommand }'>
    <div class= "grid_10">
    	<div class="grid_3">
        <div id="teamImage">
    	    <img src="${pageContext.request.contextPath}/images/default_team.png" height="150" width="150" alt="teamImage"
            title="teamImage"/>               
        </div>
		</div>
	        <div class="grid_6" id="teamName">
	            <h3 id= "name"><c:out value="${teamCommand.name}"/></h3>
	            <div id = "teamBaseAndLeader">
	            	<p id = "HomeBase"> Home Base:  <c:out value="${teamCommand.homeBase}"/></p>
	            	<p id = "TeamLeader"> Team Leader:  <c:out value="${teamCommand.leader.firstName} ${teamCommand.leader.lastName}"/><p>
	        	</div>
	        </div>
        
        </div>
        <c:if test="${session.user.id == teamCommand.leader.id}">
            <div class="clear">&nbsp;</div>
            <div class="grid_3">
                <c:if test="${session.loggedIn && (session.user.id == teamCommand.leader.id)}">
                    <a href="update/${teamCommand.teamId}">Modify team's profile</a>
                </c:if>
            </div> 
        </c:if>
        <div class="clear">&nbsp;</div>
        <div class="clear">&nbsp;</div>
        <div class="grid_7">
	        <div class="grid_7">    
	            <div class="grid_7 round_Box_Container">
	                <div class="grid_2" id="teamDescriptionTitle">
	                    <div class="shadowText">Description:</div>
	                </div>
	                <div class="clear">&nbsp;</div>
	                <div id="descriptionParagraph">
	                    <c:out value="${teamCommand.description}"/>
	                </div>
	            </div>
	            <div class="clear">&nbsp;</div>
		        <div class="grid_7 round_Box_Container">
		            <div class="grid_2">
	                    <div class="shadowText">Activity:</div>
	                </div>	
	                <div class="clear">&nbsp;</div>
	                <ul>
	                    <c:forEach var="visit" items="${activity}">
	                        <li><a href="../user/${visit.user.id}"><c:out value="${visit.user.firstName} ${visit.user.lastName}"/></a> @ 
	                            <a href="../location/${visit.location.id}"><c:out value="${visit.location.name}"/></a>
	                            (<fmt:formatDate pattern="MMM dd, yyyy hh:mma" value="${visit.date}"/>)</li>
	                    </c:forEach>
	                </ul>
	            </div>
	            
	            <div class="grid_8 round_Box_Container" id="map_canvas"></div>
	        </div>
	    </div>
        <div class="grid_4">
	        <div class="grid_4 round_Box_Container teamMemberScroller">
	            <div class="grid_4">
	                <div class="grid_3">
	                    <div class="shadowText">Team Members:</div>
	                </div>
	                <div class="clear">&nbsp;</div>
	                <ul>
	                    <c:forEach var="user" items="${teamCommand.members}">
	                        <li><a href="../user/${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a></li>
	                    </c:forEach>
	                </ul>	
	            </div>
	        </div>
	        <div class="clear">nbsp;</div>
	        <div class="grid_4 round_Box_Container" id="territoryScroller">
	            <div class="grid_3 shadowText">
	                Controlled Territory(${fn:length(territory)}):
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
        </div>
    </c:when>
    <c:otherwise>
        <p>The team you requested does not exist.</p>
    </c:otherwise>
</c:choose>

        
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/teamMap.js"></script>
<script type="text/javascript">
    $(function() {      
        setup(JSON.parse('${jsonData}'), "${teamCommand.color}");
    });
</script>
