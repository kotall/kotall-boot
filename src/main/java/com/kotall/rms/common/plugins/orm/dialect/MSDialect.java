package com.kotall.rms.common.plugins.orm.dialect;

/**
 * MSSQL 数据库方言
 *
 * @author aracwong
 * @date 2017年8月8日 上午110650
 */
public class MSDialect extends Dialect {

    protected static final String SQL_END_DELIMITER = ";";

    @Override
    public String getLimitString(String querySelect, int offset, int limit) {
        querySelect = super.getLineSql(querySelect);
        int selectIndex = querySelect.toUpperCase().lastIndexOf("SELECT");
        if (selectIndex > -1) {
            querySelect = querySelect.substring(0, selectIndex) + "SELECT TOP " + (limit + offset) + querySelect.substring(selectIndex + 6);
        }
        String sql = "SELECT * FROM(SELECT ROW_NUMBER () OVER (ORDER BY getdate()) rownum,* FROM( " + querySelect + " ) A ) B WHERE B.rownum > " + offset + " AND B.rownum <= "
                + (limit + offset);
        return sql;
    }


}
