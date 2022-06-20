drop table if exists customer;
create table customer (
	customer_id serial primary key,
	first_name VARCHAR(50),
	last_name VARCHAR(50)
);
insert into customer (customer_id, first_name, last_name) values (1, 'Regine', 'Jermy');
insert into customer (customer_id, first_name, last_name) values (2, 'Amos', 'Garratty');
insert into customer (customer_id, first_name, last_name) values (3, 'Melantha', 'Staries');
insert into customer (customer_id, first_name, last_name) values (4, 'Happy', 'Stuchbery');
drop table if exists sales_person;
create table sales_person (
	employee_id serial primary key,
	first_name VARCHAR(50),
	last_name VARCHAR(50)
);
insert into sales_person (employee_id, first_name, last_name) values (1, 'Mona', 'Duffill');
insert into sales_person (employee_id, first_name, last_name) values (2, 'Gerry', 'Lorie');
insert into sales_person (employee_id, first_name, last_name) values (3, 'Kary', 'Ludee');
insert into sales_person (employee_id, first_name, last_name) values (4, 'Rodolph', 'Yeeles');
drop table if exists sales_office;
create table sales_office (
	office_id serial primary key,
	street_address VARCHAR(50),
	city VARCHAR(50),
	state VARCHAR(50),
	postal_code VARCHAR(50)
);
insert into sales_office (office_id, street_address, city, state, postal_code) values (1, '9289 Warner Plaza', 'Chicago', 'Illinois', '60630');
insert into sales_office (office_id, street_address, city, state, postal_code) values (2, '01 Jenna Court', 'Wichita', 'Kansas', '67215');
insert into sales_office (office_id, street_address, city, state, postal_code) values (3, '4 Vernon Crossing', 'Houston', 'Texas', '77005');
insert into sales_office (office_id, street_address, city, state, postal_code) values (4, '356 Rutledge Avenue', 'Staten Island', 'New York', '10310');
drop table if exists dob;
create table dob (
	dob_id serial primary key,
	dob DATE
);
insert into dob (dob_id, dob) values (1, '5/13/2007');
insert into dob (dob_id, dob) values (2, '1/8/1990');
insert into dob (dob_id, dob) values (3, '12/26/2003');
insert into dob (dob_id, dob) values (4, '9/16/2000');