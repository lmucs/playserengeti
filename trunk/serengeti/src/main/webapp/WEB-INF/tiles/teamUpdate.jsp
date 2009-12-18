<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
<c:when test="${!empty teamCommand.teamId}">
<form id="teamUpdateForm" method="post" action="${pageContext.request.contextPath}/team/update"
        onsubmit="return validateUpdateForm();">
   
    <div class="grid_2">
        <label for="name">Team Name: </label>
    </div>
    <div class="grid_2">
        <form:input path="teamCommand.name" />
        <form:errors path="teamCommand.name"/>
    </div>

	<div class="clear">&nbsp;</div>

    <div class="grid_2">
        <label for="color">Preferred Color: </label>
    </div>
    <div class="grid_2">
        <select name="color">
            <option value="FF0000">Red</option>
            <option value="00FF00">Green</option>
            <option value="0000FF">Blue</option>
            <option value="FFFF00">Yellow</option>
            <option value="FF00FF">Magenta</option>
            <option value="00FFFF">Cyan</option>
        </select>
    </div>

    <c:if test="${!empty teamCommand.members}">
        <div class="grid_2">
            <label for="leader">Team Leader: </label>
        </div>
        <div class="grid_2">
            <form:select path="teamCommand.leader.id">
                <option value="${teamCommand.leader.id}">${teamCommand.leader.fullName}</option>
    	        <form:options items="${teamCommand.members}" itemValue="id" itemLabel="fullName" />
    	    </form:select>
	        <form:errors path="teamCommand.leader"/>
	    </div> 
    </c:if>
    
    <div class="clear">&nbsp;</div>

    <div class="grid_2">
        <label for="image">Team Profile Picture:</label>
    </div>
    <div class="grid_2">
        <input type="file" path="teamCommand.image" />
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
    
    <c:if test="${!empty teamCommand.members}">
        <div class="clear">&nbsp;</div>

        <div class="grid_2">
            <label for="removals">Remove selected users:</label>
        </div>
        <div class="grid_5">
            <c:forEach var="user" items="${teamCommand.members}">
	            <li id="user_${user.id}"><c:out value="${user.firstName} ${user.lastName}"/><input type="button" value="Remove" onClick="removeMember(${user.id}, ${teamCommand.teamId}, 'user_${user.id}')" /></li>
    	    </c:forEach>    
	    </div>
    </c:if>
    
    <div class="clear">&nbsp;</div>
    
    <div class="grid_1">
        <input type="submit" value="Update Team!" />
    </div>

</form>
</c:when>
<c:otherwise>
    <p>You don't have permission to edit this team.</p>
</c:otherwise>
</c:choose>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/remove.js"></script>
<script>
    var validateUpdateForm = function () {
        var name = document.getElementById("name");
        if (!name || name.value === '') {
            alert("The name cannot be blank");
            return false;
        }
        return true;
    }
</script>

