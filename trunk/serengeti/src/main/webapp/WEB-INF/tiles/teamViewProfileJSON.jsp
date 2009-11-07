<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="teamId" value="<c:out value="${teamCommand.id}"/>"/>
    <json:property name="name" value="<c:out value="${teamCommand.name}" />"/>
    <json:property name="color" value="<c:out value="${teamCommand.color}" />"/>
    <json:property name="description" value="<c:out value="${teamCommand.description}" />"/>
    <json:property name="homeBase" value="<c:out value="${teamCommand.homeBase}" />"/>
    <json:property name="image" value="<c:out value="${teamCommand.image}" />"/>
    <json:property name="leaderId" value="<c:out value="${teamCommand.leaderId}" />"/>
    <json:array name="members" var="user" items="${members}">
      <json:object>
        <json:property name="userId" value="<c:out value="${user.userId}"/>"/>
        <json:property name="displayName" value="<c:out value="${user.displayName}" />"/>
      </json:object>
    </json:array>

</json:object>