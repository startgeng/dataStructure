package com.kevin.datastructure.chapter1.practice;

/**
 *  线性查找法
 * @author kevin
 * @version 1.0
 * @date 2020-10-20 0:18
 */
public class LineSearch {

    /**
     * 线性查找法
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E> int search(E[] data,E target){
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
}
