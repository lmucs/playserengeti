<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
<c:when test="${!empty locationCommand.sessionId}"> 
    <p>Add a new location to Serengeti.</p>

    <form id="locationCreateForm" method="post" action="create"
        onsubmit="return validateCreateForm();"> 
            <div class="round_Box_Container grid_8"> 
	            <div class="grid_2">
	                <label for="name">Location Name: </label>
	            </div>
	            <div class="grid_2">
	                <input type="text" id="name" name="name" />
	                <form:errors path="name"/>
	            </div>
	
				<div class="clear">&nbsp;</div>
	
	            <div class="grid_2">
	               <label for="phoneNumber">Phone Number</label>
	            </div>
	            <div class="grid_2">
	                <input type="text" name="phoneNumber" />
	                <form:errors path="phoneNumber"/>
	            </div>
				
				<div class="clear">&nbsp;</div>
				
	            <div class="grid_2">
	                <label for="street">Street</label>
	            </div>
	            <div class="grid_2">
	                <input id="street" type="text" name="street" />
	                <form:errors path="street"/>
	            </div>
	
				<div class="clear">&nbsp;</div>
	
	            <div class="grid_2">
	                <label for="city">City</label>
	            </div>
	            <div class="grid_2">
	                <input id="city" type="text" name="city" />
	                <form:errors path="city"/>
	            </div>
	
				<div class="clear">&nbsp;</div>
	
	            <div class="grid_2">
	                <label for="state">State</label>
	            </div>
	            <div class="grid_2">
	                <input id="state" type="text" name="state" />
	                <form:errors path="state"/>
	            </div>
	
				<div class="clear">&nbsp;</div>
	
	            <div class="grid_2">
	                <label for="zipcode">Zipcode</label>
	            </div>
	            <div class="grid_2">
	                <input id="zipcode" type="text" name="zipcode" />
	                <form:errors path="zipcode"/>
	            </div>
	            	        
			    <div class="grid_2">
			    	<input id="latitude" type="hidden" name="latitude" />
			    </div>
			    
			    <div class="grid_2">
			    	<input id="longitude" type="hidden" name="longitude" />
			    </div>
			    
			    <div class="grid_1">
			        <input type="button" value="Create Location!" onclick="codeAddress()" />
			    </div>
		</div>
	</div>
</form>
</c:when>
<c:otherwise>
    <p>You must be logged in to create a location.</p>
</c:otherwise>
</c:choose>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
    
    var validateCreateForm = function () {
        var name = document.getElementById("name");
        var latitude = document.getElementById("latitude");
        var longitude = document.getElementById("longitude");
        var street = document.getElementById("street");
        var city = document.getElementById("city");
        var state = document.getElementById("state");
        
        if (!name || name.value === '') {
            alert("The name cannot be blank");
            return false;
        }
        if (!street || street.value === '') {
            alert("The street cannot be blank");
            return false;
        }
        if (!city || city.value === '') {
            alert("The city cannot be blank");
            return false;
        }
        if (!state || state.value === '') {
            alert("The state cannot be blank");
            return false;
        }
        if (!latitude || latitude.value === '' || 
          !longitude || longitude.value === '') {
            alert("We couldn't find that address.  Make sure everything is entered correctly and try again");
            return false;
        }
        document.forms["locationCreateForm"].submit();
        return true; 
    }
    
    var codeAddress = function () {
        var geocoder = new google.maps.Geocoder();
        var address = document.getElementById("street").value + " " + document.getElementById("city").value + 
            " " + document.getElementById("state").value + " " + document.getElementById("zipcode").value + " USA";
        if (geocoder) {
            geocoder.geocode( { 'address': address}, function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    document.getElementById("latitude").value = results[0].geometry.location.lat();
                    document.getElementById("longitude").value = results[0].geometry.location.lng();
                    validateCreateForm();
                } else {
                    alert("We couldn't find that location.  Make sure everything is entered correctly and try again.");
                }
            });
        }
    }
    
</script>
