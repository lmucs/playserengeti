<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="home-page-introduction">
  <div class="signup-button">
    <a href="user/create">Sign up now</a>
  </div>

  <p>Serengeti is a social networking tool and game
  where players join teams that compete for "ownership" of
  locations by recording their visits to the location.
  Players can track their teams' conquests through the
  playserengeti.com website, a mobile web application, or
  and iPhone app. Proprietors of locations might wish to
  offer benefits or discounts to their current "owner"
  team as a way to draw customers.  Teams might even organize
  competitions or fund-raisers to support their favorite
  charities.</p>

  <p>Already a member? <a href="user/login">Log in</a>.
  If not, <a href="user/create">sign up</a> to play today.</p>
</div>

<div class="shadowText">
<p>Newest Users</p>
</div>

<div class="verticalMenu">
	<c:forEach var="user" items="${newest}">
		<div class="miniProfile">
			<span class="miniProfilePic"><a href="user/${user.id}"><img
			src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
			title="${user.email}" width="50" height="50"/></a></span>
			
			<span class="miniProfileName"> 
			<a href="user/${user.id}" ><c:out value="${user.firstName} ${user.lastName}"/></a></span>
		</div>
		
		<span class="miniProfileInfo">Joined Serengeti on <fmt:formatDate pattern="MMM dd, yyyy @ hh:mma" value="${user.dateCreated}"/></span>
	</c:forEach>
</div>
