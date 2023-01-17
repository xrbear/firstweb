package com.study.demo.biz;

import org.springframework.stereotype.Service;

/**
 * @author ：xurong02
 * @date ：2022/11/3 2:44 下午
 */
@Service
public class ThreadBizImpl implements Runnable {

    public static int ticket = 100;

    @Override
    public void run() {
        System.out.println("ThreadBizImpl run，ticket:" + ticket--);
    }
}
