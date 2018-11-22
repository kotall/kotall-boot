
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.banner.new.title', '大家都在买的', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.banner.new.imageurl', 'http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.banner.hot.title', '大家都在买的', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.banner.hot.imageurl', 'http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.freight.value', '8', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.freight.limit', '88', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.indexlimit.new', '6', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.indexlimit.hot', '6', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.indexlimit.brand', '4', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.indexlimit.topic', '4', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.indexlimit.catloglist', '4', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.indexlimit.catloggood', '4', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.mallname', 'litemall', NOW(), NOW(), 0);
INSERT INTO `sys_config`(`param_key`, `param_value`, `create_time`, `update_time`, `deleted`) VALUES ('litemall.system.shareimage.autocreate', '0', NOW(), NOW(), 0);


-- 目录：店铺管理
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES (0, '店铺管理', 'LITE_MALL_STORE',NULL, NULL, '0', 'fa fa-coffee', 2);

-- 菜单: 店铺列表
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '店铺列表', 'LITE_MALL_STORE_LIST','mall/store/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_LIST'), '刷新', 'LITE_MALL_STORE_LIST_LIST', 'litemall:store:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_LIST'), '新增', 'LITE_MALL_STORE_LIST_SAVE', 'litemall:store:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_LIST'), '修改', 'LITE_MALL_STORE_LIST_EDIT', 'litemall:store:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_LIST'), '删除', 'LITE_MALL_STORE_LIST_REMOVE', 'litemall:store:remove', '2', NULL);

-- 菜单: 品牌管理
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '品牌管理', 'LITE_MALL_STORE_BRAND','mall/brand/list.html', NULL, '1', 'fa fa-th-list', 2);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_BRAND'), '刷新', 'LITE_MALL_STORE_BRAND_LIST', 'litemall:brand:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_BRAND'), '新增', 'LITE_MALL_STORE_BRAND_SAVE', 'litemall:brand:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_BRAND'), '修改', 'LITE_MALL_STORE_BRAND_EDIT', 'litemall:brand:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_BRAND'), '删除', 'LITE_MALL_STORE_BRAND_REMOVE', 'litemall:brand:remove', '2', NULL);

-- 菜单: 常见问题
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '常见问题', 'LITE_MALL_STORE_ISSUE','mall/issue/list.html', NULL, '1', 'fa fa-th-list', 3);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ISSUE'), '刷新', 'LITE_MALL_STORE_ISSUE_LIST', 'litemall:issue:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ISSUE'), '新增', 'LITE_MALL_STORE_ISSUE_SAVE', 'litemall:issue:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ISSUE'), '修改', 'LITE_MALL_STORE_ISSUE_EDIT', 'litemall:issue:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_ISSUE'), '删除', 'LITE_MALL_STORE_ISSUE_REMOVE', 'litemall:issue:remove', '2', NULL);

-- 菜单: 关键字管理
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '关键字管理', 'LITE_MALL_STORE_KEYWORD','mall/keyword/list.html', NULL, '1', 'fa fa-th-list', 4);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_KEYWORD'), '刷新', 'LITE_MALL_STORE_KEYWORD_LIST', 'litemall:keyword:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_KEYWORD'), '新增', 'LITE_MALL_STORE_KEYWORD_SAVE', 'litemall:keyword:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_KEYWORD'), '修改', 'LITE_MALL_STORE_KEYWORD_EDIT', 'litemall:keyword:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_KEYWORD'), '删除', 'LITE_MALL_STORE_KEYWORD_REMOVE', 'litemall:keyword:remove', '2', NULL);


-- 菜单: 小程序
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE'), '小程序管理', 'LITE_MALL_STORE_APP','mall/app/list.html', NULL, '1', 'fa fa-th-list', 5);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_APP'), '刷新', 'LITE_MALL_STORE_APP_LIST', 'litemall:app:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_APP'), '新增', 'LITE_MALL_STORE_APP_SAVE', 'litemall:app:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_APP'), '修改', 'LITE_MALL_STORE_APP_EDIT', 'litemall:app:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_STORE_APP'), '删除', 'LITE_MALL_STORE_APP_REMOVE', 'litemall:app:remove', '2', NULL);


-- 目录: 商品管理
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES (0, '商品管理', 'LITE_MALL_GOODS',NULL, NULL, '0', 'fa fa-coffee', 3);

-- 菜单: 商品类目
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS'), '商品类目', 'LITE_MALL_GOODS_CATEGORY','mall/category/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_CATEGORY'), '刷新', 'LITE_MALL_GOODS_CATEGORY_LIST', 'litemall:category:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_CATEGORY'), '新增', 'LITE_MALL_GOODS_CATEGORY_SAVE', 'litemall:category:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_CATEGORY'), '修改', 'LITE_MALL_GOODS_CATEGORY_EDIT', 'litemall:category:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_CATEGORY'), '删除', 'LITE_MALL_GOODS_CATEGORY_REMOVE', 'litemall:category:remove', '2', NULL);

-- 菜单: 商品列表
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS'), '商品列表', 'LITE_MALL_GOODS_LIST','mall/goods/list.html', NULL, '1', 'fa fa-th-list', 2);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_LIST'), '刷新', 'LITE_MALL_GOODS_LIST_LIST', 'litemall:goods:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_LIST'), '新增', 'LITE_MALL_GOODS_LIST_SAVE', 'litemall:goods:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_LIST'), '修改', 'LITE_MALL_GOODS_LIST_EDIT', 'litemall:goods:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_LIST'), '删除', 'LITE_MALL_GOODS_LIST_REMOVE', 'litemall:goods:remove', '2', NULL);

-- 菜单: 商品评论
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS'), '商品评论', 'LITE_MALL_GOODS_COMMENT','mall/comment/list.html', NULL, '1', 'fa fa-th-list', 3);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_COMMENT'), '刷新', 'LITE_MALL_GOODS_COMMENT_LIST', 'litemall:comment:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_COMMENT'), '新增', 'LITE_MALL_GOODS_COMMENT_SAVE', 'litemall:comment:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_COMMENT'), '修改', 'LITE_MALL_GOODS_COMMENT_EDIT', 'litemall:comment:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_GOODS_COMMENT'), '删除', 'LITE_MALL_GOODS_COMMENT_REMOVE', 'litemall:comment:remove', '2', NULL);


-- 目录: 订单管理
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES (0, '订单管理', 'LITE_MALL_ORDER',NULL, NULL, '0', 'fa fa-coffee', 4);
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_ORDER'), '订单管理', 'LITE_MALL_ORDER_LIST','mall/order/list.html', NULL, '1', 'fa fa-th-list', 3);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_ORDER_LIST'), '刷新', 'LITE_MALL_ORDER_LIST_LIST', 'litemall:order:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_ORDER_LIST'), '新增', 'LITE_MALL_ORDER_LIST_SAVE', 'litemall:order:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_ORDER_LIST'), '修改', 'LITE_MALL_ORDER_LIST_EDIT', 'litemall:order:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_ORDER_LIST'), '删除', 'LITE_MALL_ORDER_LIST_REMOVE', 'litemall:order:remove', '2', NULL);


-- 目录: 营销推广
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES (0, '营销推广', 'LITE_MALL_PROMOTION',NULL, NULL, '0', 'fa fa-coffee', 5);
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION'), '广告管理', 'LITE_MALL_PROMOTION_AD','mall/ad/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_AD'), '刷新', 'LITE_MALL_PROMOTION_AD_LIST', 'litemall:ad:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_AD'), '新增', 'LITE_MALL_PROMOTION_AD_SAVE', 'litemall:ad:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_AD'), '修改', 'LITE_MALL_PROMOTION_AD_EDIT', 'litemall:ad:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_AD'), '删除', 'LITE_MALL_PROMOTION_AD_REMOVE', 'litemall:ad:remove', '2', NULL);


-- 菜单: 专题管理
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION'), '专题管理', 'LITE_MALL_PROMOTION_TOPIC','mall/topic/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_TOPIC'), '刷新', 'LITE_MALL_PROMOTION_TOPIC_LIST', 'litemall:topic:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_TOPIC'), '新增', 'LITE_MALL_PROMOTION_TOPIC_SAVE', 'litemall:topic:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_TOPIC'), '修改', 'LITE_MALL_PROMOTION_TOPIC_EDIT', 'litemall:topic:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_TOPIC'), '删除', 'LITE_MALL_PROMOTION_TOPIC_REMOVE', 'litemall:topic:remove', '2', NULL);


-- 菜单: 团购规则
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION'), '团购规则', 'LITE_MALL_PROMOTION_GROUPON_RULES','mall/grouponrules/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_GROUPON_RULES'), '刷新', 'LITE_MALL_PROMOTION_GROUPON_RULES_LIST', 'litemall:grouponrules:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_GROUPON_RULES'), '新增', 'LITE_MALL_PROMOTION_GROUPON_RULES_SAVE', 'litemall:grouponrules:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_GROUPON_RULES'), '修改', 'LITE_MALL_PROMOTION_GROUPON_RULES_EDIT', 'litemall:grouponrules:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_GROUPON_RULES'), '删除', 'LITE_MALL_PROMOTION_GROUPON_RULES_REMOVE', 'litemall:grouponrules:remove', '2', NULL);


-- 菜单: 团购活动
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION'), '团购活动', 'LITE_MALL_PROMOTION_GROUPON_ACTIVITY','mall/grouponactivity/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_GROUPON_ACTIVITY'), '刷新', 'LITE_MALL_PROMOTION_GROUPON_ACTIVITY_LIST', 'litemall:grouponactivity:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_GROUPON_ACTIVITY'), '新增', 'LITE_MALL_PROMOTION_GROUPON_ACTIVITY_SAVE', 'litemall:grouponactivity:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_GROUPON_ACTIVITY'), '修改', 'LITE_MALL_PROMOTION_GROUPON_ACTIVITY_EDIT', 'litemall:grouponactivity:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_PROMOTION_GROUPON_ACTIVITY'), '删除', 'LITE_MALL_PROMOTION_GROUPON_ACTIVITY_REMOVE', 'litemall:grouponactivity:remove', '2', NULL);


-- 目录: 会员中心
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES (0, '会员中心', 'LITE_MALL_UC',NULL, NULL, '0', 'fa fa-coffee', 6);
-- 菜单: 会员管理
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '会员管理', 'LITE_MALL_UC_USER','mall/user/list.html', NULL, '1', 'fa fa-th-list', 1);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_USER'), '刷新', 'LITE_MALL_UC_USER_LIST', 'litemall:user:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_USER'), '新增', 'LITE_MALL_UC_USER_SAVE', 'litemall:user:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_USER'), '修改', 'LITE_MALL_UC_USER_EDIT', 'litemall:user:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_USER'), '删除', 'LITE_MALL_UC_USER_REMOVE', 'litemall:user:remove', '2', NULL);


-- 菜单: 收货地址
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '收货地址', 'LITE_MALL_UC_ADDRESS','mall/address/list.html', NULL, '1', 'fa fa-th-list', 2);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_ADDRESS'), '刷新', 'LITE_MALL_UC_ADDRESS_LIST', 'litemall:address:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_ADDRESS'), '新增', 'LITE_MALL_UC_ADDRESS_SAVE', 'litemall:address:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_ADDRESS'), '修改', 'LITE_MALL_UC_ADDRESS_EDIT', 'litemall:address:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_ADDRESS'), '删除', 'LITE_MALL_UC_ADDRESS_REMOVE', 'litemall:address:remove', '2', NULL);

-- 菜单: 会员收藏
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '会员收藏', 'LITE_MALL_UC_COLLECT','mall/collect/list.html', NULL, '1', 'fa fa-th-list', 3);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_COLLECT'), '刷新', 'LITE_MALL_UC_COLLECT_LIST', 'litemall:collect:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_COLLECT'), '新增', 'LITE_MALL_UC_COLLECT_SAVE', 'litemall:collect:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_COLLECT'), '修改', 'LITE_MALL_UC_COLLECT_EDIT', 'litemall:collect:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_COLLECT'), '删除', 'LITE_MALL_UC_COLLECT_REMOVE', 'litemall:collect:remove', '2', NULL);


-- 菜单: 会员足迹
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '会员足迹', 'LITE_MALL_UC_FOOTPRINT','mall/footprint/list.html', NULL, '1', 'fa fa-th-list', 4);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FOOTPRINT'), '刷新', 'LITE_MALL_UC_FOOTPRINT_LIST', 'litemall:footprint:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FOOTPRINT'), '新增', 'LITE_MALL_UC_FOOTPRINT_SAVE', 'litemall:footprint:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FOOTPRINT'), '修改', 'LITE_MALL_UC_FOOTPRINT_EDIT', 'litemall:footprint:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FOOTPRINT'), '删除', 'LITE_MALL_UC_FOOTPRINT_REMOVE', 'litemall:footprint:remove', '2', NULL);


-- 菜单: 搜索历史
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '搜索历史', 'LITE_MALL_UC_HISTORY','mall/history/list.html', NULL, '1', 'fa fa-th-list', 5);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_HISTORY'), '刷新', 'LITE_MALL_UC_HISTORY_LIST', 'litemall:history:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_HISTORY'), '新增', 'LITE_MALL_UC_HISTORY_SAVE', 'litemall:history:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_HISTORY'), '修改', 'LITE_MALL_UC_HISTORY_EDIT', 'litemall:history:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_HISTORY'), '删除', 'LITE_MALL_UC_HISTORY_REMOVE', 'litemall:history:remove', '2', NULL);


-- 菜单: 意见反馈
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`url`, `perms`, `type`, `icon`, `order_num`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC'), '意见反馈', 'LITE_MALL_UC_FEEDBACK','mall/feedback/list.html', NULL, '1', 'fa fa-th-list', 6);
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FEEDBACK'), '刷新', 'LITE_MALL_UC_FEEDBACK_LIST', 'litemall:feedback:list', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FEEDBACK'), '新增', 'LITE_MALL_UC_FEEDBACK_SAVE', 'litemall:feedback:save', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FEEDBACK'), '修改', 'LITE_MALL_UC_FEEDBACK_EDIT', 'litemall:feedback:edit', '2', NULL);
INSERT INTO `sys_menu` (`parent_id`, `name`, `code`,`perms`, `type`, `icon`) VALUES ((select m.menu_id from sys_menu m where m.code='LITE_MALL_UC_FEEDBACK'), '删除', 'LITE_MALL_UC_FEEDBACK_REMOVE', 'litemall:feedback:remove', '2', NULL);


INSERT INTO `sys_config`(`param_key`, `param_value`, `status`, `remark`, `create_time`, `update_time`) VALUES ('CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 1, '云存储配置信息', NOW(),NOW());
