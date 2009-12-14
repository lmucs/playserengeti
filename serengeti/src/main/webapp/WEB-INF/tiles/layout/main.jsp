<?xml version="1.0" encoding="utf-8" ?>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><tiles:insertAttribute name="title" value="${title}"/> - Serengeti</title>
    <link rel="stylesheet" type="text/css"
      media="screen and (min-device-width: 481px)"
      href="${pageContext.request.contextPath}/styles/serengeti.css"
    />
    <link rel="stylesheet" type="text/css"
      media="screen screen and (min-device-width: 481px)"
      href="${pageContext.request.contextPath}/styles/960.css"
    />
    <link rel="stylesheet" type="text/css"
      media="only screen and (max-device-width: 480px)"
      href="${pageContext.request.contextPath}/styles/serengeti-mobile.css"
    />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/serengeti.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/scrollbar.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/json2.js" type="text/javascript"></script>
  </head>

  <body>
    <tiles:insertAttribute name="header"/>

    <div id="container">
      <div class="mainContentArea container_12">
        <h1 class="pagetitle">
          <tiles:insertAttribute name="title" value="${title}"/>
        </h1>
        <tiles:insertAttribute name="body"/>
      </div>
    </div>

    <script src="${pageContext.request.contextPath}/scripts/inputbox.js" type="text/javascript"></script>

    <tiles:insertAttribute name="footer"/>
  </body>
</html>
