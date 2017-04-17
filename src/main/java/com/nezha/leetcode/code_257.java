package com.nezha.leetcode;

import java.util.ArrayList;
import java.util.List;

/** code:257
 * Created by nezha on 2017/4/17.
 * Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 */
public class code_257 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<String> binaryTreePaths(TreeNode root){
        if (root == null){
            return new ArrayList<String>();
        }
        List<String> returnList = new ArrayList<String>();
        DFS(returnList,root,"");
        return returnList;
    }

    public void DFS(List<String> result,TreeNode node,String base){
        String current = base.length()==0?node.val+"":base+"->"+node.val;
        if (node.left == null && node.right == null) result.add(current);
        if (node.left != null){
            DFS(result,node.left,current);
        }
        if (node.right != null){
            DFS(result,node.right,current);
        }
    }
}
