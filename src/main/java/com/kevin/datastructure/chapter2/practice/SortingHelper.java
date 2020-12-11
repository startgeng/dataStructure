package com.kevin.datastructure.chapter2.practice;

/**
 * @author kevin
 * @version 1.0
 * @date 2020-12-09 10:28
 */
public class SortingHelper {

    private SortingHelper(){};

    /**
     *  判断排序是否正确
     * @param arr
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     *  排序算法测试
     * @param sortName
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortTest(String sortName,E[] arr){
        long startTime = System.nanoTime();
        SelectionSort.sort(arr);
        long endTime = System.nanoTime();
        double spendTime = (endTime-startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)){
            throw new RuntimeException("SelectSort failed");
        }
        System.out.println("花费的时间是: "+ spendTime +" s");
    }
}
