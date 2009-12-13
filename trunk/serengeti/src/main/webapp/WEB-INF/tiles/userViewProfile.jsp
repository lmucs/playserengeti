<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:choose>
    <c:when test='${!empty userCommand}'>
        <c:if test="${session.loggedIn && (session.user.id != userCommand.userId)}">
            <div id="othersProfile">
                <div id="sendInvites">
                    <c:if test="${!alreadyFriends}">
                        <div id="inviteFriend">
                            <input type="button" value="Send Friend Request" onClick="sendFriendInvite()"/>
                        </div>
                    </c:if>
                    <c:if test="${!empty invitableTeams}">
                        <div id="inviteTeam">
                            <select id="teamInviteSelect">
                                <c:forEach var="team" items="${invitableTeams}">
                                    <option value="${team.id}"><c:out value="${team.name}"/></option>;
                                </c:forEach>
                            </select>
                            <input type="button" value="Send Team Invitation" onClick="sendTeamInvite()"/>
                        </div>
                    </c:if>
                </div>
            </div>
        </c:if>
        <div class="grid_10">
          <div class="grid_3 userImage">
          <img src="${pageContext.request.contextPath}/images/default_user.png" alt="Profile Picture"
            title="Profile Picture"/>
      </div>
          <div id="userInfo" class="grid_6">
            <h3 id="name"><c:out value="${userCommand.firstName} ${userCommand.lastName}"/></h3>
            <div id="userViewEmail">
              <p id="email"><c:out value="${userCommand.email}"/></p>
            </div>
          </div>
      </div>
      <div class="clear">&nbsp;</div>
      <div class="grid_7">
          <c:if test="${session.loggedIn && (session.user.id == userCommand.userId)}">
              <div id="ownProfile">
                  <div class="grid_4 prefix_1" id="thanks">
                      <p>Thank you for checking in.</p>
                  </div>

                  <div class="grid_7" id="checkIn">
                      <div class="grid_4" id="locList">
                          <p>Checkin from:</p>
                          <select id="locSelect"><option>Select Location</option></select>
                          <input id="notHere" type="button" value="Not Here?" onclick="showSearch()"/>
                      </div>
                      <div class="clear">&nbsp;</div>
                      <div class="grid_4" id="locSearch">
                          <input id="searchText" type="text" value="Where are you?"/>
                          <input type="button" value="Search" onclick="searchLoc()"/>
                      </div>
                      <div class="grid_4"  id="teamList">
                          <p>As team:</p>
                          <select id="teamSelect">
                              <c:forEach var="team" items="${userCommand.teams}">
                                  <option value="${team.id}"><c:out value="${team.name}"/></option>
                              </c:forEach>
                          </select>
                      </div>
                      <div class="clear">&nbsp;</div>
                      <div class="grid_1" id="checkinButton">
                          <input type="button" value="Check In" onclick="checkIn()"/>
                      </div>
                  </div>
                  <div class="clear">&nbsp;</div>
                  <c:if test="${!empty friendInvites && !empty teamInvites}">
                     <div class="grid_7 round_Box_Container">
                        <c:if test="${!empty friendInvites}">
                             <div class="grid_6" id="friendRequests">
                                 <p>These people want to be your friend.</p>
                                <ul id="friendRequestList">
                                    <c:forEach var="user" items="${friendInvites}">
                                        <li id="friendInvite_${user.id}">
                                        <a href="${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a>
                                        <button onClick="acceptFriendInvite(${user.id})">I'll allow it</button>
                                        <button onClick="rejectFriendInvite(${user.id})">Not Interested</button></li>
                                    </c:forEach>
                                 </ul>
                            </div>
                        </c:if>
                        <c:if test="${!empty teamInvites}">
                            <div class="grid_7" id="teamRequests">
                                 <p>You have been invited to the following teams.</p>
                                <ul id="teamRequestList">
                                    <c:forEach var="team" items="${teamInvites}">
                                        <li id="teamInvite_${team.id}">
                                        <a href="../team/${team.id}"><c:out value="${team.name}"/></a>
                                        <button onClick="acceptTeamInvite(${team.id})">I'll allow it</button>
                                         <button onClick="rejectTeamInvite(${team.id})">Not Interested</button></li>
                                    </c:forEach>
                                 </ul>
                            </div>
                        </c:if>
                     </div>
                 </c:if>
              </div>
          </c:if>
          <div class="clear">&nbsp;</div>
            <div class="grid_7 activityBoxContainer">
            <div class="grid_6">
                <div class="shadowText">Recent Activity</div>
                <ul id="activity">
                    <c:forEach var="visit" items="${activity}">
                        <li>@ <a href="../location/${visit.location.id}"><c:out value="${visit.location.name}"/></a>
                        (<fmt:formatDate pattern="MMM dd, yyyy @ hh:mma" value="${visit.date}"/>)</li>
                    </c:forEach>
                </ul>
            </div>
          </div>
      </div>
        <div class="grid_3 prefix_1">
        <div class="grid_3 round_Box_Container">
        <div class="grid_2">
             <div class="shadowText">Friends: </div>
        </div>
        <div class="grid_3">
            <ul id="friends">
                <c:forEach var="user" items="${userCommand.friends}">
                    <li><a href="${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a></li>
                </c:forEach>
            </ul>
        </div>
      </div>
      <div class="grid_3 round_Box_Container">
        <div class="grid_2">
            <div class="shadowText">Teams: </div>
        </div>
        <div class="grid_3">
          <ul id="teams">
              <c:forEach var="team" items="${userCommand.teams}">
                  <li><a href="../team/${team.id}"><c:out value="${team.name}"/></a></li>
              </c:forEach>
          </ul>
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
    <input type="button" value="Sweet! GO ME!" onclick="disablePopup()"/>
</div>
<div id="popupBackground"></div>

<!--  for www.playserengeti.com/ -->
<script src="http://www.google.com/jsapi" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/popup.js" type="text/javascript"></script>

<script type="text/javascript">
    google.load('search', '1');

    var lSearch;
    var userLoc;

    $(function() {
        lSearch = new google.search.LocalSearch();
        lSearch.setSearchCompleteCallback(this, searchComplete);
        lSearch.setAddressLookupMode(google.search.LocalSearch.ADDRESS_LOOKUP_DISABLED);
        userLoc = google.loader.ClientLocation;

        getNearbyLocations();
        $("#locSearch").hide();
        $("#thanks").hide();
    });

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
</script>
<c:if test="${session.loggedIn}">
<script type="text/javascript">
    var checkIn = function() {
        var request = $.get("checkIn", {userId : ${session.user.id}, teamId : $("select#teamSelect").val(),
            locationId : $("select#locSelect").val()}, function(data) {
                var jsonData = JSON.parse(request.responseText);
                if (jsonData.overtaken == "true") {
                    showPopup();
                }
                $("#thanks").append("Your current location: "  + jsonData.visit.location.name);
            });
        $("#checkIn").fadeOut("slow");
        $("#thanks").fadeIn("slow");
    ;}
</script>
<script type="text/javascript">
var sendFriendInvite = function() {
    $.get("sendFriendInvite", {firstId : uData.sessionId, secondId : ${userCommand.userId}});
    $("#inviteFriend").fadeOut("slow");
};

var acceptFriendInvite = function(userId) {
    var request = $.get("acceptFriendInvite", {firstId : userId, secondId : ${session.user.id}},
        function(data) {
            var jsonData = JSON.parse(request.responseText);
            $("#friends").append("<li><a href=" + jsonData.id + ">" + jsonData.name + "</a></li>");
        });
    $("#friendInvite_" + userId).fadeOut("slow");
};

var rejectFriendInvite = function(userId) {
    $.get("rejectFriendInvite", {firstId : userId, secondId : ${session.user.id}});
    $("#friendInvite_" + userId).fadeOut("slow");
};

var sendTeamInvite = function() {
    $.get("sendTeamInvite", {teamId : $("select#teamInviteSelect").val(), userId : ${userCommand.userId}});
    $("#inviteTeam").fadeOut("slow");
};

var acceptTeamInvite = function(teamId) {
    var request = $.get("acceptTeamInvite", {teamId : teamId, userId : ${session.user.id}},
        function(data){
            var jsonData = JSON.parse(request.responseText);
            $("#teams").append("<li><a href=../team/" + jsonData.id + ">" + jsonData.name + "</a></li>");
            $("#teamSelect").append("<option value=" + jsonData.id + ">" + jsonData.name + "</option>");
        });
    $("#teamInvite_" + teamId).fadeOut("slow");
};

var rejectTeamInvite = function(teamId) {
    $.get("rejectTeamInvite", {teamId : teamId, userId : ${session.user.id}});
    $("#teamInvite_" + teamId).fadeOut("slow");
};
</script>
</c:if>