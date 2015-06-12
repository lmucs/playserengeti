# Scoring Model #

When users check-in, they select both a location (if not determined by GPS) and a team to check-in with. a point is given to the selected team for the location. The team with the highest point total for a location over all teams is considered owner of the location.

The value of a check-in's point value will decay linearly over a set period of time, eventually become 0; this prevents one team from dominating a location for a long period of time. Currently, the time period is thought to be set either to 2 months, or is dynamically based upon number of total check-ins to a location; for example, a location that is frequently in conflict due to many users from many team checking in frequently may have a very short decay period (1-2 days), while a location that is rarely in conflict may have a decay period closer to 1-2 months.

Team totals are floored when displayed for users. When a owner's team point total is within a predetermined range of the second highest team's point total, neither team is considered owner and the location is considered "in conflict". Ownership of an location in conflict is given when one team exceeds all other teams beyond the predetermined range.

## Points to Discuss ##
  * Dynamic decay: Should decay be implemented dynamically, or should it occur at set intervals (daily, hourly, a fraction of the dynamically based decay period)?

  * Unique visitors worth more: Should 1 user visiting multiple times in a day (for example, 10am, 11:30am, 2pm) be worth less than multiple users checking in at similar times (user 1 checks in at 10am, user 2 at 11:30am, and user 3 at 2pm)? Should more points be given based upon number of visitors when number of check-ins are equal?

<a href='Hidden comment: ==Basic Scoring==
When a user checks in to a location, a set amount of points is added to each of the user"s teams. Ownership is given to the team with the highest number of points. If check-in limits (i.e., users can not check-in immediately after a previous check-in) are not implemented, check-ins to a location within a set period of time from a previous check-in to the same location will offer no additional points to a user"s teams.
===Potential Flaws===
* Near-permanent ownerships by defunct teams: If a team scored enough points for ownerships in a location, both by a huge margin and over a long period of time, and then abandoned the location, another team of similar scale could take much longer to take the location. Although the new team would likely be considered owners by most users, the old team would continue to be owners according to the database.

==Decaying Scoring==
When a user checks into a location, an entry is made for the visit with a date and starting point value. Over time, a visit"s point amount value would lower; a more recent visit would be more valuable than an older one. Decay would be either exponential or linear, and applied after set intervals. Ownership is till given to the team with the highest points for a location, and limits are implemented either by the application"s check-in limit or voiding of points to multiple check-ins to one location in a short period of time.
===Potential Flaws===
* Old visits lose all value: If decay of points is linear, all visits will eventually deteriorate to the point of carrying no value.

=Ownership: Universal or Over Sets=
Should there be a general ownership of a location, or should location ownership only be based upon a set including a user"s teams and the teams" rivals?'></a>