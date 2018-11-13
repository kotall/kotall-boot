package com.kotall.rms.common.plugins.orm.dialect;

/**
 * Postgre 数据库 方言
 *
 * @author aracwong
 * @date 2017年8月8日 上午11:07:36
 */
public class PostgreDialect extends Dialect {

    protected static final String SQL_END_DELIMITER = ";";

    @Override
    public String getLimitString(String querySelect, int offset, int limit) {
        querySelect = getLineSql(querySelect);
        String sql = querySelect + " LIMIT " + limit + " OFFSET " + offset;
        return sql;
    }
}
