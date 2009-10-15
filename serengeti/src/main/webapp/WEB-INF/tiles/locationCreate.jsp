<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <p>You can create a location.</p>

    <p>
        <form method="post" action="create">
            <div>
	            <div class="formLabel">
	        	    <label for="name">Location Name:</label>
	        	</div>
	        	<div class="spaceInputBox">
        	    	<input type="text" name="locationName"/>
        	    </div>
        	</div>
	        <div>
	        	<div class="formLabel">
	        	    <label for="latitude">Latitude:</label>
	        	</div>
	        	<div class="spaceInputBox">
        	    	<input type="text" name="latitude"/>
        	    </div>
        	</div>
        	<div>
	        	<div class="formLabel">
	        	    <label for="latitude">Longitude:</label>
	        	</div>
	        	<div class="spaceInputBox">
	        	   	<input type="text" name="longitude"/>
	        	</div>
	        </div>
	        <div>
	        	<div class="formLabel">
	        	    <label for="teamOwner">Team Owner:</label> 
	        	</div>
	        	<div class="spaceInputBox">
	        	    <input type="text" name="teamOwner"/>
	        	</div>
	        </div>
        	<input type="submit" value="Create Location!"/>
        </form>
    </p>
