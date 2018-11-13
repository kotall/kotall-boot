

insert  into `sys_org`(`parent_id`,`code`,`name`,`order_num`,`status`,`create_time`,`update_time`) values ((select o.org_id from sys_org o where o.code='BMS'),'X-BOSS','X-BOSS系统',1,1,NOW(),NOW());

INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `code`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `create_time`, `update_time`)
 VALUES (1455341074, 0, '/store', '店铺管理', NULL, NULL, 0, 'fa fa-bank', 3, NOW(), NOW());
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `code`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `create_time`, `update_time`)
 VALUES (-1766944, 0, '/product', '商品管理', NULL, NULL, 0, 'fa fa-bullhorn', 4, NOW(), NOW());
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `code`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `create_time`, `update_time`)
 VALUES (1451576447, 0, '/order', '订单管理', NULL, NULL, 0, 'fa fa-list', 5, NOW(), NOW());
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `code`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `create_time`, `update_time`)
 VALUES (1980197769, 0, '/member', '会员管理', NULL, NULL, 0, 'fa fa-user-circle', 6, NOW(), NOW());
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `code`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `create_time`, `update_time`)
 VALUES (-1628868919, 1455341074, '/store/my', '我的店铺', 'boss/store', 'store:list', 1, 'fa fa-coffee', 1, NOW(), NOW());
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `code`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `create_time`, `update_time`)
 VALUES (-1567936435, -1766944, '/product/category', '品类管理', 'boss/product', 'product:list', 1, 'fa fa-gift', 1, NOW(), NOW());
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `code`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `create_time`, `update_time`)
 VALUES (-2111722180, 1451576447, '/order/my', '我的订单', 'boss/order', 'order:list', 1, 'fa fa-calculator', 1, NOW(), NOW());
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `code`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `create_time`, `update_time`)
 VALUES (695974386, 1980197769, '/member/my', '我的会员', 'boss/member', 'member:list', 1, 'fa fa-user-o', 1, NOW(), NOW());



INSERT INTO `sys_role`(`org_id`, `role_name`, `role_sign`,`remark`, `user_id_create`, `create_time`, `update_time`)
 VALUES ((select o.org_id from sys_org o where o.code='X-BOSS'), '店长', 'boss', '【店长】', (select u.user_id from sys_user u where u.username='admin' and u.org_id=(select o.org_id from sys_org o where o.code='BMS')), NOW(), NOW());
INSERT INTO `sys_role`(`org_id`, `role_name`, `role_sign`,`remark`, `user_id_create`, `create_time`, `update_time`)
 VALUES ((select o.org_id from sys_org o where o.code='X-BOSS'), '收银员', 'cashier', '【收银员】', (select u.user_id from sys_user u where u.username='admin' and u.org_id=(select o.org_id from sys_org o where o.code='BMS')), NOW(), NOW());



INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ((select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select m.menu_id from sys_menu m where m.code='/store'));
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ((select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select m.menu_id from sys_menu m where m.code='/product'));
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ((select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select m.menu_id from sys_menu m where m.code='/order'));
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ((select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select m.menu_id from sys_menu m where m.code='/member'));
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ((select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select m.menu_id from sys_menu m where m.code='/store/my'));
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ((select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select m.menu_id from sys_menu m where m.code='/product/category'));
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ((select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select m.menu_id from sys_menu m where m.code='/order/my'));
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ((select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select m.menu_id from sys_menu m where m.code='/member/my'));


insert  into `sys_user`(`org_id`,`username`,`password`,`email`,`mobile`,`status`,`remark`,`user_id_create`,`create_time`,`update_time`)
values ((select o.org_id from sys_org o where o.code='X-BOSS'),'xboss','059b10ce049920dac171ab5f1ce3963d','xboss@kotall.com','15001906953',1,NULL,(select u.user_id from sys_user u where u.username='admin' and u.org_id=(select o.org_id from sys_org o where o.code='BMS')),NOW(),NOW());


insert  into `sys_user_role`(`user_id`,`role_id`)
values ((select u.user_id from sys_user u where u.username='xboss' and u.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')), (select r.role_id from sys_role r where r.role_sign='boss' and r.org_id=(select o.org_id from sys_org o where o.code='X-BOSS')));
