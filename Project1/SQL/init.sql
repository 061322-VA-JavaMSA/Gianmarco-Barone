


drop table if exists user_roles
create table if not exists user_roles(
id serial primary key,
user_role varchar(30) 
);
insert into user_roles(user_role) values('manager');
insert into user_roles(user_role) values ('employee');
insert into user_roles(user_role) values ('placeholder');

drop table if exists users;
create table if not exists users(
id serial primary key,
username varchar(30) unique,
password varchar(30) not null,
first_name varchar(30),
last_name varchar(30),
email varchar(50),
role_id int references user_roles(id)
);

insert into users (username, password, first_name,last_name,email, role_id) values ('manager', 'password', 'stan', 'smith','emailfake@email.com', 1);
insert into users (username, password, first_name,last_name,email, role_id) values ('manager2', 'password', 'bob', 'smith','emailfake@email.com', 1);
insert into users (username, password, first_name,last_name,email, role_id) values ('employee', 'password', 'jack', 'smith','emailfake@email.com', 2);
insert into users (username, password, first_name,last_name,email, role_id) values ('john', 'password', 'john', 'smith','emailfake@email.com', 2);
insert into users (username, password, first_name,last_name,email, role_id) values ('jane', 'password', 'jane', 'smith','emailfake@email.com', 2);


drop table if exists reimbursement_status cascade
create table if not exists reimbursement_status(
reimbursement_status_id serial primary key,
reimbursement_status varchar(30) default 'pending'
);

insert into reimbursement_status (reimbursement_status) values('accepted');
insert into reimbursement_status (reimbursement_status) values('rejected');
insert into reimbursement_status (reimbursement_status) values('pending');



drop table if exists reimbursement_type cascade
create table if not exists reimbursement_type(
type_id serial primary key,
reimbursement_type varchar(30) default 'other'
);

insert into reimbursement_type (reimbursement_type) values('travel');
insert into reimbursement_type (reimbursement_type) values('lodging');
insert into reimbursement_type (reimbursement_type) values('food');
insert into reimbursement_type (reimbursement_type) values('other');


drop table if exists reimbursement cascade
create table if not exists reimbursement(
id serial primary key,
amount int,
submitted timestamp NULL DEFAULT CURRENT_TIMESTAMP,
resolved timestamp NULL,
description text,
author_id int references users(id),
resolver_id int references users(id),
reimbursement_status_id int references reimbursement_status(reimbursement_status_id),
reimbursement_type_id int references reimbursement_type(type_id)
);

insert into reimbursement (amount, description,author_id ,resolver_id , reimbursement_status_id,reimbursement_type_id) values(100, 'description', 2, 1, 3, 1);
insert into reimbursement (amount, description,author_id ,resolver_id , reimbursement_status_id,reimbursement_type_id) values(500, 'description', 3, 1, 1, 1);
insert into reimbursement(amount, description, author_id, resolver_id, reimbursement_status_id, reimbursement_type_id) values (789, 'ummmmm', 3, 1, 2, 2);






