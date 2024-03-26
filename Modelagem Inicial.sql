CREATE SCHEMA `projeto_integrador2` ;

CREATE TABLE `projeto_integrador2`.`users` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(20) NULL,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phonenumber` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser`));
  
CREATE TABLE `projeto_integrador2`.`projects` (
  `idprojects` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NULL,
  `user` INT NOT NULL,
  `initial_date` DATE NULL,
  `final_date` DATE NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  PRIMARY KEY (`idprojects`),
  INDEX `FK_user_project_idx` (`user` ASC) VISIBLE,
  CONSTRAINT `FK_user_project`
    FOREIGN KEY (`user`)
    REFERENCES `projeto_integrador2`.`users` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `projeto_integrador2`.`projetct_itens` (
  `idprojetct_item` INT NOT NULL AUTO_INCREMENT,
  `project` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  `file_directory` VARCHAR(200) NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  PRIMARY KEY (`idprojetct_item`),
  INDEX `FK_project_item_idx` (`project` ASC) VISIBLE,
  CONSTRAINT `FK_project_item`
    FOREIGN KEY (`project`)
    REFERENCES `projeto_integrador2`.`projects` (`idprojects`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
ALTER TABLE `projeto_integrador2`.`users` 
ADD COLUMN `created_at` DATE NULL AFTER `phonenumber`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`;

CREATE TABLE `projeto_integrador2`.`portifolio_sections` (
  `idportifolio_sections` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NULL,
  `project` INT NOT NULL,
  `active` TINYINT NOT NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  PRIMARY KEY (`idportifolio_sections`),
  INDEX `FK_project_portfolio_section_idx` (`project` ASC) VISIBLE,
  CONSTRAINT `FK_project_portfolio_section`
    FOREIGN KEY (`project`)
    REFERENCES `projeto_integrador2`.`projects` (`idprojects`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
ALTER TABLE `projeto_integrador2`.`projetct_itens` 
ADD COLUMN `is_portfolio_item` TINYINT NULL AFTER `updated_at`;

ALTER TABLE `projeto_integrador2`.`projects` 
ADD COLUMN `portfolio_section` INT NULL AFTER `updated_at`,
ADD INDEX `FK_portfolio_project_idx` (`portfolio_section` ASC) VISIBLE;
;
ALTER TABLE `projeto_integrador2`.`projects` 
ADD CONSTRAINT `FK_portfolio_project`
  FOREIGN KEY (`portfolio_section`)
  REFERENCES `projeto_integrador2`.`portifolio_sections` (`idportifolio_sections`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `projeto_integrador2`.`roles` (
  `idroles` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idroles`));

CREATE TABLE `projeto_integrador2`.`users_has_roles` (
  `idusers_has_roles` INT NOT NULL,
  `user` INT NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`idusers_has_roles`),
  INDEX `FK_user_idx` (`user` ASC) VISIBLE,
  INDEX `FK_role_idx` (`role` ASC) VISIBLE,
  CONSTRAINT `FK_user`
    FOREIGN KEY (`user`)
    REFERENCES `projeto_integrador2`.`users` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_role`
    FOREIGN KEY (`role`)
    REFERENCES `projeto_integrador2`.`roles` (`idroles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
ALTER TABLE `projeto_integrador2`.`roles` 
ADD COLUMN `created_at` DATE NULL AFTER `name`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`;
