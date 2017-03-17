package com.nezha.alibaba;

import java.util.ArrayList;
import java.util.Scanner;
public class Solution {
    /**
     * http://blog.csdn.net/panzw2015/article/details/62057780
     * @param args
     */
    public static void main(String[] args){
//        ArrayList<Integer> inputs = new ArrayList<Integer>();
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//        while(line!=null && line.length() < 1){
//            int value = Integer.parseInt(line);
//            if(value==0)
//                break;
//            inputs.add(value);
//            line = in.nextLine();
//        }
//
//        int[] INPUT = new int[inputs.size()];
//        for(int i=0;i<inputs.size();i++){
//            INPUT[i]=inputs.get(i).intValue();
//        }
         int[] input = {113, 215, 221};
        int res = solve(input);
        System.out.println(res);
    }

    public static int solve(int[] INPUT){
        ArrayList<Integer> tmp= new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
        int inLength = INPUT.length;
        int[] bai = new int[inLength];
        int[] shi = new int[inLength];
        int[] ge = new int[inLength];
        for(int i=0;i<inLength;i++){
            bai[i]=INPUT[i]/100;
            shi[i]=INPUT[i]/10%10;
            ge[i]=INPUT[i]%10;
        }
        int[] treeArray = new int[16];
        for(int i=0;i<16;i++){
            treeArray[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<inLength;i++){
            int loc = (int) Math.pow(2, bai[i]-1)+shi[i]-1;
            treeArray[loc]= ge[i];
        }

        helper(treeArray,1,t,tmp);

        int r = 0;
        for(int i=0;i<t.size();i++){
            for(int j=0;j<t.get(i).size();j++)
                r += t.get(i).get(j);
        }

        return r;
    }

    public static void helper(int[] treeArray,int index,ArrayList<ArrayList<Integer>> ret,ArrayList<Integer> tmp){
        if(treeArray[index]!=Integer.MIN_VALUE)
            tmp.add(treeArray[index]);

        if(treeArray[2*index]==Integer.MIN_VALUE && treeArray[2*index+1]==Integer.MIN_VALUE)
        {
            ret.add(new ArrayList<Integer>(tmp));
            return ;
        }
        if(treeArray[2*index]!=Integer.MIN_VALUE){
            helper(treeArray,2*index,ret,tmp);
            tmp.remove(tmp.size()-1);
        }
        if(treeArray[2*index+1]!=Integer.MIN_VALUE){
            helper(treeArray,2*index+1,ret,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}