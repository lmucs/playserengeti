<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <div class="hor_menu">
	        <div>
	            <p>Teams With the Most Territory</p>
	        </div>
	        <ul class="hor_menu">
	            <c:forEach var="team" items="${leaders}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="team"/>
	                   <span>
	                       <a href="${team.id}"><c:out value="${team.name}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
	    </div>
        <div class="hor_menu">
            <div>
	        	<p>Most Active Teams</p>
	        </div>
	        <ul class="hor_menu">
	            <c:forEach var="team" items="${mostActive}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="team"/>
	                   <span>
	                       <a href="${team.id}"><c:out value="${team.name}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
        </div>
        <div class="hor_menu">
            <div>
        		<p>Newest Teams</p>
            </div>
	        <ul class="hor_menu">
	            <c:forEach var="team" items="${newest}">
	               <li>
	                   <img src="${pageContext.request.contextPath}/images/avatar.jpg" alt="team"/>
	                   <span>
	                       <a href="${team.id}"><c:out value="${team.name}"/></a>
	                   </span>
	               </li>
	            </c:forEach>
	        </ul>
        <c:if test="${session.loggedIn}">
            <p><a href="create">Create a new team?</a></p>
        </c:if>
        <script type="text/javascript">
            scrollbar();
        </script>
    </div>
