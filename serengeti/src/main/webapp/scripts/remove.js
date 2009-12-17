function removeFriend(sessionId, userId, elementId) {
        var answer = confirm("Are you sure you want to remove this friend?  This will take effect immediately.");
        if (answer) { 
            $.get("../removeFriend", {firstId : sessionId, secondId : userId});
            $("#" + elementId).fadeOut("slow");
        }
        else {}
}
    
function removeTeam(sessionId, teamId, elementId) {
        var answer = confirm("Are you sure you want to remove this team?  This will take effect immediately.");
        if (answer) {
            var request = $.get("../removeTeam", {userId : sessionId, teamId : teamId}, function(data) {
                if (request.responseText) {
                    $("#" + elementId).replaceWith("<p>You can't leave that team until you appoint another leader.</p>");
                }       
                else {       
                    $("#" + elementId).fadeOut("slow");
                }
            });
        }
        else {}
}

function removeMember(userId, teamId, elementId) {
        var answer = confirm("Are you sure you want to remove this member?  This will take effect immediately.");
        if (answer) {
            $.get("../../team/removeMember", {userId : userId, teamId : teamId});
            $("#" + elementId).fadeOut("slow");
        }
        else {}
}