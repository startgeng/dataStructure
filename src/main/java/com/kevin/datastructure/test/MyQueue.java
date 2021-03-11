package com.kevin.datastructure.test;

/**
 * 循环队列 实现方式一
 * @author kevin
 * @version 1.0
 * @date 2021-03-04 10:09
 */
public class MyQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyQueue(int k){
        data = new int[k];
        head = -1;
        size = k;
        tail = -1;
    }

    public boolean isEmpty(){
        return head == -1;
    }

    public boolean isFull(){
        return ((tail + 1) % size) == tail;
    }

    public boolean enQueue(int value){
        if (isFull()){
            return false;
        }
        tail = (tail + 1) % size;
        data[size] = value;
        return true;
    }

    public boolean deQueue(){
        if (isEmpty()){
            return false;
        }
        if (head == tail){
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }
}
