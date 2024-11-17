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
    updated_at   timestamp default current_timestamp,
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

-- sql injection example
SELECT user_name, user_id, email, role_id
FROM users
WHERE email='' OR '1'='1' -- AND password='dsdds';

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

-- Create a procedure to add a new product
DELIMITER $$
DROP PROCEDURE IF EXISTS AddProduct;
CREATE PROCEDURE AddProduct(
    IN p_product_name VARCHAR(50),
    IN p_price DOUBLE
)
BEGIN
    -- Insert a new product into the products table
    INSERT INTO products(product_name, price)
    VALUES (p_product_name, p_price);
END $$

DELIMITER ;

-- Test the AddProduct procedure
CALL AddProduct("smartwatch", 350.5, "2024-11-15");

-- Create a procedure to add a new user
DELIMITER $$
DROP PROCEDURE IF EXISTS AddUser;
CREATE PROCEDURE AddUser(
    IN p_role_id INT,
    IN p_user_name VARCHAR(50),
    IN p_email VARCHAR(50),
    IN p_password VARCHAR(50)
)
BEGIN
    -- Insert a new user into the users table
    INSERT INTO users(role_id, user_name, email, password)
    VALUES (p_role_id, p_user_name, p_email, p_password);
END $$

DELIMITER ;

-- Test the AddUser procedure
CALL AddUser(2, "new_customer", "new_customer@algonquin.com", "password123");

-- Triggers to prevent SQL injection attempts.
DELIMITER $$
drop trigger if exists prevent_sql_injection;
CREATE TRIGGER prevent_sql_injection
    BEFORE INSERT ON users
    FOR EACH ROW
BEGIN
    -- Check for suspicious characters or keywords in user_name
    IF NEW.user_name REGEXP '.*(--)|(;)|(\')|(\")|(\bOR\b)|(\bAND\b)|(\bSELECT\b)|(\bDROP\b).*' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'SQL Injection attempt detected in user_name';
    END IF;

    -- Check for suspicious characters or keywords in email
    IF NEW.email REGEXP '.*(--)|(;)|(\')|(\")|(\bOR\b)|(\bAND\b)|(\bSELECT\b)|(\bDROP\b).*' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'SQL Injection attempt detected in email';
    END IF;

    -- Check for suspicious characters or keywords in password
    IF NEW.password REGEXP '.*(--)|(;)|(\')|(\")|(\bOR\b)|(\bAND\b)|(\bSELECT\b)|(\bDROP\b).*' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'SQL Injection attempt detected in password';
    END IF;
END $$

DELIMITER ;

/*
-- testing for user_name
INSERT INTO users (role_id, user_name, email, password)
VALUES (1, 'admin OR 1=1 --', 'admin@example.com', 'password123');
-- testing for password
INSERT INTO users (role_id, user_name, email, password)
VALUES (1, 'invalid2', 'admin@example.com', 'DROP TABLE users');
-- testing for email
INSERT INTO users (role_id, user_name, email, password)
VALUES (2, 'invalid3', 'johndoe@example.com SELECT * FROM users --', 'password123');
-- testing with valid insert
INSERT INTO users (role_id, user_name, email, password)
VALUES (2, 'validUser', 'validUser@example.com', 'password123' );
 */