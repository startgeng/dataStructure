package com.kevin.datastructure.algorithm;

import java.util.Stack;

/**
 * 使用栈实现队列
 * @author kevin
 * @version 1.0
 * @date 2021-03-11 10:49
 */
public class subject5 {

    public Stack<Integer> stackA = new Stack<Integer>();
    public Stack<Integer> stackB = new Stack<Integer>();


    //入队
    public void push(Integer element){
        stackA.push(element);
    }

    //如果 b 栈为空 A栈为空 那么 A和B 都为空
    //出队
    public void pop() throws Exception {
        if (stackB.isEmpty()){
            if (stackA.isEmpty()){
                throw new Exception("栈为空，不能出栈");
            }
            tranfer();
        }
        stackB.pop();
    }

    //将A的数据压入B中
    private void tranfer() {
        if (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }
}
