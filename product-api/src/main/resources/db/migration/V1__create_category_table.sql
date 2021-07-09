create schema if not exists products;

create table products.category (
	id int primary key auto_increment,
	name varchar(100) not null
);