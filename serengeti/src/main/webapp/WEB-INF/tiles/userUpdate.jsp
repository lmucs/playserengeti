<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
<c:when test="${!empty userCommand.userId}">
<form id="teamUpdateForm" method="POST" action="${pageContext.request.contextPath}/user/update"
        enctype="multipart/form-data" onsubmit="return validateUpdateForm();">
    <div class="round_Box_Container grid_8">
        
        <div class="grid_2">
            <label for="password">Password: </label>
        </div>
        
        <div class="grid_3">
            <form:password path="userCommand.password" />
            <form:errors path="password" />
        </div>
        
        <div class="clear"&nbsp;</div>
        
        <div class="grid_2">
            <label for="confirm">Confirm Password: </label>
        </div>
        
        <div class="grid_3">
            <input type="password" id="confirm"/>
        </div>
   
   		<div class="clear"&nbsp;</div>
   	
        <div class="grid_2">
            <label for="firstName">First Name: </label>
        </div>
        <div class="grid_3">
            <form:input path="userCommand.firstName" />
            <form:errors path="firstName"/>
        </div>
        
        <div class="clear"&nbsp;</div>
     
        <div class="grid_2">
            <label for="lastName">Last Name: </label>
        </div>
        <div class="grid_3">
            <form:input path="userCommand.lastName" />
            <form:errors path="lastName"/>
        </div>
        
        <div class="clear"&nbsp;</div>
 
        <div class="grid_2">
            <label for="image">Profile Picture:</label>
        </div>
    
        <div class="grid_3">
            <input type="file" name="imageFile" id="imageFile"/>
        </div>
        
        <c:if test="${!empty userCommand.friends}">
            <div class="clear"&nbsp;</div>
  
	         <div class="round_Box_Container grid_6">
	            <label for="friendRemovals">Friends: </label>
	            <ul>
	                <c:forEach var="user" items="${userCommand.friends}">
	                    <li id="user_${user.id}"><c:out value="${user.firstName} ${user.lastName} "/><input type="button" value="Remove" onClick="removeFriend(${userCommand.userId}, ${user.id}, 'user_${user.id}')" /></li>
	                </c:forEach>
	            </ul>	
	        </div>
	    </c:if>
	    <c:if test="${!empty userCommand.teams}">
    	    <div class="clear"&nbsp;</div>
	    
	        <div class="round_Box_Container grid_6">
	            <label for="teamRemovals">Teams: </label>
	            <ul>
	                <c:forEach var="team" items="${userCommand.teams}">
	                    <li id="team_${team.id}"><c:out value="${team.name} "/><input type="button" value="Remove" onClick="removeTeam(${userCommand.userId}, ${team.id}, 'team_${team.id}')" /></li>
	                </c:forEach>
	            </ul>	
	        </div>
	    </c:if>
	    
	    <div class="clear"&nbsp;</div>
	        
	    <div class="grid_2">
	        <input type="submit" value="Save Changes" />
	    </div>
	    
	    <div class="clear"&nbsp;</div>
	
	    <a href="../delete/${userCommand.userId}">Delete Profile</a>
	</div>
</form>
</c:when>
<c:otherwise>
    <p>You don't have permission to edit this user.</p>
</c:otherwise>
</c:choose>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/remove.js"></script>
<script>
    var validateUpdateForm = function () {
        var password = document.getElementById("password");
        var confirm = document.getElementById("confirm");
        var firstName = document.getElementById("firstName");
        var lastName = document.getElementById("lastName");

        if (!password || password.value === '') {
            alert("Password cannot be blank");
            return false;
        }
        if (!confirm || confirm.value === '') {
            alert("You must confirm your password.");
            return false;
        }
        if (password.value !== confirm.value) {
            alert("Your password and password confirmation do not match.");
            return false;
        }
        if (!firstName || firstName.value === '') {
            alert("Your first name cannot be blank");
            return false;
        }
        if (!lastName || lastName.value === '') {
            alert("Your last name cannot be blank");
            return false;
        }
        return true;
    }
</script>

