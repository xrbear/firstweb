package com.study.demo.controller;

import com.study.demo.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xurong02
 * @date ：2022/11/3 2:10 下午
 */
@RestController
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping("/thread/creat")
    public String createThread(){
        threadService.createThread();
        return "createThread";
    }

    @RequestMapping("/thread/createRunnable")
    public String createRunnable(){
        threadService.createRunnable();
        return "createRunnable";
    }

    @RequestMapping("/thread/createCallable")
    public String createCallable(){
        threadService.createCallable();
        return "createCallable";
    }

}
