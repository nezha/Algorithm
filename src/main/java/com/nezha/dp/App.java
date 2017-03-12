package com.nezha.dp;

import org.junit.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public void test(){
        System.out.print("My first maven project!");
    }

    @Test
    public void  test1(){
        App app = new App();
        app.test();
    }
}
