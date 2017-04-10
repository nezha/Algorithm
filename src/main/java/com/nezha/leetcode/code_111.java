package com.nezha.leetcode;

/**
 * leetcode 111：	Minimum Depth of Binary Tree
 *
 * Created by nezha on 2017/4/10.
 * /**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class code_111 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }
        return minDepth(root);
    }

    public int minDepth(TreeNode node){
        if(node == null) return 0;
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        //一旦遇到左孩子或右孩子为空的时候就可以返回了
        if(node.left == null || node.right == null){
            return left + right + 1;
        }
        return Math.min(left,right) + 1;

    }
}
