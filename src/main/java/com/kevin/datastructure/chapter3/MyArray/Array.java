package com.kevin.datastructure.chapter3.MyArray;

/**
 * 封装一个动态数组
 * @author kevin
 * @version 1.0
 * @date 2020-12-11 11:41
 */
public class Array {

    private int[] data;
    private int size;

    private Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    private Array(){
        this(10);
    }

    //获得数组的容量
    private int getSize(){
        return size;
    }

    //获得的是数组的长度
    private int getLength(){
        return data.length;
    }
}
