package com.kevin.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * @author kevin
 * @version 1.0
 * @date 2021-03-05 10:54
 */
public class BulleSortAddEnahnce {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSort = true;
            int sortBoard = arr.length - 1;
            int lastIndex = 0;
            for (int j = 0; j < sortBoard ; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    lastIndex = j;
                    isSort = false;
                }
            }
            sortBoard = lastIndex;
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
