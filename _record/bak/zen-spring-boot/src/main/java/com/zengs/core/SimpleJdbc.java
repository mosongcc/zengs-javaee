package com.zengs.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static oracle.net.aso.C00.k;
import static oracle.net.aso.C00.r;

/**
 * 简单JDBC操作方法
 */
@Repository
public class SimpleJdbc {

    private static Logger log = LoggerFactory.getLogger(SimpleJdbc.class);

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource());
    }

    /**
     * JDBC insert table
     */
    public int insert(String tableName, Map<String,?> updateMap){
        return simpleJdbcInsert.withTableName(tableName).execute(updateMap);
    }
    public long insert(String tableName,String key, Map<String,?> updateMap){
        return simpleJdbcInsert.withTableName(tableName).usingGeneratedKeyColumns(key).executeAndReturnKey(updateMap).longValue();
    }
    public int[] insertBatch(String tableName, Map<String,?>... updateMap){
        return simpleJdbcInsert.withTableName(tableName).executeBatch(updateMap);
    }
    public int insert(Object obj){
        //Object转数据库字段Map
        //return simpleJdbcInsert.withTableName(tableName).execute(updateMap);
        return 0;
    }
    public int[] insertBatch(List<Object> list){
        //return simpleJdbcInsert.withTableName(tableName).executeBatch(updateMap);
        return null;
    }

    /**
     * JDBC update ,Oracle 需要重写此方法
     */
    public Integer executeUpdate(String sql,Object...args){
        return jdbcTemplate.update(sql,args);
        /*return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>(){
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return null;
            }
        });*/
    }

    /**
     * JDBC delete table
     */
    public int delete(String tableName,Criteria criteria){
        return jdbcTemplate.update(criteria.deleteSql(tableName),criteria.getQueryParams());
    }

    /**
     * JDBC update table
     */
    public int update(String tableName,Criteria criteria){
        return jdbcTemplate.update(criteria.updateSql(tableName),criteria.getQueryParams());
    }

    public Criteria getCriteria(){
        return new Criteria();
    }

    /**
     * 查询条件封装类
     */
    public class Criteria{

        private Map<String,Object> updateMap = new LinkedHashMap<>();

        //条件字段Map，带占位符
        private Map<String,Object> whereMap = new LinkedHashMap<>();
        //占位符对应值数组
        private List<Object> queryParams = new ArrayList<>();

        public Criteria(){
        }

        /**
         * 设置修改字段
         * @param key
         * @param value
         * @return
         */
        public Criteria setUpdate(String key,Object value){
            updateMap.put(key,value);
            return this;
        }

        private StringBuffer getWhere(){
            StringBuffer sbwhere = new StringBuffer();
            if(whereMap.size()>0){
                sbwhere.append(" where 1=1 ");
                for (Map.Entry<String,Object> entry:whereMap.entrySet()){
                    sbwhere.append(entry.getKey());
                    queryParams.add(entry.getValue());
                }
            }
            return sbwhere;
        }

        public Object[] getQueryParams(){
            return queryParams.toArray();
        }

        public String deleteSql(String tableName){
            StringBuffer sbsql = new StringBuffer("delete from ").append(tableName)
                    .append(getWhere());
            return sbsql.toString();
        }

        public String updateSql(String tableName){
            StringBuffer sbsql = new StringBuffer("update ").append(tableName);
            sbsql.append(" set ");
            for (Map.Entry<String,Object> entry:updateMap.entrySet()) {
                if(queryParams.size()>0){ sbsql.append(" , "); }
                sbsql.append(entry.getKey()).append(" = ? ");
                queryParams.add(entry.getValue());
            }
            sbsql.append(getWhere());
            return sbsql.toString();
        }

        /**
         * 拼接条件Sql
         * @param key    字段
         * @param value  值
         * @param connect 连接符 or 或者 and
         * @param criteria  条件 大于小于等等
         * @return
         */
        public Criteria demand(String key,Object value,String connect,String criteria){
            whereMap.put(connect+key+criteria + " ? ",value);
            return  this;
        }

        public Criteria andEqualTo(String key,Object value){
            return  demand(key, value, " and ", " = ");
        }
        public Criteria orEqualTo(String key,Object value){
            return  demand(key, value, " or ", " = ");
        }

        public Criteria andNotEqualTo(String key,Object value){
            return  demand(key, value, " and ", " <> ");
        }
        public Criteria orNotEqualTo(String key,Object value){
            return  demand(key, value, " or ", " <> ");
        }

        public Criteria andLessThan(String key,Object value){
            return  demand(key, value, " and ", " < ");
        }
        public Criteria orLessThan(String key,Object value){
            return  demand(key, value, " or ", " < ");
        }

        public Criteria andLessThanOrEqualTo(String key,Object value){
            return  demand(key, value, " and ", " <= ");
        }
        public Criteria orLessThanOrEqualTo(String key,Object value){
            return  demand(key, value, " or ", " <= ");
        }

        public Criteria andGreaterThan(String key,Object value){
            return  demand(key, value, " and ", " > ");
        }
        public Criteria orGreaterThan(String key,Object value){
            return  demand(key, value, " or ", " > ");
        }

        public Criteria andGreaterThanOrEqualTo(String key,Object value){
            return  demand(key, value, " and ", " >= ");
        }
        public Criteria orGreaterThanOrEqualTo(String key,Object value){
            return  demand(key, value, " or ", " >= ");
        }

        public Criteria andIsEmpty(String key){
            return  demand(key, "", " and ", " is null ");
        }
        public Criteria orIsEmpty(String key){
            return  demand(key, "", " or ", " is null ");
        }

        public Criteria andIsNotEmpty(String key){
            return  demand(key, "", " and ", " is not null ");
        }
        public Criteria orIsNotEmpty(String key){
            return  demand(key, "", " or "," is not null ");
        }

        public Criteria andLike(String key,String value){
            return  demand(key, value, " and "," like ");
        }
        public Criteria orLike(String key,String value){
            return  demand(key, value, " or "," like ");
        }

        public Criteria andNotLike(String key,String value){
            return  demand(key, value, " and "," not like ");
        }
        public Criteria orNotLike(String key,String value){
            return  demand(key, value, " or ","not like ");
        }

        public Criteria andIn(String key,List<String> list){ return  demand(key, list, " and "," in ");}
        public Criteria orIn(String key,List<String> list){ return  demand(key, list, " or "," in "); }

        public Criteria andNotIn(String key,List<String> list){ return  demand(key,list, " and "," not in ");}
        public Criteria orNotIn(String key,List<String> list){ return  demand(key, list, " or "," not in ");}


    }
}
