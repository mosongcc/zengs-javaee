package com.zing;

/**
 *
 */
public class UtilsMethod {


    /**
     * 首字母大写
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 替换类名
     * @param classPackage
     * @return
     */
    public static String replaceClassName(String classPackage,String className){
        return classPackage.replace(classPackage.substring(classPackage.lastIndexOf(".")+1),toUpperCaseFirstOne(className));
    }

    /**
     * 下划线后一位字母变大写
     */
    public static String hump(String className){
        char[] chars = className.toCharArray();
        //下划线后一位字母变大写
        for (int i = 1;i<chars.length;i++) {
            if('_'==chars[i]){
                chars[i+1] = (char)(chars[i+1]-32);
            }
        }
        return new String(chars).replace("_","");
    }

}
