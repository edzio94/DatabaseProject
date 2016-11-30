CREATE TABLE`item` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `company` varchar(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `type` INT NOT NULL,
  `is_imported` TINYINT(1) NOT NULL
);
CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL
);

CREATE TABLE `userdetails` (
  `id` INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  `created` DATE,
  `is_admin` INT DEFAULT 0,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id)

);
