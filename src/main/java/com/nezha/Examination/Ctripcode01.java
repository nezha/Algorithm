package com.nezha.Examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nezha on 2017/4/11.
 */
public class Ctripcode01 {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int input;
        input = cin.nextInt();
        System.out.println(divMax(input));

    }

    public static int divMax(int a) {
        int input = a;
        int k = 2;
        List<Integer> arrCandy = new ArrayList<Integer>();
        while (input >= k){
            arrCandy.add(k);
            input -=k;
            k++;
        }
        int len = arrCandy.size();
        if (input > 0){
            if (input == arrCandy.get(len-1)){
                arrCandy.set(len-1,arrCandy.get(len-1)+1);
                input--;
            }
            for (int j=0;j<input;j++){
                arrCandy.set(arrCandy.size()-1-j,arrCandy.get(arrCandy.size()-1-j)+1);
            }
        }
        int result = 1;
        for (int i=0;i<arrCandy.size();i++){
            result*=arrCandy.get(i);
        }
        return result;
    }
}
