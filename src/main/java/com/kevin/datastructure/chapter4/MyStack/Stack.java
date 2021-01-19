package com.kevin.datastructure.chapter4.MyStack;

/**
 *  stack的接口
 * @author kevin
 * @version 1.0
 * @date 2020-12-14 14:01
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
