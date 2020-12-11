package com.kevin.datastructure.chapter2.practice;

import java.util.Objects;

/**
 * @author kevin
 * @version 1.0
 * @date 2020-12-08 22:33
 */
public class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(){}

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student) {
        if (this == student){
            return true;
        }
        if (student == null){
            return false;
        }
        if (this.getClass() != student.getClass()){
            return false;
        }
        Student another = (Student)student;
        return this.name.equals(another.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public int compareTo(Student another) {
//        if (this.score < another.score){
//            return -1;
//        }
//        else if (this.score > another.score){
//            return 1;
//        }
//        return 0;
        //优化
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name : %s,score , %d)",name,score);
    }
}
