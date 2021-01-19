package com.kevin.datastructure.chapter1.practice;

/**
 * @author kevin
 * @version 1.0
 * @date 2020-10-20 23:06
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object student){
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
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
