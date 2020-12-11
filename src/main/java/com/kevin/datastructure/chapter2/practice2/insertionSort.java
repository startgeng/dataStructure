package com.kevin.datastructure.chapter2.practice2;

import com.kevin.datastructure.chapter1.practice.ArrayGenerator;
import com.kevin.datastructure.chapter2.practice.SortingHelper;

/**
 *  插入排序法
 * @author kevin
 * @version 1.0
 * @date 2020-12-09 16:24
 */
public class insertionSort {

    private insertionSort(){}

    /**
     *  插入排序法
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr){

        for (int i = 0; i < arr.length; i++) {
            //将arr[i] 插入到合适的位置
//            for (int j = i; j - 1 >= 0 ; j--){
//                if (arr[j].compareTo(arr[j-1]) < 0){
//                    swap(arr,j,j-1);
//                }else {
//                    break;
//                }
//            }
//            for (int j = i;j - 1 >= 0 && arr[j].compareTo(arr[j-1]) < 0;j--){
//                swap(arr,j,j-1);
//            }
            E t = arr[i];
            int j;
            for (j = i;j - 1 >= 0 && t.compareTo(arr[j-1]) > 0;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = t;
        }
    }

    /**
     * 交换arr[j] 和 arr[j-1]
     * @param arr
     * @param j
     * @param j-1
     * @param <E>
     */
    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        Integer[] arr = ArrayGenerator.generateOrderArray(100000000);
        long endTime1 = System.nanoTime();
        System.out.println((endTime1 - startTime1) / 1000000000.0);
        long startTime = System.nanoTime();
        insertionSort.sort(arr);
        long endTime = System.nanoTime();
        double spendTime = (endTime - startTime) / 1000000000.0;
        System.out.println(spendTime+" s");
        if (!SortingHelper.isSorted(arr)){
            throw new RuntimeException("出现异常,没有正常排序");
        }
    }
}
