<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>
            <tiles:insertAttribute name="title" value="${title}"/>
        </title>
        <link rel="stylesheet" type="text/css"
            href="${pageContext.request.contextPath}/styles/serengeti.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/960.css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js"
            type="text/javascript">
        </script>
        <script type="text/javascript"
            src="${pageContext.request.contextPath}/scripts/jquery-1.3.2.min.js">
        </script>
        <script type="text/javascript"
            src="${pageContext.request.contextPath}/scripts/serengeti.js">
        </script>
        <script type="text/javascript"
            src="${pageContext.request.contextPath}/scripts/scrollbar.js">
        </script>
        <script type="text/javascript"
            src="${pageContext.request.contextPath}/scripts/json2.js">
        </script>

    </head>

    <body>

    <div id="container">
    <div id="header">
        <img src="${pageContext.request.contextPath}/images/banner.jpg"/>
        <map id="hmap" name ="hmap">
            <area href="${pageContext.request.contextPath}/" shape="rect" coords="18,0, 356, 129"/>
        <div id="navbar2">
          <ul>
              <li><a href="${pageContext.request.contextPath}/">Home  </a></li>
              <c:if test="${session.loggedIn}">
                  <li><a href="${pageContext.request.contextPath}/user/${session.user.id}" >Profile</a></li>
              </c:if>
              <li><a href="${pageContext.request.contextPath}/user">Users</a></li>
              <li><a href="${pageContext.request.contextPath}/team">Teams</a></li>
              <li><a href="${pageContext.request.contextPath}/location">Locations</a></li>
              <li><a href="link5.html ">Help</a></li>
              <li><a href="link6.html ">Settings</a></li>
              <c:if test="${session.loggedIn}">
                  <li><a href="${pageContext.request.contextPath}/user/logout">Log Out</a></li>
              </c:if>
          </ul>
      </div>
    </div>
</div>









          <tiles:insertAttribute name="header"/>



          <div class="mainContentArea container_12">
              <tiles:insertAttribute name="login"/>
              <tiles:insertAttribute name="body"/>
          </div>

          <tiles:insertAttribute name="footer"/>
    </body>
</html>
