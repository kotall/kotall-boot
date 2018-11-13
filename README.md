# rms-boot

餐饮零售运营平台

参考: https://gitee.com/zhocuhenglin/dp-BOOT

启动项目步骤
1. 第一次需执行doc/init目录下面的脚本
2. 第一次需执行doc/r1.0.0 目录下面的 01_ddl.sql, 02_dml.sql

项目目录结构：

common:
   utils、枚举、、
core:
   安全、切面、job、、

modules:
   sys、wx、、
   
菜单权限部分设计思路

--------------------------
系统管理
/sys/
/sys/menu/
/sys/menu/read
/sys/menu/write
/sys/menu/update
/sys/menu/delete

