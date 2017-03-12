package com.nezha.dp.com.nezha.ds.StackQueue;

import java.util.Stack;

/**
 * Created by 123 on 2016/12/29.
 */
public class QueueStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        Integer a = Integer.valueOf(node);
        stack1.push(a);
    }

    public int pop() {
        if (stack2.size() == 0) {
            while (stack1.size() > 0) {
                Integer a = stack1.pop();
                stack2.push(a);
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }

    }
}
