package com.kotall.rms.common.plugins.orm.dialect;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;

/**
 * 数据库方言工厂,产生方言对象
 *
 * @author aracwong
 * @date 2017年8月8日 上午11:06:30
 */
@Slf4j
public class DialectFactory {

    public static String dialectClass = null;

    public static Dialect buildDialect(Configuration configuration) {
        if (dialectClass == null) {
            synchronized (DialectFactory.class) {
                if (dialectClass == null) {
                    dialectClass = configuration.getVariables().getProperty("dialectClass");
                }
            }
        }
        Dialect dialect = null;
        try {
            dialect = (Dialect) Class.forName(dialectClass).newInstance();
        } catch (Exception e) {
            log.warn("请检查 mybatis-config.xml 中  dialectClass 是否配置正确?");
        }
        return dialect;
    }
}
