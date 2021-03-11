package com.kevin.datastructure.util1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  阻塞队列  优秀是一种习惯
 * @author kevin
 * @version 1.0
 * @date 2021-02-18 13:59
 */
public class blockqueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new LinkedBlockingQueue(2);
        queue.put(1);
        queue.put(2);
        queue.put(3);
//        System.out.println(queue.offer(2));
        System.out.println(queue.take());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
