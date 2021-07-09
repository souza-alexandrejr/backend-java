create schema if not exists shopping;

create table shopping.shop (
	id int primary key auto_increment,
	user_identifier varchar(100) not null,
	date timestamp not null,
	total float not null
);

create table shopping.item (
	shop_id int references shopping.shop(id),
	product_identifier varchar(100) not null,
	price float not null
);