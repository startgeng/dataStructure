package com.kevin.datastructure.blockqueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-03-01 14:26
 */
public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.put(1);
        System.out.println(blockingQueue.offer(2,2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(3,2L, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
    }
}
