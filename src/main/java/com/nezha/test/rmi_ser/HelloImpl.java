package com.nezha.test.rmi_ser;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by nezha on 2017/5/15.
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {
    protected HelloImpl() throws RemoteException {
        super();
    }
    private static final long serialVersionUID = 4077329331699640331L;

    //@Override
    public String sayHello(String name) throws RemoteException {
        return "Hello " + name + " ^_^ ";
    }

    public static void main(String[] args) {
        try {
            IHello hello = new HelloImpl();
            LocateRegistry.createRegistry(1099); //加上此程序，就可以不要在控制台上开启RMI的注册程序，1099是RMI服务监视的默认端口
            Naming.rebind("rmi://localhost:1099/hello", hello);
            System.out.print("Ready");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
