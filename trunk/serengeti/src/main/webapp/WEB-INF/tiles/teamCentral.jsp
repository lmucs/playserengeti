<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


 <div class="shadowTextMargin">
<h2>Teams With The Most Territory</h2>
</div>

<table class="profile">
    <tr class="top-row">
        <th class="profile-picture">photo</th>
        <th>team</th>
        <th>info or something?</th>
    </tr>
	<c:forEach var="team" items="${leaders}">
		<tr>
            <td class="profile-picture">
                <p>
                    <a href="${team.id}"><img src="${pageContext.request.contextPath}/images/default_team.png" alt="team"
			         title="${visit.user.email}" width="50" height="50"/></a>
			    </p>
			</td>
		    <td class="profile-name">	
                <p><a href="${team.id}" ><c:out value="${team.name}"/></a></p>
            </td>
            <td class="profile-info">
                <%-- <span class="miniProfileInfoCheckin">    </span> --%>
            </td>
		</tr>
	</c:forEach>
</table>

<div class="shadowTextMargin">
<h2>Most Active Teams</h2>
</div>

<table class="profile">
    <tr class="top-row">
        <th class="profile-picture">photo</th>
        <th>team</th>
        <th>info or something?</th>
    </tr>
    <c:forEach var="team" items="${mostActive}">
		<tr>
            <td class="profile-picture">
                <p>
                    <a href="${user.id}"><img src="${pageContext.request.contextPath}/images/default_team.png"
                     alt="team" title="${team.id}" width="50" height="50"/></a>
                </p>
            </td> 
			<td class="profile-name">
                <p><a href="${team.id}" ><c:out value="${team.name}"/></a></p>
            </td>
            <td class="profile-info">
                <%-- <span class="miniProfileInfoCheckin">    </span> --%>
            </td>
		</tr>
		
	</c:forEach>
</table>

<div class="shadowTextMargin">
<h2>Newest Teams</h2>
</div>


<table class="profile">
    <tr class="top-row">
        <th class="profile-picture">photo</th>
        <th>team</th>
        <th>date</th>
    </tr>
	<c:forEach var="team" items="${newest}">
		<tr>
            <td class="profile-picture">
                <p>
                    <a href="${user.id}"><img src="${pageContext.request.contextPath}/images/default_team.png"
                     alt="user" title="${team.id}" width="50" height="50"/></a>
                </p>
            </td>
			<td class="profile-name"> 
                <p><a href="${team.id}" ><c:out value="${team.name}"/></a></p>
            </td>
            <td class="profile-date">
                <p>
                    <fmt:formatDate pattern="MMM dd, yyyy @ hh:mma" value="${team.dateCreated}"/>
		        </p>
		    </td>
		</tr>
	</c:forEach>
</table>