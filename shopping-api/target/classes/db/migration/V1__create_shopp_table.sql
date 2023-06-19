CREATE TABLE `shopp` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
   `user_identifier` VARCHAR(255),
   `total` DOUBLE NOT NULL,
   `date` date,
   CONSTRAINT `pk_shopp` PRIMARY KEY (id)
);

CREATE TABLE `item` (
  `shop_id` BIGINT NOT NULL,
   `product_identifier` VARCHAR(255),
   `price` DOUBLE
);

ALTER TABLE `item` ADD CONSTRAINT `fk_item_on_shopp` FOREIGN KEY (`shop_id`) REFERENCES `shopp` (id);