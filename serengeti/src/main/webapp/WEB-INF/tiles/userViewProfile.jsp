<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:choose>
    <c:when test='${!empty userCommand}'>
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
        <div class="grid_10">
	        <div class="grid_3 userImage">
			    <img src="${pageContext.request.contextPath}/images/default_user.png" alt="Profile Picture"
		        title="Profile Picture"/>               
			</div>
	        <div id="userInfo" class="grid_4">
	        	<h3 id="name"></h3>
	        	<p id="email"></p>
	        </div>
	    </div>
	    <div class="clear">&nbsp</div>
	    <div class="grid_7">
	        <c:if test="${session.loggedIn}">
	            <div id="ownProfile"> 
	                <div class="grid_4 prefix_1" id="thanks">
	                    <p>Thank you for checking in.</p>
	                </div>
	                    
	                <div class="grid_7" id="checkIn">
	                    <div class="grid_4" id="locList">
	                        <p>Checkin from:</p>
	                        <select id="locSelect">
	                        </select>
	                        <input id="notHere" type="button" value="Not Here?" onClick="showSearch()"/>
	                    </div>
	                    <div class="clear">&nbsp</div>
	                    <div class="grid_4" id="locSearch">
	                        <input id="searchText" type="text" value="Where are you?">
	                        <input type="button" value="Search" onClick="searchLoc()"/>
	                    </div>
	                    <div class="grid_4"  id="teamList">
	                        <p>As team:</p>
	                        <select id="teamSelect"></select>
	                    </div>
	                    <div class="clear">&nbsp</div>
	                    <div class="grid_1" id="checkinButton">
	                        <input type="button" value="Check In" onClick="checkIn()"/> 
	                    </div>          
	                </div>
	                <div class="clear">&nbsp</div>
		            <div class="grid_7 round_Box_Container">
			            <div class="grid_6" id="friendRequests">
			                <p>These people want to be your friend.</p>
			                <ul id="friendRequestList"></ul>
			            </div>
			            
		    	        <div class="grid_7" id="teamRequests">
			                <p>You have been invited to the following teams.</p>
			                <ul id="teamRequestList"></ul>
			            </div>
	        		</div>
	            </div>    
	        </c:if>
	        <div class="clear">&nbsp</div>
            <div class="grid_7 activityBoxContainer">
		        <div class="grid_6">
		            <p>Recent Activity</p>
		            <ul id="activity"></ul>
		        </div>
	        </div>
	    </div>  
        <div class="grid_3 prefix_1">
		    <div class="grid_3 round_Box_Container">
				<div class="grid_2">
				    <strong>Friends: </strong>
				</div>
				<div class="grid_3">
					<ul id="friends"></ul>
				</div>  
			</div>
			<div class="grid_3 round_Box_Container"> 
				<div class="grid_2">
				    <strong>Teams: </strong>
				</div>
				<div class="grid_3">
					<ul id="teams"></ul> 
				</div>
			</div>
		</div>
       

    </c:when>
    <c:otherwise>
        <p>The user you requested does not exist.</p>
    </c:otherwise>
    
</c:choose>
<div id="popupContent">
    <a id="popupContentClose">X</a>
    <h1>Contratulations!</h1>
    <p>You just claimed a territory for your team.</p>
    <p>I bet your team will be really proud of you.  I know I am.</p>
    <input type="button" value="Sweet! GO ME!" onClick="disablePopup()"/>
</div>
<div id="popupBackground"></div>
        
<!--  for www.playserengeti.com/ -->
<script src="http://www.google.com/jsapi" type="text/javascript"></script>

<script>
    google.load('search', '1');

    var uData;
    var lSearch;
    var userLoc;
    
    $(function() {
        uData = JSON.parse('${profileData}');
        lSearch = new google.search.LocalSearch();
        lSearch.setSearchCompleteCallback(this, searchComplete);
        lSearch.setAddressLookupMode(google.search.LocalSearch.ADDRESS_LOOKUP_DISABLED);
        userLoc = google.loader.ClientLocation;
        populate(uData);
        layout(uData); 
    });
        
    var populate = function(data) {
    	var friends = $("#friends");
        jQuery.each(data.friends, function(i, val) {
            friends.append("<li><a href=" + val.id + ">" + val.name + "</a></li>");
            });
            
        var teams = $("#teams");
        var teamSelect = $("#teamSelect");
        jQuery.each(data.teams, function(i, val) {
            teams.append("<li><a href=../team/" + val.id + ">" + val.name + "</a></li>");
            teamSelect.append("<option value=" + val.id + ">" + val.name + "</option>");
            });
            
        var friendRequestList = $("#friendRequestList");
        jQuery.each(data.invites.friendInvites, function(i, val) {
            friendRequestList.append("<li id=friendInvite_" + val.id + 
                "><a href=" + val.id + ">" + val.name + "</a><button onClick=acceptFriendInvite(" + 
                val.id + ")>" + "I\'ll allow it" + "</button><button onClick=rejectFriendInvite(" +
                val.id + ")>" + "Not Interested" + "</button></li>");
            });
            
        var teamRequestList = $("#teamRequestList");
        jQuery.each(data.invites.teamInvites, function(i, val) {
            teamRequestList.append("<li id=teamInvite_" + val.id + 
                "><a href=../team/" + val.id + ">" + val.name + "</a><button onClick=acceptTeamInvite(" + 
                val.id + ")>" + "I\'ll allow it" + "</button><button onClick=rejectTeamInvite(" +
                val.id + ")>" + "Not Interested" + "</button></li>");
            });
            
        var teamInviteSelect = $("#teamInviteSelect");
        jQuery.each(data.invitableTeams, function(i, val) {
            teamInviteSelect.append("<option value=" + val.id + ">" + val.name + "</option>");
            });
            
        var activity = $("#activity");
        jQuery.each(data.activity, function(i, val) {
            activity.append("<li>@ <a href=../location/" + val.location.id + ">" + 
              val.location.name + "</a> (" + val.date + ")</li>");
            });
        $("#email").append(data.user.email);
        $("#name").append(data.user.name);
        
        getNearbyLocations();
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
            if (data.invitableTeams.length === 0) {
                $("#inviteTeam").hide();
            }
        }
    };
    
    var showSearch = function(){
        $("#locSearch").fadeIn("slow");
        $("#notHere").fadeOut("slow");
        
    };

    var searchLoc = function() {
        lSearch.execute($("#searchText").val() + " " + userLoc.address.city);
        $("#locSelect").empty();
        $("#locSearch").fadeOut("slow");
        $("#locList").append("<a href=../location/create>Add Location</a>");
    };
    
    var searchComplete = function() {
        var locSelect = $("#locSelect");
        if (lSearch.results && lSearch.results.length > 0) {
            var results = lSearch.results;
            jQuery.each(results, function(i, val) {
                 var number = "";
                 if (val.phoneNumbers) {
                     number = val.phoneNumbers[0].number;
                 }
                 var request = $.get("../location/handleResult", {name : val.titleNoFormatting, lat : parseFloat(val.lat), 
                    lng : parseFloat(val.lng) , street : val.streetAddress, city : val.city, 
                    state : val.region, phone : number}, 
                        function(data) {
                            var jsonData = JSON.parse(request.responseText);
                            locSelect.append("<option value=" + jsonData.id + ">" + jsonData.name + "</option>");
                        });
            });
        }
        else {
            locSelect.replaceWith("<p>We couldn't find any locations by that name.</p>");
        }
    };
    
    var checkIn = function() {
        var request = $.get("checkIn", {userId : uData.sessionId, teamId : $("select#teamSelect").val(), 
            locationId : $("select#locSelect").val()}, function(data) {
                var jsonData = JSON.parse(request.responseText);
                if (jsonData.overtaken == "true") {
                    showPopup();
                } 
                $("#thanks").append("Your current location: "  + jsonData.visit.location.name);
            });
        $("#checkIn").fadeOut("slow");
        $("#thanks").fadeIn("slow"); 
    };
    
    var getNearbyLocations = function() {
        var request = $.get("../location/getNearbyLocations", {latitude : userLoc.latitude, 
            longitude : userLoc.longitude}, function(data) {
                var jsonData = JSON.parse(request.responseText);
                populateLocations(jsonData.locations);
            });  
    };
    
    var populateLocations = function(nearby) {
        var locSelect = $("#locSelect");
        jQuery.each(nearby, function(i, val) {
            locSelect.append("<option value=" + val.id + ">" + val.name + "</option>");
            });
    };
    
    var sendFriendInvite = function () {
        $.get("sendFriendInvite", {firstId : uData.sessionId, secondId : uData.user.id});
        $("#inviteFriend").fadeOut("slow");
    };
    
    var acceptFriendInvite = function (userId) {
        var request = $.get("acceptFriendInvite", {firstId : userId, secondId : uData.sessionId},
            function(data) {
                var jsonData = JSON.parse(request.responseText);
                $("#friends").append("<li><a href=" + jsonData.id + ">" + jsonData.name + "</a></li>");
            });
        $("#friendInvite_" + userId).fadeOut("slow");
    };
    
    var rejectFriendInvite = function (userId) {
        $.get("rejectFriendInvite", {firstId : userId, secondId : uData.sessionId});
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
<script>
    var popupStatus = 0;
    
    $(function() {      
        disablePopup();  
        $("#popupContentClose").click(function() {  
            disablePopup();  
        });  

        $("#popupBackground").click(function() {  
            disablePopup();  
        });
    });
    

    var showPopup = function() {
        centerPopup();
        loadPopup();
    };
     var loadPopup = function() {
        if (popupStatus == 0) {
            $("#popupBackground").css({
                "opacity": "0.7"
            });  
            $("#popupBackground").fadeIn("slow");  
            $("#popupContent").fadeIn("slow");  
            popupStatus = 1;
        }
    };
    
    var disablePopup = function() {
        if(popupStatus == 1){  
            $("#popupBackground").fadeOut("slow");  
            $("#popupContent").fadeOut("slow");  
            popupStatus = 0;  
        }  
    };
    
    var centerPopup = function() {
        var windowWidth = document.documentElement.clientWidth;  
        var windowHeight = document.documentElement.clientHeight;  
        var popupHeight = $("#popupContent").height();  
        var popupWidth = $("#popupContent").width();  

        $("#popupContent").css({  
            "position": "absolute",  
            "top": windowHeight/2 - popupHeight/2,  
            "left": windowWidth/2 - popupWidth/2  
        });  
         
        $("#popupBackground").css({  
            "height": windowHeight  
        });  
    }
</script>
