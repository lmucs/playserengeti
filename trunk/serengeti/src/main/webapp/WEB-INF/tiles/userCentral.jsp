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

<p> </p>



<div id="scrollContainer">
<div id="scrollContent" class="recentlyCheckedIn" style="position: absolute; width: 400px; left: 0; top: 0;">



<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->

<ul class="hor_menu">
	<c:forEach var="user" items="${recent}">
		<li><a href="${user.id}" ><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${user.email}" /></a> <span><c:out
			value="${user.email}" /> </span></li>
	</c:forEach>
</ul>

<!--END CONTENT--></div>
</div>
</div>
</div>
<div id="arrows">
<a href="#" onmouseover="moveLeft()" onmouseout="clearTimeout(moveLeftVar)"><img src="../images/leftArrow.png" height="50px" width="50px"></a> 
<a href="#" onmouseover="moveRight()" onmouseout="clearTimeout(moveRightVar)"><img src="../images/rightArrow.png" height="50px" width="50px"></a>
</div>


<div id="scrollContainer">
<div id="scrollContent" class="mostActiveUsers" style="position: absolute; width: 400px; left: 0; top: 0;">

<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->
<ul class="hor_menu">
	<c:forEach var="user" items="${mostActive}">
		<li><a href="${user.id}" ><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${user.email}" /></a> <span><c:out
			value="${user.email}" /> </span></li>
	</c:forEach>
</ul>


<!--END CONTENT--></div>
</div>
</div>
</div>
<div id="arrows">
<a href="#" onmouseover="moveLeft()" onmouseout="clearTimeout(moveLeftVar)"><img src="../images/leftArrow.png" height="50px" width="50px"></a> 
<a href="#" onmouseover="moveRight()" onmouseout="clearTimeout(moveRightVar)"><img src="../images/rightArrow.png" height="50px" width="50px"></a>
</div>

<div id="scrollContainer">
<div id="scrollContent" class="newestUsers" style="position: absolute; width: 400px; left: 0; top: 0;">

<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
<div id="nscontent" width=300 height=160 visibility=hidden><!--INSERT CONTENT HERE-->
<ul class="hor_menu">
	<c:forEach var="user" items="${newest}">
		<li><a href="${user.id}" ><img
			src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user"
			title="${user.email}" /></a> <span><c:out
			value="${user.email}" /> </span></li>
	</c:forEach>
</ul>


<!--END CONTENT--></div>
</div>
</div>
</div>
<div id="arrows">
<a href="#" onmouseover="moveLeft()" onmouseout="clearTimeout(moveLeftVar)"><img src="../images/leftArrow.png" height="50px" width="50px"></a> 
<a href="#" onmouseover="moveRight()" onmouseout="clearTimeout(moveRightVar)"><img src="../images/rightArrow.png" height="50px" width="50px"></a>
</div>
	
  <script ="text/javascript">
	scrollbar(["recentlyCheckedIn", "mostActiveUsers", "newestUsers"]);
</script>
        	
<script type="text/javascript">

var scrollbar = function(idsToTouch){
	

	var moveRightVar=null;
	var moveLeftVar=null;
	//specify speed of scroll (greater=faster)
	var speed=5;
	var divs = [];
	var i = 0;

		for (i = 0; i < idsToTouch.length; i++) {
			divs[i] = idsToTouch[i];
		}

		divs[i].mousemove(createHandler(divs[i]));

		var createHandler = function(div) {
			return function(e) {

		var crossobj=document.getElementById(div); 
		var contentWidth = crossobj.offsetWidth; 
		
		function moveRight(){
			
			if (parseInt(crossobj.style.left,10)>=(contentWidth*(-1)+100)){
				crossobj.style.left=parseInt(crossobj.style.left,10)-speed+"px";
		        }
			moveRightVar=setTimeout(moveRight,20);
			}

		function moveLeft(){
			
			if (parseInt(crossobj.style.left,10)<=0){
				crossobj.style.left=parseInt(crossobj.style.left,10)+speed+"px";
		        }
			moveLeftVar=setTimeout(moveLeft,20);

		}


		function getContent_Width(){
			var crossobj=idToTouch;
			var contentWidth = crossobj.offsetWidth;
		}
		window.onload=getContent_Width('recentlyCheckedIn');
			};
		};
	};
</script>
