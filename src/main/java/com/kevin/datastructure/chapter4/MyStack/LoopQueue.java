package com.kevin.datastructure.chapter4.MyStack;

/**
 * 循环队列
 * @author kevin
 * @version 1.0
 * @date 2020-12-14 17:43
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;
    private int size;

    //构造函数
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    //获取数组元素的容量
    public int getCapacity(){
        return data.length - 1;
    }

    //获取数组的大小
    @Override
    public int getSize(){
        return size;
    }

    //判断数组是不是空
    @Override
    public boolean isEmpty(){
        return tail == front;
    }

    //新增一个,元素
    @Override
    public void enqueue(E e){
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //获得元素头
    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    //出队
    @Override
    public E dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size -- ;
        //缩容
        if (size == getCapacity() / 4){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    //扩容
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    //重写toString方法
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d,capacity= %d\n",size,getCapacity()));
        sb.append("front[");
        for (int i = front;i != tail; i = (i + 1) % data.length){
            sb.append(data[i]);
            if ((i + 1) % data.length != tail){
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue();
        for (int i = 0; i < 10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
            if (i % 3 == 2){
                queue.dequeue();
            }
        }
    }
}
