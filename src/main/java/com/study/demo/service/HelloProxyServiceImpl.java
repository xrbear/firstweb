package com.study.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：xurong02
 * jdk动态代理
 * @date ：2022/10/25 6:09 下午
 */
@Service
public class HelloProxyServiceImpl implements InvocationHandler {

    private Object target;

    public HelloProxyServiceImpl(Object target) {
        this.target = target;
    }
    public HelloProxyServiceImpl() {
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        System.out.println("invoke");
        return invoke;
    }

    public static void main(String[] args) {

        HelloServiceImpl impl = new HelloServiceImpl();
        HelloProxyServiceImpl userProxy = new HelloProxyServiceImpl(impl);
        HelloService helloService= (HelloService) Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), userProxy);
        helloService.sayHello("xurong");
    }
}
