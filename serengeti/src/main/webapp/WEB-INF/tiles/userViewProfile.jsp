<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <c:choose>
            <c:when test='${!empty userCommand}'>
                <p>Here's the user profile you requested</p>

                <c:if test="${session.user.userId == userCommand.userId}">
                    <div class="thanks">
                        <p>Thank you for checking in.</p>
                    </div>
                    
                    <div class="checkin">
                        <p>Checkin from:</p>
                        <select name="checkinLocation" id="checkinLocation">
                            <c:forEach var="location" items="${nearbyLocations}">
                                <option value="${location.locationId}"><c:out value="${location.locationName}"/></option>
                            </c:forEach>
                        </select>
                    
                        <p>As a member of team:</p>
                        <select name="checkinTeam" id="checkinTeam">
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.id}"><c:out value="${team.name}"/></option>
                            </c:forEach>
                        </select>
                    
                        <button type="button" class="button">Check In</button>
                    </div>
                    
                </c:if>
                
                <table>
                    <tr>
                        <td><strong>Email Address: </strong></td>
                        <td><c:out value="${userCommand.email}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Display Name: </strong></td>
                        <td><c:out value="${userCommand.displayName}"/></td>
                    </tr>
                    <tr>
                        <td><strong>Profile Picture: </strong></td>
                        <td><c:out value="${userCommand.image}"/></td>
                    </tr>
                    
                    <strong>Friends: </strong>
                      <ul>
                          <c:forEach var="user" items="${friends}">
                              <li><a href="view?userId=${user.userId}"><c:out value="${user.displayName}"/></a></li>
                          </c:forEach>
                      </ul>
                   
                   <strong>Teams: </strong>
                   <ul>   
                     <c:forEach var="team" items="${teams}">
                          <li><a href="../team/view?teamId=${team.id}"><c:out value="${team.name}"/></a></li>
                      </c:forEach>
                   </ul> 
                </table>
                <c:if test="${session.user.userId == userCommand.userId}">
                    <a href="update?userId=${userCommand.userId}">Edit Profile</a><br/>
                </c:if>
            </c:when>
            <c:otherwise>
                <p>The user you requested does not exist.</p>
            </c:otherwise>
        </c:choose>

<script>
    $(function() {
        $(".thanks").hide();
        $(".button").click(function() {  
            $.get("checkIn", {userId : ${userCommand.userId}, teamId : $("select#checkinTeam").val(), 
                locationId : $("select#checkinLocation").val()}
            );
            $(".checkin").fadeOut("slow", function() {$(".thanks").fadeIn("slow");});  
                 
        });  
    });
</script>