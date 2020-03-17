﻿DROP DATABASE IF EXISTS magaz;
CREATE DATABASE magaz;
--
-- Script was generated by Devart dbForge Studio 2019 for MySQL, Version 8.2.23.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 30.10.2019 21:15:26
-- Server version: 8.0.16
-- Client version: 4.1
--

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
-- SET GLOBAL time_zone = '+2:00';
-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

--
-- Set default database
--
USE magaz;

--
-- Drop table `bucket`
--
DROP TABLE IF EXISTS bucket;

--
-- Drop table `product`
--
DROP TABLE IF EXISTS product;

--
-- Drop table `user`
--
DROP TABLE IF EXISTS user;

--
-- Set default database
--
USE magaz;

--
-- Create table `user`
--
CREATE TABLE user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(50) NOT NULL UNIQUE,
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  `group` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_0900_ai_ci;

--
-- Create table `product`
--
CREATE TABLE product (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  `desc` TEXT DEFAULT NULL,
  price DECIMAL(19, 2) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_0900_ai_ci;

--
-- Create table `bucket`
--
CREATE TABLE bucket (
  id INT(11) NOT NULL AUTO_INCREMENT,
  user_id INT(11) DEFAULT NULL,
  product_id INT(11) DEFAULT NULL,
  date TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_0900_ai_ci;

--
-- Create foreign key
--
ALTER TABLE bucket 
  ADD CONSTRAINT product_id_FK FOREIGN KEY (product_id)
    REFERENCES product(id) ON DELETE CASCADE;

--
-- Create foreign key
--
ALTER TABLE bucket 
  ADD CONSTRAINT user_id_FK FOREIGN KEY (user_id)
    REFERENCES user(id) ON DELETE CASCADE;

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;