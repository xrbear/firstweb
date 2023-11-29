package com.study.demo.service.impl;

import com.study.demo.CarFactory;
import com.study.demo.service.CarService;
import org.springframework.beans.BeansException;
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


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        CarFactory.putService(beanName, (CarService) bean);
        return bean;
    }
}
