<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <div class="grid_3 prefix_1">
	        <p>Recently Checked In</p>
	    </div>
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
	    <div class="grid_3 prefix_1">
	        <p>Most Active Users</p>
	    </div>
        <div class="hor_menu mostActiveUsers grid_6">
	        <ul class="hor_menu mostActiveUsers">
	            <c:forEach var="user" items="${mostActive}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="user" title="${user.displayName}"/>
	                   <span>
	                       <a href="${user.id}"><c:out value="${user.email}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	       
        
        </div>
        <div class="grid_3 prefix_1">
            <p>Newest Users</p>
        </div>
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
    </div>
