package com.unionlive.app.annotation.aspect;

import com.unionlive.app.annotation.LoginAuth;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 注解验证登录SessionId，用于service接口 GatewayService实现类
 */
@Aspect
@Component
//@Scope("prototype")
public class LoginAuthAspect {

    /**
     * @param pjd
     * @param loginAuth
     * @return
     */
    @Around(value = "execution(* com.unionlive.app.service.impl.*.*(..))&&@annotation(loginAuth)")
    public Object doAccessCheck(ProceedingJoinPoint pjd, LoginAuth loginAuth) {
        try {
            //System.out.println(Thread.currentThread().getId()+" 前******************");
            Object obj = pjd.proceed();
            //System.out.println(Thread.currentThread().getId()+ "后******************");
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "-----res null"; //响应数据
    }


}
