package com.kevin.datastructure.sort;

import java.util.Arrays;

/**
 *  冒泡排序  平均时间复杂度是O(n)的平方
 * @author kevin
 * @version 1.0
 * @date 2021-03-05 10:15
 */
public class BulleSort {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1 ; j++) {
                int temp = 0;
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,1,2,3,7,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
