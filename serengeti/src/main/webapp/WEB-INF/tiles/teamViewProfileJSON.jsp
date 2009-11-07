<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="teamId" value="${teamCommand.teamId}"/>
    <json:property name="name" value="${teamCommand.name}" />
    <json:property name="color" value="${teamCommand.color}" />
    <json:property name="description" value="${teamCommand.description}" />
    <json:property name="homeBase" value="${teamCommand.homeBase}" />
    <json:property name="image" value="${teamCommand.image}" />
    <json:property name="leaderId" value="${teamCommand.leaderId}" />
    <json:array name="members" var="user" items="${members}">
        <json:object>
            <json:property name="userId" value="${user.userId}"/>
            <json:property name="displayName" value="${user.displayName}" />
        </json:object>
    </json:array>
</json:object>
