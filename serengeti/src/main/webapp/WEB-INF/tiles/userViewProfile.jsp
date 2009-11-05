<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <c:choose>
            <c:when test='${!empty userCommand}'>
            <c:choose>
                <c:when test="${session.user.userId == userCommand.userId}">
                    <c:if test='${!empty friendInvites}'>
                        <div class="friendRequests">
                            <p>These people want to be your friend.</p>
                            <ul>
                            <c:forEach var="invite" items="${friendInvites}">
                                <li id="invite_${invite.key}"><a href="${invite.value.userId}"><c:out value="${invite.value.displayName}"/></a>
                                <input type="button" value="I'll allow it" onClick="acceptInvite(${invite.key})"/></li>
                            </c:forEach>
                        </div>
                    </c:if>                
                
                    <div class="thanks">
                        <p>Thank you for checking in.</p>
                    </div>
                    
                    <div class="checkin">
                        <p>Checkin from:</p>
                        <select name="checkinLocation" id="checkinLocation">
                            <c:forEach var="location" items="${nearbyLocations}">
                                <option value="${location.locationId}"><c:out value="${location.locationName}"/></option>
                            </c:forEach>
                        </select>
                    
                        <p>As a member of team:</p>
                        <select name="checkinTeam" id="checkinTeam">
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.id}"><c:out value="${team.name}"/></option>
                            </c:forEach>
                        </select>
                    
                        <button type="button" class="button">Check In</button>
                    </div>
                    
                </c:when>
                <c:otherwise>
                    <c:if test="${session.loggedIn && !alreadyFriends}">
                        <div class="sendRequests">
                            <input class="friendInvite" type="button" value="Send friend request" onClick="sendInvite()"/>
                        </div>
                    </c:if>
                </c:otherwise>
            </c:choose>
                
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
                              <li><a href="${user.userId}"><c:out value="${user.displayName}"/></a></li>
                          </c:forEach>
                      </ul>
                   
                   <strong>Teams: </strong>
                   <ul>   
                     <c:forEach var="team" items="${teams}">
                          <li><a href="../team/${team.id}"><c:out value="${team.name}"/></a></li>
                      </c:forEach>
                   </ul> 
                </table>
                <c:if test="${session.user.userId == userCommand.userId}">
                    <a href="update/${userCommand.userId}">Edit Profile</a><br/>
                </c:if>
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
    
    var sendInvite = function () {
        $.get("sendInvite", {pUserId : ${session.user.userId}, sUserId : ${userCommand.userId}});
        $(".friendInvite").fadeOut("slow");
    }
    
    var acceptInvite = function (inviteId) {
        $.get("acceptInvite", {friendshipId : inviteId});
        $("#invite_" + inviteId).fadeOut("slow");
    }
    
</script>
