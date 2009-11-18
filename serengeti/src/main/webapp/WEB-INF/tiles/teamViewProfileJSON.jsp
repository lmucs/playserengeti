<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/plain; charset=UTF-8" %>

<json:object>
  <json:property name="id" value="${teamCommand.id}"/>
  <json:property name="name" value="${teamCommand.name}" />
  <json:property name="color" value="${teamCommand.color}" />
  <json:property name="description" value="${teamCommand.description}" />
  <json:property name="homeBase" value="${teamCommand.homeBase}" />
  <json:property name="leaderId" value="${teamCommand.leader.id}" />
  <json:array name="members" var="user" items="${members}">
    <json:object>
      <json:property name="id" value="${user.id}"/>
      <json:property name="email" value="${user.email}" />
    </json:object>
  </json:array>
</json:object>
