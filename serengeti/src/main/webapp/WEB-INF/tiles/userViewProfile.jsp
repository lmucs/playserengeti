<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
    <c:when test='${!empty userCommand}'>
        <c:if test="${session.loggedIn}">
            <div id="ownProfile">
                     
                <div class="grid_10 prefix_1" id="thanks">
                    <p>Thank you for checking in.</p>
                </div>
                    
                <div class="grid_10 prefix_1" id="checkIn">
                    <div class="grid_4" id="locList">
                        <p>Checkin from:</p>
                        <select id="locSelect">
                            <c:forEach var="location" items="${nearbyLocations}">
                                <option value="${location.id}"><c:out value="${location.name}"/></option>
                            </c:forEach>
                        </select>
                        <input id="notHere" type="button" value="Not Here?" onClick="showSearch()"/>
                    </div>
                    <div class="grid_4" id="locSearch">
                        <input id="searchText" type="text" value="Where are you?">
                        <input type="button" value="Search" onClick="searchLoc()"/>
                    </div>
                    <div class="grid_4"  id="teamList">
                        <p>As a member of team:</p>
                        <select id="teamSelect"></select>
                    </div>
                    <input type="button" value="Check In" onClick="checkIn()"/>           
                </div>
                <div class="grid_5 prefix_1" id="friendRequests">
                    <p>These people want to be your friend.</p>
                    <ul id="friendInvites"></ul>
                </div>
            
                <div class="grid_5 prefix_1" id="teamRequests">
                    <p>You have been invited to the following teams.</p>
                    <ul id="teamInvites"></ul>
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
        </c:if>
            
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
        <div id="edit"></div>
    </c:when>
    <c:otherwise>
        <p>The user you requested does not exist.</p>
    </c:otherwise>
</c:choose>

<!--  for www.playserengeti.com/ -->
<script src="http://www.google.com/jsapi" type="text/javascript"></script>

<script>
    google.load('search', '1');

    var uData;
    var lSearch;
    var userLoc;
    
    $(function() {
        uData = JSON.parse('${profileData}');
        populate(uData);
        layout(uData);
        lSearch = new google.search.LocalSearch();
        lSearch.setSearchCompleteCallback(this, searchComplete);
        userLoc = google.loader.ClientLocation.address.city;
        alert(userLoc);
                      
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
        $("#name").append(data.user.name);
    };
    
    var layout = function(data) {
        if (data.sessionId == data.user.id) { 
            $("#othersProfile").hide();
            $("#thanks").hide();
            if (data.invites.friendInvites.length === 0) {
                $("#friendRequests").hide();
            }
            if (data.invites.teamInvites.length === 0) {
                $("#teamRequests").hide();
            }
            $("#edit").html("<a href=update/" + data.user.id + ">Edit Profile</a>");
            $("#locSearch").hide();
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
    
    var showSearch = function(){
        $("#locSearch").fadeIn("slow");
        $("#notHere").fadeOut("slow");
        
    };

    var searchLoc = function() {
        lSearch.execute($("#searchText").val() + " " + userLoc);
        
        $("#locSearch").fadeOut("slow");
        $("#locList").append("<a href=../location/create>Add Location</a>");
    };
    
    var searchComplete = function() {
        if (lSearch.results && lSearch.results.length > 0) {
            var results = lSearch.results;
            $("#locSelect").empty();
            jQuery.each(results, function(i, val) {
                 var request = $.get("../location/handleResult", {name : val.titleNoFormatting, lat : parseFloat(val.lat), 
                    lng : parseFloat(val.lng) , street : val.streetAddress, city : val.city, 
                    state : val.region, phone : val.phoneNumbers[0].number}, 
                        function(data) {
                            var jsonData = JSON.parse(request.responseText);
                            $("#locSelect").append("<option value=" + jsonData.id + ">" + jsonData.name + "</option>");
                        });
            });
        }
    };
    
    var checkIn = function() {
        $.get("checkIn", {userId : uData.sessionId, teamId : $("select#teamSelect").val(), 
            locationId : $("select#locSelect").val()}
        );
        $("#checkIn").fadeOut("slow");
        $("#thanks").fadeIn("slow"); 
    };
    
    var sendFriendInvite = function () {
        $.get("sendFriendInvite", {pUserId : uData.sessionId, sUserId : uData.user.id});
        $("#inviteFriend").fadeOut("slow");
    };
    
    var acceptFriendInvite = function (userId) {
        var request = $.get("acceptFriendInvite", {pUserId : userId, sUserId : uData.sessionId},
            function(data) {
                var jsonData = JSON.parse(request.responseText);
                $("#friends").append("<li><a href=" + jsonData.id + ">" + jsonData.name + "</a></li>");
            });
        $("#friendInvite_" + userId).fadeOut("slow");
    };
    
    var rejectFriendInvite = function (userId) {
        $.get("rejectFriendInvite", {pUserId : userId, sUserId : uData.sessionId});
        $("#friendInvite_" + userId).fadeOut("slow");
    };
    
    var sendTeamInvite = function () {
        $.get("sendTeamInvite", {teamId : $("select#teamInviteSelect").val(), userId : uData.user.id});
        $("#inviteTeam").fadeOut("slow");
    };
    
    var acceptTeamInvite = function (teamId) {
        var request = $.get("acceptTeamInvite", {teamId : teamId, userId : uData.sessionId}, 
            function(data){
                var jsonData = JSON.parse(request.responseText);
                $("#teams").append("<li><a href=../team/" + jsonData.id + ">" + jsonData.name + "</a></li>");
                $("#teamSelect").append("<option value=" + jsonData.id + ">" + jsonData.name + "</option>");
            });
        $("#teamInvite_" + teamId).fadeOut("slow");
    };
    
    var rejectTeamInvite = function (teamId) {
        $.get("rejectTeamInvite", {teamId : teamId, userId : uData.sessionId});
        $("#teamInvite_" + teamId).fadeOut("slow");
    };
    
</script>
