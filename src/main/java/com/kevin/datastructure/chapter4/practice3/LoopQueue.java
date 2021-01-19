package com.kevin.datastructure.chapter4.practice3;

import com.kevin.datastructure.chapter4.MyStack.Queue;

/**
 *  没有size的情况的队列
 * @author kevin
 * @version 1.0
 * @date 2020-12-18 10:41
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return tail >= front ? tail - front : data.length + tail - front;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    //扩容
    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity + 1];
        int size = getSize();
        for (int i = 0 ; i < size ; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空,没有元素能出队了");
        }
        E ret = data[front];
        data[front] = null;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue ,capacity = %d,size = %d\n",getCapacity(),getSize()));
        builder.append("front [");
        for (int i = front ; i != tail ; i = (i + 1) % data.length){
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
        for (int i = 0; i < 10 ; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        for (int i = 0; i < 10 ; i++) {
            if (i % 3 == 0){
                loopQueue.dequeue();
            }
        }
        System.out.println(loopQueue);
    }
}
