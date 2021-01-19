package com.kevin.datastructure.chapter4.practiceleetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kevin
 * @version 1.0
 * @date 2020-12-18 15:52
 */
public class Test225 {
}

class MyStack {


    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> queue1 = new LinkedList<>();
        while (queue.size() > 1){
            ((LinkedList<Integer>) queue1).add(queue.remove());
        }
        Integer ret = queue.remove();
        queue = queue1;
        return ret;
    }

    /** Get the top element. */
    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
