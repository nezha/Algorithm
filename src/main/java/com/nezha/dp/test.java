package com.nezha.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 123 on 2016/12/29.
 */
public class test {

    @Test
    public void test1(){
        int[] a = {1,2,3,4,5};
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int item:a) {
            l.add(Integer.valueOf(item));
        }
        List<Integer> d =  l.subList(1,3);
        int c = l.indexOf(3);
        List list= Arrays.asList(a);
        int b = list.indexOf(3);
        System.out.println(b);
    }
}
