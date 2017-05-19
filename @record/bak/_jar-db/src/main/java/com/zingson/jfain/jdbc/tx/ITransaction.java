package com.zingson.jfain.jdbc.tx;

import com.zingson.jfain.jdbc.JFJdbc;

import java.sql.SQLException;

public interface ITransaction<T> {

    T transaction(JFJdbc db) throws SQLException;

}
