<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="home-page-body">

  <div id="home-page-welcome">

    <p class="intro-message">Serengeti is a social networking
    application where players join teams that compete
    for ownership of real locations, such as businesses, parks,
    and beaches. Players can check in from a mobile device and track
    their teams' conquests on the web.
    Teams can organize competitions for fun, or as
    fund-raisers to support their favorite
    charities. Teams that frequent and conquer
    certain businesses might try to convince proprietors
    to offer discounts as a way to keep them checking in.</p>

    <p id="memberad">Already a member? <a href="user/login">Log in</a>.
    If not, <a href="user/create">sign up</a> to play today.</p>
  </div>

  <div id="home-page-extras">

    <div class="graphic-button" id="signup-button">
      <a href="user/create">Sign up now</a>
    </div>

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
            <p><a href="user/${user.id}" ><c:out value="${user.firstName} ${user.lastName}"/></a></p>
          </td>
          <td class="profile-date">
             <fmt:formatDate pattern="MMM d, yyyy'<br />'h:mma" value="${user.dateCreated}"/>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
