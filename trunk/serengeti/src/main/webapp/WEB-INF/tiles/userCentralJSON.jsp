<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/plain; charset=UTF-8" %>

<json:object>
  <json:array name="recent" var="visit" items="${recent}">
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
  <json:array name="mostActive" var="user" items="${mostActive}">
    <json:object>
      <json:property name="id" value="${user.id}"/>
      <json:property name="name" value="${user.firstName} ${user.lastName}"/>
      <json:property name="email" value="${user.email}"/>
    </json:object>
  </json:array>
  <json:array name="newest" var="user" items="${newest}">
    <json:object>
      <json:property name="id" value="${user.id}"/>
      <json:property name="name" value="${user.firstName} ${user.lastName}"/>
      <json:property name="email" value="${user.email}"/>
    </json:object>
  </json:array>
</json:object>