package com.study.demo.controller;

import com.study.demo.bean.Person;
import com.study.demo.biz.ThreadBizImpl;
import com.study.demo.service.HelloService;
import com.study.demo.util.HeadUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
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
    @Resource
    private Person person;

    @RequestMapping("/")
    public String hello(){
         helloService.sayHello("world");

         new Thread(()->{
             System.out.println("子线程输出"+HeadUtil.getThreadLocal());
         }).start();
         return (String) HeadUtil.getThreadLocal();
    }
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StudyDemoApplication.class, args);


        //     applicationContext.getBean("");
    }
}
