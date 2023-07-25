package com.study.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class BigCarServiceImpl extends CarServiceImpl{

    public String buyCar(String name) {
        return "我买了一辆"+name;
    }
}
