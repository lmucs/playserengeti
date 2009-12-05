<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form id="teamUpdateForm" method="post" action="${pageContext.request.contextPath}/team/update"
        onsubmit="return validateUpdateForm();">
   
    <div class="grid_2">
        <label for="name">Team Name: </label>
    </div>
    <div class="grid_2">
        <form:input path="teamCommand.name" />
    </div>

	<div class="clear">&nbsp;</div>

    <div class="grid_2">
        <label for="color">Preferred Color: </label>
    </div>
    <div class="grid_2">
        <select name="color">
            <option value="Red">Red</option>
            <option value="Green">Green</option>
            <option value="Blue">Blue</option>
            <option value="Yellow">Yellow</option>
            <option value="Magenta">Magenta</option>
            <option value="Cyan">Cyan</option>
        </select>
    </div>

    <div class="grid_2">
        <label for="userId">Team Leader: </label>
    </div>
    <div class="grid_2">
        <form:select path="teamCommand.leader.id">
    	    <form:options items="${teamCommand.candidates}" itemValue="id" itemLabel="fullName" />
	    </form:select>
	</div> 

    <div class="clear">&nbsp;</div>

    <div class="grid_2">
        <label for="description">Team Description:</label>
    </div>
    <div class="grid_2">
        <form:textarea path="teamCommand.description" rows="4" cols="40" />
    </div>

    <div class="clear">&nbsp;</div>
    
    <div class="grid_2">
        <label for="homeBase">Home Base:</label>
    </div>
    <div class="grid_2">
        <form:input path="teamCommand.homeBase" />
    </div>
    
    <div class="clear">&nbsp;</div>

    <div class="grid_2">
        <label for="removals">Remove selected users:</label>
    </div>
    <div class="grid_5">
	    <form:checkboxes path="teamCommand.removals" items="${teamCommand.candidates}" itemValue="id" itemLabel="fullName"/><br/>
    </div>
    
    <div class="clear">&nbsp;</div>
    
    <div class="grid_1">
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

