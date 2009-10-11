<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
    <head>
        <title>
            <tiles:insertAttribute name="title" value="${title}"/>
        </title>
        <link rel="stylesheet" type="text/css"
            href="${pageContext.request.contextPath}/styles/serengeti.css"
        />
        <script type="text/javascript"
            src="${pageContext.request.contextPath}/scripts/serengeti.js">
        </script>
    </head>

    <body>
        <a href="/serengeti"><img src="${pageContext.request.contextPath}/images/serengeti-logo-full.png"
            alt="logo" style="float:right" height="20%" width="20%" border="0" />
        </a>
        <tiles:insertAttribute name="header"/>
        <div class="mainContentArea">
            <tiles:insertAttribute name="body"/>
        </div>
        <tiles:insertAttribute name="footer"/>
    </body>
</html>
