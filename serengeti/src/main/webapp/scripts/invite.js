function sendFriendInvite(targetId, sourceId) {
    $.get("sendFriendInvite", {firstId : sourceId, secondId : targetId});
    $("#inviteFriend").fadeOut("slow");
}
 
function acceptFriendInvite(userId, sessionId) {
    var request = $.get("acceptFriendInvite", {firstId : userId, secondId : sessionId},
        function(data) {
            var jsonData = JSON.parse(request.responseText);
            $("#friends").append("<li><a href=" + jsonData.id + ">" + jsonData.name + "</a></li>");
        });
    $("#friendInvite_" + userId).fadeOut("slow");
}
    
function rejectFriendInvite(userId, sessionId) {
    $.get("rejectFriendInvite", {firstId : userId, secondId : sessionId});
    $("#friendInvite_" + userId).fadeOut("slow");
}
    
function sendTeamInvite(targetId) {
    $.get("sendTeamInvite", {teamId : $("select#teamInviteSelect").val(), userId : targetId});
    $("#inviteTeam").fadeOut("slow");
}
    
function acceptTeamInvite(teamId, sessionId) {
    var request = $.get("acceptTeamInvite", {teamId : teamId, userId : sessionId}, 
        function(data){
            var jsonData = JSON.parse(request.responseText);
            $("#teams").append("<li><a href=../team/" + jsonData.id + ">" + jsonData.name + "</a></li>");
            $("#teamSelect").append("<option value=" + jsonData.id + ">" + jsonData.name + "</option>");
        });
    $("#teamInvite_" + teamId).fadeOut("slow");
}
 
function rejectTeamInvite(teamId, sessionId) {
    $.get("rejectTeamInvite", {teamId : teamId, userId : sessionId});
    $("#teamInvite_" + teamId).fadeOut("slow");
}