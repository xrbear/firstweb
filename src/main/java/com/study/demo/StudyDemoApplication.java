package com.study.demo;

import com.study.demo.bean.Person;
import com.study.demo.service.CarService;
import com.study.demo.service.HelloService;
import com.study.demo.util.HeadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：xurong02
 * @date ：2022/9/2 11:16 下午
 */
@RestController
@SpringBootApplication(scanBasePackages="com.study.demo")
public class StudyDemoApplication {


    @Resource
    private HelloService helloService;
    @Resource
    private Person person;
    @Autowired
    private CarService carServiceImpl;

    @RequestMapping("/")
    public String hello(){
         helloService.sayHello("world");
         HeadUtil.setThreadLocal("head");
        String threadLocal = HeadUtil.getThreadLocal();
        new Thread(()->{
            System.out.println("子线程"+HeadUtil.getThreadLocal());
        }).start();
        return threadLocal;
    }

    @RequestMapping("/buyCar")
    public String buyCar(){
        String car = carServiceImpl.buyCar("car");
        return car;
    }
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StudyDemoApplication.class, args);


        //     applicationContext.getBean("");
    }



}
