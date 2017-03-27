package com.nezha.java;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.TimeUnit;

/**
 * Created by nezha on 2017/3/27.
 */
public class ThreadCommunication {



    public static void main(String[] args) throws IOException{
        Piped piped = new Piped();
        piped.ConnByPip();
    }
    public void printInfo(){
        Thread thread = Thread.currentThread();
        System.out.println("id:"+thread.getId()+"name:"+thread.getName());
    }
    @Test
    public void testPip() throws IOException{
        printInfo();
    }



}

class Piped{
    public void ConnByPip() throws IOException{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();
        int receive = 0;
        try{
            while ((receive = System.in.read()) != -1){
                out.write(receive);
            }
        }finally {
            out.close();
            in.close();
        }
    }
}
class Print implements Runnable{
    private PipedReader in;
    public Print(PipedReader in){
        this.in = in;
    }
    public void run() {
        int receive = 0;
        try {
            while ((receive = in.read()) != -1){
                System.out.print((char) receive);
            }
        }catch (IOException e){

        }
    }
}


class Profiler{
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };

    public static void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost:" + Profiler.end()+"mills");
    }
}
