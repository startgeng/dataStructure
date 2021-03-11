package com.kevin.datastructure.sort;

import java.util.Arrays;

/**
 *  冒泡算法增强版本
 * @author kevin
 * @version 1.0
 * @date 2021-03-05 10:23
 */
public class BulleSortEnhance {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1 ; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,2,3,7,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
