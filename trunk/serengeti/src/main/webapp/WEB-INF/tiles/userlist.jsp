<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>All of the Users</title>
    </head>

    <body>
        <p>Here are all the users</p>

        <table>
            <tr>
                <th>Id</th>
                <th>Login Name</th>
                <th>Display Name</th>
            </tr>
            <c:forEach var="user" items="${allUsers}">
                <tr>
                    <td>${user.id}</td>
                    <td><c:out value="${user.loginName}"/></td>
                    <td><c:out value="${user.displayName}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
