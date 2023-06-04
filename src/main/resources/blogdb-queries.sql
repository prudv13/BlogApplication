CREATE DATABASE blogdb;
USE blogdb;

SHOW TABLES;

SELECT * FROM blogdb.posts;

-- -------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM blogdb.users;

INSERT INTO `blogdb`.`users` (`id`, `email`, `name`, `password`, `username`) VALUES ('1', 'prudhvi1522@gmail.com', 'prudhvi', 'Prudhvi@06', 'prudhvi');
INSERT INTO `blogdb`.`users` (`id`, `email`, `name`, `password`, `username`) VALUES ('2', 'admin@gmail.com', 'admin', 'admin', 'admin');

UPDATE `blogdb`.`users` SET `password` = '$2a$10$u5qAFKXszTs5mnmLA6rHNOwlYIRdsy/DXP2Mh9DA2.okCg09LMjZe' WHERE (`id` = '2');
UPDATE `blogdb`.`users` SET `password` = '$2a$10$5aakpQsyF43/ihPQ5s8.7.CQkRPCMJho7BBSRrhtaAywlGWL1D9RW' WHERE (`id` = '1');

-- -------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM blogdb.roles;

INSERT INTO `blogdb`.`roles` (`id`, `name`) VALUES ('1', 'ROLE_USER');
INSERT INTO `blogdb`.`roles` (`id`, `name`) VALUES ('2', 'ROLE_ADMIN');

-- -------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM blogdb.users_roles;

INSERT INTO `blogdb`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `blogdb`.`users_roles` (`user_id`, `role_id`) VALUES ('2', '2');

-- -------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM blogdb.categories;