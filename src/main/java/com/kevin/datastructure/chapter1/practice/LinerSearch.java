package com.kevin.datastructure.chapter1.practice;

/**
 *  线性查
 * @author kevin
 * @version 1.0
 * @date 2020-10-20 0:32
 */
public class LinerSearch {

    public static <E> int search(E[] arr,E target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Student[] students = {new Student("Alice"),
                            new Student("Bobo"),
                            new Student("Charles"),
                            new Student("Bobo")};
        Student bobo = new Student("Bobo");
        System.out.println(search(students,bobo));
    }
}
