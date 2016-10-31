/*
-- Query: SELECT * FROM sshe.resources
-- Date: 2016-10-31 10:45
*/
TRUNCATE  TABLE `resources`;
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (1,'顶级节点',NULL,'/',2,NULL,1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (2,'系统管理','1','/user',1,'系统管理菜单',1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (3,'用户列表','2','/user/list',1,'用户列表菜单',1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (4,'创建用户','2','/user/create',1,'创建用户菜单',1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (5,'用户保存','2','/user/save',2,'保存用户',1);
