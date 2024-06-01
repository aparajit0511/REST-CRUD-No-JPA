CREATE DATABASE IF NOT EXISTS `employee1`;
USE `employee1`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee`(
	`id` int NOT NULL AUTO_INCREMENT,
	`first_name` varchar(45) DEFAULT NULL,
	`last_name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `employee` VALUES
	(1,'aparajit','chatterjee','ap@12345.com'),
	(2,'ashu','adopted','ashu@1234.com');