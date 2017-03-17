package com.nezha.alibaba;

/**
 * Created by 123 on 2017/3/16.
 */
public class BinaryTree {
    private Node root;
    /**
     *
     * 内部节点类
     * @author yhh
     */
    private class Node{
        private Node left;
        private Node right;
        private int data;
        public Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
}
