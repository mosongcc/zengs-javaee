package com.ul.spring.context;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *  获取 Spring ApplicationContext
 */
@Component
public class ContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws NoSuchBeanDefinitionException {
        this.applicationContext = applicationContext;
        checkApplicationContext();
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException(" Spring ApplicaitonContext 未定义");
        }
    }

    /**
     * 根据实例名称获取bean实例
     */
    public static Object getBean(String name) throws NoSuchBeanDefinitionException {
        checkApplicationContext();
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name,Class<T> c) throws NoSuchBeanDefinitionException {
        checkApplicationContext();
        return applicationContext.getBean(name,c);
    }

    /**
     * 根据类名获取bean实例 <br>
     * //将第一个字符改大写  <br>
     * StringUtils.capitalize(Str)  <br>
     * 将第一个个字符改小写  <br>
     * StringUtils.uncapitalize(str)  <br>
     */
    public static <T> T getBean(Class<T> clazz)  throws NoSuchBeanDefinitionException {
        checkApplicationContext();
        String className = StringUtils.uncapitalize(clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1));
        return applicationContext.getBeansOfType(clazz).get(className);
    }

}