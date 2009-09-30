<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>View User Profile</title>
    </head>
  
    <body>
        <c:choose>
            <c:when test='${ !empty user }'>
                <p>Here's the user profile you requested</p>
                <table>
                    <tr>
                        <td><strong>Login Name</strong></td>
                        <td><c:out value="${user.loginName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Display Name</strong></td>
                        <td><c:out value="${user.displayName}"/></td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <p>A user does not exist with that user ID.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>

