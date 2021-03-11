package com.kevin.datastructure.util1;

import java.util.Comparator;
import java.util.Objects;

/**
 * Objects 工具类的使用
 * @author kevin
 * @version 1.0
 * @date 2021-02-18 10:49
 */
public class objectutils <E>{
    public static void main(String[] args) {
//        Student s1 = new Student(30);
//        Student s2 = new Student(20);
//        System.out.println(Objects.compare(s1,s2, Comparator.comparing(Student::getAge)));

//        int arr1[] = new int[]{1,2,3};
//        int arr2[] = new int[]{1,2,3};
//        System.out.println(Objects.deepEquals(arr1,arr2));
        String a = null;
        System.out.println(Objects.isNull(null));
        System.out.println("----------------------isNull-------------------");
//        System.out.println(Objects.requireNonNull(a));
        System.out.println(Objects.nonNull("aa"));
        System.out.println("--------------华丽的分割线-----------");
        System.out.println(Objects.requireNonNull(a,"a的值为空"));
    }
}
