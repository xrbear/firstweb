package com.study.demo.bean;

/**
 * @author ：xurong02
 * @date ：2022/11/5 11:00 上午
 */
public class MyThread extends Thread{

    private int i;
    private Integer count = 5;

   /* public MyThread(int x){
        this.i = x;
    }*/

    /*public MyThread(String name){
        this.setName(name);
    }*/

    @Override
     public  void  run(){
synchronized (count){

}
        for (int i=0;i<500;i++){
            System.out.println("i = "+ (i+1));
        }

            /*try{
                System.out.println("run threadName="+Thread.currentThread().getName()+" begin");
                Thread.sleep(2000);
                System.out.println("run threadName="+Thread.currentThread().getName()+" end");
            }catch (Exception e){

            }*/


    }
}
