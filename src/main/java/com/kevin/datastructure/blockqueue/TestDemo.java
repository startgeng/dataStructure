package com.kevin.datastructure.blockqueue;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-03-03 17:35
 */
public class TestDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 10 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(666,2);
        System.out.println(linkedList);
    }
}
