package com.unionlive.app.annotation;

import java.lang.annotation.*;

/**
 * 登录验证
 * 添加@LoginAuth注解的方法必须登录才能访问，未登录返回错误，json格式
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginAuth {

    //自定义注解的属性，default是设置默认值
    String desc() default "";

}
