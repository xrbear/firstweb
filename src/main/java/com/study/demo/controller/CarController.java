package com.study.demo.controller;

import com.study.demo.dto.ResponseDTO;
import com.study.demo.repository.xurongtest.entity.Person;
import com.study.demo.service.PersonService;
import com.study.demo.service.impl.BigCarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：xurong02
 * @date ：2023/3/7 2:48 下午
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private PersonService personService;
    @Autowired
    private BigCarServiceImpl carService;
    @RequestMapping("/buyBigCar")
    public String buyBigCar(){

        return carService.buyCar("大卡车");
    }
}
