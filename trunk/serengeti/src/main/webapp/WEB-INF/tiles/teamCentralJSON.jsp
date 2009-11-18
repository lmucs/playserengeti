<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/plain; charset=UTF-8" %>

<json:object>
  <json:array name="leaders" var="team" items="${leaders}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>
  <json:array name="mostActive" var="team" items="${mostActive}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>
  <json:array name="newest" var="team" items="${newest}">
    <json:object>
      <json:property name="id" value="${team.id}"/>
      <json:property name="name" value="${team.name}"/>
    </json:object>
  </json:array>
</json:object>