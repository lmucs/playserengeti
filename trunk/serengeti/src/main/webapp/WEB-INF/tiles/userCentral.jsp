<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="shadowText">
<p>Recently Checked In</p>
</div>

<div class="verticalMenu">
	<c:forEach var="visit" items="${recent}">
		<div class="miniProfile">
			<span class="miniProfilePic">
			<a href="${visit.user.id}"><img src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
			title="${visit.user.email}" width="50" height="50"/></a> </span>
			
			<span class="miniProfileName">	
			<a href="${visit.user.id}" ><c:out value="${visit.user.firstName} ${visit.user.lastName}"/></a></span>
			
				
		</div>
	
	</c:forEach>
</div>

<div class="shadowText">
<p>Most Active Users</p>
</div>

<div class="verticalMenu">
<c:forEach var="user" items="${mostActive}">
		<div class="miniProfile">
			<span class="miniProfilePic"><a href="${user.id}"><img
			src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
			title="${user.email}" width="50" height="50"/></a></span> 
			
			<span class="miniProfileName">
			<a href="${user.id}" ><c:out value="${user.firstName} ${visit.user.lastName}"/></a></span>
		</div>
	</c:forEach>
</div>

<div class="shadowText">
<p>Newest Users</p>
</div>


<div class="verticalMenu">
	<c:forEach var="user" items="${newest}">
		<div class="miniProfile">
			<span class="miniProfilePic"><a href="${user.id}"><img
			src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
			title="${user.email}" width="50" height="50"/></a></span>
			
			<span class="miniProfileName"> 
			<a href="${user.id}" ><c:out value="${user.firstName} ${visit.user.lastName}"/></a></span>
		</div>
	</c:forEach>
</div>





<!--
<div class="shadowText">
<p>Recently Checked In</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows"> <a id="leftArrow1" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a> 
</span>

<div class="centralScrollSpan">

<div id="scrollContainer">
<div id="recentlyCheckedIn"
	style="position: absolute; width: 400px; left: 0; top: 0;">


<div id="nscontainer" width=300 height=600 clip="0,0,300,160">
<div id="nscontent" width=300 height=600 visibility=hidden>INSERT CONTENT HERE

<ul class="hor_menu">
	<c:forEach var="visit" items="${recent}">
		<a href="${visit.user.id}"><img
			src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
			title="${visit.user.email}" width="50" height="50"/></a> 
			<a href="${visit.user.id}" ><c:out value="${visit.user.firstName}"/></a>
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
<p>Most Active Users</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows">
<a id="leftArrow2" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a>
</span>	

<div class="centralScrollSpan">

<div id="scrollContainer">
<div id="mostActive"
	style="position: absolute; width: 400px; left: 0; top: 0;">

<div id="nscontainer" width=300 height=600 clip="0,0,300,160">
<div id="nscontent" width=300 height=600 visibility=hidden>INSERT CONTENT HERE
<ul class="hor_menu">
	<c:forEach var="user" items="${mostActive}">
		<a href="${user.id}"><img
			src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
			title="${user.email}" width="50" height="50"/></a> 
			<a href="${user.id}" ><c:out value="${user.firstName} "/></a>
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
<p>Newest Users</p>
</div>

<div class="arrowsAndScroll">

<span class="allLeftArrows">
<a id="leftArrow3" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="160px" width="80px"></a>
</span>

<div class="centralScrollSpan">

<div id="scrollContainer">
<div id="newestUsers"
	style="position: absolute; width: 400px; left: 0; top: 0;">

<div id="nscontainer" width=300 height=600 clip="0,0,300,160">
<div id="nscontent" width=300 height=600 visibility=hidden>INSERT CONTENT HERE
<ul class="hor_menu">
	<c:forEach var="user" items="${newest}">
		<a href="${user.id}"><img
			src="${pageContext.request.contextPath}/images/default_user.png" alt="user"
			title="${user.email}" width="50" height="50"/></a> 
			<a href="${user.id}" ><c:out value="${user.firstName}"/></a>
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
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['recentlyCheckedIn','mostActive', 'newestUsers'],["rightArrow1", "rightArrow2", "rightArrow3"]);
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['recentlyCheckedIn','mostActive', 'newestUsers'],["rightArrow1", "rightArrow2", "rightArrow3"]);
</script>
-->