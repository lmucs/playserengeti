  1. A web application **shall** serve as a serengeti game server and administration portal.
    1. Resources in the web application **should** deliver content in four forms
      1. HTML for desktop and laptop browsers
      1. Minimal HTML for mobile web browsers
      1. XML
      1. JSON
    1. The output format **shall** be uniquely determined by the uri
      1. The server **should** produce JSON if the url ends in "/json"
      1. The server **should** produce XML if the url ends in "/xml"
      1. The server **should** produce simple HTML if the url server name begins with "m."
    1. HTML resources **shall** validate as XTHML 1.1 Strict
    1. The root url of the webapp **shall** map to a welcome screen displaying information about the application, a login area, and a registration area.
    1. Each page of the webapp **shall** contain a header and a footer
      1. The header **shall** contain a menu with the following options:
        1. Navigating to the home page
        1. Signing up (creating a new account)
        1. Viewing and managing teams
        1. Viewing and managing players
        1. Viewing and managing locations
        1. Logging in (if not already logged on) or logging out (if logged in)
        1. Obtaining help
    1. A player **shall** be able to manage his or her own account (profile):
      1. A player **shall** be given the following options:
        1. Deactivate his or her account
        1. Modify the following attributes of the account:
          1. Username
          1. Home location
          1. Contact information
          1. Profile Picture
        1. Invite other players to become friends
        1. Remove friends
      1. Players **shall** be given a search feature to find potential friends to invite
    1. Users **shall** be able to manage teams
      1. The user will be presented with three options:
        1. Create Team
        1. Modify Team
        1. Delete Team
      1. For the "Create Team" option:
        1. The user will be able to select information about the team such as:
          1. Team Name
          1. Preferred Color (for the map overlay)
          1. Team Picture
        1. After the team is created, the user will be able to select people to invite to their team.
        1. The creator of the team is automatically set as the team leader.
      1. For the "Modify Team" option:
        1. If the user will be presented with a list of teams to which they are a member.
        1. The user, if they are the team leader, will be able to modify the team name, preferred color, team picture, and team home location.
        1. If the user is the team leader, they may appoint another user to be the leader.
        1. The user will be able to invite people to the team and, if they are the leader, remove people from the team.
      1. The "Delete Team" option will remove the team from the database, as long as the user is the team leader.
    1. For the "View World Map" option:
      1. The user will be presented with a large map centered around their home location, search bars for both locations and people, and a text area at the bottom (this will initially be hidden).
      1. The map will contain mechanisms to zoom in/out and to move in all directions.
      1. The map will show a colored overlay to show which teams own which areas.
      1. The map will show any friends and team members that are currently checked in as green circles.
      1. The map will contain any locations that are controlled by the user, their teams, and any locations under contention with another team as squares.
      1. Locations controlled by a user's group will be colored that of the teams color and locations under contention will be colored gray.
      1. When a person or location is selected from the map, the text area will show information about that person/location.
      1. The user may search for people and locations using the search bars.
      1. When a search for a person or location is successful, the map will update to be centered around that person or location and the text area will show information about that person or location.
    1. For the Location Management Option
      1. The user will be presented with options to
        1. Add a location/business
        1. Manage a location/business
        1. Delete a location/business
        1. For the purposes of serengeti a business is a location that has additional information stored for it (i.e., proprietor) <a href='Hidden comment: 
# For the "Communicate" option
# The user will be presented with options to:
# Invite to Game - a user can enter an email address and a message will be sent to that address inviting the recipient to sign up to Serengeti wiki:commentNo longer relevant or to be implemented - REMOVE/wiki:comment
# Send friend request - invite a user to be added to a users friends list, allowing them to see each other"s location wiki:comment Now part of profiles /wiki:comment
# Accept a friend request - allows a user to accept a friend request that has been received wiki:comment Now part of profiles /wiki:comment
# Invite to team - allows a user to invite another user to join a team wiki:comment Now part of profiles /wiki:comment
# Invite to Location - allows a user to invite another user to meet them at their current location. wiki:commentNo longer relevant or to be implemented - REMOVE'></a>
  1. A native iPhone app **shall** be delivered to allow checking in
    1. When the user opens the application they are presented with a screen containing several button options.  This approach is used to ease initial loading time and to better separate a user's actions.
    1. The options that will be provided to the user are as follows:
      1. Check In
      1. Find People
      1. Find Places
      1. View World Map
      1. Settings/Options
    1. For the "Check In" option:
      1. When selected, the application will record where the user is currently located.
      1. When checking in, if the server detects that any of the user's friends and/or team members are checked in to the same location, a message is displayed stating that those people are in the same location.
      1. After the user has checked in, the user can select whether to automatically update their position or to check them out after a set period of time.
    1. For the "Find People" option:
      1. When selected, the user is presented with a new page that contains a search bar at the top, a map below it that includes a check box to "Show Territories (Regions?)", and a text area at the bottom (this will initially be hidden).
      1. The map will contain mechanisms to zoom in/out and to move in all directions.
      1. The map shows an area of 10 miles in any direction centered around the current location of the user with the user represented as a blue circle.
      1. On the map, any friends or team members of the user that have recently checked in and are within the view area are represented as green circles.
      1. When the "Show Territories (Regions?)" option is enabled, the map will display a colored overlay to represent which teams own which areas.  A key will be provided to differentiate regions.
      1. Players can be searched for by first and/or last name or by username.
      1. If a search is successful, the resulting users will be displayed in a scrolling list.
      1. When the user selects one of the results the text area below the map will display that person's profile.
      1. If the person searched for is currently checked in to a location, the map will update to show the location of that person.
      1. If a search is unsuccessful, a message will appear which states that the person cannot be found.
    1. For the Find Places option:
      1. When "Find Places" is selected, the user is presented with a new page that contains a search bar at the top, a map below it that includes a check box to "Show Territories (Regions?)", and a text area at the bottom (this will initially be hidden).
      1. The map will contain mechanisms to zoom in/out and to move in all directions.
      1. The map shows an area of 10 miles in any direction centered around the current location of the user with the user represented as a blue circle.
      1. When the "Show Territories" option is enabled, the map will display a colored overlay to represent which teams own which areas.  A key will be provided to differentiate regions.
      1. Locations can be searched by name.
      1. If the search is successful, the results will be displayed in a scrolling list.
      1. When a location is selected, the map is updated to show that location, represented as a square on the map and the text area below the map will display the location's profile.
    1. For the View World Map option:
      1. The user will be presented a screen with a map and a text area below it (this will initially be hidden).
      1. The map will contain mechanisms to zoom in/out and to move in all directions.
      1. The map will be centered around the user's current location.
      1. The map will show a colored overlay to show which teams own which areas.
      1. The map will show the locations of all friends and team members.
      1. The map will show locations of interest that are near to the user, locations owned by the user's teams, and locations that are under contention.
      1. When people/locations are selected from the map, the text area below the map will display that person or location's profile.
    1. For the Location Management Option
      1. The user will be presented with options to
        1. Add a location/business
        1. Manage a location/business
        1. Delete a location/business
        1. For the purposes of serengeti a business is a location that has additional information stored for it (i.e., proprietor)
  1. The domain objects and their behavior **shall** be subject to the following rules
    1. A player **shall** be identified by TODO
      1. The email and password properties of a player are required.
      1. A player can belong to zero or more teams
    1. A team **shall** be identified by TODO
    1. A location **shall** be identified by name, street address, GPS coordinates, and tags identifying the type of location. (i.e.: bar, bookstore, etc.)
      1. A new location can be added only by a user with role TODO
      1. Location data can be modified only by a user with role TODO
    1. Players can check in to a location through either the web app or the iPhone app.
      1. Location is derived from a search of existing locations based upon tags, address, or GPS coordinates. (GPS Coordinates found automatically on iPhone app.)
    1. A player **shall** indicate, upon checkin, a team on whose behalf the checkin is made
      1. Players **should** be provided a simple interface for selecting the team (e.g., a dropdown box)
    1. A team's score is calculated based upon the total number of visits attributed to a team as well as the number of unique visitors on the team.
      1. The score from an individual visit decays over a set period of time.
        1. TODO - scoring decay requirements
    1. A team **shall** be considered to be the owner of a location when TODO
    1. A player **shall** be permitted to check into a location only when TODO