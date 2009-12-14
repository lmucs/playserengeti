<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form id="teamUpdateForm" method="POST" action="${pageContext.request.contextPath}/user/update"
        enctype="multipart/form-data" onsubmit="return validateUpdateForm();">
    <div class="round_Box_Container grid_8">
        
        <div class="grid_2">
            <label for="password">Password: </label>
        </div>
        
        <div class="grid_3">
            <form:input path="userCommand.password" />
        </div>
   
   		<div class="clear"&nbsp;</div>
   	
        <div class="grid_2">
            <label for="firstName">First Name: </label>
        </div>
        <div class="grid_3">
            <form:input path="userCommand.firstName" />
        </div>
        
        <div class="clear"&nbsp;</div>
     
        <div class="grid_2">
            <label for="lastName">Last Name: </label>
        </div>
        <div class="grid_3">
            <form:input path="userCommand.lastName" />
        </div>
        
        <div class="clear"&nbsp;</div>
 
        <div class="grid_2">
            <label for="image">Profile Picture:</label>
        </div>
    
        <div class="grid_3">
            <input type="file" path="userCommand.imageBytes"/>
        </div>
        
        <div class="clear"&nbsp;</div>

	     <div class="round_Box_Container grid_6">
	        <label for="friendRemovals">Friends: </label>
	        <ul>
	            <c:forEach var="user" items="${userCommand.friends}">
	                <li id="user_${user.id}"><c:out value="${user.firstName} ${user.lastName}"/><input type="button" value="Remove" onClick="removeFriend(${userCommand.userId}, ${user.id}, 'user_${user.id}')" /></li>
	            </c:forEach>
	        </ul>	
	    </div>
	    
	    <div class="clear"&nbsp;</div>
	    
	    <div class="round_Box_Container grid_6">
	        <label for="teamRemovals">Teams: </label>
	        <ul>
	            <c:forEach var="team" items="${userCommand.teams}">
	                <li id="team_${team.id}"><c:out value="${team.name}"/><input type="button" value="Remove" onClick="removeTeam(${userCommand.userId}, ${team.id}, 'team_${team.id}')" /></li>
	            </c:forEach>
	        </ul>	
	    </div>
	    
	    <div class="clear"&nbsp;</div>
	        
	    <div class="grid_2">
	        <input type="submit" value="Save Changes" />
	    </div>
	    
	    <div class="clear"&nbsp;</div>
	
	    <a href="../delete/${userCommand.userId}">Delete Profile</a>
	</div>
</form>


<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/remove.js"></script>
<script>
function validateUpdateForm() {
        var name = document.getElementById("password");
        if (name && name.value !== '') {
            return true;
        }
        alert("The password cannot be blank");
        return false;
}    
</script>

