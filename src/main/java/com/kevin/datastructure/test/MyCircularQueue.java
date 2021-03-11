package com.kevin.datastructure.test;

/**
 * 循环队列实现方式二
 * @author kevin
 * @version 1.0
 * @date 2021-03-04 10:17
 */
public class MyCircularQueue {

    private int[] array;
    private int front;
    private int rear;

    public MyCircularQueue(int capacity){
        array = new int[capacity];
    }

    public void enQueue(int data){
        if ((rear + 1) % array.length == front){
            throw new IndexOutOfBoundsException("队列已满");
        }
        array[rear] = data;
        rear = (rear + 1) % array.length;
    }

    public int deQueue(){
        if (front == rear){
            throw new NullPointerException("队列为空");
        }
        int removeElement = array[front];
        front = (front + 1) % array.length;
        return removeElement;
    }
}
