package com.nezha.dp.Singleton;

/**
 * Created by nezha on 2017/3/24.
 */
public class SingletonEnum {
    class Resource{
        //这里就是需要存放的单例资源
    }
    enum Singleton{
        INSTANCE;
        private Resource instance;
        private Singleton(){
            instance = new Resource();
        }

    }

    public static void main(String[] args) {
        Singleton s=Singleton.INSTANCE;
        Singleton s2=Singleton.INSTANCE;
        System.out.println(s==s2);
    }
}


