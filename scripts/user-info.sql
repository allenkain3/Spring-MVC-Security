CREATE DATABASE IF NOT EXISTS `user_directory`;
USE `user_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;


CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `users` 
VALUES 
('jen','{noop}test123',1),
('kim','{noop}test123',1),
('kai','{noop}test123',1);




CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `authorities` 
VALUES 
('jen','ROLE_USER'),
('kim','ROLE_USER'),
('kim','ROLE_MODERATOR'),
('kai','ROLE_USER'),
('kai','ROLE_MODERATOR'),
('kai','ROLE_OWNER');