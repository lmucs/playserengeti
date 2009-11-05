<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <div class="grid_3 prefix_4">
	        <p>Teams With the Most Territory</p>
	    </div>
	    <div class="clear">&nbsp;</div>
	    
        <div class="hor_menu">
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
	    <div class="grid_3 prefix_4">
	        	<p>Most Active Teams</p>
	    </div>
        <div class="clear">&nbsp;</div>
        <div class="hor_menu">
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
            <p>Newest Teams</p>
        </div>
        <div class="clear">&nbsp;</div>
        <div class="grid_10 prefix_1">
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
