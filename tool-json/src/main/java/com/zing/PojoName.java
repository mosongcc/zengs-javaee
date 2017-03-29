package com.zing;

/**
 * 属性名生成规格接口，生成规则根据需要实现
 */
public interface PojoName {

    /**
     * 类名
     * @param name
     * @return
     */
    String className(String name);

    /**
     * 根据key生成属性名
     * @param name
     * @return
     */
    String attrName(String name);

    /**
     * get方法名
     * @param name
     * @return
     */
    String getMethodName(String name);

    /**
     * set方法名
     * @param name
     * @return
     */
    String setMethodName(String name);


}
