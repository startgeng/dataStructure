package com.kevin.datastructure.chapter2.practice;

import java.util.Arrays;

/**
 *  选择排序控制循环不变量 , 从后向前进行排序
 * @author kevin
 * @version 1.0
 * @date 2020-12-09 14:47
 */
public class SelectSortHomeWork {

//    public static void selectSort(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            int minValue = i;
//            for (int j = arr.length-1; j > 0; j--) {
//                if (arr[j] < arr[minValue]){
//                    minValue = j;
//                }
//            }
//            swap(arr,i,minValue);
//        }
//    }
//
//    private static void swap(int[] arr, int i, int j) {
//        int t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
//    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        for (int i = arr.length-1; i >= 0; i--) {
            int maxValue = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxValue]) > 0){
                    maxValue = j;
                }
            }
            swap(i,maxValue,arr);
        }
    }

    private static <E extends Comparable<E>> void swap(int i, int maxValue, E[] arr) {
        E t = arr[i];
        arr[i] = arr[maxValue];
        arr[maxValue] = t;
    }


    public static void main(String[] args) {
        Integer[] arr = {5,6,1,2,9,7};
        SelectSortHomeWork.sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
