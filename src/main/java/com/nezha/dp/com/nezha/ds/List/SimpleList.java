package com.nezha.dp.com.nezha.ds.List;

import org.junit.Test;

/**
 * Created by 123 on 2016/12/29.
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}

public class SimpleList {
    public ListNode head;
    public SimpleList(){
        this.head = null;
    }
    public void addTail(int val){
        ListNode node = new ListNode(val);
        if (this.head == null){
            this.head = node;
        }else {
            ListNode point = this.head;
            while (point.next != null){
                point = point.next;
            }
            point.next = node;
        }
    }

    @Test
    public void test(){
        SimpleList list = new SimpleList();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        ListNode head = list.head;
        while (head!= null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
