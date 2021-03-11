package com.kevin.datastructure.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class sharedata{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try{
            while (number != 0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try{
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 *  加减锁
 * @author kevin
 * @version 1.0
 * @date 2021-03-01 17:00
 */
public class productconsumer {
    public static void main(String[] args) {
        sharedata sharedata = new sharedata();
        new Thread(()->{
            for (int i = 0; i < 5 ; i++) {
                try {
                    sharedata.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 5 ; i++) {
                try {
                    sharedata.decrement();
                } catch (Exception e) {
                    throw new IllegalArgumentException("失败");
                }
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 0; i < 5 ; i++) {
                try {
                    sharedata.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for (int i = 0; i < 5 ; i++) {
                try {
                    sharedata.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
