<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${session.loggedIn}">
	<div class="graphic-button" id="team-create-button">
		<a href="create">Create a team</a>
	</div>	
</c:if>
<div class="shadowTextMargin">
	<p>Teams With The Most Territory</p>
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 <!--<div class="shadowText">
<p>Teams With Most Territory</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows"> <a id="leftArrow1" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a> 
</span>

<span class="centralScrollSpan">

<div id="scrollContainer">
<div id="mostTerritory"
	style="position: absolute; width: 400px; left: 0; top: 0;">


<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden>INSERT CONTENT HERE

<ul class="hor_menu">
	<c:forEach var="team" items="${leaders}">
		<li><a href="${team.id}"><img
			src="${pageContext.request.contextPath}/images/default_team.png" alt="team"
			title="${team.name}" width="50" height="50"/></a> <span><c:out value="${team.name}" />
		</span><a href="${team.id}" ><c:out value="${team.name}"/></a></li>
	</c:forEach>
</ul>

END CONTENT</div>
</div>
</div>
</div>

</span>

<span class="allRightArrows"><a
	id="rightArrow1" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="160px" width="80px"></a>
</span>



</div>


<div class="shadowText">
<p>Most Active Teams</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows">
<a id="leftArrow2" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a>
</span>	

<span class="centralScrollSpan">

<div id="scrollContainer">
<div id="mostActive"
	style="position: absolute; width: 400px; left: 0; top: 0;">

<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden>INSERT CONTENT HERE
<ul class="hor_menu">
	<c:forEach var="team" items="${mostActive}">
		<li><a href="${team.id}"><img
			src="${pageContext.request.contextPath}/images/default_team.png" alt="user"
			title="${team.name}" width="50" height="50"/></a> <span><c:out value="${team.name}" />
		</span><a href="${team.id}" ><c:out value="${team.name}"/></a></li>
	</c:forEach>
</ul>


END CONTENT</div>
</div>
</div>
</div>
</span>

<span class="allRightArrows"><a
	id="rightArrow2" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="160px" width="80px"></a>
</span>

</div>



<div class="shadowText">
<p>Newest Teams</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows">
<a id="leftArrow3" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a>
</span>

<span class="centralScrollSpan">

<div id="scrollContainer">
<div id="newestTeams"
	style="position: absolute; width: 400px; left: 0; top: 0;">

<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden>INSERT CONTENT HERE
<ul class="hor_menu">
	<c:forEach var="team" items="${newest}">
		<li><a href="${team.id}"><img
			src="${pageContext.request.contextPath}/images/default_team.png" alt="user"
			title="${team.name}" width="50" height="50"/></a> <span><c:out value="${team.name}" />
		</span><a href="${team.id}" ><c:out value="${team.name}"/></a></li>
	</c:forEach>
</ul>


END CONTENT</div>
</div>
</div>
</div>
</span>

<span class="allRightArrows"><a
	id="rightArrow3" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="160px" width="80px"></a>
</span>

</div>



<script type="text/javascript">
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['mostTerritory','mostActive', 'newestTeams'],["rightArrow1", "rightArrow2", "rightArrow3"]);
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['mostTerritory','mostActive', 'newestTeams'],["rightArrow1", "rightArrow2", "rightArrow3"]);
</script>
 
 
 
 -->