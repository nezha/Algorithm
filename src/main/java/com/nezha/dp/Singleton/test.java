package com.nezha.dp.Singleton;

/**
 * Created by 123 on 2017/3/14.
 */
public class test {
    public static void main(String[] args){
        SingletonInnerclass s1 = SingletonInnerclass.getInstance();
        System.out.printf("" + s1.hashCode());
        SingletonInnerclass s2 = SingletonInnerclass.getInstance();
        System.out.printf("" + s2.hashCode());
    }

}
