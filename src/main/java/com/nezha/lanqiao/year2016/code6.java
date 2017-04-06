package com.nezha.lanqiao.year2016;

/**
 * Created by nezha on 2017/4/6.
 */
public class code6 {
    static boolean[] visit = new boolean[13];
    static int[] list = new int[12];
    static int count = 0;
    static void dfs(int step){
        if (step == 12){
            if((list[0] + list[1])==list[2] && (list[3] - list[4]) == list[5]
                    && (list[6] * list[7]) == list[8] && (list[11]*list[10] == list[9])){
                count++;
                System.out.println(count);
            }
            return;
        }

        for (int item = 0;item < 13; item++){
            if (visit[item] == false){
                list[step] = item + 1;
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
