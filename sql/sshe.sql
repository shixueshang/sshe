-- MySQL Script generated by MySQL Workbench
-- 10/28/16 16:06:56
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sshe
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sshe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sshe` DEFAULT CHARACTER SET utf8 ;
USE `sshe` ;

-- -----------------------------------------------------
-- Table `sshe`.`resources`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sshe`.`resources` ;

CREATE TABLE IF NOT EXISTS `sshe`.`resources` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL COMMENT '资源名称',
  `parent_id` VARCHAR(45) NULL DEFAULT NULL COMMENT '父级资源',
  `url` VARCHAR(255) NOT NULL COMMENT '地址',
  `description` VARCHAR(500) NULL DEFAULT NULL,
  `is_valid` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `url_UNIQUE` (`url` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '资源表';


-- -----------------------------------------------------
-- Table `sshe`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sshe`.`role` ;

CREATE TABLE IF NOT EXISTS `sshe`.`role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_code` VARCHAR(45) NOT NULL COMMENT '角色代码',
  `role_name` VARCHAR(45) NOT NULL COMMENT '角色名称',
  `description` VARCHAR(45) NULL DEFAULT NULL COMMENT '角色描述',
  `is_valid` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `role_name_UNIQUE` (`role_code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '角色表';


-- -----------------------------------------------------
-- Table `sshe`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sshe`.`user` ;

CREATE TABLE IF NOT EXISTS `sshe`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login_name` VARCHAR(45) NOT NULL COMMENT '登录名',
  `display_name` VARCHAR(45) NOT NULL COMMENT '显示名',
  `password` VARCHAR(45) NOT NULL,
  `is_valid` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_name_UNIQUE` (`login_name` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '用户表';


-- -----------------------------------------------------
-- Table `sshe`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sshe`.`user_role` ;

CREATE TABLE IF NOT EXISTS `sshe`.`user_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '用户角色关联表';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
