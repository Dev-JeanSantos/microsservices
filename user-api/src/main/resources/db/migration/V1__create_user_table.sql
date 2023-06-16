CREATE TABLE `user` (
  id BIGINT AUTO_INCREMENT NOT NULL,
   `name` VARCHAR(255),
   `cpf` VARCHAR(255),
   `address` VARCHAR(255),
   `email` VARCHAR(255),
   `phone` VARCHAR(255),
   `registration_date` date,
   CONSTRAINT `pk_user` PRIMARY KEY (id)
);