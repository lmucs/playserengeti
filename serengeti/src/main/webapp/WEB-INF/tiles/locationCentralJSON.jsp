<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
  <json:array name="nearbyLocations" var="location" items="${nearbyLocations}">
    <json:object>
      <json:property name="locationId" value="${location.locationId}"/>
      <json:property name="locationName" value="${location.locationName}"/>
      <json:property name="phoneNumber" value="${location.phoneNumber}"/>
      <json:property name="latitude" value="${location.latitude}"/>
      <json:property name="longitude" value="${location.longitude}"/>
      <json:property name="street" value="${location.street}"/>
      <json:property name="city" value="${location.city}"/>
      <json:property name="state" value="${location.state}"/>
      <json:property name="zipcode" value="${location.zipcode}"/>
      <json:property name="description" value="${location.description}"/>
      <json:property name="teamOwner" value="${location.teamOwner}"/>
    </json:object>
  </json:array>
</json:object>