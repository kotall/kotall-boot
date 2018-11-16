package com.kotall.rms.core.annotation;

import java.lang.annotation.*;

/**
 * litemall 数据过滤
 *
 * @author zpwang
 * @version 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StoreFilter {
    /**  表的别名 */
    String tableAlias() default "";

    /**  true：拥有下级连锁店铺的数据权限 */
    boolean subStore() default false;

    /**  店铺ID */
    String storeId() default "store_id";

    /**  用户ID */
    String userId() default "user_id";

}
