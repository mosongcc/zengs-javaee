package com.zingson.jfain.jdbc.dialect;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
public interface RowMapper<T> {

    List<T> call(ResultSet rs) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, SQLException;

}
