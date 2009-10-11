<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <p>Choose which of your friends to invite to the team.</p>

    <form method="post" action="invite">
      <label for="invitees">Friends: </label>
          <select multiple size=5 name="invitees">
            <c:forEach var="user" items="${teamInvite.users}">
                <option value="${user}"><c:out value="${user.userName}"/></option>
            </c:forEach>
                </select><br/>
      <input type="submit" value="Invite!"/>
    </form>
