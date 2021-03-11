package com.kevin.datastructure.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-03-02 10:12
 */
@Slf4j
public class MyQueue {

    private List<Integer> data;
    private int pStart;

    public MyQueue(){
        data = new ArrayList<>();
        pStart = 0;
    }

    public boolean enqueue(int x){
        data.add(x);
        return true;
    }

    public boolean isEmpty(){
        return pStart >= data.size();
    }

    public Integer getFront(){
        return data.get(pStart);
    }

    public boolean dequeue(){
        if (isEmpty()){
            return false;
        }
        pStart++;
        return true;
    }
}

@Slf4j
class demo{
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(3);
        queue.enqueue(5);
        if (queue.isEmpty()){
            log.info("队列是空");
        }else {
            log.info("队首元素是: "+queue.getFront());
        }
        if (!queue.isEmpty()){
            log.info("出队是否成功: "+queue.dequeue());
        }
        if (!queue.isEmpty()){
            log.info("出队后的队首元素是: "+queue.getFront());
        }
    }
}

