package com.study.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

/**
 * @author ：xurong02
 * @date ：2022/10/25 3:05 下午
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        String s = null;
        s.equals("23e");
        System.out.println("hello "+name);
//        String ss = null;
 //       ss.equals("ss");
    }
}
