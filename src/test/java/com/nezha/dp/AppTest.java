package com.nezha.dp;

import com.nezha.dp.Singleton.Singleton;
import com.nezha.dp.Singleton.SingletonInnerclass;
import  org.junit.Test;

public class AppTest
{
    @Test
    public void test(){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("Singleton Test"+singleton1.hashCode()+"and"+singleton2.hashCode());
        SingletonInnerclass singleton3 = SingletonInnerclass.getInstance();
        SingletonInnerclass singleton4 = SingletonInnerclass.getInstance();
        System.out.print("SingletonInnerclass Test"+singleton3.hashCode()+"and"+singleton4.hashCode());
    }
}
