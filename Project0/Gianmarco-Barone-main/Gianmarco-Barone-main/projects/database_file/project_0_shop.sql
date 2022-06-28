drop table if exists employee;
create table employee(
employee_id serial primary key,
employee_username varchar(30),
employee_password varchar(30)
);

drop table if exists product_inventory;
create table product_inventory(
product_id serial primary key,
product_name varchar(30),
price int, 
status varchar(30)
);
drop table if exists customer_account cascade;
create table customer_account(
customer_id serial primary key,
customer_username varchar(30),
customer_password varchar(30)
);

insert into customer_account  (customer_id, customer_username, customer_password) values (1, 'customer1', 'password1');
insert into customer_account  (customer_id, customer_username, customer_password) values (2, 'customer2', 'password2');
insert into customer_account  (customer_id, customer_username, customer_password) values (3, 'customer3', 'password3');
drop table if exists customer_inventory;
create table customer_inventory(
customer_inventory_id serial references customer_account(customer_id),
customer_inventory text,
remaining_payments int
);

drop table if exists employee_processing;
create table employee_processing(
transaction_id serial primary key,
pending_transactions varchar(30) references product inventory(status),
customer_payments int references customer_inventory(remaining_payments)
);