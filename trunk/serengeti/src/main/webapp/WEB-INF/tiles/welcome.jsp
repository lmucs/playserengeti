<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="home-page-body">

  <div id="home-page-welcome">

    <p class="intro-message">Serengeti is a social networking
    application and game where players join teams that compete
    for ownership of locations (businesses, parks, beaches, and
    so on.) Players can check in from a mobile device and track
    their teams' conquests on the playserengeti.com website.
    Teams can organize competitions for fun or as
    fund-raisers to support their favorite
    charities. Teams that frequent and conquer
    certain businesses might even convince proprietors
    to offer discounts as a way to keep checking in.</p>

    <p id="memberad">Already a member? <a href="user/login">Log in</a>.
    If not, <a href="user/create">sign up</a> to play today.</p>
  </div>

  <div id="home-page-extras">

    <div class="signup-button">
      <a href="user/create">Sign up now</a>
    </div>

    <div class="shadowText">
      <h2 class="tablecaption">Newest Users</h2>
    </div>

    <table id="userprofile">
      <tr><th>photo</th><th>name</th><th>join date</th></tr>
      <c:forEach var="user" items="${newest}">
        <tr>
          <td class="userprofile-picture">
            <div>
              <a href="user/${user.id}">
                <img src="${pageContext.request.contextPath}/images/default_user.png" alt="user" title="${user.email}" width="50" height="50"/>
              </a>
            </div>
          </td>
          <td class="userprofile-name">
            <p><a href="user/${user.id}" ><c:out value="${user.firstName} ${user.lastName}"/></a></p>
          </td>
          <td class="userprofile-joindate">
             <p><fmt:formatDate pattern="MMM dd, yyyy @ hh:mma" value="${user.dateCreated}"/></p>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
