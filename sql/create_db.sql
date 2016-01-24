CREATE USER admin@localhost identified BY 'admin';
GRANT usage ON *.* TO admin@localhost identified BY 'admin';
CREATE DATABASE IF NOT EXISTS device;
GRANT ALL privileges ON device.* TO admin@localhost;
USE device;
CREATE TABLE IF NOT EXISTS `device`.`Classes` (
  `class_id` INT NOT NULL AUTO_INCREMENT,
  `class_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`class_id`))
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `device`.`Keywords` (
  `keyword_id` INT NOT NULL AUTO_INCREMENT,
  `keyword` VARCHAR(20) NOT NULL,
  `binded_class` INT NOT NULL,
  PRIMARY KEY (`keyword_id`),
  UNIQUE INDEX `keyword_id_UNIQUE` (`keyword_id` ASC),
  INDEX `fk_Keywords_Class_idx` (`binded_class` ASC),
  CONSTRAINT `fk_Keywords_Class`
    FOREIGN KEY (`binded_class`)
    REFERENCES `device`.`Classes` (`class_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
