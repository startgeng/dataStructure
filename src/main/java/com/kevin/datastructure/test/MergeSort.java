package com.kevin.datastructure.test;

import java.util.Arrays;

/**
 * 归并排序法
 * @author kevin
 * @version 1.0
 * @date 2021-01-20 9:14
 */
public class MergeSort {

    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr,0,arr.length-1,0);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, int depth) {
        if ( l >= r){
            return;
        }
        int mid = (l+r)/2;
        sort(arr,l,mid,depth + 1);
        sort(arr,mid+1,r,depth+1);
        mergeSort(arr,l,mid,r,depth);
    }

    //合并算法
    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int mid, int r, int depth) {
        //封装一个零时数组
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r ; k++){
            if (i > mid){
                arr[k] = temp[j - l]; j++;
            }else if (j > r){
                arr[k] = temp[i - l]; i++;
            }else if (temp[j - l].compareTo(temp[i - l]) <= 0){
                arr[k] = temp[j - l]; j++;
            }else {
                arr[k] = temp[i - l]; i++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,7,1,3,4,2,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
