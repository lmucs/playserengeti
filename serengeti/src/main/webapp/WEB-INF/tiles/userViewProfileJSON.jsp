<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/plain; charset=UTF-8" %>

<json:object>
  <json:object name="user">
    <json:property name="id" value="${userCommand.userId}"/>
    <json:property name="email" value="${userCommand.email}"/>
    <json:property name="name" value="${userCommand.firstName} ${userCommand.lastName}"/>
  </json:object>

  <json:array name="friends" var="user" items="${userCommand.friends}">
    <json:object>
      <json:property name="id" value="${user.id}"/>
      <json:property name="name" value="${user.firstName} ${user.lastName}" />
    </json:object>
  </json:array>

  <json:array name="teams" var="team" items="${userCommand.teams}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>

  <json:object name="invites">
    <json:array name="friendInvites" var="user" items="${friendInvites}">
      <json:object>
        <json:property name="id" value="${user.id}"/>
        <json:property name="name" value="${user.firstName} ${user.lastName}"/>
      </json:object>
    </json:array>
    <json:array name="teamInvites" var="team" items="${teamInvites}">
      <json:object>
        <json:property name="id" value="${team.id}"/>
        <json:property name="name" value="${team.name}"/>
      </json:object>
    </json:array>
  </json:object>
  
  <json:array name="invitableTeams" var="team" items="${invitableTeams}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>
  
  <json:array name="activity" var="visit" items="${activity}">
    <json:object>
      <json:property name="id" value="${visit.id}"/>
      <json:object name="user">
        <json:property name="id" value="${visit.user.id}"/>
        <json:property name="name" value="${visit.user.firstName} ${visit.user.lastName}"/>
      </json:object>
      <json:object name="team">
        <json:property name="id" value="${visit.team.id}"/>
        <json:property name="name" value="${visit.team.name}"/>
      </json:object>
      <json:object name="location">
        <json:property name="id" value="${visit.location.id}"/>
        <json:property name="name" value="${visit.location.name}"/>
        <json:property name="latitude" value="${visit.location.latitude}"/>
        <json:property name="longitude" value="${visit.location.longitude}"/>
      </json:object>
      <json:property name="date"><fmt:formatDate pattern="MMM dd, yyyy @ hh:mma" value="${visit.date}"/></json:property>
    </json:object>
  </json:array>
  
  <json:property name="alreadyFriends" value="${alreadyFriends}"/>
</json:object>
