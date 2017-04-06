package com.nezha.lanqiao.year2016;

/**
 * Created by nezha on 2017/4/6.
 */
public class code2 {
    public static void main(String[] args){
        int allAge = 236;
        int startAge = 1;
        int endAge = 100;
        for (int i = 0;i<=100;i++){
            int sum = 0;
            int count = i;
            while (sum < allAge){
                sum = sum + count;
                count = count + 1;
            }
            if (sum == allAge){
                startAge = i;
                endAge = count - 1;
                break;
            }
        }
        System.out.println(startAge);
        System.out.println(endAge);
    }
}
