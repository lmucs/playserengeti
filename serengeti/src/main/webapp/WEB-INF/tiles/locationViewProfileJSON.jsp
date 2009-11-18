<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/plain; charset=UTF-8" %>

<json:object>
  <json:property name="id" value="${teamCommand.id}"/>
  <json:property name="name" value="${teamCommand.name}"/>
  <json:property name="phoneNumber" value="${teamCommand.phoneNumber}"/>
  <json:property name="latitude" value="${teamCommand.latitude}"/>
  <json:property name="longitude" value="${teamCommand.longitude}"/>
  <json:property name="street" value="${teamCommand.street}"/>
  <json:property name="city" value="${teamCommand.city}"/>
  <json:property name="state" value="${teamCommand.state}"/>
  <json:property name="zipcode" value="${teamCommand.zipcode}"/>
  <json:property name="description" value="${teamCommand.description}"/>
  <json:property name="teamOwner" value="${teamCommand.teamOwner.name}"/>
  <json:array name="competingTeams" var="team" items="${competingTeams}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>
</json:object>