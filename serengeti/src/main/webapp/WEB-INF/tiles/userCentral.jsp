<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="grid_3 prefix_1">
<div class="shadowText">
<p>Recently Checked In</p>
</div>
</div>

<div class="grid_3 prefix_1">
<div class="shadowText">
<p>Most Active Users</p>
</div>
</div>

<div class="grid_3 prefix_1">
<div class="shadowText">
<p>Newest Users</p>
</div>
</div>

<p></p>



<div id="scrollContainer">
<div id="recentlyCheckedIn" 
	style="position: absolute; width: 400px; left: 0; top: 0;">



<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->

<ul class="hor_menu">
	<c:forEach var="user" items="${recent}">
		<li><a href="${user.id}"><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${user.email}" /></a> <span><c:out value="${user.email}" />
		</span></li>
	</c:forEach>
</ul>

<!--END CONTENT--></div>
</div>
</div>
</div>
<div id="arrows"><a id="leftArrow1" href="#" 
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="50px" width="50px"></a> <a
	id="rightArrow1" href="#" 
	onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="50px" width="50px"></a></div>


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
		</span></li>
	</c:forEach>
</ul>


<!--END CONTENT--></div>
</div>
</div>
</div>
<div id="arrows"><a id="leftArrow2" href="#" 
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="50px" width="50px"></a> <a
	id="rightArrow2" href="#" 
	onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="50px" width="50px"></a></div>

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
		</span></li>
	</c:forEach>
</ul>


<!--END CONTENT--></div>
</div>
</div>
</div>
<div id="arrows"><a id="leftArrow3" href="#"
	onmouseout="clearInterval(moveLeftVar)"><img
	src="../images/leftArrow.png" height="50px" width="50px"></a> <a
	id="rightArrow3" href="#" 
	onmouseout="clearInterval(moveRightVar)"><img
	src="../images/rightArrow.png" height="50px" width="50px"></a></div>


<script type="text/javascript">
var moveRightVar=null;
var moveLeftVar=null;
var speed=5;

var scrollbar = function(leftArrowIds, scrollAreaIds, rightArrowIds){
	
	
	
	//specify speed of scroll (greater=faster)
	
	var divs = [];
	var i = 0;

		for (i = 0; i < leftArrowIds.length; i++) {
			var leftArrow = document.getElementById(leftArrowIds[i]);
			var scrollArea = document.getElementById(scrollAreaIds[i]);
			var rightArrow = document.getElementById(rightArrowIds[i]);

			leftArrow.onmouseover = createMoveLeftHandler(scrollArea);
			rightArrow.onmouseover = createMoveRightHandler(scrollArea);
		}

};

var createMoveRightHandler = function(div) {
	return function(e) {
		moveRightVar = setInterval(function() { moveRight(div); }, 20);
	};
};

var createMoveLeftHandler = function(div) {
	return function(e) {
		moveLeftVar = setInterval(function() { moveLeft(div); }, 20);
	};
};
		
		function moveRight(crossobj){
			var contentWidth = crossobj.offsetWidth;
			if (parseInt(crossobj.style.left,10)>=(contentWidth*(-1)+100)){
				crossobj.style.left=parseInt(crossobj.style.left,10)-speed+"px";
		        }
//			moveRightVar=setTimeout(moveRight,20);
			}

		function moveLeft(crossobj){
			var contentWidth = crossobj.offsetWidth;
			if (parseInt(crossobj.style.left,10)<=0){
				crossobj.style.left=parseInt(crossobj.style.left,10)+speed+"px";
		        }
//			moveLeftVar=setTimeout(moveLeft,20);

		}


		function getContent_Width(crossobj){
		      contentWidth=crossobj.offsetWidth;
		}
		window.onload=getContent_Width('recentlyCheckedIn');
		

	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['recentlyCheckedIn','mostActive', 'newestUsers'],["rightArrow1", "rightArrow2", "rightArrow3"]);
	scrollbar(["leftArrow1", "leftArrow2", "leftArrow3"],['recentlyCheckedIn','mostActive', 'newestUsers'],["rightArrow1", "rightArrow2", "rightArrow3"]);
</script>
