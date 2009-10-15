<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <p>Create your own team and start marking your territory.
       Just fill in the information below.</p>

    <form id="teamCreateForm" method="post" action="create"
        onsubmit="return validateCreateForm();">
        <div>    
            <div class="formLabel">
                <label for="name">Team Name: </label>
            </div>
            <div class="spaceInputBox">
                <input type="text" id="name" name="name"/>
            </div>
        </div>
        <div>
            <div class="formLabel">
                <label for="color">Preferred Color: </label>
            </div>
            <select name="color">
                <option value="Red">Red</option>
                <option value="Green">Green</option>
                <option value="Blue">Blue</option>
                <option value="Yellow">Yellow</option>
                <option value="Magenta">Magenta</option>
                <option value="Cyan">Cyan</option>
            </select>
        </div>

        <p> This will not be necessary when user sign in is implemented.</p>

    <div>
        <div class="formLabel">
            <label for="userId">Team Leader: </label>
        </div>
        <div class="spaceInputBox">
	        <select name="userId">
	            <c:forEach var="user" items="${createTeam.allUsers}">
	                <option value="${user.userId}"><c:out value="${user.userName}"/></option>
	            </c:forEach>
	        </select>
	    </div>
    </div>

    <div>
        <div class="formLabel">
            <label for="image">Team Image URL:</label>
        </div>
        <div class="spaceInputBox">
            <input type="text" name="image"/>
        </div
    </div>

    <div class="formRow">
        <input type="submit" value="Create Team!"/>
    </div>

</form>

<script>
    var validateCreateForm = function () {
        var name = document.getElementById("name");
        if (name && name.value !== '') {
            return true;
        }
        alert("The name cannot be blank");
        return false;
    }
</script>
