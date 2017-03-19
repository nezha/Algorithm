package com.nezha.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by 123 on 2017/3/15.
 */
public class threadTest {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
        Thread1 mTh11 = new Thread1("A");
        Thread1 mTh12 = new Thread1("B");
        mTh11.setPriority(Thread.MAX_PRIORITY);
        mTh11.start();
        mTh12.start();
//        Thread2 mTh2 = new Thread2();
//        new Thread(mTh2, "C").start();
//        new Thread(mTh2, "D").start();

    }
}


/**
 * Created by 123 on 2017/3/15.
 *
 * @function Thread类型创建多线程
 */
class Thread1 extends Thread {
    private String name;

    public Thread1(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行--->>>" + i);
            try {
                sleep((int) Math.random() * 10 * 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable {
    private String name;
    private int count = 15;

    public Thread2() {

    }

    public Thread2(String name) {
        this.name = name;
    }


    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  :  " + count--);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyCallableThread implements Callable<Integer>{
    public static void main(String[] args) {
        MyCallableThread mct = new MyCallableThread();
        FutureTask<Integer> ft = new FutureTask<Integer>(mct);
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==20)
            {
                new Thread(ft,"有返回值的线程").start();
            }
        }
        try
        {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }

        public Integer call() throws Exception {
        int i = 0;
        for(;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }
}

class MyThreadPrinter2 implements Runnable {

    private String name;
    private final Object prev;
    private final Object self;

    private MyThreadPrinter2(String name, final Object prev, final Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        final Object a = new Object();
        final Object b = new Object();
        final Object c = new Object();
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);
        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);


        new Thread(pa).start();
        Thread.sleep(1000);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(1000);
        new Thread(pc).start();
        Thread.sleep(1000);

    }
}

/**
 * @author yi_zhang
 * @function 模拟死锁的发生
 */

class ThreadLockDemo implements Runnable {
    private boolean flag;
    private Object left;
    private Object right;
    public ThreadLockDemo(Object left, Object right, boolean flag) {
        this.left = left;
        this.right = right;
        this.flag = flag;
    }
    public void run() {
        if (flag) {
            synchronized (left) {
                System.out.println("if  A_LOCK");
                synchronized (right) {
                    System.out.println("B_LOCK");
                }

            }
        } else {
            synchronized (right) {
                System.out.println("else B_LOCK");
                synchronized (left) {
                    System.out.println("A_LOCK");
                }
            }
        }
    }
    public static void main(String[] args) {
        Object left = new Object();
        Object right = new Object();
        ThreadLockDemo td1 = new ThreadLockDemo(left,right,false);
        ThreadLockDemo td2 = new ThreadLockDemo(left,right,true);
        Thread t1 = new Thread(td1);
        Thread t2 = new Thread(td2);
        t1.start();
        t2.start();
    }
}


class ThreadInterrupt extends Thread
{
    public void run()
    {
        try
        {
            sleep(50000);  // 延迟50秒
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws Exception
    {
        Thread thread = new ThreadInterrupt();
        thread.start();
        System.out.println("在50秒之内按任意键中断线程!");
        System.in.read();
        thread.interrupt();
        thread.join();
        System.out.println("线程已经退出!");
    }
}
