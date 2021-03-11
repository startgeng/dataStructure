package com.kevin.datastructure.blockqueue;

/**
 * 循环队列
 * @author kevin
 * @version 1.0
 * @date 2021-03-03 11:05
 */
public class MyCircularQueue {

    private int[] data;
    private int size;
    private int tail;
    private int head;

    public MyCircularQueue(int k){
         data = new int[k];
         size = k;
         tail = -1;
         head = -1;
    }

    public boolean isEmpty(){
        return head == -1;
    }

    public boolean isFull(){
        return ((tail + 1) % size) == head;
    }

    public boolean enQueue(int value){
        if (isFull()){
            return false;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
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

    public int Front(){
        if (isEmpty()){
            return -1;
        }
        return data[head];
    }

    public int Rear(){
        if (isEmpty()){
            return -1;
        }
        return data[tail];
    }
}



