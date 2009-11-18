<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/plain; charset=UTF-8" %>

<json:object>
  <json:property name="id" value="${locationCommand.id}"/>
  <json:property name="name" value="${locationCommand.name}"/>
  <json:property name="phoneNumber" value="${locationCommand.phoneNumber}"/>
  <json:property name="latitude" value="${locationCommand.latitude}"/>
  <json:property name="longitude" value="${locationCommand.longitude}"/>
  <json:property name="street" value="${locationCommand.street}"/>
  <json:property name="city" value="${locationCommand.city}"/>
  <json:property name="state" value="${locationCommand.state}"/>
  <json:property name="zipcode" value="${locationCommand.zipcode}"/>
  <json:property name="description" value="${locationCommand.description}"/>
  <json:property name="owner" value="${locationCommand.owner.name}"/>
  <json:array name="competingTeams" var="team" items="${competingTeams}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>
</json:object>