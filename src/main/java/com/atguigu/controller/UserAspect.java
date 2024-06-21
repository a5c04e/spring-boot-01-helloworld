package com.atguigu.controller;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
//定义切面类
public class UserAspect {
    // 切点(也称之为切入点，告诉程序对哪些方法进行功能增强)
    @Pointcut("execution(* com.atguigu.controller.UserController.*(..))")
    public void pointcut() {

    }

    // 前置通知通知
    @Before("pointcut()")
    public void doBefore() {
        System.out.println("执行了前置通知");
    }

    // 后置通知
    @After("pointcut()")
    public void doAfter() {
        System.out.println("执行了后置通知");
    }

    // 环绕通知
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知执行之前");
        // 执行目标方法
        Object result = joinPoint.proceed();
        System.out.println("环绕通知执行之后");
        return result;
    }
}
