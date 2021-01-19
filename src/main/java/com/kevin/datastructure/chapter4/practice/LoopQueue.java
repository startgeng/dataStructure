package com.kevin.datastructure.chapter4.practice;

import com.kevin.datastructure.chapter4.MyStack.Queue;

/**
 *  按照自己的想法实现一个队列
 * @author kevin
 * @version 1.0
 * @date 2020-12-17 16:59
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int front,tail;

    private LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    private LoopQueue(){
        this(10);
    }

    //获取队列里面的元素大小
    @Override
    public int getSize() {
        return size;
    }

    //判断循环队列是不是为空
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    //获取循环队列的长度
    public int getCapacity(){
        return data.length;
    }

    //入队
    @Override
    public void enqueue(E e) {
        //循环队列触发扩容
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //扩容
    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity + 1];
        for (int i = 0 ; i < size ; i++){
            newData = (E[]) data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is Empty");
        }
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列已满");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //缩容
        if (size == getCapacity() / 4){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue : size = %d,capacity = %d\n",size,getCapacity()));
        builder.append("front [ ");
        for (int i = 0 ; i != tail ; i = (i + 1) % data.length){
            builder.append(data[i]);
            if ((i + 1) % data.length != tail){
                builder.append(",");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i <10 ; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        for (int i = 0; i <10 ; i++) {
            if (i % 3 == 0){
                loopQueue.dequeue();
            }
        }
        System.out.println(loopQueue);
    }
}
