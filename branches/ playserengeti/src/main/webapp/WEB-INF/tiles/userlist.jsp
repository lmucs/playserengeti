<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <p>Here are all the users</p>

        <table>
            <tr>
                <th>Id</th>
                <th>Login Name</th>
                <th>Display Name</th>
            </tr>
            <c:forEach var="user" items="${allUsers}">
                <tr>
                    <td>${user.userId}</td>
                    <td>
                        <a href="view?userId=${user.userId}"><c:out value="${user.userName}"/></a>
                    </td>
                    <td><c:out value="${user.email}"/></td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="create">Create a user account?</a></p>
