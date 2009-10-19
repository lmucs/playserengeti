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
	    <select name="leaderId">
	    </select>
    </div>

    <div>
        <div class="formLabel">
            <label for="image">Team Image URL:</label>
        </div>
        <div class="spaceInputBox">
            <input type="text" name="image"/>
        </div
    </div>
    
    <div>
        <div class="formLabel">
            <label for="description">Team Description:</label>
        </div>
        <div class="spaceInputBox">
            <input type="textarea" path="teamCommand.description" rows="3" cols="20"/>
        </div
    </div>
    
    <div>
        <div class="formLabel">
            <label for="homeBase">Home Base:</label>
        </div>
        <div class="spaceInputBox">
            <input type="text" name="homeBase"/>
        </div
    </div>
    <div>
        <div class="formLabel">
            <label for="removals">Remove selected users:</label>
        </div>
		<form:checkboxes path="teamCommand.removals" items="${teamCommand.candidates}"/><br/>
    </div>
    
    <div class="formRow">
        <input type="submit" value="Update Team!"/>
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

