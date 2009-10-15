<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<p>Create a Location by filling in the information below.</p>

<form:form method="post">
    <div>
        <label for="locationName">locationName: </label>
        <form:input path="locationName"/>
        <form:errors path="locationName"/>
    </div>

    <div>
        <label for="latitude">Latitude: </label>
        <form:input path="latitude"/>
        <form:errors path="latitude"/>
    </div>

    <div>
        <label for="longitude">Longitude: </label>
        <form:input path="longitude"/>
        <form:errors path="longitude"/>
    </div>

    <div>
        <input type="submit" value="Create!"/>
    </div>
</form:form>

<c:if test="${not empty message}">
    <p><c:out value="${message}"/></p>
</c:if>