package org.springframework.extend.sqlxml;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class SqlMapperHandle {

    //存储Sql
    private Map<String,String> sqlMapper = new HashMap<>();

    public String getSqlMapper(String id) {
        return sqlMapper.get(id);
    }
    public Map<String, String> getSqlMapper() {
        return sqlMapper;
    }

    public void setSqlMapper(Map<String, String> sqlMapper) {
        sqlMapper.putAll(sqlMapper);
    }
}
