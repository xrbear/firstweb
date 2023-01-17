package com.study.demo.controller;

import com.study.demo.biz.ThreadBizImpl;
import com.study.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author ：xurong02
 * @date ：2022/9/2 11:16 下午
 */
@RestController
@SpringBootApplication
@ComponentScan(value = {"com.study.demo"})
public class StudyDemoApplication {


    @Resource
    private HelloService helloService;

    @RequestMapping("/")
    public String hello(){
         helloService.sayHello("world");
         return "hello";
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StudyDemoApplication.class, args);

    }
}
