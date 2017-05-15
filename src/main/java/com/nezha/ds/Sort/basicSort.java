package com.nezha.ds.Sort;

import java.util.Arrays;

/**
 * Created by nezha on 2017/4/10.
 */
public class basicSort {
    public static void main(String[] args) {
        int[] a = {2, 4, 2, 6, 4, 2, 8, 9, 0, 5, 4, 3, 12, 3, 5, 323, 2, 1, 46, 34, 45};
//        basicSort.bubbleSort(a);
//        basicSort.insertSort(a);
//        basicSort.insertBinarySort(a);
//        basicSort.selectSort(a);
//        basicSort.sortQuick(a);
        basicSort.mergeSort(a);

        System.out.println(Arrays.toString(a));


    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    flag = false;
                }
            }
            if (flag) return;
        }

    }

    //插入排序

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            out:
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else break out;
            }
        }
    }

    public static void insertBinarySort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int low = 0, high = i - 1, mid;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (temp < arr[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                for (int j = i; j > low; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[low] = temp;
            }
        }
    }

    //希尔排序

    public static void shellSort(int[] arr) {
        int gap = Math.round(arr.length / 2);
        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j += gap) {
                    if (arr[j] > arr[j - gap]) {
                        int temp = arr[j];
                        int k = j - gap;
                        while (k >= 0 && arr[k] > temp) {
                            arr[k + gap] = arr[k];
                            k -= gap;
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i = i + gap) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    //选择排序
    public static void selectSort(int[] arr) {
        int len = arr.length;
        //每次从后边选择一个最小值
        for (int i = 0; i < len - 1; i++) {     //只需选择n-1次
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }


    //快速排序
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortQuick(int[] quickArray) {
        int[] arr = quickArray;
        quickSort(0, arr.length - 1, arr);
    }



    public static void quickSort(int start, int end, int[] arr) {
        if (start < end) {
            int pivot = arr[start];
            int left = start;
            int right = end;
            while (left != right) {
                while (arr[right] >= pivot && left < right) right--;
                while (arr[left] <= pivot && left < right) left++;
                swap(left, right, arr);
            }
            arr[start] = arr[left];
            arr[left] = pivot;
            quickSort(start, left - 1, arr);
            quickSort(left + 1, end, arr);
        }
    }

    //归并排序
    public static void mergeSort(int[] arr){
        mergeSortDiv(arr,0,arr.length-1);
    }

    public static int[] mergeSortDiv(int[] arr,int low,int high){
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSortDiv(arr, low, mid);
            // 右边
            mergeSortDiv(arr, mid + 1, high);
            // 左右归并
            merge(arr, low, mid, high);
        }
        return arr;
    }

    public static void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

    //堆排序：http://blog.csdn.net/zdp072/article/details/44227317


}
