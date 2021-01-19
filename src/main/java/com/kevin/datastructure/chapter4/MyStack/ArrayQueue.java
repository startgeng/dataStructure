package com.kevin.datastructure.chapter4.MyStack;

import com.kevin.datastructure.chapter3.MyArray.Array;

/**
 * @author kevin
 * @version 1.0
 * @date 2020-12-14 16:56
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    //获得数组容量
    public int getCapacity(){
        return array.getCapacity();
    }

    //判断是否为空
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    //入队
    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    //出队
    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    //拿到队列头
    @Override
    public E getFront(){
        return array.getFirst();
    }

    //重写toString方法
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Queue : ");
        builder.append("front [");
        for (int i = 0; i < array.getSize() ; i++) {
            builder.append(array.get(i));
            if (i != array.getSize() - 1){
                builder.append(",");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue();
        for (int i = 0; i < 10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
            if (i % 3 == 0){
                queue.dequeue();
            }
        }
    }
}
