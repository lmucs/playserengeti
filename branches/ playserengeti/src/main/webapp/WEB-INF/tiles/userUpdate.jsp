<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


      <c:choose>
            <c:when test='${ !empty updateUser}'>
                <p>Modify your user's settings.</p>
                <p><strong><c:out value="${updateUser.userName}"/></strong></p>
                <p>
                    <form method="post" action="update">
                        <label for="userName">User Name: </label><input type="text" name="userName"/><br/>
                        <label for="firstName">First Name: </label><input type="text" name="firstName"/><br/>
                        <label for="lastName">Last Name: </label><input type="text" name="lastName"/><br/>
                        <label for="email">Email: </label><input type="text" name="email"/><br/>
                        <label for="dateOfBirth">Date of Birth: </label><input type="text" name="dateOfBirth"/><br/>
                        <input type="submit" value="Modify User!"/>
                    </form>
                </p>
            </c:when>
            <c:otherwise>
                <p>Which ID would you like to update?</p>
        		<p>
                    <form method="get" action="update">
                        <label for="userID"> User ID </label><input type="text" name="userID"/><br/>
                        <input type="submit" value="Update ID"/>
                    </form>
                </p>
            </c:otherwise>
        </c:choose>