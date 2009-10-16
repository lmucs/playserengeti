<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<p>Stub page to turn off pinging from userID</p>

<c:if test='${ !empty userID }'>
    <p><strong><c:out value=" ${userID}"/></strong>...</p>
</c:if>
