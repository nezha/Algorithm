package com.nezha.test;

/**
 * Created by 123 on 2017/4/7.
 */
public class code1 {
        public static void main(String[] args) {
            String s1 = "hello";
            String s2 = "he"+new String("llo");
            System.out.println(s1==s2);
        }
}

class classA{
    private final void Print(){
        System.out.println("1");
    }
}

class classB extends classA{
    public classB(int a){

    }


    public static void main(String[] args){

    }
}

abstract class abstractTest{
    public abstractTest(){

    }
    public void test(){

    }
}

