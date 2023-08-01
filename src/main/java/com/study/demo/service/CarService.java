package com.study.demo.service;

import org.springframework.beans.factory.config.BeanPostProcessor;

public interface CarService extends BeanPostProcessor {

    String buyCar(String name);
}
