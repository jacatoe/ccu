-- ------------------------------------------------------------
-- CoastalPublishing Setup: Sets up schema and tables
-- Author: Joshua Catoe
-- Course: CSCI 225
-- Assignment: 04
-- Date: 06/26/18
-- Version: 1.0
-- ------------------------------------------------------------

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CoastalPublishing
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `CoastalPublishing` ;

-- -----------------------------------------------------
-- Schema CoastalPublishing
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CoastalPublishing` DEFAULT CHARACTER SET utf8 ;
USE `CoastalPublishing` ;

-- -----------------------------------------------------
-- Table `CoastalPublishing`.`Agent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoastalPublishing`.`Agent` ;

CREATE TABLE IF NOT EXISTS `CoastalPublishing`.`Agent` (
  `AgentID` INT NOT NULL AUTO_INCREMENT,
  `AgentFirstName` VARCHAR(45) NOT NULL,
  `AgentLastName` VARCHAR(45) NOT NULL,
  `AgentPhone` CHAR(12) NOT NULL,
  PRIMARY KEY (`AgentID`),
  UNIQUE INDEX `AgentID_UNIQUE` (`AgentID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoastalPublishing`.`Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoastalPublishing`.`Author` ;

CREATE TABLE IF NOT EXISTS `CoastalPublishing`.`Author` (
  `AuthorID` INT NOT NULL AUTO_INCREMENT,
  `AuthorFirstName` VARCHAR(45) NOT NULL,
  `AuthorLastName` VARCHAR(45) NOT NULL,
  `AgentID` INT NULL,
  PRIMARY KEY (`AuthorID`),
  UNIQUE INDEX `AuthorID_UNIQUE` (`AuthorID` ASC),
  INDEX `fk_Author_Agent1_idx` (`AgentID` ASC),
  CONSTRAINT `AgentID`
    FOREIGN KEY (`AgentID`)
    REFERENCES `CoastalPublishing`.`Agent` (`AgentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoastalPublishing`.`Editor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoastalPublishing`.`Editor` ;

CREATE TABLE IF NOT EXISTS `CoastalPublishing`.`Editor` (
  `EditorID` INT NOT NULL AUTO_INCREMENT,
  `EditorFirstName` VARCHAR(45) NOT NULL,
  `EditorLastName` VARCHAR(45) NOT NULL,
  `MentorID` INT NULL,
  UNIQUE INDEX `EditorID_UNIQUE` (`EditorID` ASC),
  INDEX `fk_Editor_Editor1_idx` (`MentorID` ASC),
  PRIMARY KEY (`EditorID`),
  CONSTRAINT `MentorID`
    FOREIGN KEY (`MentorID`)
    REFERENCES `CoastalPublishing`.`Editor` (`EditorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoastalPublishing`.`Book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoastalPublishing`.`Book` ;

CREATE TABLE IF NOT EXISTS `CoastalPublishing`.`Book` (
  `BookTitle` VARCHAR(45) NOT NULL,
  `AuthorID` INT NOT NULL,
  `BookGenre` VARCHAR(45) NULL,
  `BookPublishDate` CHAR(4) NOT NULL,
  `BookNumPages` VARCHAR(45) NOT NULL,
  `EditorID` INT NOT NULL,
  PRIMARY KEY (`BookTitle`, `AuthorID`),
  INDEX `fk_Book_Editor1_idx` (`EditorID` ASC),
  CONSTRAINT `AuthorID`
    FOREIGN KEY (`AuthorID`)
    REFERENCES `CoastalPublishing`.`Author` (`AuthorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EditorID`
    FOREIGN KEY (`EditorID`)
    REFERENCES `CoastalPublishing`.`Editor` (`EditorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
