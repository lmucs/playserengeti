<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <form id="teamCreateForm" method="post" action="create"
        onsubmit="return validateCreateForm();">
        <div>    
            <div class="formLabel">
                <label for="name">Change Team Name: </label>
            </div>
            <div class="spaceInputBox">
                <input type="text" id="name" name="name"/>
            </div>
        </div>
        <div>
            <div class="formLabel">
                <label for="color"> Change Preferred Color: </label>
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
        <div>
        <div class="formLabel">
            <label for="userId">Change Team Leader: </label>
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
            <label for="userId">Remove friends: </label>
        </div>
        <div>
	   
	            <c:forEach var="user" items="${createTeam.allUsers}">
	                <input type="checkbox" name="${user.userId}" value="${user.userName}" checked="checked"/>${user.userName}<BR>
	            </c:forEach>
	       
	    </div>
    </div>
    <div>
        <div class="formLabel">
            <label for="image">Change Team Image URL:</label>
        </div>
        <div class="spaceInputBox">
            <input type="text" name="image"/>
        </div
    </div>
    <div>    
	    <div class="formLabel">
	        <label for="name">Change Home Base: </label>
	    </div>
	    <div class="spaceInputBox">
	        <input type="text" id="name" name="name"/>
	    </div>
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
