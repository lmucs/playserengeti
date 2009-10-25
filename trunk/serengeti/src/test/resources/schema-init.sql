------------------------------------------------------------------------------
-- Serengeti Postgres Database Initialization Script
--
-- This only works in PostgreSQL.
--
-- It will blow away the tables in database serengeti_dev and populate them
-- with test data.
------------------------------------------------------------------------------

\c serengeti_dev

drop table Player;

create table Player (
    id integer unique,
    email text unique,
    password text not null,
    name text not null,
    image_url text,
    creation_date integer not null,
    constraint pk_user primary key (id)
);

insert into Player values (1, 'loren.abrams@gmail.com', 'password', 'Loren Abrams', 'image.jpg', '10-20-09');
insert into Player values (2, 'rtoal@gmail.com', 'password', 'Ray Toal', 'image.jpg', '10-20-09');
insert into Player values (3, ';gratrix@gmail.com', 'password', 'Lita Gratrix', 'image.jpg', '10-20-09');
insert into Player values (4, 'mueller.chris0@gmail.com', 'password', 'Chris Mueller', 'image.jpg', '10-20-09');
insert into Player values (5, 'jcol88@gmail.com', 'password', 'James Coleman', 'image.jpg', '10-20-09');
insert into Player values (6, 'mxchickmagnet86@gmail.com', 'password', 'Chick Magnet', 'image.jpg', '10-20-09');
insert into Player values (7, 'malevolentman87@gmail.com', 'password', 'Edgardo Ineguez', 'image.jpg', '10-20-09');
insert into Player values (8, 'DJScythe15@gmail.com', 'password', 'Don Murphy', 'image.jpg', '10-20-09');

drop table Team;

create table Team (
    id integer unique,
    name text unique,
    description text,
    home_base text,
    color text,
    image_url text,
    leader_id integer references Player(id),
    creation_date integer not null,
    constraint pk_team primary key (id)
);

insert into Team values (1, 'UmpaLumpas', 'Doopidy Doo', 'The Factory', 'Green', 'http://www.google.com', 1, '10-20-09');
insert into Team values (2, 'Constipated Koalas', 'A team for all those koalas out there.', 'Eucalyptus Trees', 'Gray', 'http://www.google.com', 3, '10-20-09');
insert into Team values (3, 'Raptors', 'RAWR', 'Cretaceous Period', 'Red', 'http://www.google.com', 7, '10-20-09');
insert into Team values (4, 'Lions', 'For people who like lions.', 'The Serengeti....', 'Gold', 'http://www.google.com', 2, '10-20-09');
insert into Team values (5, 'Frivolous Fliers', 'We are so frivolous', 'Anywhere, we can fly.', 'Blue', 'http://www.google.com', 8, '10-20-09');
insert into Team values (6, 'ChickMagnets', 'It's all about the chicks man.', 'The streets', 'Money', 'http://www.google.com', 6, '10-20-09');



drop table Location;

create table Location (
    id integer unique,
    name text not null,
    latitude double not null,
    longitude double not null,
    street text,
    city text,
    state text,
    zipcode text,
    team_owner integer references Team(id),
    description text,
    phone text,
    image_url text,
    constraint pk_location primary key (id)
);

insert into Location values (1, 'Doolan Hall', 33.969326, -118.414387, 'Doolan Hall, 1 LMU Dr.', 'Los Angeles', 'CA', '90045', '', 'Where magic happens.', 
    '(310) 338-7351', 'keck.jpg');
insert into Location values (2, 'Viva Fresh', 33.959988, -118.416851, '7101 W Manchester Ave', 'Los Angeles', 'CA', '90045', '', 'Small Mexican place.', 
    '', 'viva.jpg');
insert into Location values (3, 'Los Angeles Internation Airport', 33.946864, -118.401504, 'Los Angeles Internation Ariport', 'Los Angeles', 'CA', '90045', '', 'LAX', 
    '', 'airport.jpg');
insert into Location values (4, 'Chris' House', 33.594681, -111.896031, '8509 E. Sunnyside Dr.', 'Scottsdale', 'AZ', '85260', '', 'Where Chris lives.', 
    '', 'cactus.jpg');
insert into Location values (5, '3rd Street Promenade', 34.015414, -118.491969, '3rd Street Promenade', 'Santa Monica', 'CA', '90401', '', 'A shopping center.', 
    '', 'shopping.jpg');
insert into Location values (6, 'ChickMagnetVille', 33.526151, -112.261047, '1 W Cardinals Way', 'Glendale', 'AZ', '85305', '', 'Obviously the Cardinals' stadium.', 
    '(623) 433-7100', 'cards.jpg');
    
drop table Friend;

create table Friend (
    id integer unique,
    primary_id integer not null references Player(id),
    secondary_id integer not null references Player(id),
    constraint pk_friend primary key (id)
);

insert into Friend values(1, 1, 2);
insert into Friend values(2, 2, 3);
insert into Friend values(3, 1, 3);
insert into Friend values(4, 1, 4);
insert into Friend values(5, 1, 5);
insert into Friend values(6, 1, 6);
insert into Friend values(7, 1, 7);
insert into Friend values(8, 1, 8);
insert into Friend values(9, 3, 4);
insert into Friend values(10, 5, 4);
insert into Friend values(11, 5, 2);
insert into Friend values(12, 7, 8);
insert into Friend values(13, 8, 3);
insert into Friend values(14, 7, 2);
insert into Friend values(15, 8, 6);

drop table Member;

create table Member (
    id integer unique,
    team_id integer not null references Team(id),
    user_id integer not null references Player(id),
    constraint pk_member primary key (id)
);

insert into Member values(1, 1, 1);
insert into Member values(2, 1, 2);
insert into Member values(3, 1, 8);
insert into Member values(4, 2, 1);
insert into Member values(5, 2, 2);
insert into Member values(6, 2, 3);
insert into Member values(7, 2, 5);
insert into Member values(8, 3, 5);
insert into Member values(9, 3, 4);
insert into Member values(10, 3, 7);
insert into Member values(11, 3, 1);
insert into Member values(12, 4, 1);
insert into Member values(13, 4, 2);
insert into Member values(14, 4, 6);
insert into Member values(15, 4, 5);
insert into Member values(16, 5, 8);
insert into Member values(17, 5, 1);
insert into Member values(18, 5, 2);
insert into Member values(19, 5, 3);
insert into Member values(20, 6, 1);
insert into Member values(21, 6, 2);
insert into Member values(22, 6, 4);
insert into Member values(23, 6, 8);
insert into Member values(24, 6, 7);
insert into Member values(25, 6, 6);

drop table Visit;

create table Visit (
    id integer unique,
    user_id integer not null references Player(id),
    team_id integer not null references Team(id), 
    location_id integer not null references Location(id),
    date integer not null,
    constraint pk_visit primary key (id)
    
insert into Visit values(1 ,1, 1, 2);
insert into Visit values(2 ,1, 2, 3);		
insert into Visit values(3, 2, 2, 4);
insert into Visit values(4 ,3, 2, 1);	
insert into Visit values(5, 3, 5, 5);
insert into Visit values(6, 4, 3, 2);
insert into Visit values(7, 4, 3, 6);
insert into Visit values(8, 4, 6, 4);
insert into Visit values(9, 5, 2, 3);
insert into Visit values(10, 5, 3, 4);
insert into Visit values(11, 6, 4, 4);
insert into Visit values(12, 6, 6, 5);
insert into Visit values(13, 7, 3, 6);
insert into Visit values(14, 7, 6, 2);
insert into Visit values(15, 8, 1, 1);
insert into Visit values(16, 8, 5, 1);
insert into Visit values(17, 8, 6, 4);
insert into Visit values(18, 8, 5, 3);