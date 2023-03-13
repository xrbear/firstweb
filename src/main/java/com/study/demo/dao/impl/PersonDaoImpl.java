package com.study.demo.dao.impl;

import com.study.demo.dao.PersonDao;
import com.study.demo.repository.xurongtest.entity.Person;
import com.study.demo.repository.xurongtest.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：xurong02
 * @date ：2023/3/7 3:06 下午
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> searchPersonByIds(List<Integer> ids) {
        personMapper.selectById(1);
        List<Person> people = personMapper.selectBatchIds(ids);
        return people;
    }
}
