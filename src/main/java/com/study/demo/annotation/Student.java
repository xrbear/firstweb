package com.study.demo.annotation;


/**
 * @author ：xurong02
 * @date ：2022/11/8 4:53 下午
 */
public class Student {
    @Hello(name = "cherry-peng", age = 23, score = {99, 66, 77})
    public void study(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Good Good Study, Day Day Up!");

        }
    }


    public static void main(String[] args) {
        Student student = new Student();
        student.study(10);
    }
}
