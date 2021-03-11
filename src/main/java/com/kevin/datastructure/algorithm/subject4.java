package com.kevin.datastructure.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * 一个元素是否是2的名词方
 * @author kevin
 * @version 1.0
 * @date 2021-03-10 15:11
 */
@Slf4j
public class subject4 {

    public static boolean isPowerof1(int num){
        int temp = 1;
        while (temp <= num){
            if (num == temp){
                return true;
            }
            temp = temp << 2;
        }
        return false;
    }

    public static boolean isPowerOf2(int num){
        return (num & num-1) == 0;
    }

    public static void main(String[] args) {
        log.info(String.valueOf(isPowerOf2(4)));
    }
}
