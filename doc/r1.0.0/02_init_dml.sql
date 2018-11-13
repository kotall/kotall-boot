

-- 目录SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES (0, '用户中心', 'LITE_MALL_UC',NULL, NULL, '0', 'fa fa-coffee', 2);
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '用户管理', 'LITE_MALL_UC_USER','mall/user/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_USER'), '刷新', 'LITE_MALL_UC_USER_LIST', 'litemall:user:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_USER'), '新增', 'LITE_MALL_UC_USER_SAVE', 'litemall:user:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_USER'), '修改', 'LITE_MALL_UC_USER_EDIT', 'litemall:user:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_USER'), '删除', 'LITE_MALL_UC_USER_REMOVE', 'litemall:user:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '收货地址', 'LITE_MALL_UC_ADDRESS','mall/address/list.html', NULL, '1', 'fa fa-th-list', 2);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_ADDRESS'), '刷新', 'LITE_MALL_UC_ADDRESS_LIST', 'litemall:address:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_ADDRESS'), '新增', 'LITE_MALL_UC_ADDRESS_SAVE', 'litemall:address:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_ADDRESS'), '修改', 'LITE_MALL_UC_ADDRESS_EDIT', 'litemall:address:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_ADDRESS'), '删除', 'LITE_MALL_UC_ADDRESS_REMOVE', 'litemall:address:remove', '2', NULL);

INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '会员收藏', 'LITE_MALL_UC_COLLECT','mall/collect/list.html', NULL, '1', 'fa fa-th-list', 3);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_COLLECT'), '刷新', 'LITE_MALL_UC_COLLECT_LIST', 'litemall:collect:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_COLLECT'), '新增', 'LITE_MALL_UC_COLLECT_SAVE', 'litemall:collect:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_COLLECT'), '修改', 'LITE_MALL_UC_COLLECT_EDIT', 'litemall:collect:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_COLLECT'), '删除', 'LITE_MALL_UC_COLLECT_REMOVE', 'litemall:collect:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '会员足迹', 'LITE_MALL_UC_FOOTPRINT','mall/footprint/list.html', NULL, '1', 'fa fa-th-list', 4);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FOOTPRINT'), '刷新', 'LITE_MALL_UC_FOOTPRINT_LIST', 'litemall:footprint:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FOOTPRINT'), '新增', 'LITE_MALL_UC_FOOTPRINT_SAVE', 'litemall:footprint:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FOOTPRINT'), '修改', 'LITE_MALL_UC_FOOTPRINT_EDIT', 'litemall:footprint:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FOOTPRINT'), '删除', 'LITE_MALL_UC_FOOTPRINT_REMOVE', 'litemall:footprint:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '搜索历史', 'LITE_MALL_UC_HISTORY','mall/history/list.html', NULL, '1', 'fa fa-th-list', 5);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_HISTORY'), '刷新', 'LITE_MALL_UC_HISTORY_LIST', 'litemall:history:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_HISTORY'), '新增', 'LITE_MALL_UC_HISTORY_SAVE', 'litemall:history:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_HISTORY'), '修改', 'LITE_MALL_UC_HISTORY_EDIT', 'litemall:history:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_HISTORY'), '删除', 'LITE_MALL_UC_HISTORY_REMOVE', 'litemall:history:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '意见反馈', 'LITE_MALL_UC_FEEDBACK','mall/feedback/list.html', NULL, '1', 'fa fa-th-list', 6);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FEEDBACK'), '刷新', 'LITE_MALL_UC_FEEDBACK_LIST', 'litemall:feedback:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FEEDBACK'), '新增', 'LITE_MALL_UC_FEEDBACK_SAVE', 'litemall:feedback:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FEEDBACK'), '修改', 'LITE_MALL_UC_FEEDBACK_EDIT', 'litemall:feedback:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FEEDBACK'), '删除', 'LITE_MALL_UC_FEEDBACK_REMOVE', 'litemall:feedback:remove', '2', NULL);


INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES (0, '店铺管理', 'LITE_MALL_STORE',NULL, NULL, '0', 'fa fa-coffee', 3);
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '品牌管理', 'LITE_MALL_STORE_BRAND','mall/brand/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_BRAND'), '刷新', 'LITE_MALL_STORE_BRAND_LIST', 'litemall:brand:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_BRAND'), '新增', 'LITE_MALL_STORE_BRAND_SAVE', 'litemall:brand:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_BRAND'), '修改', 'LITE_MALL_STORE_BRAND_EDIT', 'litemall:brand:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_BRAND'), '删除', 'LITE_MALL_STORE_BRAND_REMOVE', 'litemall:brand:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '商品类目', 'LITE_MALL_STORE_CATEGORY','mall/category/list.html', NULL, '1', 'fa fa-th-list', 2);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_CATEGORY'), '刷新', 'LITE_MALL_STORE_CATEGORY_LIST', 'litemall:category:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_CATEGORY'), '新增', 'LITE_MALL_STORE_CATEGORY_SAVE', 'litemall:category:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_CATEGORY'), '修改', 'LITE_MALL_STORE_CATEGORY_EDIT', 'litemall:category:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_CATEGORY'), '删除', 'LITE_MALL_STORE_CATEGORY_REMOVE', 'litemall:category:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '订单管理', 'LITE_MALL_STORE_ORDER','mall/order/list.html', NULL, '1', 'fa fa-th-list', 3);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ORDER'), '刷新', 'LITE_MALL_STORE_ORDER_LIST', 'litemall:order:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ORDER'), '新增', 'LITE_MALL_STORE_ORDER_SAVE', 'litemall:order:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ORDER'), '修改', 'LITE_MALL_STORE_ORDER_EDIT', 'litemall:order:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ORDER'), '删除', 'LITE_MALL_STORE_ORDER_REMOVE', 'litemall:order:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '常见问题', 'LITE_MALL_STORE_ISSUE','mall/issue/list.html', NULL, '1', 'fa fa-th-list', 4);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ISSUE'), '刷新', 'LITE_MALL_STORE_ISSUE_LIST', 'litemall:issue:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ISSUE'), '新增', 'LITE_MALL_STORE_ISSUE_SAVE', 'litemall:issue:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ISSUE'), '修改', 'LITE_MALL_STORE_ISSUE_EDIT', 'litemall:issue:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ISSUE'), '删除', 'LITE_MALL_STORE_ISSUE_REMOVE', 'litemall:issue:remove', '2', NULL);


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '关键字管理', 'LITE_MALL_STORE_KEYWORD','mall/keyword/list.html', NULL, '1', 'fa fa-th-list', 5);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_KEYWORD'), '刷新', 'LITE_MALL_STORE_KEYWORD_LIST', 'litemall:keyword:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_KEYWORD'), '新增', 'LITE_MALL_STORE_KEYWORD_SAVE', 'litemall:keyword:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_KEYWORD'), '修改', 'LITE_MALL_STORE_KEYWORD_EDIT', 'litemall:keyword:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_KEYWORD'), '删除', 'LITE_MALL_STORE_KEYWORD_REMOVE', 'litemall:keyword:remove', '2', NULL);


-- 目录SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES (0, '商品管理', 'SYS_GOODS',NULL, NULL, '0', 'fa fa-coffee', 4);
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='SYS_GOODS'), '商品列表', 'SYS_GOODS_LIST','mall/goods/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='SYS_GOODS_LIST'), '刷新', 'SYS_GOODS_LIST_LIST', 'litemall:goods:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='SYS_GOODS_LIST'), '新增', 'SYS_GOODS_LIST_SAVE', 'litemall:goods:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='SYS_GOODS_LIST'), '修改', 'SYS_GOODS_LIST_EDIT', 'litemall:goods:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='SYS_GOODS_LIST'), '删除', 'SYS_GOODS_LIST_REMOVE', 'litemall:goods:remove', '2', NULL);
