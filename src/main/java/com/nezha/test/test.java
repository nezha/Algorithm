package com.nezha.test;

import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 123 on 2017/3/14.
 */
public class test {
    public final int COUNT = 10;
    public static void  main(String[] args){
//        BlockingQueue<String> test = new ArrayBlockingQueue<String>(10);
//        try {
//            test.put("1");
//            test.put("2");
//            test.take();
//            test.take();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        Object o1 = new Object();
//        System.out.println("o1 hash"+o1.hashCode());
//        int h = o1.hashCode();
//        System.out.println("h >>> 16" + (8 >>> 3));
//        int b = h ^ (h >>> 16);
//        System.out.println(b);


    }

    public int getJudge(){
        try {
            System.out.println(COUNT);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return 1;
        }
    }

}


abstract class shape{
    public abstract void getArea();
}


class shapeA extends shape{
    public static String a = "Hello";
    public shapeA() {
        System.out.println("shapeA init "+super.getClass().getName());
    }

    @Override
    public void getArea() {
        System.out.println("shapeA");
    }

    class innerClass{
        public innerClass(){
            System.out.println(super.getClass().getName());
        }
    }
}
