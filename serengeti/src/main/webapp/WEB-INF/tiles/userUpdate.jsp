<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form id="teamUpdateForm" method="post" action="update"
        onsubmit="return validateUpdateForm();">

    <div>    
        <div class="formLabel">
            <label for="password">Password: </label>
        </div>
        <div class="spaceInputBox">
            <form:input path="userCommand.password" />
        </div>
    </div>
    
    <div>    
        <div class="formLabel">
            <label for="firstName">First Name: </label>
        </div>
        <div class="spaceInputBox">
            <form:input path="userCommand.firstName" />
        </div>
    </div>
    
    <div>    
        <div class="formLabel">
            <label for="lastName">Last Name: </label>
        </div>
        <div class="spaceInputBox">
            <form:input path="userCommand.lastName" />
        </div>
    </div>

    <div>
        <label for="friendRemovals">Friends: </label>
        <ul>
            <c:forEach var="user" items="${userCommand.friends}">
                <li id="user_${user.key}"><c:out value="${user.value}"/><input type="button" value="Remove" onClick="removeFriend(${user.key}, 'user_${user.key}')" /></li>
            </c:forEach>
        </ul>	
    </div>
    <div>
        <label for="teamRemovals">Teams: </label>
        <ul>
            <c:forEach var="team" items="${userCommand.teams}">
                <li id="team_${team.key}"><c:out value="${team.value}"/><input type="button" value="Remove" onClick="removeTeam(${team.key}, 'team_${team.key}')" /></li>
            </c:forEach>
        </ul>	
    </div>
        
    <div class="formRow">
        <input type="submit" value="Save Changes" />
    </div>

    <a href="delete?userId=${userCommand.userId}">Delete Profile</a>
    
</form>


<script>
    
    var validateUpdateForm = function () {
        var name = document.getElementById("password");
        if (name && name.value !== '') {
            return true;
        }
        alert("The password cannot be blank");
        return false;
    }
    
    var removeFriend = function (sUserId, elementId) {
        $.get("removeFriend", {pUserId : ${userCommand.userId}, sUserId : sUserId});
        $("#" + elementId).fadeOut("slow");
    }
    
    var removeTeam = function (teamId, elementId) {
        $.get("removeTeam", {userId : ${userCommand.userId}, teamId : teamId});
        $("#" + elementId).fadeOut("slow");
    }
    
</script>

