package com.nezha.dp.Singleton;

/**
 * Created by 123 on 2017/3/14.
 */
public class test{
    //这里就是需要存放的单例资源
    public test(){

    }

    public static void main(String[] args){
        test test1 = SingletonEnum.INSTANCE.getInstance();
        test test3 = SingletonEnum.INSTANCE.getInstance();
        System.out.println(test1==test3);
    }
}
