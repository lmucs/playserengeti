<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <div class="grid_3 prefix_1">
	        <p>Recently Checked In</p>
	    </div>
 <!--  
	      <div class="hor_menu recentlyCheckedIn grid_6">
	        <ul class="hor_menu recentlyCheckedIn">
	            <c:forEach var="user" items="${recent}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.email}"/>
	                   <span>
	                       <a href="${user.id}"><c:out value="${user.email}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	     </div>
-->	     
	    <div class="grid_3 prefix_1">
	        <p>Most Active Users</p>
	    </div>
<!--	    
        <div class="hor_menu mostActiveUsers grid_6">
	        <ul class="hor_menu mostActiveUsers">
	            <c:forEach var="user" items="${mostActive}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.email}"/>
	                   <span>
	                       <a href="${user.id}"><c:out value="${user.email}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>	       
        </div>
-->        
        <div class="grid_3 prefix_1">
            <p>Newest Users</p>
        </div>
<!--        
        <div class="hor_menu newestUsers grid_6">
	        <ul class="hor_menu newestUsers">
	            <c:forEach var="user" items="${newest}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.email}"/>
	                   <span>
	                       <a href="${user.id}"><c:out value="${user.email}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	        
	 <script type="text/javascript">
            scrollbar(["recentlyCheckedIn", "mostActiveUsers", "newestUsers"]);
        </script>      
        
	    </div>
-->	    
	     <script type="text/javascript">
/******************************************
* Scrollable content script II- © Dynamic Drive (www.dynamicdrive.com)
* Visit http://www.dynamicdrive.com/ for full source code
* This notice must stay intact for use
******************************************/

var iens6=document.all||document.getElementById;
var ns4=document.layers;
var moveRightVar=null;
var moveLeftVar=null;

//specify speed of scroll (greater=faster)
var speed=5

if (iens6){
document.write('<div id="container" style="position:relative;width:300px;height:160px;border:1px solid black;overflow:hidden">')
document.write('<div id="content" style="position:absolute;width:300px;left:0;top:0">')
}
</script>

	<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
	<div id="nscontent" width=300 height=160 visibility=hidden>

<!--INSERT CONTENT HERE-->

	        <ul class="hor_menu recentlyCheckedIn">
	            <c:forEach var="user" items="${recent}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.email}"/>
	                   <span>
	                       <a href="${user.id}"><c:out value="${user.email}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>

<!--END CONTENT-->

	</div>
	</div>
	
<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
	<div id="nscontent" width=300 height=160 visibility=hidden>

<!--INSERT CONTENT HERE-->
<ul class="hor_menu mostActiveUsers">
	            <c:forEach var="user" items="${mostActive}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.email}"/>
	                   <span>
	                       <a href="${user.id}"><c:out value="${user.email}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	        

<!--END CONTENT-->

	</div>
	</div>
	
	<div id="nscontainer" width=300 height=160 clip="0,0,300,160">
	<div id="nscontent" width=300 height=160 visibility=hidden>

<!--INSERT CONTENT HERE-->
<ul class="hor_menu newestUsers">
	            <c:forEach var="user" items="${newest}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.email}"/>
	                   <span>
	                       <a href="${user.id}"><c:out value="${user.email}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	        

<!--END CONTENT-->

	</div>
	</div>
	
	

<script language="JavaScript1.2">
if (iens6)
document.write('</div></div>')
</script>

<div id="arrows" style="float: right">
<a href="#" onmouseover="moveLeft()" onmouseout="clearTimeout(moveLeftVar)"><img src="../images/leftArrow.png" height="50px" width="50px"></a> 
<a href="#" onmouseover="moveRight()" onmouseout="clearTimeout(moveRightVar)"><img src="../images/rightArrow.png" height="50px" width="50px"></a>
</div>


<script language="JavaScript1.2">
if (iens6){
	var crossobj=document.getElementById? document.getElementById("content") : document.all.content;
	var contentheight=crossobj.offsetHeight;
	var contentWidth = crossobj.offsetWidth;
	}
	else if (ns4){
	var crossobj=document.nscontainer.document.nscontent;
	var contentheight=crossobj.clip.height;
	var contentWidth = crossobj.clip.width;
	}

	function moveRight(){
		if (iens6&&parseInt(crossobj.style.left,10)>=(contentWidth*(-1)+100)){
			crossobj.style.left=parseInt(crossobj.style.left,10)-speed+"px";
	        }
		else if (ns4&&crossobj.left>=(contentWidth*(-1)+100)){
			crossobj.left-=speed;
	        }
		moveRightVar=setTimeout(moveRight,20);
		}

	function moveLeft(){
		if (iens6&&parseInt(crossobj.style.left,10)<=0){
			crossobj.style.left=parseInt(crossobj.style.left,10)+speed+"px";
	        }
		else if (ns4&&crossobj.left<=0){
			crossobj.left+=speed;
	        }
		moveLeftVar=setTimeout(moveLeft,20);

	}

	function getContent_Width(){
	if (iens6){
	      contentWidth=crossobj.offsetWidth;
	 }
	else if (ns4){
	      document.nscontainer.document.nscontent.visibility="show";
	 }
	}
	window.onload=getContent_Width();
</script>
    
