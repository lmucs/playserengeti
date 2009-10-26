<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<form id="userDeleteForm" method="post" action="delete">
    <p>Are you sure you want to remove yourself from Serengeti?  By continuing, you will lose all 
        data associated with your profile.  This cannot be recovered.</p>

    <p>${userCommand.displayName}</p>

    <div class="formRow">
        <input type="submit" value="Delete Profile" />
    </div>
</form>

<!--
<c:if test="${ !empty message }">
    <p class="error"><c:out value="${message}"/></p>
</c:if>

<p>Select the user that you'd like to delete!</p>

<ul>
    <c:forEach var="user" items="${allUsers}">
        <li>
            <a href="javascript:void(0);" onclick="deleteUser(${user.userId});"><c:out value="${user.userName}"/></a>
        </li>
    </c:forEach>
</ul>

<script type="text/javascript">
    function deleteUser(id) {
        var bodies = document.getElementsByTagName("body");
        var form = document.createElement("form");
        var input = document.createElement("input");

        form.action = "delete";
        form.method = "POST";

        input.type = "hidden";
        input.name = "userId";
        input.value = id;

        form.appendChild(input);

        bodies[0].appendChild(form);

        form.submit();
    }
</script>
-->