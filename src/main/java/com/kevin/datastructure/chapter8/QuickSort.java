package com.kevin.datastructure.chapter8;

/**
 * 多个版本的快速排序算法
 * @author kevin
 * @version 1.0
 * @date 2021-01-20 10:23
 */
public class QuickSort {

    private QuickSort(){}

    //快速排序法
    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr,0,arr.length-1);
    }

    private static<E extends Comparable> void sort(E[] arr, int i, int r) {
        if (i > r){
            return;
        }
        int p = partition(arr, 0, r);
        sort(arr,0,p - 1);
        sort(arr,p + 1,r);
    }

    //求出中间值
    private static <E extends Comparable<E>> int partition(E[] arr,int l,int r){
        //arr[l+1...j] < V  <  arr[j+1....i]
        int j = l;
        for (int i = l + 1;i <= r ; i++){
            if (arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E ret = arr[i];
        arr[i] = arr[j];
        arr[j] = ret;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,1,2,4,5};
        System.out.println(partition(arr,0,4));
    }
}
