package com.kevin.datastructure.algorithm;

import java.util.Stack;

/**
 *  最小栈
 * @author kevin
 * @version 1.0
 * @date 2021-03-10 13:45
 */
public class subject2 {

    private Stack<Integer> maxStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    //入栈  如果最小栈为空 或者最小栈的栈顶元素小于等于插入元素
    public void push(int element){
        if (minStack.isEmpty() || minStack.peek() <= element){
            minStack.push(element);
        }
        maxStack.push(element);
    }

    //出栈   如果普通栈的元素等于    最小栈的元素
    public Integer pop(){
        if (maxStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return maxStack.pop();
    }

    //最小栈  直接是最小栈出栈
    public Integer getMin() throws Exception {
        if (minStack.isEmpty()){
            throw new Exception("栈为空,没有最小值");
        }
        return minStack.peek();
    }
}
