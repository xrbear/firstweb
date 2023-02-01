package com.study.demo.morethread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Data;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：xurong02
 * @date ：2023/1/11 3:22 下午
 */
@Data
public class ThreadLocalStudy {

    private ThreadLocal<Integer> age = new ThreadLocal<>();
    private ThreadLocal<Integer> age1 = new ThreadLocal<>();
    private ThreadLocal<Integer> age2 = new ThreadLocal<>();
    private ThreadLocal<Integer> age3 = new ThreadLocal<>();
    private ThreadLocal<Integer> age4 = new ThreadLocal<>();
    private ThreadLocal<Integer> age5 = new ThreadLocal<>();
    private ThreadLocal<Integer> age6 = new ThreadLocal<>();
    private ThreadLocal<Integer> age7 = new ThreadLocal<>();
    private ThreadLocal<Integer> age8 = new ThreadLocal<>();
    private ThreadLocal<Integer> age9 = new ThreadLocal<>();
    private ThreadLocal<Integer> age10 = new ThreadLocal<>();
    private ThreadLocal<Integer> age11 = new ThreadLocal<>();
    private ThreadLocal<Integer> age12 = new ThreadLocal<>();
    private ThreadLocal<Integer> age13 = new ThreadLocal<>();
    private ThreadLocal<Integer> age14 = new ThreadLocal<>();
    private ThreadLocal<Integer> age15 = new ThreadLocal<>();
    private ThreadLocal<Integer> age16 = new ThreadLocal<>();
    private ThreadLocal<String> name = new ThreadLocal<>();

    private ThreadFactory threadFactory = new ThreadFactoryBuilder().build();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws InterruptedException {
        ThreadLocalStudy threadLocalStudy = new ThreadLocalStudy();
        threadLocalStudy.setAge16(1);
        threadLocalStudy.setAge3(3);
        System.out.println(threadLocalStudy.getAge16());
        System.out.println(threadLocalStudy.getAge3());
    }

    private Integer getAge(){
        return age.get();
    }

    private Integer getAge16(){
        return age16.get();
    }
    private Integer getAge3(){
        return age3.get();
    }

    private void setAge(int i) {
        age.set(i);
    }

    private void setAge1(int i) {
        age1.set(i);
    }
    private void setAge2(int i) {
        age2.set(i);
    }
    private void setAge3(int i) {
        age3.set(i);
    }
    private void setAge4(int i) {
        age4.set(i);
    }
    private void setAge5(int i) {
        age5.set(i);
    }
    private void setAge6(int i) {
        age6.set(i);
    }
    private void setAge7(int i) {
        age7.set(i);
    }private void setAge8(int i) {
        age8.set(i);
    }private void setAge9(int i) {
        age9.set(i);
    }private void setAge10(int i) {
        age10.set(i);
    }private void setAge11(int i) {
        age11.set(i);
    }
    private void setAge12(int i) {
        age12.set(i);
    }private void setAge13(int i) {
        age13.set(i);
    }
    private void setAge14(int i) {
        age14.set(i);
    }
    private void setAge15(int i) {
        age15.set(i);
    }
    private void setAge16(int i) {
        age16.set(i);
    }







}
