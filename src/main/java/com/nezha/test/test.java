package com.nezha.test;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * Created by 123 on 2017/3/14.
 */
public class test {
    //这里的channel理解为Java里的SynchronousQueue

    private static void printer(Channel<Integer> in) throws SuspendExecution, InterruptedException{
        Integer v;
        while((v = in.receive()) != null){
            System.out.println(v);
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, SuspendExecution{
        //定义两个Channel
        Channel<Integer> naturals = Channels.newChannel(-1);
        Channel<Integer> squares = Channels.newChannel(-1);
        //运行两个Fiber实现.
        //1.生产者
        new Fiber(() -> {
            for (int i = 0; i < 10; i++)
                naturals.send(i);
            naturals.close();
        }).start();

        //消费者
        new Fiber(() -> {
            Integer v;
            while ((v = naturals.receive()) != null)
                squares.send(v*v);
            squares.close();
        }).start();

        printer(squares);
    }

}


