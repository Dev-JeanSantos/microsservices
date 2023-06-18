CREATE SCHEMA IF NOT EXISTS `products`;
--CREATE TABLE `products.category` (
--  id BIGINT AUTO_INCREMENT NOT NULL,
--   `name` VARCHAR(255),
--   CONSTRAINT `pk_category` PRIMARY KEY (id)
--);

CREATE TABLE `category` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
   `name` VARCHAR(255),
   CONSTRAINT `pk_category` PRIMARY KEY (id)
);