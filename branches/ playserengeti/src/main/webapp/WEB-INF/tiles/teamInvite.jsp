<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <p>Choose which of your friends to invite to the team.</p>    

    <form method="post" action="invite">
		<form:checkboxes path="teamInvite.invitees" items="${teamInvite.users}"/><br/>
      <input type="submit" value="Invite!"/>
    </form>
