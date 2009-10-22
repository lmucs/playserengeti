<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form id="teamUpdateForm" method="post" action="update"
        onsubmit="return validateUpdateForm();">
        <div>    
            <div class="formLabel">
                <label for="name">Team Name: </label>
            </div>
            <div class="spaceInputBox">
                <form:input path="teamCommand.name" />
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

    <div>
        <div class="formLabel">
            <label for="userId">Team Leader: </label>
        </div>
        <div class="spaceInputBox">
            <form:select path="teamCommand.leaderId">
        	    <form:options items="${teamCommand.candidates}" />
    	    </form:select>
    	</div> 
    </div>

    <div>
        <div class="formLabel">
            <label for="image">Team Image URL: </label>
        </div>
        <div class="spaceInputBox">
            <form:input path="teamCommand.image" />
        </div>
    </div>
    
    <div>
        <div class="formLabel">
            <label for="description">Team Description:</label>
        </div>
        <div class="spaceInputBox">
            <form:textarea path="teamCommand.description" rows="4" cols="40" />
        </div>
    </div>
    
    <div>
        <div class="formLabel">
            <label for="homeBase">Home Base:</label>
        </div>
        <div class="spaceInputBox">
            <form:input path="teamCommand.homeBase" />
        </div>
    </div>
    <div>
        <div class="formLabel">
            <label for="removals">Remove selected users:</label>
        </div>
		<form:checkboxes path="teamCommand.removals" items="${teamCommand.candidates}" /><br/>
    </div>
    
    <div class="formRow">
        <input type="submit" value="Update Team!" />
    </div>

</form>

<script>
    var validateUpdateForm = function () {
        var name = document.getElementById("name");
        if (name && name.value !== '') {
            return true;
        }
        alert("The name cannot be blank");
        return false;
    }
</script>

