-- MIGRATION SCRIPT
-- Database Type: DBType{type='mysql', urlScheme='jdbc:', dialect='org.hibernate.dialect.MySQLDialect', driverClass='org.mariadb.jdbc.Driver'}
-- App Name: TELUSAgentUI
-- Database: TELUSAgentUIDB
-- Created At: 03-Aug-2023 15:20:10.UTC
-- Script Version: 11.0
-- -----------------------------------------------------------------
ALTER TABLE `ENTITY_DOCUMENTS` ADD COLUMN `createdByEmplId` VARCHAR(100) NULL;
