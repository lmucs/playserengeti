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
    <div>
        <div class="formLabel">
            <label for="friendRemovals">Remove selected friends: </label>
        </div>
		<form:checkboxes path="userCommand.friendRemovals" items="${userCommand.friends}" /><br/>
    </div>
    <div>
        <div class="formLabel">
            <label for="teamRemovals">Remove selected teams: </label>
        </div>
		<form:checkboxes path="userCommand.teamRemovals" items="${userCommand.teams}" /><br/>
    </div>
    
    <div class="formRow">
        <input type="submit" value="Update Profile!" />
    </div>

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
</script>

