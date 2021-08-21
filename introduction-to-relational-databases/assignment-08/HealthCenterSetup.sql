-- ---------------------------------------------------
-- HealthCenterSetup: Sets up tables for Assignment 08
-- Author: Joshua Catoe
-- Course: CSCI 225
-- Assignment: 08
-- Date: 07/05/18
-- Version: 1.0
-- ---------------------------------------------------

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema HealthCenter
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `HealthCenter` ;

-- -----------------------------------------------------
-- Schema HealthCenter
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `HealthCenter` DEFAULT CHARACTER SET utf8 ;
USE `HealthCenter` ;

-- -----------------------------------------------------
-- Table `HealthCenter`.`INSURANCE_COMPANY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HealthCenter`.`INSURANCE_COMPANY` ;

CREATE TABLE IF NOT EXISTS `HealthCenter`.`INSURANCE_COMPANY` (
  `InsuranceCoID` INT NOT NULL,
  `InsuranceCoName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`InsuranceCoID`),
  UNIQUE INDEX `InsuranceCoID_UNIQUE` (`InsuranceCoID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HealthCenter`.`PATIENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HealthCenter`.`PATIENT` ;

CREATE TABLE IF NOT EXISTS `HealthCenter`.`PATIENT` (
  `PatientID` INT NOT NULL,
  `PatientName` VARCHAR(45) NOT NULL,
  `INSURANCE_COMPANY_InsuranceCoID` INT NOT NULL,
  PRIMARY KEY (`PatientID`),
  UNIQUE INDEX `PatientID_UNIQUE` (`PatientID` ASC),
  INDEX `fk_PATIENT_INSURANCE_COMPANY1_idx` (`INSURANCE_COMPANY_InsuranceCoID` ASC),
  CONSTRAINT `fk_PATIENT_INSURANCE_COMPANY1`
    FOREIGN KEY (`INSURANCE_COMPANY_InsuranceCoID`)
    REFERENCES `HealthCenter`.`INSURANCE_COMPANY` (`InsuranceCoID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HealthCenter`.`DOCTOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HealthCenter`.`DOCTOR` ;

CREATE TABLE IF NOT EXISTS `HealthCenter`.`DOCTOR` (
  `DocID` INT NOT NULL,
  `DocName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DocID`),
  UNIQUE INDEX `DocID_UNIQUE` (`DocID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HealthCenter`.`APPOINTMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HealthCenter`.`APPOINTMENT` ;

CREATE TABLE IF NOT EXISTS `HealthCenter`.`APPOINTMENT` (
  `DOCTOR_DocID` INT NOT NULL,
  `PATIENT_PatientID` INT NOT NULL,
  `NextAppointmentDate` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DOCTOR_DocID`, `PATIENT_PatientID`),
  INDEX `fk_APPOINTMENT_DOCTOR1_idx` (`DOCTOR_DocID` ASC),
  CONSTRAINT `fk_APPOINTMENT_PATIENT1`
    FOREIGN KEY (`PATIENT_PatientID`)
    REFERENCES `HealthCenter`.`PATIENT` (`PatientID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_APPOINTMENT_DOCTOR1`
    FOREIGN KEY (`DOCTOR_DocID`)
    REFERENCES `HealthCenter`.`DOCTOR` (`DocID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
