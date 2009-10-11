<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <p>Create your own team and start marking your territory.
       Just fill in the information below.</p>

      <form method="post" action="create">
        <label for="name">Team Name: </label><input type="text" name="name"/><br/>
        <label for="color">Preferred Color: </label>
            <select name="color">
                <option value="Red">Red</option>
                <option value="Green">Green</option>
                <option value="Blue">Blue</option>
                <option value="Yellow">Yellow</option>
                <option value="Magenta">Magenta</option>
                <option value="Cyan">Cyan</option>
            </select><br/>
        <p> This will not be necessary when user sign in is implemented.</p>
        <label for="userId">Team Leader: </label>
            <select name="userId">
                <c:forEach var="user" items="${createTeam.allUsers}">
                    <option value="${user.userId}"><c:out value="${user.userName}"/></option>
                </c:forEach>
            </select><br/>
        <label for="homeLocation">Home Location: </label>
                <select name="homeLocation">
                <c:forEach var="location" items="${createTeam.allLocations}">
                    <option value="${location.locationId}"><c:out value="${location.locationName}"/></option>
                </c:forEach>
            </select><br/>
        <label for="image">Team Image URL: </label><input type="text" name="image"/><br/>

        <input type="submit" value="Create Team!"/>
      </form>
