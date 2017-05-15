package com.nezha.test.rmi_ser;

import java.rmi.Remote;

/**
 * Created by nezha on 2017/5/15.
 */
public interface IHello extends Remote{
    public String sayHello(String name) throws java.rmi.RemoteException;
}
