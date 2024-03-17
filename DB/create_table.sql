-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enjoytrip` DEFAULT CHARACTER SET utf8mb3 ;
USE `enjoytrip` ;

-- -----------------------------------------------------
-- Table `enjoytrip`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`sido` (
  `sido_code` INT NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`gugun` (
  `gugun_code` INT NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  `sido_code` INT NOT NULL,
  PRIMARY KEY (`gugun_code`, `sido_code`),
  INDEX `gugun_to_sido_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `gugun_to_sido_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_info` (
  `content_id` INT NOT NULL,
  `content_type_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `addr2` VARCHAR(50) NULL DEFAULT NULL,
  `zipcode` VARCHAR(50) NULL DEFAULT NULL,
  `tel` VARCHAR(50) NULL DEFAULT NULL,
  `first_image` VARCHAR(200) NULL DEFAULT NULL,
  `first_image2` VARCHAR(200) NULL DEFAULT NULL,
  `readcount` INT NULL DEFAULT NULL,
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `latitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `longitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `mlevel` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  INDEX `attraction_to_content_type_id_fk_idx` (`content_type_id` ASC) VISIBLE,
  INDEX `attraction_to_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  INDEX `attraction_to_gugun_code_fk_idx` (`gugun_code` ASC) VISIBLE,
  CONSTRAINT `attraction_to_content_type_id_fk`
    FOREIGN KEY (`content_type_id`)
    REFERENCES `enjoytrip`.`content_type` (`content_type_id`),
  CONSTRAINT `attraction_to_gugun_code_fk`
    FOREIGN KEY (`gugun_code`)
    REFERENCES `enjoytrip`.`gugun` (`gugun_code`),
  CONSTRAINT `attraction_to_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_description` (
  `content_id` INT NOT NULL,
  `homepage` VARCHAR(100) NULL DEFAULT NULL,
  `overview` VARCHAR(10000) NULL DEFAULT NULL,
  `telname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_attraciton_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_detail` (
  `content_id` INT NOT NULL,
  `cat1` VARCHAR(3) NULL DEFAULT NULL,
  `cat2` VARCHAR(5) NULL DEFAULT NULL,
  `cat3` VARCHAR(9) NULL DEFAULT NULL,
  `created_time` VARCHAR(14) NULL DEFAULT NULL,
  `modified_time` VARCHAR(14) NULL DEFAULT NULL,
  `booktour` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_basic_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `delete_yn` INT NOT NULL DEFAULT '0',
  `user_position` INT NOT NULL DEFAULT '1',
  `user_pwd` VARCHAR(20) NOT NULL,
  `user_nickname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `email_domain` VARCHAR(45) NULL DEFAULT NULL,
  `gender` VARCHAR(45) NULL DEFAULT NULL,
  `profile_img` VARCHAR(45) NULL DEFAULT NULL,
  `refresh_token` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_nickname_UNIQUE` (`user_nickname` ASC) VISIBLE,
  UNIQUE INDEX `refresh_token_UNIQUE` (`refresh_token` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`board` (
  `article_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NULL DEFAULT NULL,
  `article_type` VARCHAR(45) NULL DEFAULT '0',
  `article_title` VARCHAR(45) NOT NULL,
  `article_content` VARCHAR(45) NOT NULL,
  `article_hit` INT NULL DEFAULT '1',
  `article_register_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_no`),
  INDEX `article_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `ar_us_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`comment` (
  `comment_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NULL DEFAULT NULL,
  `comment_content` VARCHAR(45) NULL DEFAULT NULL,
  `comment_register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `article_no` INT NULL DEFAULT NULL,
  PRIMARY KEY (`comment_no`),
  INDEX `co_wr_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `co_bo_fk_idx` (`article_no` ASC) VISIBLE,
  CONSTRAINT `co_bo_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `enjoytrip`.`board` (`article_no`)
    ON DELETE CASCADE,
  CONSTRAINT `co_wr_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 36
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`file_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`file_info` (
  `file_id` INT NOT NULL AUTO_INCREMENT,
  `article_no` INT NULL DEFAULT NULL,
  `file_path` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`file_id`),
  INDEX `fi_ar_fk_idx` (`article_no` ASC) VISIBLE,
  CONSTRAINT `fi_ar_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `enjoytrip`.`board` (`article_no`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`interest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`interest` (
  `interest_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NULL DEFAULT NULL,
  `user_interest` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`interest_no`),
  INDEX `in_us_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `in_us_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`my_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`my_plan` (
  `plan_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NULL DEFAULT NULL,
  `plan_register_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `plan_open` VARCHAR(45) NULL DEFAULT '0',
  PRIMARY KEY (`plan_no`),
  INDEX `my_us_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `my_us_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`my_place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`my_place` (
  `place_no` INT NOT NULL AUTO_INCREMENT,
  `plan_no` INT NULL DEFAULT NULL,
  `content_id` INT NULL DEFAULT NULL,
  `sequence` INT NULL DEFAULT NULL,
  PRIMARY KEY (`place_no`),
  INDEX `place_plan_fk_idx` (`plan_no` ASC) VISIBLE,
  INDEX `place_att_fk_idx` (`content_id` ASC) VISIBLE,
  CONSTRAINT `place_att_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`),
  CONSTRAINT `place_plan_fk`
    FOREIGN KEY (`plan_no`)
    REFERENCES `enjoytrip`.`my_plan` (`plan_no`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
