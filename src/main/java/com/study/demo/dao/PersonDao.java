package com.study.demo.dao;

import com.study.demo.repository.xurongtest.entity.Person;

import java.util.List;

/**
 * @author xurong
 */
public interface PersonDao {

    List<Person> searchPersonByIds(List<Integer> ids);
}
