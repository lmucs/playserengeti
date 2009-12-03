<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="shadowText">
<p>Recently Checked In</p>
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
	<c:forEach var="visit" items="${recent}">
		<li><a href="${visit.user.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${visit.user.email}" /></a> <span><c:out value="${visit.user.email}" />
		</span><a href="${visit.user.id}" ><c:out value="${visit.user.firstName}"/></a></li>
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
<p>Most Active Users</p>
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
	<c:forEach var="user" items="${mostActive}">
		<li><a href="${user.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${user.email}" /></a> <span><c:out value="${user.email}" />
		</span><a href="${user.id}" ><c:out value="${user.firstName}"/></a></li>
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
<p>Newest Users</p>
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
	<c:forEach var="user" items="${newest}">
		<li><a href="${user.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${user.email}" /></a> <span><c:out value="${user.email}" />
		</span><a href="${user.id}" ><c:out value="${user.firstName}"/></a></li>
	</c:forEach>
</ul>


<!--END CONTENT--></div>
</div>
</div>
</div>
</span>

<span class="allRightArrows"><a
	id="rightArrow3" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="160px" width="80px"></a>
</span>

</div>

<!-- 
<div id="arrows"><a id="leftArrow3" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="50px" width="50px"></a> <a
	id="rightArrow3" href="#" onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="50px" width="50px"></a></div>
 -->



<script type="text/javascript">
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['recentlyCheckedIn','mostActive', 'newestUsers'],["rightArrow1", "rightArrow2", "rightArrow3"]);
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['recentlyCheckedIn','mostActive', 'newestUsers'],["rightArrow1", "rightArrow2", "rightArrow3"]);
</script>
