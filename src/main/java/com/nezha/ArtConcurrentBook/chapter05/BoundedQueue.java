/**
 * 
 */
package com.nezha.ArtConcurrentBook.chapter05;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 10-21
 */
public class BoundedQueue<T> {
    private Object[]  items;

    private int       addIndex, removeIndex, count;
    private Lock      lock     = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull  = lock.newCondition();

    public BoundedQueue(int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length){
                System.out.println("Queue full");
                notFull.await();
            }
            items[addIndex] = t;
            if (++addIndex == items.length)
                addIndex = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }


    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                System.out.println("Queue empty");
                notEmpty.await();
            }

            Object x = items[removeIndex];
            if (++removeIndex == items.length)
                removeIndex = 0;
            --count;
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return ""+items[0]+"-"+items[1];
    }
}

class ThreadTest{
    public static BoundedQueue<Integer> boundedQueue = new BoundedQueue<Integer>(2);
    public static void main(String[] args) {
        Thread t1 = new Thread(new putRunnable(boundedQueue),"Thread1 ");
        Thread t2 = new Thread(new popRunnable(boundedQueue),"Thread2 ");
        Thread t3 = new Thread(new putOneRunnable(boundedQueue),"Thread3 ");
        try {
            t1.start();
            Thread.sleep(2000);
            t2.start();
            Thread.sleep(2000);
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class popRunnable implements Runnable{
    BoundedQueue<Integer> boundedQueue;
    public  popRunnable(BoundedQueue boundedQueue){
        this.boundedQueue = boundedQueue;
    }
    public void run() {
        try {
            boundedQueue.remove();
            System.out.println(Thread.currentThread().getName()+boundedQueue.toString());
            boundedQueue.remove();
            System.out.println(Thread.currentThread().getName()+boundedQueue.toString());
            boundedQueue.remove();
            System.out.println(Thread.currentThread().getName()+boundedQueue.toString());
            boundedQueue.remove();
            System.out.println(Thread.currentThread().getName()+boundedQueue.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class putOneRunnable implements Runnable{
    BoundedQueue<Integer> boundedQueue;
    public  putOneRunnable(BoundedQueue boundedQueue){
        this.boundedQueue = boundedQueue;
    }
    public void run() {
        try {
            boundedQueue.add(4);
            System.out.println(Thread.currentThread().getName()+boundedQueue.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class putRunnable implements Runnable{
    BoundedQueue<Integer> boundedQueue;
    public  putRunnable(BoundedQueue boundedQueue){
        this.boundedQueue = boundedQueue;
    }
    public void run(){
        try {
            boundedQueue.add(1);
            System.out.println(Thread.currentThread().getName()+boundedQueue.toString());
            boundedQueue.add(2);
            System.out.println(Thread.currentThread().getName()+boundedQueue.toString());
            boundedQueue.add(3);
            System.out.println(Thread.currentThread().getName()+boundedQueue.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
