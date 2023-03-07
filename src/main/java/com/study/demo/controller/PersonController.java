package com.study.demo.controller;

import com.study.demo.dto.ResponseDTO;
import com.study.demo.repository.xurongtest.entity.Person;
import com.study.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：xurong02
 * @date ：2023/3/7 2:48 下午
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/searchPerson")
    public ResponseDTO searchPerson(){
        List<Person> people = personService.searchPerson();
        return ResponseDTO.success(people);
    }
}
