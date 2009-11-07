<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="userId" value="<c:out value="${userCommand.id}"/>"/>
    <json:property name="displayName" value="<c:out value="${userCommand.name}" />"/>
    <json:property name="email" value="<c:out value="${userCommand.email}" />"/>

    
    <json:array name="friends" var="user" items="${friends}">
      <json:object>
        <json:property name="userId" value="<c:out value="${user.userId}"/>"/>
        <json:property name="displayName" value="<c:out value="${user.displayName}" />"/>
      </json:object>
    </json:array>

    <json:array name="teams" var="team" items="${teams}">
      <json:object>
        <json:property name="teamId" value="<c:out value="${team.id}"/>"/>
        <json:property name="name" value="<c:out value="${team.name}" />"/>
      </json:object>      
    </json:array>
    
    <json:array name="nearbyLocations" var="location" items="${nearbyLocations}">
      <json:object>
        <json:property name="locationId" value="<c:out value="${teamCommand.locationId}"/>"/>
        <json:property name="locationName" value="<c:out value="${teamCommand.locationName}" />"/>
        <json:property name="phoneNumber" value="<c:out value="${teamCommand.phoneNumber}" />"/>
        <json:property name="latitude" value="<c:out value="${teamCommand.latitude}" />"/>
        <json:property name="longitude" value="<c:out value="${teamCommand.longitude}" />"/>
        <json:property name="street" value="<c:out value="${teamCommand.street}" />"/>
        <json:property name="city" value="<c:out value="${teamCommand.city}" />"/>
        <json:property name="state" value="<c:out value="${teamCommand.state}" />"/>
        <json:property name="zipcode" value="<c:out value="${teamCommand.zipcode}" />"/>
        <json:property name="description" value="<c:out value="${teamCommand.description}" />"/>
        <json:property name="teamOwner" value="<c:out value="${teamCommand.teamOwner.name}" />"/>
      </json:object>
    </json:array>
    
    <json:array name="invites" var="invite" items="${friendInvites}">
      <json:object>
        <json:property name="friendshipId" value="<c:out value="${invite.key}"/>"/>
        <json:property name="userId" value="<c:out value="${invite.value.userId}" />"/>
        <json:property name="displayName" value="<c:out value="${invite.value.displayName}" />"/>
      </json:object>      
    </json:array>
    
</json:object>