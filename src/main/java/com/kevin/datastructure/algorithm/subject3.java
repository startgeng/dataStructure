package com.kevin.datastructure.algorithm;

/**
 * 辗转相除法  求两个数的最小公倍数
 * @author kevin
 * @version 1.0
 * @date 2021-03-10 14:13
 */
public class subject3 {

    //辗转相除发 使用一个较小的数 去除以一个公约数
    public int generatestCommonDivisor(int a,int b){
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        if (big % small == 0){
            return small;
        }
        return generatestCommonDivisor(big % small , small);
    }

    //根据九章算数发 一个较大的数a,和 b a > b  减去一个较小的数为c 再讲小的b与c在做递归相减就能求的最大公倍数
    public int generatestCommonDivisor1(int a,int b){
        if (a == b){
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return generatestCommonDivisor1(big - small,small);
    }
}
