package com.study.demo.proxy;

import com.study.demo.service.CarService;
import com.study.demo.service.impl.CarServiceImpl;

/**
 * @author ：xurong02
 * @date ：2023/3/7 12:29 上午
 */
public class MainClass {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        // JDK动态代理
        MyInvocationHandler handler = new MyInvocationHandler(new CarServiceImpl() );
        CarService proxy = (CarService) handler.getProxy();
        String car = proxy.buyCar("奔驰");
        System.out.println(car);
    }
}
