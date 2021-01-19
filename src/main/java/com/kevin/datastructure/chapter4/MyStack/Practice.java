package com.kevin.datastructure.chapter4.MyStack;

/**
 *  测试类
 * @author kevin
 * @version 1.0
 * @date 2020-12-14 14:34
 */
public class Practice {

    //进行验证的测试类
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack(10);
        for (int i = 0; i < 5 ; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
