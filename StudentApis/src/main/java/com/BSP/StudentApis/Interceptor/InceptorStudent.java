package com.BSP.StudentApis.Interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InceptorStudent {

    @Before("@execution(* com.BSP.StudentApis.Controller.*.*(..)")
    public String method(JoinPoint joinPoint ){
        return("Before Controller method call"+joinPoint.getSignature().getName());
    }



    @After("@execution(* com.BSP.StudentApis.Controller.*.*(..)")
    public String method2(JoinPoint joinPoint){
        return ("After Controller method call"+joinPoint.getSignature().getName());
    }


}
