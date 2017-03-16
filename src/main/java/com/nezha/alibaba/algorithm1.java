package com.nezha.alibaba;

/**
 * Created by 123 on 2017/3/14.
 *  @author nezha
 *  @deprecated 题目：一个整型数组，将其划分为和相同的4个切片，例如：{ 2, 3, 5, 1, 2, 2, 1, 1, 3 }，切片操作后划分为：{2,3}，{5}，{1,2,2}，{1,1,3}，也就找到所谓的四等分点。只不过输出结果为true或者false（是否能得到这样的4个切片）。同时要求时间复杂度和空间复杂度为o(n)。
 */
public class algorithm1 {

    public static void main(String[] args) {
        int[] a = { 2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7 };
        int[] b={10,2,11,13,1,1,1,1,1};
        int[] c={};
        int[] d={1,1,1,5,3,9,1,2,7,2,1};
        int[] e={1,2,3,4,5,6,7};
        int[] f={1,2,3};

        System.out.println(fensi(a));
        System.out.println(fensi(b));
        System.out.println(fensi(c));
        System.out.println(fensi(d));
        System.out.println(fensi(e));
        System.out.println(fensi(f));


    }

    private static boolean fensi(int[] a) {
        if (a.length < 7 || a==null)
            return false;
        int i = 0, j = a.length - 1;
        int i2=0,j2=0;
        long p = a[i], q = a[j];

        while (i<j-3){
            if (p < q ) {
                i++;
                p = p + a[i];
            }
            if (p > q ) {
                j--;
                q = q + a[j];
            }
            i2=i;
            j2=j;
            if(p==q){//第一四份相等，检查第二份和第三份是否和一四份相等
                i=i+2;j=j-2;
                long p2=a[i];
                long q2=a[j];
                //检查2，3份是否合乎规范
                while(i<j-2){
                    if(p2<q2){
                        i++;
                        p2=p2+a[i];
                    }
                    if(p2>q2 && i<j-2){
                        j--;
                        q2=q2+a[j];
                    }
                    if(p2==q2 && i<j-2){
                        i++;
                        p2=p2+a[i];
                    }
                }

                if(p2==q2 && p==p2 && i+2==j){//找到
                    return true;
                }

                if(p2+q2>p+q){//没找到
                    j=j2;
                    i=i2;
                    i++;
                    p=p+a[i];
                }
            }

        }
        return false;
    }
}
