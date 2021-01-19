package com.kevin.datastructure.chapter4.MyStack;

import com.kevin.datastructure.chapter3.MyArray.Array;

/**
 *  ArrayStack 的容积
 * @author kevin
 * @version 1.0
 * @date 2020-12-14 14:00
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(10);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    /**
     * 进栈
     * @param e
     */
    @Override
    public void push(E e){
        array.addLast(e);
    }

    /**
     * 出栈
     * @return
     */
    @Override
    public E pop(){
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public E peek(){
        return array.getFirst();
    }

    /**
     * 获取元素的容量
     * @return
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * 获得数组的容量
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    //判断栈是否为空
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    //重写一个自己的打印方法
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Stack:");
        builder.append("[");
        for (int i = 0; i < array.getSize() ; i++) {
            builder.append(array.get(i));
            if (i != array.getSize() - 1){
                builder.append(",");
            }
        }
        builder.append("] top");
        return builder.toString();
    }
}
