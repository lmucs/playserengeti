function sendFriendInvite() {
    $.get("sendFriendInvite", {firstId : uData.sessionId, secondId : ${userCommand.userId}});
    $("#inviteFriend").fadeOut("slow");
}
 
function acceptFriendInvite(userId) {
    var request = $.get("acceptFriendInvite", {firstId : userId, secondId : ${session.user.id}},
        function(data) {
            var jsonData = JSON.parse(request.responseText);
            $("#friends").append("<li><a href=" + jsonData.id + ">" + jsonData.name + "</a></li>");
        });
    $("#friendInvite_" + userId).fadeOut("slow");
}
    
function rejectFriendInvite(userId) {
    $.get("rejectFriendInvite", {firstId : userId, secondId : ${session.user.id}});
    $("#friendInvite_" + userId).fadeOut("slow");
}
    
function sendTeamInvite() {
    $.get("sendTeamInvite", {teamId : $("select#teamInviteSelect").val(), userId : ${userCommand.userId}});
    $("#inviteTeam").fadeOut("slow");
}
    
function acceptTeamInvite(teamId) {
    var request = $.get("acceptTeamInvite", {teamId : teamId, userId : ${session.user.id}}, 
        function(data){
            var jsonData = JSON.parse(request.responseText);
            $("#teams").append("<li><a href=../team/" + jsonData.id + ">" + jsonData.name + "</a></li>");
            $("#teamSelect").append("<option value=" + jsonData.id + ">" + jsonData.name + "</option>");
        });
    $("#teamInvite_" + teamId).fadeOut("slow");
}
 
function rejectTeamInvite(teamId) {
    $.get("rejectTeamInvite", {teamId : teamId, userId : ${session.user.id}});
    $("#teamInvite_" + teamId).fadeOut("slow");
}