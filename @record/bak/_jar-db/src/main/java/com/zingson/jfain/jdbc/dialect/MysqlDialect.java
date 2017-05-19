package com.zingson.jfain.jdbc.dialect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlDialect extends Dialect  {

    public <T>List<T> queryForListPage(Connection conn, Class<T> clazz, Class<T> returnClass,int pageNumber,int pageSize, Criteria...criterias) throws SQLException {
        final StringBuffer sql = new StringBuffer("SELECT * FROM ").append(getTableName(clazz));
        final List<Object> values = new ArrayList<>();
        sql.append(" limit ?,?");
        values.add(pageNumber*pageSize);
        values.add(pageSize);
        where(sql,values,criterias);
        return rsList(conn,sql,values,returnClass);
    }

}
