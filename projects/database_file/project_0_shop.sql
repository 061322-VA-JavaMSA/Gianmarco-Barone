drop table if exists employee;
create table employee(
employee_id serial primary key,
employee_username varchar(30),
employee_password varchar(30)
);

drop table if exists product_inventory;
create table product_inventory(
product_id serial primary key,
species varchar(30),
price int, 
status varchar(30)
);
drop table if exists customer_login cascade;
create table customer_login(
customer_id serial primary key,
customer_username varchar(30),
customer_password varchar(30)
);
drop table if exists customer_inventory;
create table customer_inventory(
customer_inventory_id serial references customer_login(customer_id),
customer_inventory text
);

drop table if exists employee_processing;
create table employee_processing(
transaction_id serial primary key
pending_transactions varchar(30) references product_inventory(status)
--make seperate table for product status/sales
);