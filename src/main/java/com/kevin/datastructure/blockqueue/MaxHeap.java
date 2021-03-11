package com.kevin.datastructure.blockqueue;

/**
 *  最大堆
 * @author kevin
 * @version 1.0
 * @date 2021-03-04 17:41
 */
public class MaxHeap<E> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }


}
