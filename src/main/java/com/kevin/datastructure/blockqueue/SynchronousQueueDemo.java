package com.kevin.datastructure.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * @author kevin
 * @version 1.0
 * @date 2021-03-01 15:27
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue queue = new SynchronousQueue();

        new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                queue.put("3");
            }catch (Exception e){
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t"+queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t"+queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t"+queue.take());
            }catch (Exception e){
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
