drop table Team;

create table Team (
    id integer unique,
    name text not null,
    description text,
    color text,
    image_url text,
    constraint pk_team primary key (id)
);

drop table Player;

create table Player (
    id integer unique,
    email text unique,
    name text not null,
    constraint pk_user primary key (id)
);

insert into Player values (1, 'jcol88@gmail.com', 'James Coleman');
insert into Player values (2, 'loren.abrams@gmail.com', 'Loren Abrams');
insert into Player values (3, 'president@whitehouse.gov', 'Barack Obama');
insert into Player values (4, 'mxchickmagnet86@gmail.com', 'Chick Magnet');

insert into Team values (1, 'Constipated Koalas', 'What do you think?', 'grey', 'http://www.google.com');

