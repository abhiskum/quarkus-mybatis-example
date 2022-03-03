drop table if exists user;
drop table if exists role;
drop table if exists user_role;

create table user
(
    id   VARCHAR(32),
    name VARCHAR(32)
);

create table role
(
    id   VARCHAR(32),
    name VARCHAR(32)
);


create table user_role
(
    user_id VARCHAR(32),
    role_id VARCHAR(32)
);

insert into user(id, name) values ('u1', 'Abhishek Kumar');
insert into user(id, name) values ('u2', 'Ayush Sharma');

insert into role(id, name) values ('r1', 'Admin');
insert into role(id, name) values ('r2', 'Export');


insert into user_role(user_id, role_id) values ('u1', 'r1');
insert into user_role(user_id, role_id) values ('u1', 'r2');
insert into user_role(user_id, role_id) values ('u2', 'r1');