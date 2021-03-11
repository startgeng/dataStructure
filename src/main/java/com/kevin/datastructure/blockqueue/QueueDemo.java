package com.kevin.datastructure.blockqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  队列的demo
 * @author kevin
 * @version 1.0
 * @date 2021-03-03 14:21
 */
public class QueueDemo {

    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        System.out.println(((LinkedList) queue).pop());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }



}
