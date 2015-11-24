CREATE TABLE jsf.customers(
	id INT primary KEY auto_increment,
	name varchar(25) NOT NULl,
	address VARCHAR(255) NOT NULL,
	created_date datetime NOT NULL
);

insert into jsf.customers(id, name, address, created_date) 
values(1, 'mkyong1', 'address1', now());
insert into jsf.customers(id, name, address, created_date) 
values(2, 'mkyong2', 'address2', now());
insert into jsf.customers(id, name, address, created_date) 
values(3, 'mkyong3', 'address3', now());
insert into jsf.customers(id, name, address, created_date) 
values(4, 'mkyong4', 'address4', now());
insert into jsf.customers(id, name, address, created_date) 
values(5, 'mkyong5', 'address5', now());