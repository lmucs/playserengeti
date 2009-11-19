<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
    <c:when test='${!empty userCommand}'>
        <div id="ownProfile">
        
            <div class="grid_10 prefix_1" id="checkIn">
                <div class="grid_4" id="locList">
                    <p>Checkin from:</p>
                    <select id="locSelect">
                        <c:forEach var="location" items="${nearbyLocations}">
                            <option value="${location.id}"><c:out value="${location.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="grid_4" id="teamList">
                    <p>As a member of team:</p>
                    <select id="teamSelect"></select>
                </div>
                    <input type="button" value="Check In" onClick="checkIn()"/>
            </div>
            
            <div class="grid_4" id="info">
                <div class="grid_2">
	            	<strong>Email Address: </strong>
	            </div>
	            <div class="grid_2">
	                <p id="email"></p>
	            </div>
	            
	            <div class="grid_2">
	                <strong>Name: </strong>
	            </div>
	            <div class="grid_2">
	                <p id="name"></p>
	            </div>
	            
	            <div class="grid_2">
	                <strong>Friends: </strong>
	            </div>
	            <div class="grid_2">
	                <ul id="friends"></ul>
	            </div>
	                   
	            <div class="grid_2">
	                <strong>Teams: </strong>
	            </div>
	            <div class="grid_2">
	                <ul id="teams"></ul> 
	            </div>
            </div>
            
            <div class="grid_5 prefix_1" id="friendRequests">
                <p>These people want to be your friend.</p>
                <ul id="friendInvites"></ul>
            </div>
            
            <div class="grid_5 prefix_1" id="teamRequests">
                <p>You have been invited to the following teams.</p>
                <ul id="teamInvites"></ul>
            </div>
                    
            <div id="thanks">
                <p>Thank you for checking in.</p>
            </div>
                    
            
        </div>       
             
        <div id="othersProfile">
            <c:if test="${session.loggedIn}">
                <div id="sendInvites">
                    <div id="inviteFriend">
                        <input type="button" value="Send friend request" onClick="sendFriendInvite()"/>
                    </div>   
                    <div id="inviteTeam">
                        <select id="teamInviteSelect"></select>
                        <input type="button" value="Send Team Invitation" onClick="sendTeamInvite()"/>
                    </div>
                </div>                        
            </c:if>
        </div>
            
        
        <c:if test="${session.user.id == userCommand.userId}">
            <a href="update/${userCommand.userId}">Edit Profile</a><br/>
        </c:if>
    </c:when>
    <c:otherwise>
        <p>The user you requested does not exist.</p>
    </c:otherwise>
</c:choose>
        
<script>
    var uData;
    
    $(function() {
        uData = JSON.parse('${profileData}');
        populate(uData);
        layout(uData);
                     
    });
        
    var populate = function(data) {
        jQuery.each(data.friends, function(i, val) {
            $("#friends").append("<li><a href=" + val.id + ">" + val.name + "</a></li>");
            });
        jQuery.each(data.teams, function(i, val) {
            $("#teams").append("<li><a href=../team/" + val.id + ">" + val.name + "</a></li>");
            $("#teamSelect").append("<option value=" + val.id + ">" + val.name + "</option>");
            });
        jQuery.each(data.invites.friendInvites, function(i, val) {
            $("#friendInvites").append("<li id=friendInvite_" + val.id + 
                "><a href=" + val.id + ">" + val.name + "</a><button onClick=acceptFriendInvite(" + 
                val.id + ")>" + "I\'ll allow it" + "</button><button onClick=rejectFriendInvite(" +
                val.id + ")>" + "Not Interested" + "</button></li>");
            });
        jQuery.each(data.invites.teamInvites, function(i, val) {
            $("#teamInvites").append("<li id=teamInvite_" + val.id + 
                "><a href=../team/" + val.id + ">" + val.name + "</a><button onClick=acceptTeamInvite(" + 
                val.id + ")>" + "I\'ll allow it" + "</button><button onClick=rejectTeamInvite(" +
                val.id + ")>" + "Not Interested" + "</button></li>");
            });
        jQuery.each(data.eligableTeams, function(i, val) {
            $("#teamInviteSelect").append("<option value=" + val.id + ">" + val.name + "</option>");
            });
        $("#email").append(data.user.email);
        $("#name").append(data.user.firstName + " " + data.user.lastName);
    };
    
    var layout = function(data) {
        if (${session.user.id} == data.user.id) { 
            $("#othersProfile").hide();
            $("#thanks").hide();
            if (data.invites.friendInvites.length === 0) {
                $("#friendRequests").hide();
            }
            if (data.invites.teamInvites.length === 0) {
                $("#teamRequests").hide();
            }
        }
        else {
            $("#ownProfile").hide();
            if (data.alreadyFriends == "true") {
                $("#inviteFriend").hide();
            }
            if (data.eligableTeams.length === 0) {
                $("#inviteTeam").hide();
            }
        }

    };
    
    var checkIn = function() {
        $.get("checkIn", {userId : ${userCommand.userId}, teamId : $("select#teamSelect").val(), 
            locationId : $("select#locSelect").val()}
        );
        $("#checkIn").fadeOut("slow", function() {$("#thanks").fadeIn("slow");}); 
    };
    
    var sendFriendInvite = function () {
        $.get("sendFriendInvite", {pUserId : ${session.user.id}, sUserId : uData.user.id});
        $("#inviteFriend").fadeOut("slow");
    };
    
    var acceptFriendInvite = function (userId) {
        var request = $.get("acceptFriendInvite", {pUserId : userId, sUserId : ${session.user.id}},
            function(data) {
                var jsonData = JSON.parse(request.responseText);
                $("#friends").append("<li><a href=" + jsonData.id + ">" + jsonData.name + "</a></li>");
            });
        $("#friendInvite_" + userId).fadeOut("slow");
    };
    
    var rejectFriendInvite = function (userId) {
        $.get("rejectFriendInvite", {pUserId : userId, sUserId : ${session.user.id}});
        $("#friendInvite_" + userId).fadeOut("slow");
    };
    
    var sendTeamInvite = function () {
        $.get("sendTeamInvite", {teamId : $("select#teamInviteSelect").val(), userId : uData.user.id});
        $("#inviteTeam").fadeOut("slow");
    };
    
    var acceptTeamInvite = function (teamId) {
        var request = $.get("acceptTeamInvite", {teamId : teamId, userId : ${session.user.id}}, 
            function(data){
                var jsonData = JSON.parse(request.responseText);
                $("#teams").append("<li><a href=../team/" + jsonData.id + ">" + jsonData.name + "</a></li>");
                $("#teamSelect").append("<option value=" + jsonData.id + ">" + jsonData.name + "</option>");
            });
        $("#teamInvite_" + teamId).fadeOut("slow");
    };
    
    var rejectTeamInvite = function (teamId) {
        $.get("rejectTeamInvite", {teamId : teamId, userId : ${session.user.id}});
        $("#teamInvite_" + teamId).fadeOut("slow");
    };
    
</script>
