package com.kevin.datastructure.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-01-07 11:24
 */
public class TestDemo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(111);
        set.add(2222);
        set.add(3333);
        StringBuilder builder = new StringBuilder();
        builder.append("(");
//        for (Integer i : set) {
//            if (i != null){
//                builder.append("'");
//                builder.append(i);
//                builder.append("'");
//                builder.append(",");
//            }
//        }
//        builder.append(")");
//    }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer setValue = iterator.next();
            if (setValue != null){
                builder.append("'");
                builder.append(setValue);
                builder.append("'");
                builder.append(",");
            }
        }
        String str = builder.substring(0, builder.length() - 1);
        String s = str.concat(")");
        System.out.println(s);
    }
}
