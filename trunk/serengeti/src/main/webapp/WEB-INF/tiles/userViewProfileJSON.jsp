<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/plain; charset=UTF-8" %>

<json:object>
  <json:property name="userId" value="${userCommand.userId}"/>
  <json:property name="email" value="${userCommand.email}"/>

  <json:array name="friends" var="user" items="${friends}">
    <json:object>
      <json:property name="userId" value="${user.id}"/>
      <json:property name="email" value="${user.email}" />
    </json:object>
  </json:array>

  <json:array name="teams" var="team" items="${teams}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>

  <json:array name="nearbyLocations" var="location" items="${nearbyLocations}">
    <json:object>
      <json:property name="id" value="${location.id}"/>
      <json:property name="name" value="${location.name}"/>
      <json:property name="phoneNumber" value="${location.phoneNumber}"/>
      <json:property name="latitude" value="${location.latitude}"/>
      <json:property name="longitude" value="${location.longitude}"/>
      <json:property name="street" value="${location.street}"/>
      <json:property name="city" value="${location.city}"/>
      <json:property name="state" value="${location.state}"/>
      <json:property name="zipcode" value="${location.zipcode}"/>
      <json:property name="description" value="${location.description}"/>
      <json:property name="owner" value="${location.owner.name}"/>
    </json:object>
  </json:array>

  <json:array name="friendInvites" var="user" items="${friendInvites}">
    <json:object>
      <json:property name="id" value="${user.id}"/>
      <json:property name="email" value="${user.email}"/>
    </json:object>
  </json:array>

  <json:array name="teamInvites" var="team" items="${teamInvites}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>
</json:object>
