<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <c:choose>
            <c:when test='${ !empty user }'>
                <p>Here's the user profile you requested</p>
                <table>
                    <tr>
                      <td><string>User Id: </strong></td>
                      <td><c:out value="${user.userId}"/></td>
                    </tr>
                    <tr>
                        <td><strong>User Name: </strong></td>
                        <td><c:out value="${user.userName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>First Name: </strong></td>
                        <td><c:if test='${ !empty user.firstName }'>
                                <c:out value="${user.firstName}"/>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Last Name: </strong></td>
                        <td><c:if test='${ !empty user.lastName }'>
                                <c:out value="${user.lastName}"/>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Email: </strong></td>
                        <td><c:out value="${user.email}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Date of Birth: </strong></td>
                        <td><c:if test='${ !empty user.dateOfBirth }'>
                                <c:out value="${user.dateOfBirth}"/>
                            </c:if>
                        </td>
                    </tr>
                </table>
                <a href="update?userId=${user.userId}">Modify Users</a><br/>
                <a href="delete?userId=${user.userId}">Delete Users</a><br/>
                <a href="list">View All Users</a>
            </c:when>
            <c:otherwise>
                <p>The location you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

