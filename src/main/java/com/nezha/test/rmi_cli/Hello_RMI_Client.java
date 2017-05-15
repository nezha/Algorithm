package com.nezha.test.rmi_cli;

import com.nezha.test.rmi_ser.IHello;

import java.rmi.Naming;

/**
 * Created by nezha on 2017/5/15.
 */
public class Hello_RMI_Client {
    public static void main(String[] args) {
        try {
            IHello hello = (IHello) Naming.lookup("rmi://localhost:1099/hello");
            System.out.println(hello.sayHello("zhangxianxin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
