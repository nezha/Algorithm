package com.nezha.lanqiao.year2016;

/**
 * Created by nezha on 2017/4/6.
 */
public class code3 {
    static boolean[] visit = new boolean[10];
    static int[] list = new int[10];
    static int count = 0;
    static void dfs(int step){
        if (step == 10){
            if(list[0] < list[1] && list[0] < list[2]
                    && list[1] < list[3] && list[1] < list[4] && list[2] < list[4] && list[2] < list[5]
                    && list[3] < list[6] && list[3] < list[7] && list[4] < list[7] && list[4] < list[8] && list[5] < list[8] && list[5] < list[9]){
                count++;
            }
            return;
        }

        for (int item = 0;item < 10; item++){
            if (visit[item] == false){
                list[step] = item;
                visit[item] = true;
                dfs(step+1);
                visit[item] = false;
            }
        }
    }
    public static void main(String[] args){
        dfs(0);
        System.out.println(count);

    }

}
