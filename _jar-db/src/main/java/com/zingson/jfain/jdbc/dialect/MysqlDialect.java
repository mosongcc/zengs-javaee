package com.zingson.jfain.jdbc.dialect;

import java.sql.SQLException;
import java.util.List;

public class MysqlDialect extends Dialect  {

    public void paginate(int pageNumber, int pageSize, final StringBuffer sql, final List<Object> values) throws SQLException {
        sql.append(" limit ?,?");
        values.add(pageNumber*pageSize);
        values.add(pageSize);
    }

}
