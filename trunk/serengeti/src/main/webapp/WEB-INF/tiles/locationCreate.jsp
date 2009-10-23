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
        <div>
            <div class="formLabel">
                <label for="street">Street</label>
            </div>
            <div class="spaceInputBox">
                <input type="text" name="street" />
            </div>
        </div>
        <div>
            <div class="formLabel">
                <label for="city">City</label>
            </div>
            <div class="spaceInputBox">
                <input type="text" name="city" />
            </div>
        </div>
        <div>
            <div class="formLabel">
                <label for="state">State</label>
            </div>
            <div class="spaceInputBox">
                <input type="text" name="state" />
            </div>
        </div>
        <div>
            <div class="formLabel">
                <label for="zipcode">Zipcode</label>
            </div>
            <div class="spaceInputBox">
                <input type="text" name="zipcode" />
            </div>
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
    
    
    <div class="formRow">
        <input type="submit" value="Create Location!" />
    </div>

</form>

<script>
    var validateCreateForm = function () {
        var name = document.getElementById("locationName");
        if (name && name.value !== '') {
            return true;
        }
        alert("The name cannot be blank");
        return false;
    }
</script>
