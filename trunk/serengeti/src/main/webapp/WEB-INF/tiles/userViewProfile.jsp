<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="lookingAtYourself">${session.loggedIn && (session.user.id == userCommand.userId)}</c:set>

<c:choose>
    <c:when test='${!empty userCommand}'>
        <c:if test="${session.loggedIn && (session.user.id != userCommand.userId)}">
            <div id="othersProfile">
                <div id="sendInvites">
                    <c:if test="${!alreadyFriends}">
                        <div id="inviteFriend">
                            <input type="button" value="Send Friend Request" onClick="sendFriendInvite(${userCommand.userId}, ${session.user.id})"/>
                        </div>
                    </c:if>
                    <c:if test="${!empty invitableTeams}">
                        <div id="inviteTeam">
                            <select id="teamInviteSelect">
                                <c:forEach var="team" items="${invitableTeams}">
                                    <option value="${team.id}"><c:out value="${team.name}"/></option>;
                                </c:forEach>
                            </select>
                            <input type="button" value="Send Team Invitation" onClick="sendTeamInvite(${userCommand.userId})"/>
                        </div>
                    </c:if>
                </div>
            </div>
        </c:if>
        <div class="grid_10">
          <div class="grid_3">
              <div id="profileImage">
		          <img src="${pageContext.request.contextPath}/images/default_user.png" height="150" width="150" alt="Profile Picture"
		            title="Profile Picture"/>
		      </div>
	            
	          <div class="clear">&nbsp;</div>
	          <c:if test="${lookingAtYourself}">
	              <div class="grid_3">
	                  <a href="update/${userCommand.userId}">Modify your profile</a>
	              </div> 
	          </c:if>
          </div>
          <div id="userInfo" class="grid_6">
              <h3 id="name"><c:out value="${userCommand.firstName} ${userCommand.lastName}"/></h3>
              <div id="userViewEmail">
                  <p id="email"><c:out value="${userCommand.email}"/></p>
              </div>
          </div>
      </div>
      <div class="clear">&nbsp;</div>
      <div class="grid_7">
          <c:if test="${lookingAtYourself}">
              <div id="ownProfile">             
                  <div class="grid_7" id="checkIn">
                      <div class="grid_4" id="locList">
                          <p>Checkin from:</p>
                          <select id="locSelect" size="4"></select>
                          <input id="notHere" type="button" value="Not Here?" onclick="showSearch()"/>
                      </div>
                      <div class="clear">&nbsp;</div>
                      <div class="grid_4" id="locSearch">
                          <input id="searchText" type="text" value="Where are you?"/>
                          <input type="button" value="Search" onclick="searchLoc()"/>
                      </div>
                      <div class="grid_4"  id="teamList">
                          <p>As team:</p>
                          <c:choose>
                              <c:when test="${!empty userCommand.teams}">
                                  <select id="teamSelect">
                                      <c:forEach var="team" items="${userCommand.teams}">
                                          <option value="${team.id}"><c:out value="${team.name}"/></option>
                                      </c:forEach>
                                  </select>
                                  <div class="clear">&nbsp;</div>
                                  <div class="grid_1" id="checkinButton">
                                      <input type="button" value="Check In" onclick="checkIn(${session.user.id})"/>
                                  </div>
                              </c:when>
                              <c:otherwise>
                                  <p>You aren't a member of any teams yet.  Ask a friend to invite you to one
                                  or <a href="../team/create">make your own.</a></p>
                              </c:otherwise>
                          </c:choose>
                      </div>
                  </div>
                  <div class="clear">&nbsp;</div>
                  <c:if test="${!empty friendInvites || !empty teamInvites}">
                     <div class="grid_7 round_Box_Container">
                        <c:if test="${!empty friendInvites}">
                             <div class="grid_6" id="friendRequests">
                                 <p>These people want to be your friend.</p>
                                <ul id="friendRequestList">
                                    <c:forEach var="user" items="${friendInvites}">
                                        <li id="friendInvite_${user.id}">
                                        <a href="${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a>
                                        <button onClick="acceptFriendInvite(${user.id}, ${session.user.id})">I'll allow it</button>
                                        <button onClick="rejectFriendInvite(${user.id}, ${session.user.id})">Not Interested</button></li>
                                    </c:forEach>
                                 </ul>
                            </div>
                        </c:if>
                        <c:if test="${!empty teamInvites}">
                            <div class="grid_7" id="teamRequests">
                                 <p>You have been invited to the following teams.</p>
                                <ul id="teamRequestList">
                                    <c:forEach var="team" items="${teamInvites}">
                                        <li id="teamInvite_${team.id}">
                                        <a href="../team/${team.id}"><c:out value="${team.name}"/></a>
                                        <button onClick="acceptTeamInvite(${team.id}, ${session.user.id})">I'll allow it</button>
                                         <button onClick="rejectTeamInvite(${team.id}, ${session.user.id})">Not Interested</button></li>
                                    </c:forEach>
                                 </ul>
                            </div>
                        </c:if>
                     </div>
                 </c:if>
              </div>
          </c:if>
          <div class="clear">&nbsp;</div>
          <div class="grid_7 activityBoxContainer activityScroller">
              <div class="grid_6">
                  <div class="shadowText">Friend Activity</div>
                  <ul id="activity">
                      <c:choose>
                          <c:when test="${!empty friendActivity}">
                              <c:forEach var="visit" items="${friendActivity}">
                                  <li><a href="${visit.user.id}"><c:out value="${visit.user.fullName}"/></a> @ <a href="../location/${visit.location.id}"><c:out value="${visit.location.name}"/></a>
                                  (<fmt:formatDate pattern="MMM dd, yyyy hh:mma" value="${visit.date}"/>)</li>
                              </c:forEach>
                          </c:when>
                          <c:otherwise>
                              <c:choose>
                                  <c:when test="${lookingAtYourself}">
                                      <p>Your friends haven't done anything yet.</p>
                                  </c:when>
                                  <c:otherwise>
                                      <p>${userCommand.firstName}'s friends haven't done anything yet.</p>
                                  </c:otherwise>
                              </c:choose>
                          </c:otherwise>
                      </c:choose>
                  </ul>
              </div>
          </div>
          <div class="clear">&nbsp;</div>
          <div class="grid_7 activityBoxContainer activityScroller">
              <div class="grid_6">
                  <div class="shadowText">Recent Activity</div>
                  <c:choose>
                      <c:when test="${!empty activity}">
                          <ul id="activity">
                              <c:forEach var="visit" items="${activity}">
                                  <li>@ <a href="../location/${visit.location.id}"><c:out value="${visit.location.name}"/></a>
                                  (<fmt:formatDate pattern="MMM dd, yyyy hh:mma" value="${visit.date}"/>)</li>
                              </c:forEach>
                          </ul>
                      </c:when>
                      <c:otherwise>
                          <c:choose>
                              <c:when test="${lookingAtYourself}">
                                  <p>You haven't done anything yet.</p>
                              </c:when>
                              <c:otherwise>
                                  <p>${userCommand.firstName} hasn't done anything yet.</p>
                              </c:otherwise>
                          </c:choose>
                      </c:otherwise>
                  </c:choose>
              </div>
          </div>
          

      </div>
        <div class="grid_3 prefix_1">
        <div class="grid_3 round_Box_Container userExtendingDiv">
        <div class="grid_2">
             <div class="shadowText">Friends: </div>
        </div>
        <div class="grid_3">
            <ul id="friends">
                <c:choose>
                    <c:when test="${!empty userCommand.friends}">
                        <c:forEach var="user" items="${userCommand.friends}">
                            <li><a href="${user.id}"><c:out value="${user.firstName} ${user.lastName}"/></a></li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${lookingAtYourself}">
                                <p>You don't have any friends yet.</p>
                            </c:when>
                            <c:otherwise>
                                <p>${userCommand.firstName} doesn't have any friends yet.</p>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>    
            </ul>
        </div>
      </div>
      <div class="grid_3 round_Box_Container userExtendingDiv">
        <div class="grid_2">
            <div class="shadowText">Teams: </div>
        </div>
        <div class="grid_3">
          <ul id="teams">
              <c:choose>
                  <c:when test="${!empty userCommand.teams}">
                      <c:forEach var="team" items="${userCommand.teams}">
                          <li><a href="../team/${team.id}"><c:out value="${team.name}"/></a></li>
                      </c:forEach>
                  </c:when>
                  <c:otherwise>
                      <c:choose>
                          <c:when test="${lookingAtYourself}">
                              <p>You aren't a member of any teams yet.</p>
                          </c:when>
                          <c:otherwise>
                              <p>${userCommand.firstName} isn't a member of any teams yet.</p>
                          </c:otherwise>
                      </c:choose>
                  </c:otherwise>
              </c:choose>
          </ul>
        </div>
      </div>
    </div>

    </c:when>
    <c:otherwise>
        <p>The user you requested does not exist.</p>
    </c:otherwise>

</c:choose>
<div id="popupContent">
    <a id="popupContentClose">X</a>
    <h1>Contratulations!</h1>
    <p>You just claimed a territory for your team.</p>
    <p>I bet your team will be really proud of you.  I know I am.</p>
    <input type="button" value="Sweet! GO ME!" onclick="disablePopup()"/>
</div>
<div id="popupBackground"></div>

<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/popup.js"></script>
<c:if test="${session.loggedIn}">
  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/invite.js"></script>
  <c:if test="${session.user.id == userCommand.userId}">
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/checkIn.js"></script>
  </c:if>
</c:if>

