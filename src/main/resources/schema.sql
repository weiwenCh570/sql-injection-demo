CREATE DATABASE IF NOT EXISTS demo_injection;
use demo_injection;
drop table if exists products;
drop table if exists users;
drop table if exists roles;

create table roles
(
    id        int AUTO_INCREMENT,
    role_name varchar(20),
    primary key (id)
);

create table users
(
    user_id   int AUTO_INCREMENT,
    role_id   int,
    user_name varchar(50),
    email     varchar(50),
    password  varchar(50),
    PRIMARY KEY (user_id),
    Foreign key (role_id) references roles (id)
);

create table products
(
    product_id   int AUTO_INCREMENT,
    product_name varchar(50),
    price double,
    updated_at   timestamp,
    PRIMARY KEY (product_id)
);

insert into roles(role_name)
values ("admin"),
       ("normal user");
select *
from roles;
insert into users(role_id, user_name, email, password)
values (1, "admin1", "admin@algonquin.com", "admin123"),
       (2, "custumer1", "custumer1@algonquin.com", "custumer1231"),
       (2, "custumer2", "custumer2@algonquin.com", "custumer1232"),
       (2, "custumer3", "custumer3@algonquin.com", "custumer1233"),
       (2, "custumer4", "custumer4@algonquin.com", "custumer1234"),
       (2, "custumer5", "custumer5@algonquin.com", "custumer1235");
select *
from users;
insert into products(product_name, price, updated_at)
values ("laptop", 850, "2019-08-08"),
       ("smart phone", 1028.8, "2021-01-01"),
       ("ipad", 399.99, "2023-12-21"),
       ("switch", 270, "2022-07-19"),
       ("desktop", 1800, "2023--08-10"),
       ("headphone", 199.6, "2023-06-01");
select *
from products;

-- Create a view for products: only shows product name and price
CREATE OR REPLACE VIEW view_products AS
SELECT
    product_id,
    product_name,
    price
FROM
    products;

-- Create a view for users: hides passwords and shows roles
CREATE OR REPLACE VIEW view_users AS
SELECT
    u.user_id,
    u.user_name,
    u.email,
    r.role_name
FROM
    users u
        JOIN
    roles r
    ON
        u.role_id = r.id;

-- Test the views
SELECT * FROM view_products;
SELECT * FROM view_users;
