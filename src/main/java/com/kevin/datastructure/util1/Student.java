package com.kevin.datastructure.util1;

/**
 * Student做实体类
 * @author kevin
 * @version 1.0
 * @date 2021-02-18 10:54
 */
public class Student {

    private int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
