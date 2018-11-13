

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


-- 菜单SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('-1120774303',(select m.menu_id from sys_menu m where m.code='/litemall'), '会员足迹', '/litemall/footprint','mall/footprint/list.html', NULL, '1', 'fa fa-th-list');
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-805626228',(select m.menu_id from sys_menu m where m.code='/litemall/footprint'), '刷新', '/litemall/footprint/list', 'litemall:footprint:list', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-805425301',(select m.menu_id from sys_menu m where m.code='/litemall/footprint'), '新增', '/litemall/footprint/save', 'litemall:footprint:save', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-805839880',(select m.menu_id from sys_menu m where m.code='/litemall/footprint'), '修改', '/litemall/footprint/edit', 'litemall:footprint:edit', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-944790798',(select m.menu_id from sys_menu m where m.code='/litemall/footprint'), '删除', '/litemall/footprint/remove', 'litemall:footprint:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('-593120906',(select m.menu_id from sys_menu m where m.code='/litemall'), '搜索历史', '/litemall/history','mall/history/list.html', NULL, '1', 'fa fa-th-list');
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('409323927',(select m.menu_id from sys_menu m where m.code='/litemall/history'), '刷新', '/litemall/history/list', 'litemall:history:list', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('409524854',(select m.menu_id from sys_menu m where m.code='/litemall/history'), '新增', '/litemall/history/save', 'litemall:history:save', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('409110275',(select m.menu_id from sys_menu m where m.code='/litemall/history'), '修改', '/litemall/history/edit', 'litemall:history:edit', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-1608796355',(select m.menu_id from sys_menu m where m.code='/litemall/history'), '删除', '/litemall/history/remove', 'litemall:history:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`) VALUES ('-68568349',(select m.menu_id from sys_menu m where m.code='/litemall'), '意见反馈', '/litemall/feedback','mall/feedback/list.html', NULL, '1', 'fa fa-th-list');
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-113271734',(select m.menu_id from sys_menu m where m.code='/litemall/feedback'), '刷新', '/litemall/feedback/list', 'litemall:feedback:list', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`)  VALUES ('-113070807',(select m.menu_id from sys_menu m where m.code='/litemall/feedback'), '新增', '/litemall/feedback/save', 'litemall:feedback:save', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-113485386',(select m.menu_id from sys_menu m where m.code='/litemall/feedback'), '修改', '/litemall/feedback/edit', 'litemall:feedback:edit', '2', NULL);
INSERT INTO `sys_menu` (`menu_id`,`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ('-1312052944',(select m.menu_id from sys_menu m where m.code='/litemall/feedback'), '删除', '/litemall/feedback/remove', 'litemall:feedback:remove', '2', NULL);
