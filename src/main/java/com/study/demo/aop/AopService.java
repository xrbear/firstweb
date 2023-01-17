package com.study.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ：xurong02
 * @date ：2022/10/25 2:28 下午
 */
@Aspect
@Component
public class AopService {

    /**
     * 切点
     * * com.study.demo.service.HelloService.*(..)称为连接点
     */
    @Pointcut("execution(* com.study.demo.service.HelloService.*(..))")
    public void check(){}

    /**
     * 通知
     */
    @Before("check()")
    public void checkBefore(){
        System.out.println("before aop");
    }

    @After("check()")
    public void checkAfter(){
        System.out.println("after aop");
    }

    @AfterThrowing("check()")
    public void checkAfterThrowing(){
        System.out.println("Throwing aop");
    }

    @Around("check()")
    public void checkAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around aop1");
        Object[] args = pjp.getArgs();
        pjp.proceed();
        System.out.println("around aop2");
    }
}
