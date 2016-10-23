package com.zengs.jdbc;

import java.util.*;

/**
 * sql查询条件封装
 */
public class Criteria {

    //表名
    private String tableName;

    //数据库表列名，查询
    private String[] columns;

    //update字段
    private Map<String,Object>  updateMap = new LinkedHashMap<>();

    //where条件
    private List<Map<String,Object>> where = new ArrayList<Map<String,Object>>();

    private int beginIndex = 0; //开始下标，默认0
    private int pageSize = 10;  //一页数量，默认10

    public Criteria(){

    }

    //构造方法设置表名
    public Criteria(String tableName){
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public Criteria setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public List<Map<String, Object>> getWhere() {
        return where;
    }

    public String[] getColumns() {
        return columns;
    }

    public Criteria setColumns(String[] columns) {
        this.columns = columns;
        return this;
    }

    public Map<String, Object> getUpdateMap() {
        return updateMap;
    }

    public Criteria setUpdateMap(Map<String, Object> updateMap) {
        this.updateMap = updateMap;
        return this;
    }

    public Criteria putUpdateMap(String k,Object v){
        this.updateMap.put(k,v);
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    /**
     * 设置拼接条件
     * @param key    字段
     * @param value  值
     * @param connect 连接符 or 或者 and
     * @param criteria  条件 大于小于等等
     * @return
     */
    public Criteria condition(String key,Object value,String connect,String criteria){
        Map<String,Object> mapCriteria = new HashMap<String,Object>();
        mapCriteria.put("_column", key);
        mapCriteria.put("_columnValue", value);
        mapCriteria.put("_connect", connect);
        mapCriteria.put("_criteria",criteria);
        where.add(mapCriteria);
        return  this;
    }

    public Criteria andEqualTo(String key,Object value){
        return  condition(key, value, " and ", " = ");
    }
    public Criteria orEqualTo(String key,String value){
        return  condition(key, value, " or ", " = ");
    }

    public Criteria andNotEqualTo(String key,String value){
        return  condition(key, value, " and ", " <> ");
    }
    public Criteria orNotEqualTo(String key,String value){
        return  condition(key, value, " or ", " <> ");
    }

    public Criteria andLessThan(String key,String value){
        return  condition(key, value, " and ", " < ");
    }
    public Criteria orLessThan(String key,String value){
        return  condition(key, value, " or ", " < ");
    }

    public Criteria andLessThanOrEqualTo(String key,String value){
        return  condition(key, value, " and ", " <= ");
    }
    public Criteria orLessThanOrEqualTo(String key,String value){
        return  condition(key, value, " or ", " <= ");
    }

    public Criteria andGreaterThan(String key,String value){
        return  condition(key, value, " and ", " > ");
    }
    public Criteria orGreaterThan(String key,String value){
        return  condition(key, value, " or ", " > ");
    }

    public Criteria andGreaterThanOrEqualTo(String key,String value){
        return  condition(key, value, " and ", " >= ");
    }
    public Criteria orGreaterThanOrEqualTo(String key,String value){
        return  condition(key, value, " or ", " >= ");
    }

    public Criteria andIsEmpty(String key){
        return  condition(key, "", " and ", " is null ");
    }
    public Criteria orIsEmpty(String key){
        return  condition(key, "", " or ", " is null ");
    }

    public Criteria andIsNotEmpty(String key){
        return  condition(key, "", " and ", " is not null ");
    }
    public Criteria orIsNotEmpty(String key){
        return  condition(key, "", " or "," is not null ");
    }

    public Criteria andLike(String key,String value){
        return  condition(key, value, " and "," like ");
    }
    public Criteria orLike(String key,String value){
        return  condition(key, value, " or "," like ");
    }

    public Criteria andNotLike(String key,String value){
        return  condition(key, value, " and "," not like ");
    }
    public Criteria orNotLike(String key,String value){
        return  condition(key, value, " or ","not like ");
    }

    public Criteria andIn(String key,List<String> list){ return  condition(key, list, " and "," in ");}
    public Criteria orIn(String key,List<String> list){ return  condition(key, list, " or "," in "); }

    public Criteria andNotIn(String key,List<String> list){ return  condition(key,list, " and "," not in ");}
    public Criteria orNotIn(String key,List<String> list){ return  condition(key, list, " or "," not in ");}



    public String wSql;
    public List<String> vList;

    public String getwSql() {
        if (wSql==null){ whereCriteria(); }
        return wSql;
    }
    public List<String> getvList() {
        if (vList==null){ whereCriteria(); }
        return vList;
    }

    /**
     * 拼接where条件
     * @return
     */
    @SuppressWarnings("unchecked")
    public void whereCriteria(){
        List<Map<String,Object>> criteriaList = this.getWhere();
        StringBuffer sbsql = new StringBuffer();
        List<String> valList = new ArrayList<String>();
        if(criteriaList.size()>0){
            int i = 0;
            for (Map<String,Object> criteriaMap:criteriaList){
                if(i==0){
                    sbsql.append(" where ");
                    i++;
                }else{
                    sbsql.append(criteriaMap.get("_connect"));
                }
                sbsql.append(criteriaMap.get("_column"));
                Object cri = criteriaMap.get("_criteria");
                sbsql.append(cri);
                if(String.valueOf(cri).indexOf("in")!=-1){
                    List<String> vlist = (List<String>)criteriaMap.get("_columnValue");
                    sbsql.append(" ( ");
                    String wh = " ";
                    for (String v:vlist){
                        wh += "?,";
                        valList.add(v);
                    }
                    wh = wh.substring(0,wh.length()-1);
                    sbsql.append(wh);
                    sbsql.append(" ) ");
                }else{
                    sbsql.append(" ? ");
                    valList.add(String.valueOf(criteriaMap.get("_columnValue")));
                }

            }
        }
        wSql = sbsql.toString();
        vList = valList;
    }


}
