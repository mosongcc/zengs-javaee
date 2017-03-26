package com.zing;

/**
 * 默认实现方式，属性名原样返回，get set方法属性首字母改为大写
 */
public class DefaultAttributeName implements PojoAttributeName {
    @Override
    public String attrName(String name) {
        return UtilsMethod.hump(name);
    }

    @Override
    public String getMethodName(String name) {
        return "get"+UtilsMethod.toUpperCaseFirstOne(attrName(name));
    }

    @Override
    public String setMethodName(String name) {
        return "set"+UtilsMethod.toUpperCaseFirstOne(attrName(name));
    }
}
