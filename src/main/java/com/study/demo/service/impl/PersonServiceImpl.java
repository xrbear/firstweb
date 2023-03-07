package com.study.demo.service.impl;

import com.study.demo.dao.PersonDao;
import com.study.demo.repository.xurongtest.entity.Person;
import com.study.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author ：xurong02
 * @date ：2023/3/7 3:03 下午
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> searchPerson() {
        return personDao.searchPersonByIds(Collections.singletonList(1));
    }
}
