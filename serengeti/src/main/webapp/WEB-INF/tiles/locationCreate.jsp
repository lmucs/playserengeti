<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <p>Add a new location to Serengeti.</p>

    <form id="locationCreateForm" method="post" action="create"
        onsubmit="return validateCreateForm();">  
            <div class="grid_2">
                <label for="locationName">Location Name: </label>
            </div>
            <div class="grid_2">
                <input type="text" id="locationName" name="locationName" />
            </div>

			<div class="clear">&nbsp;</div>

            <div class="grid_2">
               <label for="phoneNumber">Phone Number</label>
            </div>
            <div class="grid_2">
                <input type="text" name="phoneNumber" />
            </div>
			
			<div class="clear">&nbsp;</div>
			
            <div class="grid_2">
                <label for="street">Street</label>
            </div>
            <div class="grid_2">
                <input id="street" type="text" name="street" />
            </div>

			<div class="clear">&nbsp;</div>

            <div class="grid_2">
                <label for="city">City</label>
            </div>
            <div class="grid_2">
                <input id="city" type="text" name="city" />
            </div>

			<div class="clear">&nbsp;</div>

            <div class="grid_2">
                <label for="state">State</label>
            </div>
            <div class="grid_2">
                <input id="state" type="text" name="state" />
            </div>

			<div class="clear">&nbsp;</div>

            <div class="grid_2">
                <label for="zipcode">Zipcode</label>
            </div>
            <div class="grid_2">
                <input id="zipcode" type="text" name="zipcode" />
            </div>

			<div class="clear">&nbsp;</div>
    

            <div class="grid_2">
                <label for="description">Description:</label>
            </div>
            <div class="grid_2">
                <form:textarea path="locationCommand.description" rows="4" cols="40" />
            </div>

       		<div class="clear">&nbsp;</div>

            <div class="grid_2">
                <label for="image">Image</label>
            </div>
            <div class="grid_2">
                <input type="text" name="image" />
            </div>
            
            <div class="clear">&nbsp;</div>
        </div>
    <div class=grid_2>
    <input id="latitude" type="text" name="latitude" />
    <input id="longitude" type="text" name="longitude" />
    <input id="candidates" type="hidden" name="candidates" />
    </div>
    
    <div class="clear">&nbsp;</div>
    
    <div class="grid_1">
        <input type="submit" value="Create Location!""/>
    </div>
    
    <div class="clear">&nbsp;</div>
    
    <div class="grid_1">
    <input type="button" value="Encode" onclick="codeAddress()">
	</div>
</form>

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
    
    var validateCreateForm = function () {
        
        var name = document.getElementById("locationName");
        var street = document.getElementById("street");
        if (name && name.value !== '') {
            return true;
        }
        else {
            alert("The name cannot be blank");
        }
        return false;
    }
    
    var codeAddress = function () {
        var geocoder = new google.maps.Geocoder();
        var address = document.getElementById("street").value + " " + document.getElementById("city").value + 
            " " + document.getElementById("state").value + " " + document.getElementById("zipcode").value + " USA";
        if (geocoder) {
            geocoder.geocode( { 'address': address}, function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    document.getElementById("candidates").value = results;
                    document.getElementById("latitude").value = results[0].geometry.location.lat();
                    document.getElementById("longitude").value = results[0].geometry.location.lng();
                    
                } else {
                    alert("Geocode was not successful for the following reason: " + status);
                }
            });
        }
    }
    
</script>
