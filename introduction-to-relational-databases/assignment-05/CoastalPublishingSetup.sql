-- --------------------------------------------------------
-- CoastalPublishing Setup
--
-- Author: Clint Fuchs
-- Course: CSCI 225
-- Assignment: 6
-- Date: 6/27/2018
-- Version: 1.0
-- --------------------------------------------------------



SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- Note: this deletes teh database if it exists, for easy reloading
DROP SCHEMA IF EXISTS `CoastalPublishing` ;

CREATE SCHEMA IF NOT EXISTS `CoastalPublishing` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `CoastalPublishing` ;

-- -----------------------------------------------------
-- Table `CoastalPublishing`.`Agent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoastalPublishing`.`Agent` ;

CREATE TABLE IF NOT EXISTS `CoastalPublishing`.`Agent` (
  `agentID` INT NOT NULL AUTO_INCREMENT,
  `AgentFirstName` VARCHAR(45) NOT NULL,
  `AgentLastName` VARCHAR(45) NOT NULL,
  `AgentPhone` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`agentID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoastalPublishing`.`Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoastalPublishing`.`Author` ;

CREATE TABLE IF NOT EXISTS `CoastalPublishing`.`Author` (
  `authorID` INT NOT NULL,
  `AuthorFirstName` VARCHAR(45) NOT NULL,
  `AuthorLastName` VARCHAR(45) NOT NULL,
  `Agent_agentID` INT NULL,
  PRIMARY KEY (`authorID`),
  INDEX `fk_Author_Agent_idx` (`Agent_agentID` ASC),
  CONSTRAINT `fk_Author_Agent`
    FOREIGN KEY (`Agent_agentID`)
    REFERENCES `CoastalPublishing`.`Agent` (`agentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoastalPublishing`.`Editor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoastalPublishing`.`Editor` ;

CREATE TABLE IF NOT EXISTS `CoastalPublishing`.`Editor` (
  `editorID` INT NOT NULL AUTO_INCREMENT,
  `EditorFirstName` VARCHAR(45) NULL,
  `EditorLastName` VARCHAR(45) NULL,
  `mentorID` INT NULL,
  PRIMARY KEY (`editorID`),
  INDEX `fk_Editor_Editor1_idx` (`mentorID` ASC),
  CONSTRAINT `fk_Editor_Editor1`
    FOREIGN KEY (`mentorID`)
    REFERENCES `CoastalPublishing`.`Editor` (`editorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoastalPublishing`.`Book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoastalPublishing`.`Book` ;

CREATE TABLE IF NOT EXISTS `CoastalPublishing`.`Book` (
  `BookTitle` VARCHAR(55) NOT NULL,
  `BookGenre` VARCHAR(45) NULL,
  `BookPublishDate` VARCHAR(10) NOT NULL,
  `BookNumberOfPages` INT NOT NULL,
  `Author_authorID` INT NOT NULL,
  `Editor_editorID` INT NOT NULL,
  PRIMARY KEY (`BookTitle`, `Author_authorID`),
  INDEX `fk_Book_Author1_idx` (`Author_authorID` ASC),
  INDEX `fk_Book_Editor1_idx` (`Editor_editorID` ASC),
  CONSTRAINT `fk_Book_Author1`
    FOREIGN KEY (`Author_authorID`)
    REFERENCES `CoastalPublishing`.`Author` (`authorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Editor1`
    FOREIGN KEY (`Editor_editorID`)
    REFERENCES `CoastalPublishing`.`Editor` (`editorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
