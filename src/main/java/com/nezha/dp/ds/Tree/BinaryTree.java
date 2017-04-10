package com.nezha.dp.ds.Tree;

import java.util.*;

/**
 * Created by 123 on 2017/3/17.
 */
public class BinaryTree {
    public Node root = null;

    /**
     * 二叉树结点的定义
     */
    private class Node{
        private int data;
        private Node left,right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public BinaryTree(){
    }

    /**
     * 递归创建二叉树
     * @param node
     * @param data
     */
    public void buildTree(Node node,int data){
        if (null == root){
            root = new Node(data);
        }else {
            if (data > node.data){
                //大于就往右边存
                if (null == node.right){
                    node.right = new Node(data);
                }else {
                    buildTree(node.right,data);
                }
            }else {
                //小于就往左边存
                if (null == node.left){
                    node.left = new Node(data);
                }else {
                    buildTree(node.left,data);
                }
            }
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(Node node){
        if (node != null){
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 前序遍历,非递归方式
     * @param root
     * * 利用栈实现循环先序遍历二叉树
     * 这种实现类似于图的深度优先遍历（DFS）
     * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。
     * 这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用
     */
    public void nonRecPreOrder(Node root){
        Stack<Node> stack = new Stack<Node>();
        if(root == null){
            System.out.println("----空树----");
        }else {
            stack.push(root);
            while(!stack.empty()){
                Node node = stack.pop();
                visit(node);
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     *
     * @param root 树的根节点
     * 利用栈模拟递归过程实现循环先序遍历二叉树
     * 这种方式具备扩展性，它模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树
     */
    public void preOrderStack_2(Node root){
        if(root==null)return;
        Stack<Node> s=new Stack<Node>();
        while(root!=null||!s.isEmpty()){
            while(root!=null){
                visit(root);
                s.push(root);//先访问再入栈
                root=root.left;
            }
            root=s.pop();
            root=root.right;//如果是null，出栈并处理右子树
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    /**
     * 中序遍历，非递归方式
     * @param root
     */
    public void nonRecInOrder(Node root){
        Stack<Node> stack =new Stack<BinaryTree.Node>();
        Node node = root;
        while(node!=null||stack.size()>0){
            //存在左子树
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            //栈非空
            if(stack.size()>0){
                node=stack.pop();
                visit(node);
                node=node.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }

    /**
     *后序遍历-非递归
     * @param root 树根节点
     * 后序遍历不同于先序和中序，它是要先处理完左右子树，然后再处理根(回溯)，所以需要一个记录哪些节点已经被访问的结构(可以在树结构里面加一个标记)，这里可以用map实现
     */
    public void postOrderStack(Node root){
        if(root==null)return;
        Stack<Node> s=new Stack<Node>();
        Map<Node,Boolean> map=new HashMap<Node,Boolean>();
        s.push(root);
        while(!s.isEmpty()){
            Node temp=s.peek();
            if(temp.left!=null&&!map.containsKey(temp.left)){
                temp=temp.left;
                while(temp!=null){
                    if(map.containsKey(temp))break;
                    else s.push(temp);
                    temp=temp.left;
                }
                continue;
            }
            if(temp.right!=null&&!map.containsKey(temp.right)){
                s.push(temp.right);
                continue;
            }
            Node t=s.pop();
            map.put(t,true);
            visit(t);
        }
    }

    /**
     * 层次遍历
     * 先将根节点入队，当前节点是队头节点，将其出队并访问，如果当前节点的左节点不为空将左节点入队，如果当前节点的右节点不为空将其入队。所以出队顺序也是从左到右依次出队。
     * @param root
     */
    public void levelIterator(Node root)
    {
        if(root == null)
        {
            return ;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        Node current = null;
        queue.offer(root);//将根节点入队
        while(!queue.isEmpty())
        {
            current = queue.poll();//出队队头元素并访问
            visit(current);
            if(current.left != null)//如果当前节点的左节点不为空入队
            {
                queue.offer(current.left);
            }
            if(current.right != null)//如果当前节点的右节点不为空，把右节点入队
            {
                queue.offer(current.right);
            }
        }

    }
    /**
     * 求二叉树的最大深度
     * @param node
     * @return
     */
    int maxDepth(Node node){
        if(node==null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left,right) + 1;
    }

    /**
     * 求二叉树的最小深度
     * @param root
     * @return
     */
    int getMinDepth(Node root){
        if(root == null){
            return 0;
        }
        return getMin(root);
    }
    int getMin(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null&&root.right == null){
            return 1;
        }
        return Math.min(getMin(root.left),getMin(root.right)) + 1;
    }

    /**
     * 求二叉树中叶子节点的个数
     * @param root
     * @return
     */
    public int numsOfNoChildNode(Node root){
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return numsOfNoChildNode(root.left)+numsOfNoChildNode(root.right);
    }

    /**
     * 求二叉树中节点的个数
     * @param node
     * @return
     */
    int numOfTreeNode(Node node){
        if(node == null){
            return 0;
        }
        int left = numOfTreeNode(node.left);
        int right = numOfTreeNode(node.right);
        return left + right + 1;
    }

    /**
     * 求二叉树中第k层节点的个数
     * @param node
     * @param k
     * @return
     */
    int numsOfkLevelTreeNode(Node node,int k){
        if(node == null||k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int numLeft = numsOfkLevelTreeNode(node.left,k-1);
        int numRight = numsOfkLevelTreeNode(node.right,k-1);
        return numLeft + numRight;
    }

    /**
     * 递归的方式遍历所有路径
     */
    List<String> res = new ArrayList<String>();

    public List<String> binaryTreePaths(Node root) {
        if(root != null) findPaths(root,String.valueOf(root.data));
        return res;
    }
    private void findPaths(Node n, String path){

        if(n.left != null) findPaths(n.left, path+"->"+n.left.data);
        if(n.right != null) findPaths(n.right, path+"->"+n.right.data);
        if(n.left == null && n.right == null) res.add(path);
    }

    /**
     * 递归方式求加权路径和
     */
    List<Integer> weightPathsSum = new ArrayList<Integer>();
    public List<Integer> binaryTreeWeightPathsSum(Node root) {
        if(root != null) findPathsSum(root,1,0);
        return weightPathsSum;
    }

    public void findPathsSum(Node node,int height,int data){
        if (node.left != null) findPathsSum(node.left,height+1,node.data+ data);
        if (node.right != null) findPathsSum(node.right,height+1,node.data + data);
        if (node.left == null && node.right == null) weightPathsSum.add(data+node.data);
    }



    /**
     * 读取数据
     * @param node
     */
    public void visit(Node node){
        System.out.print(node.data);
    }


    public static void main(String[] args){
        BinaryTree bTree = new BinaryTree();
        int[] a = {2,1,4,12,45,21,6,111};
        for (int item:a) {
            System.out.println("item"+item);
            bTree.buildTree(bTree.root,item);
        }
        System.out.println("\n----preOrder-----\n");
        bTree.preOrder(bTree.root);
        System.out.println();
        bTree.nonRecPreOrder(bTree.root);
        System.out.println("\n-----inOrder-----\n");
        bTree.inOrder(bTree.root);
        System.out.println();
        bTree.nonRecInOrder(bTree.root);
        System.out.println("\n-----postOrder-----\n");
        bTree.postOrder(bTree.root);
        bTree.postOrderStack(bTree.root);
        System.out.println();
        System.out.println("\n-----maxDepth-----\n");
        int maxDeep = bTree.maxDepth(bTree.root);
        System.out.println(maxDeep);
        System.out.println("\n-----minDepth-----\n");
        int minDepth = bTree.getMinDepth(bTree.root);
        System.out.println(minDepth);
        System.out.println("\n-----二叉树中叶子节点的个数-----\n");
        int numofleaf = bTree.numsOfNoChildNode(bTree.root);
        System.out.println(numofleaf);
        System.out.println("\n-----二叉树中节点的个数-----\n");
        int numOfNode = bTree.numOfTreeNode(bTree.root);
        System.out.println(numOfNode);
        System.out.println("\n-----二叉树中第k层节点的个数-----\n");
        int numKnode = bTree.numsOfkLevelTreeNode(bTree.root,3);
        System.out.println(numKnode);
        System.out.println("\n-----二叉树中层次遍历-----\n");
        bTree.levelIterator(bTree.root);
        System.out.println();
        System.out.println("\n-----二叉树遍历路径-----\n");
        List<String> treePath = bTree.binaryTreePaths(bTree.root);
        System.out.println("二叉树遍历路径"+treePath);

        System.out.println("\n-----递归方式求加权路径和-----\n");
        List<Integer> PathsSum = bTree.binaryTreeWeightPathsSum(bTree.root);
        System.out.println("二叉树加权路径和"+PathsSum.toString());
    }

}
