<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <c:choose>
            <c:when test='${!empty userCommand}'>
            <c:choose>
                <c:when test="${session.user.id == userCommand.userId}">
                    <div class="grid_12" id="checkin">
                        <div class="grid_2"
	                        <p>Checkin from:</p>
	                    </div>
	                    <div class="grid_3">
	                        <select name="checkinLocation" id="checkinLocation">
	                            <c:forEach var="location" items="${nearbyLocations}">
	                                <option value="${location.locationId}"><c:out value="${location.locationName}"/></option>
	                            </c:forEach>
	                        </select>
                        </div>
                        <div class="grid_2">
	                        <p>As a member of team:</p>
	                    </div>
	                    <div class="grid_3">
	                        <select name="checkinTeam" id="checkinTeam">
	                            <c:forEach var="team" items="${teams}">
	                                <option value="${team.id}"><c:out value="${team.name}"/></option>
	                            </c:forEach>
	                        </select>
	                    </div>
                        <button type="button" class="button">Check In</button>
                        <div class="clear">&nbsp;</div>
                        <div class="thanks">
                            <p>Thank you for checking in.</p>
                        </div>
                    </div>
                    <div class="container_12">
	                    <div class="grid_6" id="user_info_friend_request_container">
			                <div class="grid_6">
			                    <c:if test='${!empty friendInvites}'>
			                        <div class="friendRequests">
			                            <p>These people want to be your friend.</p>
			                            <ul>
			                            <c:forEach var="user" items="${friendInvites}">
			                                <li id="friendInvite_${user.id}"><a href="${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a>
			                                <input type="button" value="I'll allow it" onClick="acceptFriendInvite(${user.id})"/>
			                                <input type="button" value="Not Interested" onClick="rejectFriendInvite(${user.id})"/></li>
			                            </c:forEach>
			                        </div>
			                    </c:if>                
			                </div>
			                <div class="grid_6">
			                    <c:if test='${!empty teamInvites}'>
			                        <div class="teamRequests">
			                            <p>You have been invited to the following teams.</p>
			                            <ul>
			                            <c:forEach var="team" items="${teamInvites}">
			                                <li id="teamInvite_${team.id}"><a href="../team/${team.id}"><c:out value="${team.name}"/></a>
			                                <input type="button" value="I'll allow it" onClick="acceptTeamInvite(${team.id})"/>
			                                <input type="button" value="Not Interested" onClick="rejectTeamInvite(${team.id})"/></li>
			                            </c:forEach>
			                        </div>
			                    </c:if>
			                </div>
			        </div>
			    </c:when>
	                <c:otherwise>
	                    <c:if test="${session.loggedIn}">
	                        <div class="sendRequests">
	                            <c:if test="${!alreadyFriends}">
	                                <input class="inviteFriend" type="button" value="Send friend request" onClick="sendFriendInvite()"/>
	                            </c:if>
	                            <c:if test="${!empty teamsToInviteTo}">
	                                <select name="teamToInvite" id="teamToInvite">
	                                    <c:forEach var="team" items="${teamsToInviteTo}">
	                                        <option value="${team.id}"><c:out value="${team.name}"/></option>
	                                    </c:forEach>
	                                </select>
	                                <input class="inviteMember" type="button" value="Send Team Invitation" onClick="sendTeamInvite()"/>
	                            </c:if>
	                        </div>                        
	                    </c:if>
	                </c:otherwise>
	            </c:choose>
	            <div class="grid_6" id="user_friend_team_container">
	                <table>
	                    <tr>
	                        <div class="grid_2">
	                        	<td><strong>Email Address: </strong></td>
	                        </div>
	                        <div class="grid_3">
	                        	<td><c:out value="${userCommand.email}"/></td>
	                        </div>
	                    </tr>
	                    <tr>
	                        <div class="grid_2">
	                        	<td><strong>Name: </strong></td>
	                        </div>
	                        <div class="grid_3">
	                        	<td><c:out value="${userCommand.firstName} ${userCommand.lastName}"/></td>
	                        </div>
	                    </tr>
	                    
	                    <strong>Friends: </strong>
	                      <ul>
	                          <c:forEach var="user" items="${friends}">
	                              <li><a href="${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a></li>
	                          </c:forEach>
	                      </ul>
	                   
	                   <strong>Teams: </strong>
	                   <ul>   
	                     <c:forEach var="team" items="${teams}">
	                          <li><a href="../team/${team.id}"><c:out value="${team.name}"/></a></li>
	                      </c:forEach>
	                   </ul> 
	                </table>
	                <c:if test="${session.user.id == userCommand.userId}">
                    <a href="update/${userCommand.userId}">Edit Profile</a><br/>
                </c:if>
	            </div>
	        </div>    
            </c:when>
            <c:otherwise>
                <p>The user you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

<script>
    $(function() {
        $(".thanks").hide();
        $(".button").click(function() {  
            $.get("checkIn", {userId : ${userCommand.userId}, teamId : $("select#checkinTeam").val(), 
                locationId : $("select#checkinLocation").val()}
            );
            $(".checkin").fadeOut("slow", function() {$(".thanks").fadeIn("slow");});  
                 
        });  
    });
    
    var sendFriendInvite = function () {
        $.get("sendFriendInvite", {pUserId : ${session.user.id}, sUserId : ${userCommand.userId}});
        $(".inviteFriend").fadeOut("slow");
    }
    
    var acceptFriendInvite = function (userId) {
        $.get("acceptFriendInvite", {pUserId : userId, sUserId : ${session.user.id}});
        $("#friendInvite_" + userId).fadeOut("slow");
    }
    
    var rejectFriendInvite = function (userId) {
        $.get("rejectFriendInvite", {pUserId : userId, sUserId : ${session.user.id}});
        $("#friendInvite_" + userId).fadeOut("slow");
    }
    
    var sendTeamInvite = function () {
        $.get("sendTeamInvite", {teamId : $("select#teamToInvite").val(), userId : ${userCommand.userId}});
        $(".inviteMember").fadeOut("slow");
    }
    
    var acceptTeamInvite = function (teamId) {
        $.get("acceptTeamInvite", {teamId : teamId, userId : ${session.user.id}});
        $("#teamInvite_" + teamId).fadeOut("slow");
    }
    
    var rejectTeamInvite = function (teamId) {
        $.get("rejectTeamInvite", {teamId : teamId, userId : ${session.user.id}});
        $("#teamInvite_" + teamId).fadeOut("slow");
    }
</script>
