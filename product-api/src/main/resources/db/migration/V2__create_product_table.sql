CREATE TABLE `product` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
   `name` VARCHAR(255),
   `price` DOUBLE NOT NULL,
   `description` VARCHAR(255),
   `product_identifier` VARCHAR(255),
   `category_id` BIGINT,
   CONSTRAINT `pk_product` PRIMARY KEY (id)
);

ALTER TABLE `product` ADD CONSTRAINT `fk_product_on_category` FOREIGN KEY (category_id) REFERENCES `category` (id);