package com.kevin.datastructure.chapter2.practice2;

import java.util.Arrays;

/**
 *
 *  插入排序发的优化
 * @author kevin
 * @version 1.0
 * @date 2020-12-10 16:36
 */
public class insertionSortU {

    /**
     * 插入排序法的优化
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void insertSortU(E[] arr){

        for (int i = 0; i < arr.length; i++) {
//            E t = arr[i];
//            int j;
//            for (j = i; j - 1 >= 0 && t.compareTo(arr[j-1]) > 0; j--) {
//                arr[j] = arr[j-1];
//            }
//            arr[j] = t;
            E t = arr[i];
            int j;
            for (j = i;j - 1 >= 0 && t.compareTo(arr[j-1]) < 0;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0 ; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int j, int k) {
        E t = arr[k];
        arr[k] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {4,2,1,6,7,5};
        insertSortU(arr);
        System.out.println(Arrays.toString(arr));
    }
}
