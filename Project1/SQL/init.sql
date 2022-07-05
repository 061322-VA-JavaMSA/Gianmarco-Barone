


drop table if exists reimbursement_status
create table if not exists reimbursement_status(
status_id serial primary key,
status varchar(30) default 'pending'
);


drop table if exists reimbursement_type
create table if not exists reimbursement_type(
type_id serial primary key,
type varchar(30) default 'generic'
);


drop table if exists user_role
create table if not exists user_role(
user_role_id serial primary key,
user_role varchar(30)
);
insert into user_role(user_role) values('Manager');
insert into user_role(user_role) values ('Employee');

drop table if exists users
create table if not exists users(
user_id serial primary key,
username varchar(30) unique,
password varchar(30),
role_id int references user_role(user_role_id)
);

insert into users (username,password, role_id) values('manager','password', 1);
insert into users (username,password, role_id) values('employee','password', 2);


drop table if exists reimbursement
create table if not exists reimbursement(
reimbursement_id serial primary key,
amount int,
description text,
author varchar(30) references users(username),
resolver varchar(30) references users(username),
status_id int references reimbursement_status(status_id),
type_id int references reimbursement_type(type_id)
);
