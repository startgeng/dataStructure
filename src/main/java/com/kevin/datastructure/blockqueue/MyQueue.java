package com.kevin.datastructure.blockqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**链表
 * @author kevin
 * @version 1.0
 * @date 2021-03-03 10:51
 */
@Slf4j
public class MyQueue<T> {

    private List<T> data;
    private Integer pStart;

    public MyQueue(){
        data = new ArrayList<>();
        pStart = 0;
    }

    public boolean isEmpty(){
        return pStart >= data.size();
    }

    public boolean enqueue(T x){
        data.add(x);
        return true;
    }

    public boolean dequeue(){
        if (isEmpty()){
            return false;
        }
        pStart++;
        return true;
    }

    public T getFront(){
        return data.get(pStart);
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(3);
        queue.enqueue(5);
        log.info("front: "+ queue.getFront());
        log.info("出队:"+queue.dequeue());
        log.info("front:"+queue.getFront());
    }
}
