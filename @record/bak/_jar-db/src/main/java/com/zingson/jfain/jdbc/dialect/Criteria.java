package com.zingson.jfain.jdbc.dialect;

import java.util.ArrayList;
import java.util.List;

public class Criteria {

    public static Criteria build(){
        return new Criteria();
    }

    public static Criteria build(String ao){
        return new Criteria(ao);
    }

    public static final String AND = "AND ";
    public static final String OR = "OR  ";

    private String join = AND;

    public String getJoin() {
        return join;
    }

    public Criteria(){ }

    public Criteria(String join){
        this.join = join;
    }

    private StringBuffer whereSql = new StringBuffer(" ");
    private List<Object> values = new ArrayList<>();

    public String getWhereSql() {
        return whereSql.substring(AND.length());
    }

    public List<Object> getValues() {
        return values;
    }

    private Criteria demand(String key, Object value, String connect, String criteria){
        if(value!=null){
            whereSql.append(connect).append(key).append(criteria).append(" ? ");
            values.add(value);
        }else{
            whereSql.append(connect).append(key).append(criteria);
        }
        return  this;
    }

    public Criteria andEqualTo(String key, Object value){
        return  demand(key, value, AND, " = ");
    }
    public Criteria orEqualTo(String key, Object value){
        return  demand(key, value, OR, " = ");
    }

    public Criteria andNotEqualTo(String key, Object value){
        return  demand(key, value, AND, " <> ");
    }
    public Criteria orNotEqualTo(String key, Object value){
        return  demand(key, value, OR, " <> ");
    }

    public Criteria andLessThan(String key, Object value){
        return  demand(key, value, AND, " < ");
    }
    public Criteria orLessThan(String key, Object value){
        return  demand(key, value, OR, " < ");
    }

    public Criteria andLessThanOrEqualTo(String key, Object value){
        return  demand(key, value, AND, " <= ");
    }
    public Criteria orLessThanOrEqualTo(String key, Object value){
        return  demand(key, value, OR, " <= ");
    }

    public Criteria andGreaterThan(String key, Object value){
        return  demand(key, value, AND, " > ");
    }
    public Criteria orGreaterThan(String key, Object value){
        return  demand(key, value, OR, " > ");
    }

    public Criteria andGreaterThanOrEqualTo(String key, Object value){
        return  demand(key, value, AND, " >= ");
    }
    public Criteria orGreaterThanOrEqualTo(String key, Object value){
        return  demand(key, value, OR, " >= ");
    }

    public Criteria andIsNull(String key){
        return  demand(key, null, AND, " IS NULL ");
    }
    public Criteria orIsNull(String key){
        return  demand(key, null, OR, " IS NULL ");
    }

    public Criteria andIsNotNull(String key){
        return  demand(key, null, AND, " IS NOT NULL ");
    }
    public Criteria orIsNotNull(String key){
        return  demand(key, null, OR," IS NOT NULL ");
    }

    public Criteria andLike(String key, String value){
        return  demand(key, value, AND," LIKE ");
    }
    public Criteria orLike(String key, String value){
        return  demand(key, value, OR," LIKE ");
    }

    public Criteria andNotLike(String key, String value){
        return  demand(key, value, AND," NOT LIKE ");
    }
    public Criteria orNotLike(String key, String value){
        return  demand(key, value, OR,"NOT LIKE ");
    }

}
