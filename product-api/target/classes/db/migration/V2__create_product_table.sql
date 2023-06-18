--CREATE TABLE `products.category` (
--  id BIGINT AUTO_INCREMENT NOT NULL,
--  `product_identifier`VARCHAR(255) NOT NULL,
--   `name` VARCHAR(255) NOT NULL,
--   `descricao` VARCHAR(255) NOT NULL,
--   `preco` float(255) NOT NULL,
--   `category_id` BIGINT REFERENCES `products.category`(id),
--   CONSTRAINT `pk_category` PRIMARY KEY (id)
--);

CREATE TABLE `product` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
   `name` VARCHAR(255),
   `price` DOUBLE NOT NULL,
   `description` VARCHAR(255),
   `product_identifier` VARCHAR(255),
   `category_id` BIGINT,
   CONSTRAINT `pk_product` PRIMARY KEY (id)
);

ALTER TABLE `Product` ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES Category (id);