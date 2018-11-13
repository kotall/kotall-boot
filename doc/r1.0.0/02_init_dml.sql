

-- 目录SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('-1984818959',0, '用户中心', '/litemall',NULL, NULL, '0', 'fa fa-coffee');
-- 菜单SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('-1591403991',(select m.menu_id from sys_menu m where m.code='/litemall'), '用户管理', '/litemall/user','mall/user/list.html', NULL, '1', 'fa fa-th-list');
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-189081404',(select m.menu_id from sys_menu m where m.code='/litemall/user'), '刷新', '/litemall/user/list', 'litemall:user:list', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-188880477',(select m.menu_id from sys_menu m where m.code='/litemall/user'), '新增', '/litemall/user/save', 'litemall:user:save', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-189295056',(select m.menu_id from sys_menu m where m.code='/litemall/user'), '修改', '/litemall/user/edit', 'litemall:user:edit', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-1150701782',(select m.menu_id from sys_menu m where m.code='/litemall/user'), '删除', '/litemall/user/remove', 'litemall:user:remove', '2', NULL);



