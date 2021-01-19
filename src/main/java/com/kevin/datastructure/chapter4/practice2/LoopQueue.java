package com.kevin.datastructure.chapter4.practice2;

import com.kevin.datastructure.chapter4.MyStack.Queue;

/**
 *  实现一个不浪费一个空间的队列
 * @author kevin
 * @version 1.0
 * @date 2020-12-18 9:48
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int front,tail;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
        tail = 0;
        front = 0;
    }

    public LoopQueue(){
        this(10);
    }

    //获取队列个数
    @Override
    public int getSize() {
        return size;
    }

    //获取队列长度
    public int getCapacity(){
        return data.length;
    }

    //是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //入队
    @Override
    public void enqueue(E e) {
        //入队扩容
        if (size == getCapacity()){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //扩容
    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0 ;i < size ; i++){
            newData[i] = (data[(i + front) % data.length]);
        }
        data = newData;
        front = 0;
        tail = size;
    }

    //获取头元素
    @Override
    public E getFront() {
        return data[front];
    }

    //出队
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空，不能出队");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            //缩容
            resize(getCapacity() / 2);
        }
        return ret;
    }

    //重写toString方法
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue : size = %d,capacity = %d\n",size,getCapacity()));
        builder.append("front [");
        for (int i = 0 ; i < size ; i++){
            builder.append(data[(i + front + 1) % data.length]);
            if ((i + front + 1) % data.length != tail){
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
