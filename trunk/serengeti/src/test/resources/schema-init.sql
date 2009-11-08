------------------------------------------------------------------------------
-- Serengeti Postgres Database Initialization Script
--
-- This only works in PostgreSQL.
--
-- It will blow away the tables in database serengeti_dev and populate them
-- with test data.
------------------------------------------------------------------------------

\c serengeti_dev

drop table visit;
drop table membership;
drop table friendship;
drop table location;
drop table team;
drop table player;

create table Player (
    id                  serial              primary key,
    email               varchar(200)        unique not null,
    password_hash       char(32)            not null,
    first_name          varchar(200),
    last_name           varchar(200),
    creation_timestamp  timestamp           default current_timestamp
);

create table Team (
    id                  serial              primary key,
    name                varchar(200)        unique not null,
    description         char(400),
    home_base           varchar(200),
    leader_id           integer             not null,
    creation_timestamp  timestamp           default current_timestamp,
    foreign key (leader_id) references Player(id)
);

create table Location (
    id                  serial              primary key,
    name                varchar(200)        not null,
    latitude            numeric(9,6)        not null,
    longitude           numeric(9,6)        not null,
    street              varchar(200)        not null,
    city                varchar(200)        not null,
    state               char(2)             not null,
    zipcode             integer             not null,
    team_owner_id       integer,
    description         char(400),
    foreign key (team_owner_id) references Team(id)
);

create table Friendship (
    first_id            integer             not null,
    second_id           integer             not null,
    primary key (first_id, second_id),
    foreign key (first_id) references Player(id),
    foreign key (second_id) references Player(id)
);

create table Membership (
    team_id             integer             not null,
    user_id             integer             not null,
    primary key (team_id, user_id),
    foreign key (team_id) references Team(id),
    foreign key (user_id) references Player(id)
);

create table Visit (
    id                  serial              primary key,
    user_id             integer             not null,
    team_id             integer             not null, 
    location_id         integer             not null,
    visit_timestamp     timestamp           default current_timestamp,
    foreign key (user_id) references Player(id),
    foreign key (team_id) references Team(id),
    foreign key (location_id) references Location(id)
);


insert into Player (email, password_hash, first_name, last_name) values ('loren.abrams@gmail.com', md5('loren'), 'Loren', 'Abrams');
insert into Player (email, password_hash, first_name, last_name) values ('rtoal@gmail.com', md5('ray'), 'Ray', 'Toal');
insert into Player (email, password_hash, first_name, last_name) values ('lgratrix@gmail.com', md5('lita'), 'Lita', 'Gratrix');
insert into Player (email, password_hash, first_name, last_name) values ('mueller.chris0@gmail.com', md5('chris'), 'Chris', 'Mueller');
insert into Player (email, password_hash, first_name, last_name) values ('jcol88@gmail.com', md5('james'), 'James', 'Coleman');
insert into Player (email, password_hash, first_name, last_name) values ('mxchickmagnet86@gmail.com', md5('chick'), 'Chick', 'Magnet');
insert into Player (email, password_hash, first_name, last_name) values ('malevolentman87@gmail.com', md5('egardo'), 'Edgardo', 'Ineguez');
insert into Player (email, password_hash, first_name, last_name) values ('djscythe15@gmail.com', md5('don'), 'Don', 'Murphy');

insert into Team (name, description, home_base, leader_id) values ('UmpaLumpas', 'Doopidy Doo', 'The Factory', 1);
insert into Team (name, description, home_base, leader_id) values ('Constipated Koalas', 'A team for all those koalas out there.', 'Eucalyptus Trees', 3);
insert into Team (name, description, home_base, leader_id) values ('Raptors', 'RAWR', 'Cretaceous Period', 7);
insert into Team (name, description, home_base, leader_id) values ('Lions', 'For people who like lions.', 'The Serengeti....', 2);
insert into Team (name, description, home_base, leader_id) values ('Frivolous Fliers', 'We are so frivolous', 'Anywhere, we can fly.', 8);
insert into Team (name, description, home_base, leader_id) values ('ChickMagnets', 'It\'s all about the chicks man.', 'The streets', 6);

insert into Location (name, latitude, longitude, street, city, state, zipcode, team_owner_id, description) values ('Doolan Hall', 33.969326, -118.414387, 'Doolan Hall, 1 LMU Dr.', 'Los Angeles', 'CA', 90045, 1, 'Where magic happens.');
insert into Location (name, latitude, longitude, street, city, state, zipcode, team_owner_id, description) values ('Viva Fresh', 33.959988, -118.416851, '7101 W Manchester Ave', 'Los Angeles', 'CA', 90045, 1, 'Small Mexican place.');
insert into Location (name, latitude, longitude, street, city, state, zipcode, team_owner_id, description) values ('Los Angeles Internation Airport', 33.946864, -118.401504, 'Los Angeles Internation Ariport', 'Los Angeles', 'CA', 90045, 1, 'LAX');
insert into Location (name, latitude, longitude, street, city, state, zipcode, team_owner_id, description) values ('Chris\' House', 33.594681, -111.896031, '8509 E. Sunnyside Dr.', 'Scottsdale', 'AZ', 85260, 1, 'Where Chris lives.');
insert into Location (name, latitude, longitude, street, city, state, zipcode, team_owner_id, description) values ('3rd Street Promenade', 34.015414, -118.491969, '3rd Street Promenade', 'Santa Monica', 'CA', 90401, 1, 'A shopping center.');
insert into Location (name, latitude, longitude, street, city, state, zipcode, team_owner_id, description) values ('ChickMagnetVille', 33.526151, -112.261047, '1 W Cardinals Way', 'Glendale', 'AZ', 85305, 1, 'Obviously the Cardinals\' stadium.');

insert into Friendship values(1, 2);
insert into Friendship values(2, 3);
insert into Friendship values(1, 3);
insert into Friendship values(1, 4);
insert into Friendship values(1, 5);
insert into Friendship values(1, 6);
insert into Friendship values(1, 7);
insert into Friendship values(1, 8);
insert into Friendship values(3, 4);
insert into Friendship values(5, 4);
insert into Friendship values(5, 2);
insert into Friendship values(7, 8);
insert into Friendship values(8, 3);
insert into Friendship values(7, 2);
insert into Friendship values(8, 6);

insert into Membership values(1, 1);
insert into Membership values(1, 2);
insert into Membership values(1, 8);
insert into Membership values(2, 1);
insert into Membership values(2, 2);
insert into Membership values(2, 3);
insert into Membership values(2, 5);
insert into Membership values(3, 5);
insert into Membership values(3, 4);
insert into Membership values(3, 7);
insert into Membership values(3, 1);
insert into Membership values(4, 1);
insert into Membership values(4, 2);
insert into Membership values(4, 6);
insert into Membership values(4, 5);
insert into Membership values(5, 8);
insert into Membership values(5, 1);
insert into Membership values(5, 2);
insert into Membership values(5, 3);
insert into Membership values(6, 1);
insert into Membership values(6, 2);
insert into Membership values(6, 4);
insert into Membership values(6, 8);
insert into Membership values(6, 7);
insert into Membership values(6, 6);
    
insert into Visit (user_id, team_id, location_id) values (1, 1, 2);
insert into Visit (user_id, team_id, location_id) values (1, 2, 3);		
insert into Visit (user_id, team_id, location_id) values (2, 2, 4);
insert into Visit (user_id, team_id, location_id) values (3, 2, 1);	
insert into Visit (user_id, team_id, location_id) values (3, 5, 5);
insert into Visit (user_id, team_id, location_id) values (4, 3, 2);
insert into Visit (user_id, team_id, location_id) values (4, 3, 6);
insert into Visit (user_id, team_id, location_id) values (4, 6, 4);
insert into Visit (user_id, team_id, location_id) values (5, 2, 3);
insert into Visit (user_id, team_id, location_id) values (5, 3, 4);
insert into Visit (user_id, team_id, location_id) values (6, 4, 4);
insert into Visit (user_id, team_id, location_id) values (6, 6, 5);
insert into Visit (user_id, team_id, location_id) values (7, 3, 6);
insert into Visit (user_id, team_id, location_id) values (7, 6, 2);
insert into Visit (user_id, team_id, location_id) values (8, 1, 1);
insert into Visit (user_id, team_id, location_id) values (8, 5, 1);
insert into Visit (user_id, team_id, location_id) values (8, 6, 4);
insert into Visit (user_id, team_id, location_id) values (8, 5, 3);

