package com.kevin.datastructure.util1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * CollectionUtils的工具类
 * @author kevin
 * @version 1.0
 * @date 2021-02-18 11:19
 */
public class conllectionsUtils{

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
//        Collections.sort(list);
        System.out.println(list);
        System.out.println("------------华丽的分割线----------");
        Collections.sort(list, Comparator.comparing(Student::getAge));
    }
}
