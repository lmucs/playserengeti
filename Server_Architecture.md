The Serengeti server is a Java web application with the following components
  * Configuration
    * web.xml
    * spring-servlet.xml (MVC)
    * application-context.xml (data source, transactions)
    * IBATIS sql maps, Tiles defs, UrlRewrite rules
  * Domain Objects – just POJOs (thx Spring)!
  * Controllers, commands, validators
  * Services
  * Daos
  * UI: JSP, JSTL, Tiles, CSS, Scripts

## Domain Classes ##
<img src='http://playserengeti.googlecode.com/files/DomainsUMLwtrans.png'>

<h2>Controllers and URIs</h2>

Controllers are an intermediate layer in between the front-end Java Service Pages and the services themselves.  Controllers gather the information together and pass it to the .jsps to be rendered by the client.  It is important for the controllers to stay away from implementing business logic and to rely on the Services to perform such operations.  The controller classes are: <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/AvatarController.java'>AvatarController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/HelpController.java'>HelpController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/LocationController.java'>LocationController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/LocationCreateController.java'>LocationCreateController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/SearchController.java'>SearchController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/TeamController.java'>TeamController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/TeamCreateController.java'>TeamCreateController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/TeamUpdateController.java'>TeamUpdateController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserCreateController.java'>UserCreateController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserDeleteController.java'>UserDeleteController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserLoginController.java'>UserLoginController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserUpdateController.java'>UserUpdateController</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/WelcomeController.java'>WelcomeController</a>

URIs are the way that clients communicate with the application.  Serengeti is capable of returning data in the form of XML and JSON, as well as a Java Server Page based on the "format" parameter.  A brief description of each follows.<br>
<br>
<br>
Note:  Root URL is <a href='http://www.playserengeti.com'>http://www.playserengeti.com</a>

URL: /<br>
<blockquote>Description:<br>
<blockquote>Gets the playserengeti.com home page.<br>
</blockquote>Parameters:<br>
<blockquote>none<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/WelcomeController.java'>WelcomeController</a></blockquote></blockquote>

URL: /user OR /user/central<br>
<blockquote>Description:<br>
<blockquote>Gets the user central page. Contains interesting information about users.<br>
</blockquote>Parameters:<br>
<blockquote>format (optional) → Specify the format of the response.  Either “xml” or “json”.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/$id$<br>
<blockquote>Description:<br>
<blockquote>Gets the given user's profile page.  Uses a url rewrite so the url can be specified as “/user/2/xml” and is routed to “/user/view?userId=2&format=xml”.<br>
</blockquote>Parameters:<br>
<blockquote>userId (required) → The id of the requested user.<br>
format (optional) → Specify the format of the response.  Either “xml” or  “json”.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView – if json is requested, the profile information is written as a json string to the response<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/logout<br>
<blockquote>Description:<br>
<blockquote>Logs out the current user.  A user must first be logged in.<br>
</blockquote>Parameters:<br>
<blockquote>none<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/checkIn<br>
<blockquote>Description:<br>
<blockquote>Creates a visit for a given user, as a member of a given team, at a given location.  A user 		must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>userId (required) → The id of the user who is checking in.  Must equal the current 				                      session's userId.<br>
teamId (required) → The id of the team the user is choosing to check-in as a member of.<br>
locationId (required) → The id of the location the user is checking-in to.<br>
<blockquote>Return Type:<br>
</blockquote>void<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/removeFriend<br>
<blockquote>Description:<br>
<blockquote>Removes the friendship between the two given users.  A user must be logged in and one of the userIds given must equal the current session's userId.<br>
</blockquote>Parameters:<br>
<blockquote>firstId (required) → The id of one of the users in the friendship to be removed.<br>
secondId (required) → The id of the other user in the friendship.<br>
<blockquote>Return Type:<br>
</blockquote>void<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/removeTeam<br>
<blockquote>Description:<br>
<blockquote>Removes the given user from the given team.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>userId (required) → The id of the user who is removing the given team.  Must equal the current session's userId.<br>
teamId (required) →  The id of the team the user is removing.<br>
<blockquote>Return Type:<br>
</blockquote>void<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/sendFriendInvite<br>
<blockquote>Description:<br>
<blockquote>Sends a friend request from the primary user to the secondary user.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>firstId (required) → The id of the user who is doing the inviting.  Must equal the current session's userId.<br>
<blockquote>second (required) → The id of the user who will be receiving the invite.<br>
<blockquote>Return Type:<br>
</blockquote></blockquote>void<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/acceptFriendInvite<br>
<blockquote>Description:<br>
<blockquote>Accepts a friend invite.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>firstId (required) → The id of the user who initiated the friend request.<br>
secondId (required) → The id of the user who is the recipient of the request.<br>
<blockquote>Return Type:<br>
</blockquote>void – writes the user whose friendship was accepted as a json string to the response.<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/rejectFriendInvite<br>
<blockquote>Description:<br>
<blockquote>Rejects a friend invite.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>firstId (required) → The id of the user who initiated the friend request.<br>
secondId (required) → The id of the user who is the recipient of the request.<br>
<blockquote>Return Type:<br>
</blockquote>void<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/sendTeamInvite<br>
<blockquote>Description:<br>
<blockquote>Sends an invitation for the given user to join the given team.<br>
</blockquote>Parameters:<br>
<blockquote>userId (required) → The id of the user who will be receiving the invite.<br>
<blockquote>teamId (required) → The id of the team the user is being invited to.<br>
<blockquote>Return Type:<br>
</blockquote></blockquote>void<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/acceptTeamInvite<br>
<blockquote>Description:<br>
<blockquote>Accepts a team invite.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>userId (required) → The id of the user who is receiving the invite.<br>
teamId (required) → The id of the team the user is being invited to.<br>
<blockquote>Return Type:<br>
</blockquote>void – writes the team that the user has been invited to as a json string to the response.<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/rejectTeamInvite<br>
<blockquote>Description:<br>
<blockquote>Rejects a team invite.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>userId (required) → The id of the user who is receiving the invite.<br>
teamId (required) → The id of the team the user is being invited to.<br>
<blockquote>Return Type:<br>
</blockquote>void<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/controller/UserController.java'>UserController</a></blockquote></blockquote>

URL: /user/create<br>
<blockquote>Description:<br>
<blockquote>Gets the user creation form.  Logs the user on successful submission.<br>
</blockquote>Parameters:<br>
<blockquote>none<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/UserCreateController.java'>UserCreateController</a></blockquote></blockquote>

URL: /user/delete<br>
<blockquote>Description:<br>
<blockquote>Deletes the given user.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>userId (required) → The id of the user to be deleted.  Must equal the current session's userId.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/UserDeleteController.java'>UserDeleteController</a></blockquote></blockquote>

URL: /user/login<br>
<blockquote>Description:<br>
<blockquote>Gets the user login page.<br>
</blockquote>Parameters:<br>
<blockquote>none<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/UserLoginController.java'>UserLoginController</a></blockquote></blockquote>

URL: /user/update<br>
<blockquote>Description:<br>
<blockquote>Gets the update form for the given user.  A user must be currently logged in.  Uses a url rewrite so the url can be specified as “/user/update/2” and is routed to “/user/update?userId=2”.<br>
</blockquote>Parameters:<br>
<blockquote>userId (required) → The id of the user who is being updated.  Must equal the current 					          session's userId.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/UserUpdateController.java'>UserUpdateController</a></blockquote></blockquote>

URL: /team OR /team/central<br>
<blockquote>Description:<br>
<blockquote>Gets the team central page.  Contains interesting information about teams.<br>
</blockquote>Parameters:<br>
<blockquote>format (optional) →  Specify the format of the response.  Either “xml” or  “json”.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/TeamController.java'>TeamController</a></blockquote></blockquote>

URL: /team/$id$<br>
<blockquote>Description:<br>
<blockquote>Gets the profile of the given team.  Uses a url rewrite so the url can be specified as “/team/2/xml” and is routed to “/team/view?teamId=2&format=xml”.<br>
</blockquote>Parameters:<br>
<blockquote>teamId (required) → The id of the requested team.<br>
format (optional) → Specify the format of the response.  Either “xml” or  “json”.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/TeamController.java'>TeamController</a></blockquote></blockquote>

URL: /team/create<br>
<blockquote>Description:<br>
<blockquote>Gets the team creation profile.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>none<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/TeamCreateController.java'>TeamCreateController</a></blockquote></blockquote>

URL: /team/update<br>
<blockquote>Description:<br>
<blockquote>Gets the update form for the given team.  A user must be currently logged in.  The current session's userId must equal that of the team leader's.  Uses a url rewrite so the url can be specified as “/team/update/2” and is routed to “/team/update?teamId=2”.<br>
</blockquote>Parameters:<br>
<blockquote>teamId (required) → The id of the team to be updated.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/TeamUpdateController.java'>TeamUpdateController</a></blockquote></blockquote>

URL: /location OR /location/central<br>
<blockquote>Description:<br>
<blockquote>Gets the location central page.  Displays nearby locations based on the user's current location.<br>
</blockquote>Parameters:<br>
<blockquote>format (optional) → Specify the format of the response.  Either “xml” or  “json”.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/LocationController.java'>LocationController</a></blockquote></blockquote>

URL: /location/$id$<br>
<blockquote>Description:<br>
<blockquote>Gets the profile of the given location.  Uses a url rewrite so the url can be specified as “/location/2/xml” and is routed to “/location/view?teamId=2&format=xml”.<br>
</blockquote>Parameters:<br>
<blockquote>locationId (required) → The id of the requested location.<br>
format (optional) → Specify the format of the response.  Either “xml” or  “json”.<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/LocationController.java'>LocationController</a></blockquote></blockquote>

URL: /location/create<br>
<blockquote>Description:<br>
<blockquote>Gets the location create form.  A user must be currently logged in.<br>
</blockquote>Parameters:<br>
<blockquote>none<br>
<blockquote>Return Type:<br>
</blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/LocationCreateController.java'>LocationCreateController</a></blockquote></blockquote>

URL: /location/getNearbyLocations<br>
<blockquote>Description:<br>
<blockquote>Gets locations that are within ~2 miles of the given locations.<br>
</blockquote>Parameters:<br>
<blockquote>latitude (required) → The latitude of the user's current location.<br>
longitude (required) → The longitude of the user's current location.<br>
</blockquote>Return Type:<br>
<blockquote>void – Writes the locations to the response as a JSON object with the property “locations” having a value of an array containing location objects.<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/LocationController.java'>LocationController</a></blockquote></blockquote>

URL: /location/handleResult<br>
<blockquote>Description:<br>
<blockquote>Takes in information about a location, adds it to Serengeti and returns a json object containing the location's information.<br>
</blockquote>Parameters:<br>
<blockquote>name (required) → The name of the location.<br>
lat (required) → The latitude of the location.<br>
lng (required) → The longitude of the location.<br>
street (required) → The street address of the location.<br>
city (required) → The city of the location.<br>
state (required) → The state of the location.<br>
phone (required) → The phone number of the location.<br>
</blockquote>Return Type:<br>
<blockquote>void – Writes the resulting location object as a JSON object to the response.<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/LocationController.java'>LocationController</a></blockquote></blockquote>

URL: /search<br>
<blockquote>Description:<br>
<blockquote>Searches users, teams, and locations for the given string.<br>
</blockquote>Parameters:<br>
<blockquote>query (required) → The string to search the database against.<br>
</blockquote>Return Type:<br>
<blockquote>ModelAndView<br>
</blockquote>Controller:<br>
<blockquote><a href='http://code.google.com/p/playserengeti/source/browse/#svn/trunk/serengeti/src/main/java/com/playserengeti/controller/SearchController.java'>SearchController</a></blockquote></blockquote>

<blockquote><i>-Chris Mueller</i></blockquote>

<h2>Services</h2>

Services implement the majority of the business logic in our web application.  They interface with the underlying data storage via data access objects, and are interfaced with primarily by controllers and other services.  Serengeti's service classes are: <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/service/UserService.java'>UserService</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/service/TeamService.java'>TeamService</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/service/LocationService.java'>LocationService</a> and <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/service/VisitService.java'>VisitService</a>.  The categories of functionality provided by each service is evident in their names.<br>
<blockquote><i>-Loren Abrams</i></blockquote>

<h2>DAOs</h2>


Data access objects provide a relatively primitive abstraction layer to the underlying data stores.  They provide methods that more or less query the data store and map the results directly to domain objects (objects that represent entities in the application) without any business processing.  The methods of the DAOs are declared in interfaces so that they may be separately implemented for various styles of data storage.  We've implemented two sets of DAOs.  One set for mock data (data that's declared directly as data structures in the application code for testing purposes), and another set with IBATIS object-relational mappings, which map the results of SQL queries on a relational database to domain objects.<br>
<br>
The DAO interfaces Serengeti utilizes are: <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/FriendshipDao.java'>FriendshipDao</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/LocationDao.java'>LocationDao</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/MembershipDao.java'>MembershipDao</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/UserDao.java'>UserDao</a>, <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/TeamDao.java'>TeamDao</a> and <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/VisitDao.java'>VisitDao</a>.  <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/FriendshipDao.java'>FriendshipDao</a> provides methods to query friendship relationships between users.  <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/MembershipDao.java'>MembershipDao</a> provides methods for querying relationships between users and teams.  <a href='http://code.google.com/p/playserengeti/source/browse/trunk/serengeti/src/main/java/com/playserengeti/dao/VisitDao.java'>VisitDao</a> provides methods for querying visits by users at locations for a specific team.  The purposes of the other DAOs are relatively self-explanatory by their names.<br>
<blockquote><i>-Loren Abrams</i></blockquote>

<a href='Hidden comment: 
To contain:
* List of domain classes
* Include UML diagram
* List of controllers and URIs
* List of services
* List of daos
'></a>