<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="shadowText">
<p>Users</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows"> <a id="leftArrow1" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a> 
</span>

<span class="centralScrollSpan">

<div id="scrollContainer">
<div id="recentlyCheckedIn"
	style="position: absolute; width: 400px; left: 0; top: 0;">


<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->

<ul class="hor_menu">
	<c:forEach var="user" items="${users}">
		<li><a href="${user.id}"><img
			src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
			title="${user.email}" width="50" height="50"/></a> <span><c:out value="${user.email}" />
		</span><a href="../user/${user.id}" ><c:out value="${user.firstName}"/></a></li>
	</c:forEach>
</ul>

<!--END CONTENT--></div>
</div>
</div>
</div>

</span>

<span class="allRightArrows"><a
	id="rightArrow1" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="160px" width="80px"></a>
</span>



</div>
<!--
<div id="arrows"><a id="leftArrow1" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="50px" width="50px"></a> <a
	id="rightArrow1" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="50px" width="50px"></a></div>
-->



<div class="shadowText">
<p>Teams</p>
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
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->
<ul class="hor_menu">
	<c:forEach var="team" items="${teams}">
		<li><a href="${team.id}"><img
			src="${pageContext.request.contextPath}/images/default_team.png" alt="team"
			title="${team.name}" width="50" height="50"/></a> <span><c:out value="${team.name}" />
		</span><a href="../team/${team.id}" ><c:out value="${team.name}"/></a></li>
	</c:forEach>
</ul>


<!--END CONTENT--></div>
</div>
</div>
</div>
</span>

<span class="allRightArrows"><a
	id="rightArrow2" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="160px" width="80px"></a>
</span>

</div>

<!--  
<div id="arrows"><a id="leftArrow2" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="50px" width="50px"></a> <a
	id="rightArrow2" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="50px" width="50px"></a></div>
-->


<div class="shadowText">
<p>Locations</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows">
<a id="leftArrow3" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a>
</span>

<span class="centralScrollSpan">

<div id="scrollContainer">
<div id="newestUsers"
	style="position: absolute; width: 400px; left: 0; top: 0;">

<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->
<ul class="hor_menu">
	<c:forEach var="location" items="${locations}">
		<li><!-- <a href="${location.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="location"
			title="${location.name}" /></a> --> <span><c:out value="${location.name}" />
		</span><a href="../location/${location.id}" ><c:out value="${location.name}"/></a></li>
		
	</c:forEach>
</ul>