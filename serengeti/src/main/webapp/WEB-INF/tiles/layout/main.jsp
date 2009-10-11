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
        <tiles:insertAttribute name="header"/>

        <%-- Right-floated big logo, linked to home --%>
        <div class="mainlogo">
            <a href="${pageContext.request.contextPath}/"><img
            src="${pageContext.request.contextPath}/images/logo-full-116.png"
            alt="logo" /></a>
        </div>

        <%-- Page title prefixed with small tree linked to home --%>
        <div class="pagetitle">
            <a href="${pageContext.request.contextPath}/"><img
            src="${pageContext.request.contextPath}/images/logo-tree-32.png"
            alt="logo" /></a>
            <tiles:insertAttribute name="title" value="${title}"/>
        </div>

        <div class="mainContentArea">
            <tiles:insertAttribute name="body"/>
        </div>

        <tiles:insertAttribute name="footer"/>
    </body>
</html>
