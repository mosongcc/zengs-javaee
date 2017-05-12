package com.zingson.jfain.jdbc.dialect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class OracleDialect extends Dialect  {


    @Override
    public int executeUpdate(Connection conn,StringBuffer sql, Object...params) throws SQLException{
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql.toString());
            for (int i=0; i<params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            return pst.executeUpdate();
        } finally {
            if(pst!=null){
                pst.close();
            }
        }
    }

    @Override
    public <T>List<T> executeQuery(Connection conn, RowMapper<T> rowMapper, StringBuffer sql, Object...params)throws SQLException {
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql.toString());
            for (int i=0; i<params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            return rowMapper.call(pst.executeQuery());
        } catch (Exception e){
            throw new SQLException(e.getMessage());
        }finally {
            if(pst!=null){
                pst.close();
            }
        }
    }


}
