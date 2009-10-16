<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

      <form method="post" action="delete">
        <p>Are you sure you want to delete team <c:out value="${deleteTeam.name}"/>?</p>
        <input type="submit" value="Delete Team!"/>
      </form>
