SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `StudentMajor` ;
CREATE SCHEMA IF NOT EXISTS `StudentMajor` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `StudentMajor` ;

-- -----------------------------------------------------
-- Table `StudentMajor`.`Major`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentMajor`.`Major` ;

CREATE TABLE IF NOT EXISTS `StudentMajor`.`Major` (
  `MajorCode` INT NOT NULL,
  `MajorName` VARCHAR(45) NOT NULL,
  `MajorProfessorCount` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MajorCode`),
  UNIQUE INDEX `MajorName_UNIQUE` (`MajorName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentMajor`.`Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentMajor`.`Student` ;

CREATE TABLE IF NOT EXISTS `StudentMajor`.`Student` (
  `studentID` INT NOT NULL,
  `StudentSSN` VARCHAR(45) NOT NULL,
  `StudentFirstName` VARCHAR(45) NOT NULL,
  `StudentLastName` VARCHAR(45) NOT NULL,
  `StudentYear` VARCHAR(45) NOT NULL,
  `StudentGPA` DOUBLE NOT NULL,
  `Major_MajorCode` INT NOT NULL,
  PRIMARY KEY (`studentID`),
  UNIQUE INDEX `StudentSSN_UNIQUE` (`StudentSSN` ASC),
  INDEX `fk_Student_Major_idx` (`Major_MajorCode` ASC),
  CONSTRAINT `fk_Student_Major`
    FOREIGN KEY (`Major_MajorCode`)
    REFERENCES `StudentMajor`.`Major` (`MajorCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
