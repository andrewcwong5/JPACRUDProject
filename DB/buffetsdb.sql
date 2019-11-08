-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema buffets
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `buffets` ;

-- -----------------------------------------------------
-- Schema buffets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `buffets` DEFAULT CHARACTER SET utf8 ;
USE `buffets` ;

-- -----------------------------------------------------
-- Table `buffets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buffets` ;

CREATE TABLE IF NOT EXISTS `buffets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS eater@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'eater'@'localhost' IDENTIFIED BY 'eater';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'eater'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `buffets`
-- -----------------------------------------------------
START TRANSACTION;
USE `buffets`;
INSERT INTO `buffets` (`id`, `name`) VALUES (1, 'Eater');

COMMIT;

