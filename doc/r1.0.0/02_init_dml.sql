

-- 目录SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('-1984818959',0, '用户中心', '/litemall',NULL, NULL, '0', 'fa fa-coffee');
-- 菜单SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('-1591403991',(select m.menu_id from sys_menu m where m.code='/litemall'), '用户管理', '/litemall/user','mall/user/list.html', NULL, '1', 'fa fa-th-list');
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-189081404',(select m.menu_id from sys_menu m where m.code='/litemall/user'), '刷新', '/litemall/user/list', 'litemall:user:list', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-188880477',(select m.menu_id from sys_menu m where m.code='/litemall/user'), '新增', '/litemall/user/save', 'litemall:user:save', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-189295056',(select m.menu_id from sys_menu m where m.code='/litemall/user'), '修改', '/litemall/user/edit', 'litemall:user:edit', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-1150701782',(select m.menu_id from sys_menu m where m.code='/litemall/user'), '删除', '/litemall/user/remove', 'litemall:user:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('1627220182',(select m.menu_id from sys_menu m where m.code='/litemall'), '收货地址', '/litemall/address','mall/address/list.html', NULL, '1', 'fa fa-th-list');
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-1659261385',(select m.menu_id from sys_menu m where m.code='/litemall/address'), '刷新', '/litemall/address/list', 'litemall:address:list', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-1659060458',(select m.menu_id from sys_menu m where m.code='/litemall/address'), '新增', '/litemall/address/save', 'litemall:address:save', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-1659475037',(select m.menu_id from sys_menu m where m.code='/litemall/address'), '修改', '/litemall/address/edit', 'litemall:address:edit', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-949423139',(select m.menu_id from sys_menu m where m.code='/litemall/address'), '删除', '/litemall/address/remove', 'litemall:address:remove', '2', NULL);

INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('-570610164',(select m.menu_id from sys_menu m where m.code='/litemall'), '会员收藏', '/litemall/collect','mall/collect/list.html', NULL, '1', 'fa fa-th-list');
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-296568127',(select m.menu_id from sys_menu m where m.code='/litemall/collect'), '刷新', '/litemall/collect/list', 'litemall:collect:list', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-296367200',(select m.menu_id from sys_menu m where m.code='/litemall/collect'), '新增', '/litemall/collect/save', 'litemall:collect:save', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-296781779',(select m.menu_id from sys_menu m where m.code='/litemall/collect'), '修改', '/litemall/collect/edit', 'litemall:collect:edit', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-1366227481',(select m.menu_id from sys_menu m where m.code='/litemall/collect'), '删除', '/litemall/collect/remove', 'litemall:collect:remove', '2', NULL);

