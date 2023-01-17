package com.study.demo.biz;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xurong02
 * @date ：2022/11/16 10:06 上午
 */
@Service
public class CollectionsBizImpl {

    public void doMap(){
        Map<String, String> map = new HashMap<>(16);
        String put = map.put("1", "1");
        map.get("1");
    }

    public static void main(String[] args) {
        CollectionsBizImpl collectionsBiz = new CollectionsBizImpl();
        collectionsBiz.doMap();
    }
}
