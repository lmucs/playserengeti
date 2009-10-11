<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <p>You can create a location.</p>

    <p>
            <form method="post" action="create">
        <label for="name">Location Name: </label><input type="text" name="locationName"/><br/>
        <label for="latitude">Latitude: </label><input type="text" name="latitude"/><br/>
        <label for="latitude">Longitude: </label><input type="text" name="longitude"/><br/>
        <label for="teamOwner">Team Owner: </label><input type="text" name="teamOwner"/><br/>
        <input type="submit" value="Create Location!"/>
      </form>
        </p>
