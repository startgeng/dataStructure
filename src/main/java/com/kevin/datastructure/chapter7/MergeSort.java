package com.kevin.datastructure.chapter7;

import com.kevin.datastructure.chapter3.MyArray.Array;

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
        sort(arr,0,arr.length-1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr,int l,int r){
        if (l >= r){
            return;
        }
        int mid = (l + r) / 2;
        sort(arr,l,mid);
        sort(arr,mid + 1,r);
        merge(arr,l,mid,r);
    }

    //[l,mid] [mid+1,r]
    private static <E extends Comparable<E>> void merge(E[] arr,int l,int mid,int r){
        // r+1 是因为copyOfRange复制的时候是前闭后开
        E[] temp = Arrays.copyOfRange(arr,l,r + 1);
        int i = l ,j  = mid + 1;
        //每轮循环为arr[k]赋值
        for (int k = l ; k <= r ; k++){
            if(i > mid){
                arr[k] = temp[j - l]; j ++;
            }
            else if(j > r){
                arr[k] = temp[i - l]; i ++;
            }
            else if(temp[i - l].compareTo(temp[j - l]) <= 0){
                arr[k] = temp[i - l]; i ++;
            }
            else{
                arr[k] = temp[j - l]; j ++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,7,1,3,4,2,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
