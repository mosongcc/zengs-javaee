package com.zengs.access.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  数据库操作静态类
 *
 */
public class DBHandle {

    /**
     * 静态常量Map，缓存表字段名与实体类字段名转换值
     */
    private static final Map<String,String> columnMap = new ConcurrentHashMap<>();

    public static void setColumnMap(String k,String v){
        columnMap.put(k,v);
    }
    public static void setColumnMap(Map<String,String> columnMap){
        columnMap.putAll(columnMap);
    }

    /**
     * 获取insert Sql语句
     * @param obj  为Map时需设置key='_tableName'对应的表名名称；为实体类对象时，对象名自动转为表名
     * @return
     */
    private String getInsertSql(Object obj){
        return "";
    }

    private String getUpdateSql(Object obj,Criteria criteria){
        return "";
    }

    private String getDeleteSql(Criteria criteria){
        return "";
    }

    private String getSelectSql(Criteria criteria){
        return "";
    }


    /**
     * 数据库操作条件拼接
     */
    public class Criteria{

        private class JoinEntity{
            private String a;// and 与 or 拼接条件
            private String c; //交易符号，大于号小于号等
            private String k;
            private Object v;

            public JoinEntity(String a,String c,String k,Object v){
                this.a = a;
                this.c = c;
                this.k = k;
                this.v = v;
            }

            public String getA() {
                return a;
            }
            public String getC() {
                return c;
            }
            public String getK() {
                return k;
            }
            public Object getV() {
                return v;
            }
        }

        private List<JoinEntity> list = new ArrayList<>();

        private Criteria demand(String key,Object value,String connect,String criteria){
            list.add(new JoinEntity(connect,criteria,key,value));
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

        //public Criteria andIn(String key,List<String> list){ return  demand(key, list, " and "," in ");}
        //public Criteria orIn(String key,List<String> list){ return  demand(key, list, " or "," in "); }


    }

}
