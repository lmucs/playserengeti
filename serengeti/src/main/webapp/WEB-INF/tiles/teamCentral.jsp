<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 
 <div class="shadowText">
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
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->

<ul class="hor_menu">
	<c:forEach var="team" items="${leaders}">
		<li><a href="${team.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="team"
			title="${team.name}" /></a> <span><c:out value="${team.name}" />
		</span><a href="${team.name}" ><c:out value="${team.name}"/></a></li>
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
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->
<ul class="hor_menu">
	<c:forEach var="team" items="${mostActive}">
		<li><a href="${team.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${team.name}" /></a> <span><c:out value="${team.name}" />
		</span><a href="${team.name}" ><c:out value="${team.name}"/></a></li>
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
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->
<ul class="hor_menu">
	<c:forEach var="team" items="${newest}">
		<li><a href="${team.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${team.name}" /></a> <span><c:out value="${team.name}" />
		</span><a href="${team.name}" ><c:out value="${team.name}"/></a></li>
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



<script type="text/javascript">
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['mostTerritory','mostActive', 'newestTeams'],["rightArrow1", "rightArrow2", "rightArrow3"]);
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['mostTerritory','mostActive', 'newestTeams'],["rightArrow1", "rightArrow2", "rightArrow3"]);
</script>
 
 
 
 