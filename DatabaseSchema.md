Following is the Serengeti relational data model.  We've included column and key specifications, as well as basic constraints, but omitted most of the indexing and other tuning-related information.

## PLAYER ##

| **Column name** | **Type** | **Notes** |
|:----------------|:---------|:----------|
| player\_id      | integer, primary key |           |
| player\_email   | varchar(200), not null, unique | index     |
| player\_password\_hash | char(32), not null |           |
| player\_first\_name | varchar(200) |           |
| player\_last\_name | varchar(200) |           |
| player\_creation\_timestamp | timestamp |           |
| player\_avatar\_id | integer, foreign key => player\_avatar(player\_avatar\_id) | on delete restrict |

## TEAM ##

| **Column name** | **Type** | **Notes** |
|:----------------|:---------|:----------|
| team\_id        | integer, primary key, unique |           |
| team\_name      | varchar(200), not null | index     |
| team\_description | char(400) |           |
| team\_home\_base | varchar(200) |           |
| team\_leader\_id | integer, foreign key => player(player\_id), not null | on delete cascade |
| team\_creation\_timestamp | timestamp |           |
| team\_color     | varchar(200) |           |
| team\_avatar\_id | integer, foreign key => team\_avatar(team\_avatar\_id) | on delete restrict|

## LOCATION ##

| **Column name** | **Type** | **Notes** |
|:----------------|:---------|:----------|
| location\_id    | integer, primary key |           |
| location\_name  | varchar(200), not null | part of unique, part of index |
| location\_latitude | numeric(9,6), not null | part of unique, part of index |
| location\_longitude | numeric(9,6), not null | part of unique, part of index |
| location\_street | varchar(200), not null |           |
| location\_city  | varchar(200), not null |           |
| location\_state | char(2), not null | state, province, department, etc.|
| location\_zipcode | char(10) | postal code |
| location\_phone\_number | char(16) |           |
| team\_owner\_id | integer, foreign key team(team\_id) |           |

## MEMBERSHIP ##

| **Column name** | **Type** | **Notes** |
|:----------------|:---------|:----------|
| team\_id        | integer, foreign key => team(team\_id), not null | part of primary key, on delete cascade |
| player\_id      | integer, foreign key => player(player\_id), not null | part of primary key, on delete cascade |
| status          | char(10) |           |

## FRIENDSHIP ##

| **Column name** | **Type** | **Notes** |
|:----------------|:---------|:----------|
| first\_id       | integer, foreign key => player(player\_id), not null | part of primary key, on delete cascade |
| second\_id      | integer, foreign key => player(player\_id), not null | part of primary key, on delete casecade |
| status          | char(10) |           |

## VISIT ##

| **Column name** | **Type** | **Notes** |
|:----------------|:---------|:----------|
| visit\_id       | integer, primary key |           |
| visit\_user\_id | integer, foreign key => player(player\_id), not null | on delete cascade |
| visit\_team\_id | integer, foreign key => team(team\_id), not null | on delete cascade |
| visit\_location\_id  | integer, foreign key => location(location\_id), not null | on delete cascade |
| visit\_timestamp | timestamp |           |

## PLAYER\_AVATAR ##

| **Column name** | **Type** | **Notes** |
|:----------------|:---------|:----------|
| player\_avatar\_id | integer, primary key |           |
| player\_id      | integer, foreign key => player(player\_id), not null | on delete cascade |
| avatar\_bytes   | bytes, not null |           |
| avatar\_mime    | varchar(20), not null |           |

## TEAM\_AVATAR ##

| **Column name** | **Type** | **Notes** |
|:----------------|:---------|:----------|
| team\_avatar\_id | integer, primary key |           |
| team\_id        | integer, foreign key => team(team\_id), not null | on delete cascade |
| avatar\_bytes   | bytes, not null |           |
| avatar\_mime    | varchar(20), not null |           |