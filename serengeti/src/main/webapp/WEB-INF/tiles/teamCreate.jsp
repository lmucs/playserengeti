<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <p>Create your own team and start marking your territory.
       Just fill in the information below.</p>

    <form id="teamCreateForm" method="post" action="create"
        onsubmit="return validateCreateForm();">
        <div class="formRow">
          <label for="name">Team Name: </label><input type="text" id="name" name="name"/><br/>
        </div>


        <div class="formRow">
            <label for="color">Preferred Color: </label>
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

    <div class="formRow">
        <label for="userId">Team Leader: </label>
        <select name="userId">
            <c:forEach var="user" items="${createTeam.allUsers}">
                <option value="${user.userId}"><c:out value="${user.userName}"/></option>
            </c:forEach>
        </select>
    </div>

    <div class="formRow">
        <label for="image">Team Image URL: </label><input type="text" name="image"/><br/>
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
