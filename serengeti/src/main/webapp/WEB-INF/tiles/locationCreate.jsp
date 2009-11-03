<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <p>Add a new location to Serengeti.</p>

    <form id="locationCreateForm" method="post" action="create"
        onsubmit="return validateCreateForm();">
        <div>    
            <div class="formLabel">
                <label for="locationName">Location Name: </label>
            </div>
            <div class="spaceInputBox">
                <input type="text" id="locationName" name="locationName" />
            </div>
        </div>
        <div>
            <div class="formLabel">
               <label for="phoneNumber">Phone Number</label>
            </div>
            <div class="spaceInputBox">
                <input type="text" name="phoneNumber" />
            </div>
        </div>
        
    <div id="locationEntry">
        <div>
            <div class="formLabel">
                <label for="street">Street</label>
            </div>
            <div class="spaceInputBox">
                <input id="street" type="text" name="street" />
            </div>
        </div>
        <div>
            <div class="formLabel">
                <label for="city">City</label>
            </div>
            <div class="spaceInputBox">
                <input id="city" type="text" name="city" />
            </div>
        </div>
        <div>
            <div class="formLabel">
                <label for="state">State</label>
            </div>
            <div class="spaceInputBox">
                <input id="state" type="text" name="state" />
            </div>
        </div>
        <div>
            <div class="formLabel">
                <label for="zipcode">Zipcode</label>
            </div>
            <div class="spaceInputBox">
                <input id="zipcode" type="text" name="zipcode" />
            </div>
        </div>
    </div>
    
    <div id="locationSelect">

    </div>
    
       <div>
            <div class="formLabel">
                <label for="description">Description:</label>
            </div>
            <div class="spaceInputBox">
                <form:textarea path="locationCommand.description" rows="4" cols="40" />
            </div>
       </div>
       <div>
            <div class="formLabel">
                <label for="image">Image</label>
            </div>
            <div class="spaceInputBox">
                <input type="text" name="image" />
            </div>
        </div>
    
    <input id="latitude" type="text" name="latitude" />
    <input id="longitude" type="text" name="longitude" />
    <input id="candidates" type="hidden" name="candidates" />
        
    <div class="formRow">
        <input type="submit" value="Create Location!""/>
    </div>
    
    <input type="button" value="Encode" onclick="codeAddress()">

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
