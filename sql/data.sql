/*
-- Query: SELECT * FROM sshe.resources
-- Date: 2016-10-31 17:15
*/

INSERT INTO `sshe`.`user` (`id`, `login_name`, `display_name`, `password`, `is_valid`) VALUES ('1', 'admin', '管理员', '21232f297a57a5a743894a0e4a801fc3', '1');


TRUNCATE TABLE `resources`;
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (1,'顶级节点',NULL,'/',2,NULL,1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (2,'系统管理','1','/admin',1,'系统管理菜单',1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (3,'用户列表','2','/admin/user/list',1,'用户列表菜单',1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (4,'创建用户','2','/admin/user/create',1,'创建用户菜单',1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (5,'用户保存','2','/admin/user/save',2,'保存用户',1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (6,'系统工具','1','/system',1, '系统工具',1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (7,'性能监控','6','/system/monitoring',1, 'druid性能监控', 1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (8,'角色列表','2','/admin/role/list',1, '角色列表菜单', 1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (9,'创建角色','2','/admin/role/create',1, '创建角色菜单', 1);
INSERT INTO `resources` (`id`,`name`,`parent_id`,`url`,`level`,`description`,`is_valid`) VALUES (10,'角色保存','2','/admin/role/save',1, '保存角色', 1);



TRUNCATE TABLE `role`;
INSERT INTO `sshe`.`role` (`id`, `role_code`, `role_name`, `description`, `is_valid`) VALUES ('1', 'role_common', '一般角色', '拥有基本权限', '1');
INSERT INTO `sshe`.`role` (`id`, `role_code`, `role_name`, `description`, `is_valid`) VALUES ('2', 'role_system', '系统角色', '拥有所有权限', '1');
