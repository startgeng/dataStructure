package com.kevin.datastructure.chapter1.practice;

/**
 * @author kevin
 * @version 1.0
 * @date 2020-12-02 17:17
 */
public class ArrayGenerator {

    private ArrayGenerator(){}

    /**
     * 构造一个顺序数组
     * @param n
     * @return
     */
    public static Integer[] generateOrderArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static <E> int search(E[] data,E target){
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10000000;
        Integer[] arr = ArrayGenerator.generateOrderArray(n);
        long startTime = System.currentTimeMillis();
        search(arr,n);
        long endTime = System.currentTimeMillis();

        double spendTime = (endTime - startTime) / 1000.0;
        System.out.println(spendTime + "s");
    }

}
