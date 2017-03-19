package com.nezha.java;

import java.text.Collator;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 123 on 2017/3/15.
 */
public class CollectionTest {
    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<Integer>();
        System.out.println(list1.size());
        List<Integer> list2 = new LinkedList<Integer>();
        Collections.sort(list1, Collator.getInstance(Locale.CHINA));
        Vector<Integer> vect1 = new Vector<Integer>();
        HashMap<String,Integer> hashMap1 = new HashMap<String, Integer>();
        Hashtable hashtable1 = new Hashtable();
        hashtable1.put("1",1);
        hashtable1.put(2,2);
        HashSet hashSet1 = new HashSet();
        hashMap1.put(null,null);
        Collections.synchronizedMap(hashMap1);
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String, String>();
        LinkedHashMap<String,Integer> hashMap2 = new LinkedHashMap<String, Integer>(16, 0.75f,true);
        TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
    }
}

class compareTest implements Comparable,Comparator{
    public int compareTo(Object o) {
        return 0;
    }

    public int compare(Object o1, Object o2) {
        return 0;
    }
}
