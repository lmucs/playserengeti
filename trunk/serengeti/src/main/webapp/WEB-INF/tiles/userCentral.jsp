<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <div class="mainContentArea">
        <div class="hor_menu recentlyCheckedIn">
	        <div>
	            <p>Recently Checked In</p>
	        </div>
	        <ul class="hor_menu recentlyCheckedIn">
	            <c:forEach var="user" items="${recent}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.displayName}"/>
	                   <span>
	                       <a href="${user.userId}"><c:out value="${user.displayName}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	       
	        
	    </div>
        <div class="hor_menu mostActiveUsers">
            <div>
	        	<p>Most Active Users</p>
	        </div>
	        <ul class="hor_menu mostActiveUsers">
	            <c:forEach var="user" items="${mostActive}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.displayName}"/>
	                   <span>
	                       <a href="${user.userId}"><c:out value="${user.displayName}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	       
        
        </div>
        <div class="hor_menu newestUsers">
            <div>
        		<p>Newest Users</p>
            </div>
	        <ul class="hor_menu newestUsers">
	            <c:forEach var="user" items="${newest}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.displayName}"/>
	                   <span>
	                       <a href="${team.userId}"><c:out value="${user.displayName}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	 <script type="text/javascript">
            scrollbar(["recentlyCheckedIn", "mostActiveUsers", "newestUsers"]);
        </script>      
        
	    </div>
    </div>
