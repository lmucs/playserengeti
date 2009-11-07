<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
  <json:array name="nearbyLocations" var="location" items="${nearbyLocations}">
    <json:object>
      <json:property name="locationId" value="<c:out value="${location.locationId}"/>"/>
      <json:property name="locationName" value="<c:out value="${location.locationName}" />"/>
      <json:property name="phoneNumber" value="<c:out value="${location.phoneNumber}" />"/>
      <json:property name="latitude" value="<c:out value="${location.latitude}" />"/>
      <json:property name="longitude" value="<c:out value="${location.longitude}" />"/>
      <json:property name="street" value="<c:out value="${location.street}" />"/>
      <json:property name="city" value="<c:out value="${location.city}" />"/>
      <json:property name="state" value="<c:out value="${location.state}" />"/>
      <json:property name="zipcode" value="<c:out value="${location.zipcode}" />"/>
      <json:property name="description" value="<c:out value="${location.description}" />"/>
      <json:property name="teamOwner" value="<c:out value="${location.teamOwner}" />"/>
    </json:object>
  </json:array>
</json:object>