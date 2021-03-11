package com.kevin.datastructure.blockqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈的实现
 * @author kevin
 * @version 1.0
 * @date 2021-03-03 14:42
 */
public class MyStack {

    private List<Integer> data;

    public MyStack(){
        data = new ArrayList<>();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void push(int value){
        data.add(value);
    }

    public int top(){
        return data.get(data.size()-1);
    }

    public boolean pop(){
        if (isEmpty()){
            return false;
        }
        data.remove(data.size()-1);
        return true;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
