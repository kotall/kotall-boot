package com.kotall.rms.common.plugins.orm.dialect;

/**
 * MySQL数据库方言
 *
 * @author aracwong
 * @date 2017年8月8日 上午11:07:12
 */
public class MySql5Dialect extends Dialect {

    protected static final String SQL_END_DELIMITER = ";";

    @Override
    public String getLimitString(String querySelect, int offset, int limit) {
        querySelect = getLineSql(querySelect);

        String sql = querySelect + " limit " + offset + " ," + limit;

        return sql;
    }
}
