package com.study.demo.service.impl;

import com.study.demo.service.CarService;
import org.springframework.stereotype.Service;

@Service("bigCarService")
public class BigCarServiceImpl implements CarService {

    @Override
    public String buyCar(String name) {
        return "BigCarServiceImpl  我买了一辆"+name;
    }
}
