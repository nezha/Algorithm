package com.nezha.test;

import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by 123 on 2017/3/14.
 */
public class test {
    public static void main(String[] args) {
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(20));
    }

}


