package com.kevin.datastructure.chapter7;

import java.util.Arrays;

/**
 *  归并排序算法
 * @author kevin
 * @version 1.0
 * @date 2021-01-19 9:14
 */
public class MergeSort {

    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
    }

    //[l,mid] [mid+1,r]
    private static <E extends Comparable<E>> void merge(E[] arr,int l,int mid,int r){
        // r+1 是因为前闭后开
        E[] temp = Arrays.copyOfRange(arr,l,r+1);
        int i = l ,j  = mid + 1;
        //每轮循环为arr[k]赋值
        for (int k = l ; k <= r ; k++){
            if (i > mid){
                arr[k] = temp[j - l]; j++;
            }else if (j > r){
                arr[k] = temp[i - 1]; i++;
            }else if (temp[i - l].compareTo(temp[j - 1]) <= 0){
                arr[k] = temp[i - 1]; i++;
            }else {
                arr[k] = temp[j - 1]; j++;
            }
        }
    }
}
