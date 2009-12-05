<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:choose>
    <c:when test="${!empty userCommand.teams}">
        <p>Not so fast.  You are still the leader of these teams.  You can't just bail on them without 
        appointing another leader.</p>
        <ul>
        <c:forEach var="team" items="${userCommand.teams}">
            <li><a href="../../team/update/${team.id}"><c:out value="${team.name}"/></a></li>
        </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <form id="userDeleteForm" method="POST" action="${pageContext.request.contextPath}/user/delete">
            <p>Are you sure you want to remove yourself from Serengeti?  By continuing, you will lose all 
            data associated with your profile.  This cannot be recovered.</p>

            <p><c:out value="${userCommand.firstName} ${userCommand.lastName}"/></p>

            <div class="formRow">
                <input type="submit" value="Delete Profile" />
            </div>
        </form>
    </c:otherwise>
</c:choose>


