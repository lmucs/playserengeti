<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div id="header">

  <div>
    <img id="banner" alt="banner"
      src="${pageContext.request.contextPath}/images/banner.jpg"
    />
  </div>

  <div id="navbar2">
    <ul>
      <li><a href="${pageContext.request.contextPath}/">Home</a></li>
      <c:if test="${session.loggedIn || (!empty userCommand.sessionId) 
        || (!empty teamCommand.sessionId) || (!empty locationCommand.sessionId)}">
        <li><a href="${pageContext.request.contextPath}/user/${session.user.id}${userCommand.sessionId}${teamCommand.sessionId}${locationCommand.sessionId}">Profile</a></li>
      </c:if>
      <c:if test="${not session.loggedIn && (empty userCommand.sessionId) 
        && (empty teamCommand.sessionId) && (empty locationCommand.sessionId)}">
        <li><a href="${pageContext.request.contextPath}/user/login">Log In</a></li>
      </c:if>
      <li><a href="${pageContext.request.contextPath}/user">Users</a></li>
      <li><a href="${pageContext.request.contextPath}/team">Teams</a></li>
      <li><a href="${pageContext.request.contextPath}/location">Locations</a></li>
      <li><a href="${pageContext.request.contextPath}/help">Help</a></li>
      <c:if test="${session.loggedIn  || (!empty userCommand.sessionId) 
        || (!empty teamCommand.sessionId) || (!empty locationCommand.sessionId)}">
        <li><a href="${pageContext.request.contextPath}/user/logout">Log Out</a></li>
      </c:if>
    </ul>
  </div>

  <div class="searchbar">
    <form action="${pageContext.request.contextPath}/search" method="post">
      <div>
        <input type="text" name="query" id="query"
          value="Search for people, places, or teams"
          onfocus="makeBlank(this)"
          onblur="returnValue(this)"
        />
        <input type="submit" value="Go" />
      </div>
    </form>
  </div>
</div>
