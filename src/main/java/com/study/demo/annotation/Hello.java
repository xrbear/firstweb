package com.study.demo.annotation;

import java.lang.annotation.*;

/**
 * @author xurong
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Hello {

    public String name();
    int age() default 18;
    int[] score();
}
