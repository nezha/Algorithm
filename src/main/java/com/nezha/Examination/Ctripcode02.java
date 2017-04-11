package com.nezha.Examination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nezha on 2017/4/11.
 */
public class Ctripcode02 {
    /******************************开始写代码******************************/
    static int run(String numbers){
        char[] charNum = numbers.toCharArray();
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length(); i++) {
            number.add((int)(charNum[i]-'0'));
        }

        return 0;
    }
    /******************************结束写代码******************************/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numbers = new String();
        for(int rows=3; rows>0; rows--){
            for(String n: scan.nextLine().split(" ")){
                numbers += n;
            }
        }

        int res = run(numbers);

        System.out.println(String.valueOf(res));
    }
}
