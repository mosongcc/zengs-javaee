package org.wjlmgqs.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class QueryBuilder<T> {
	
	private String sql = null;
	private Object[] params = null;
	
	public QueryBuilder(String sql,Object...params){
		this.sql = sql;
		this.params = params;
	}
	
	public String getPrepareSQL(){
		return this.sql;
	}
	
	public Object[] getPrepareParams(){
		return this.params;
	}
	
	/**
	 * 参数预处理
	 * @param ps
	 * @param params
	 */
	public void setParams(PreparedStatement ps,Object... params) throws Exception{};
	
	/**
	 * 处理查询出来的数据
	 * @param rs
	 * @return
	 */
	public abstract T execute(ResultSet rs) throws Exception;
	
}
