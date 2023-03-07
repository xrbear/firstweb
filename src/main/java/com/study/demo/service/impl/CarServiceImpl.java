package com.study.demo.service.impl;

import com.study.demo.service.CarService;
import org.springframework.stereotype.Service;

/**
 * @author ：xurong02
 * @date ：2023/3/7 12:20 上午
 */
@Service
public class CarServiceImpl implements CarService {
    @Override
    public String buyCar(String name) {
        return "我买了一辆"+name;
    }
}
