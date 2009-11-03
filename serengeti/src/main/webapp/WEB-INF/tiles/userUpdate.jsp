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
            <label for="displayName">Display Name: </label>
        </div>
        <div class="spaceInputBox">
            <form:input path="userCommand.displayName" />
        </div>
    </div>
    <div>    
        <div class="formLabel">
            <label for="image">Profile Picture: </label>
        </div>
        <div class="spaceInputBox">
            <form:input path="userCommand.image" />
        </div>
    </div>
    
    <p> Currently, when the "Remove" button is pressed, the friend/team remains in the list.</p>
    <p> However, it actually has been removed.</p> 
    <div>
        <label for="friendRemovals">Friends: </label>
        <ul>
            <c:forEach var="user" items="${userCommand.friends}">
                <li><c:out value="${user.value}"/><input type="button" value="Remove" onClick="removeFriend(${user.key})" /></li>
            </c:forEach>
        </ul>	
    </div>
    <div>
        <label for="teamRemovals">Teams: </label>
        <ul>
            <c:forEach var="team" items="${userCommand.teams}">
                <li><c:out value="${team.value}"/><input type="button" value="Remove" onClick="removeTeam(${team.key})" /></li>
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
    
    var removeFriend = function (sUserId) {
        $.get("removeFriend", {pUserId : ${userCommand.userId}, sUserId : sUserId});
    }
    
    var removeTeam = function (teamId) {
        $.get("removeTeam", {userId : ${userCommand.userId}, teamId : teamId});
    }
    
</script>

