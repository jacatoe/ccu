-- Joshua Catoe
-- 06/24/18
-- CSCI 225
-- CompanyEmployee Script

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CompanyEmployee
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CompanyEmployee
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CompanyEmployee` DEFAULT CHARACTER SET utf8 ;
USE `CompanyEmployee` ;

-- -----------------------------------------------------
-- Table `CompanyEmployee`.`Company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CompanyEmployee`.`Company` ;

CREATE TABLE IF NOT EXISTS `CompanyEmployee`.`Company` (
  `CompanyID` INT NOT NULL AUTO_INCREMENT,
  `CompanyName` VARCHAR(45) NOT NULL,
  `CompanyFoundingDate` DATE NOT NULL,
  PRIMARY KEY (`CompanyID`),
  UNIQUE INDEX `CompanyID_UNIQUE` (`CompanyID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CompanyEmployee`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CompanyEmployee`.`Employee` ;

CREATE TABLE IF NOT EXISTS `CompanyEmployee`.`Employee` (
  `EmployeeID` INT NOT NULL AUTO_INCREMENT,
  `EmployeePhoneNumber` CHAR(12) NOT NULL,
  `EmployeeSalary` VARCHAR(45) NULL,
  `EmployeeFirstName` VARCHAR(45) NOT NULL,
  `EmployeeLastName` VARCHAR(45) NOT NULL,
  `Company_CompanyID` INT NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  UNIQUE INDEX `EmployeeID_UNIQUE` (`EmployeeID` ASC),
  INDEX `fk_Employee_Company1_idx` (`Company_CompanyID` ASC),
  CONSTRAINT `fk_Employee_Company1`
    FOREIGN KEY (`Company_CompanyID`)
    REFERENCES `CompanyEmployee`.`Company` (`CompanyID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CompanyEmployee`.`EmployeeSkill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CompanyEmployee`.`EmployeeSkill` ;

CREATE TABLE IF NOT EXISTS `CompanyEmployee`.`EmployeeSkill` (
  `EmpSkill` VARCHAR(45) NOT NULL,
  `Employee_EmployeeID` INT NOT NULL,
  PRIMARY KEY (`EmpSkill`, `Employee_EmployeeID`),
  CONSTRAINT `fk_EmployeeSkill_Employee`
    FOREIGN KEY (`Employee_EmployeeID`)
    REFERENCES `CompanyEmployee`.`Employee` (`EmployeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
