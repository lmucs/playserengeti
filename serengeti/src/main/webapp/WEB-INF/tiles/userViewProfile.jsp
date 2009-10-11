<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <c:choose>
            <c:when test='${ !empty user }'>
                <p>Here's the user profile you requested</p>
                <table>
                    <tr>
                        <td><strong>User Name</strong></td>
                        <td><c:out value="${user.userName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Email Address</strong></td>
                        <td><c:out value="${user.email}"/></td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <p>A user does not exist with that user ID.</p>
            </c:otherwise>
        </c:choose>
