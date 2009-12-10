<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <p>Create your own team and start marking your territory.
       Just fill in the information below.</p>

    <form id="teamCreateForm" method="post" action="create"
        onsubmit="return validateCreateForm();">   
	    <div class="round_Box_Container grid_8">
		    <div class="grid_2">
		        <label for="name">Team Name: </label>
		    </div>
		    <div class="grid_2">
		        <input type="text" id="name" name="name" />
		    </div>
		    
		    <div class="clear">&nbsp;</div>
	        
	        <div class="grid_2">
	            <label for="color">Preferred Color: </label>
	        </div>
	        <div class="grid_1"
		        <select name="color">
		            <option value="Red">Red</option>
		            <option value="Green">Green</option>
		            <option value="Blue">Blue</option>
		            <option value="Yellow">Yellow</option>
		            <option value="Magenta">Magenta</option>
		            <option value="Cyan">Cyan</option>
		        </select>
	        </div>
	        
	        <div class="clear">&nbsp;</div>
	        
	
		    <div class="grid_2">
		        <label for="image">Team Profile Picture: </label>
		    </div>
		    <div class="grid_2">
		        <input type="file" path="image" />
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
		        <input type="text" name="homeBase" />
		    </div>
		    
		    <div class="clear">&nbsp;</div>
		    	
		    <div class="grid_2">
		        <label for="invitees">Invite people to team:</label>
		    </div>
		    <div class="grid_5">
				<form:checkboxes path="teamCommand.invitees" items="${teamCommand.candidates}" itemValue="id" itemLabel="fullName"/><br/>
		    </div>
		    
		    <div class="clear">&nbsp;</div>
		    
		    <div class="grid_1">
		        <input type="submit" value="Create Team!" />
		    </div>
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
