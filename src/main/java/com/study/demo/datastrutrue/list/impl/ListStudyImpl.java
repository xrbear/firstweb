package com.study.demo.datastrutrue.list.impl;

import com.study.demo.datastrutrue.list.ListStudy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rong.xu
 */
@Service("ListStudy")
public class ListStudyImpl implements ListStudy {
    @Override
    public void addStudy() {
        List list = new ArrayList();
        list.add(1L);
        list.size();
        Object o = list.get(0);
        System.out.println(o);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1L);
        list.size();
        Long o = (Long)list.get(0);
        System.out.println(o);
    }
}
