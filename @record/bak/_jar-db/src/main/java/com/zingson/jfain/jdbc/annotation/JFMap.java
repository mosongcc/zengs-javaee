package com.zingson.jfain.jdbc.annotation;

import java.lang.annotation.*;

/**
 * @author jfain
 * @date 2017/05/06
 * 数据表字段名与Java实体类属性名映射注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD, ElementType.METHOD})
public @interface JFMap {

    /**
     * 对应数据库表名或者字段名
     * @return
     */
    String value();

    /**
     * 标记排除字段，数据库操作时标记忽略
     * @return
     */
    boolean exclude() default false;

    /**
     * 是否是主键
     * @return
     */
    boolean isPrimaryKey() default false;

    //待扩展注解 如：时间格式、字符串非空判断、字符串长度验证、修改时为空的字段忽略

}
