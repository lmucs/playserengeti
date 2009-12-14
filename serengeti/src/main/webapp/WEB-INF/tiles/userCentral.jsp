<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="shadowText">
  <h2 class="tablecaption">Recently Checked In</h2>
</div>

<table class="profile">
  <tr class="top-row">
    <th class="profile-picture">photo</th>
    <th>user</th>
    <th>location</th>
    <th>check-in date and time</th>
  </tr>
  <c:forEach var="visit" items="${recent}">
    <tr>
      <td class="profile-picture">
        <p>
          <a href="${visit.user.id}"><img src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
          title="${visit.user.email}" width="50" height="50"/></a>
        </p>
      </td>
      <td class="profile-name">
        <p><a href="${visit.user.id}"><c:out value="${visit.user.firstName} ${visit.user.lastName}"/></a></p>
      </td>
      <td class="profile-location">
        <p><a href="../location/${visit.location.id}">${visit.location.name}</a></p>
      </td>
      <td class="profile-date">
        <fmt:formatDate pattern="MMM dd, yyyy'<br />'hh:mma"
        value="${visit.date}"/>
      </td>
    </tr>
  </c:forEach>
</table>

<div class="shadowText">
  <h2 class="tablecaption">Most Active Users</h2>
</div>

<table class="profile">
  <tr class="top-row">
    <th class="profile-picture">photo</th>
    <th>user</th>
  </tr>
  <c:forEach var="user" items="${mostActive}">
    <tr>
      <td class="profile-picture">
        <p>
          <a href="${user.id}"><img src="${pageContext.request.contextPath}/images/default_user.png"
          alt="user" title="${user.email}" width="50" height="50"/></a>
        </p>
      </td>
      <td class="profile-name">
        <p><a href="${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a></p>
      </td>
    </tr>
  </c:forEach>
</table>

<div class="shadowText">
  <h2 class="tablecaption">Newest Users</h2>
</div>

<table class="profile">
  <tr class="top-row">
    <th class="profile-picture">photo</th>
    <th>name</th>
    <th>join date</th>
  </tr>
  <c:forEach var="user" items="${newest}">
    <tr>
      <td class="profile-picture">
        <p>
          <a href="user/${user.id}">
            <img src="${pageContext.request.contextPath}/images/default_user.png" alt="user" title="${user.email}" width="50" height="50"/>
          </a>
        </p>
      </td>
      <td class="profile-name">
        <p><a href="${user.id}" ><c:out value="${user.firstName} ${user.lastName}"/></a></p>
      </td>
      <td class="profile-date">
        <fmt:formatDate pattern="MMM dd, yyyy'<br />'hh:mma"
        value="${user.dateCreated}"/>
      </td>
    </tr>
  </c:forEach>
</table>
