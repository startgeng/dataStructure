package com.kevin.datastructure.blockqueue;


import java.util.Stack;

/**
 * 栈的使用Demo
 * @author kevin
 * @version 1.0
 * @date 2021-03-03 14:51
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
