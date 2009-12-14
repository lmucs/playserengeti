<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="shadowText">
<p>Users</p>
</div>

<div class="verticalMenu">
  <c:forEach var="user" items="${users}">
    <div class="miniProfile">
      <span class="miniProfilePic">
      <a href="user/${user.id}"><img
      src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
      title="${user.email}" width="50" height="50"/></a> </span>

      <span class="miniProfileName">
      <a href="user/${user.id}" ><c:out value="${user.firstName} ${user.lastName}"/></a></span>


    </div>

  </c:forEach>
</div>

<div class="shadowText">
<p>Teams</p>
</div>

<div class="verticalMenu">
<c:forEach var="team" items="${teams}">
    <div class="miniProfile">
      <span class="miniProfilePic"><a href="team/${team.id}"><img
      src="${pageContext.request.contextPath}/images/default_team.png" alt="team"
      title="${team.id}" width="50" height="50"/></a></span>

      <span class="miniProfileName">
      <a href="team/${team.id}" ><c:out value="${team.name}"/></a></span>
    </div>
  </c:forEach>
</div>

  <div class="shadowText">
<p>Locations</p>
</div>

<div class="verticalMenu">
  <c:forEach var="location" items="${locations}">
    <div class="miniProfile">
    <span class="miniProfilePicHidden">
      <a href="location/${location.id}"><img src="${pageContext.request.contextPath}/images/default_team.png" alt="location"
      title="${location.id}" width="50" height="50"/></a> </span>
    <span class="miniProfileName">
      <a href="location/${location.id}" ><c:out value="${location.name}"/></a></span>

    </div>
  </c:forEach>
</div>
