package com.study.demo.annotation.handler;

import com.study.demo.annotation.Hello;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author rong.xu
 */
@Aspect
@Component
public class HelloHandler {

    @Pointcut("@annotation(com.study.demo.annotation.Hello)")
    public void pointCut(){}

    @Around("pointCut()&& @annotation(hello)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, Hello hello) throws Throwable {
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        Hello annotation = method.getAnnotation(Hello.class);
        int age = annotation.age();
        int[] score = annotation.score();


        int age1 = hello.age();
        System.out.println(age1);
        return proceedingJoinPoint.proceed();
    }
}
