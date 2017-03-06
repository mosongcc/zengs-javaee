package org.springframework.extend.sqlxml;

/**
 * Sql语句映射对象
 */
public class SqlMapper {
    private String id;
    private String value;
    private String returnClass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getReturnClass() {
        return returnClass;
    }

    public void setReturnClass(String returnClass) {
        this.returnClass = returnClass;
    }
}
