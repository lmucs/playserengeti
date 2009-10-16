<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <p>
      <form method="post" action="delete">
        <p>Are you sure you want to delete location <c:out value="${deleteLocation.locationName}"/>?</p>
        <input type="submit" value="Delete Location!"/>
      </form>
        </p>
