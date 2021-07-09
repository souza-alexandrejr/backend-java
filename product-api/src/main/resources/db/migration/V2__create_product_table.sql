create table products.product (
	id int primary key auto_increment,
	product_identifier varchar not null,
	name varchar(100) not null,
	description varchar not null,
	price float not null,
	category_id int references products.category(id)
);