<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
  <json:array name="recent" var="user" items="${recent}">
    <json:object>
      <json:property name="userId" value="${user.id}"/>
      <json:property name="email" value="${user.email}"/>
    </json:object>
  </json:array>
  <json:array name="mostActive" var="user" items="${mostActive}">
    <json:object>
      <json:property name="userId" value="${user.id}"/>
      <json:property name="email" value="${user.email}"/>
    </json:object>
  </json:array>
  <json:array name="newest" var="user" items="${newest}">
    <json:object>
      <json:property name="userId" value="${user.id}"/>
      <json:property name="email" value="${user.email}"/>
    </json:object>
  </json:array>
</json:object>