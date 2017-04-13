package com.nezha.leetcode;

/**
 * code: 110
 * Created by nezha on 2017/4/10.
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class code_110 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = treeHight(root.left); //左子树的高度
        int right = treeHight(root.right);//右子树的高度
        //如果左右子树高度差小于1，就遍历所有孩子的子树。
        if(Math.abs(left-right) <= 1){
            return isBalanced(root.left) & isBalanced(root.right);
        }
        //否则不是平衡二叉树
        return false;
    }
    //求最大深度
    public int treeHight(TreeNode node){
        if(node == null) return 0;
        int left = treeHight(node.left);
        int right = treeHight(node.right);
        return Math.max(left,right) + 1;
    }
}
