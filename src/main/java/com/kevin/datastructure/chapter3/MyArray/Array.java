package com.kevin.datastructure.chapter3.MyArray;

import javax.swing.plaf.PanelUI;

/**
 * 封装一个动态数组
 * @author kevin
 * @version 1.0
 * @date 2020-12-11 11:41
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    //获得数组的容量
    public int getSize(){
        return size;
    }

    //获得的是数组的长度
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //查看最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //查看第一个元素
    public E getFirst(){
        return get(0);
    }

    //向数组最后添加一个元素,可以复用add方法
//    public void addLast(int e){
//        if (size == data.length) {
//            throw new  IllegalArgumentException("addLast failed,aray is full")
//        };
//        data[size] = e;
//        size++;
//    }

    //复用addd方法,给元素最后一个位置添加元素
    public void addLast(E e){
        add(e,size);
    }

    //给第一个数组第一个元素添加数据
    public void addFirst(E e){
        if (size == data.length){
            throw new IllegalArgumentException("add Last failed,Array is full");
        }
        add(e,0);
    }

    //查找该元素所在的索引位置
    public int find(E e){
        for (int i = 0; i < size ; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //查找元素是否包含在数组里面
    public boolean contain(E e){
        for (int i = 0 ; i < size ; i++){
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    //移除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    //给指定位置添加元素
    public void add(E e,int index){
        if (size == data.length){
            resize(2 * data.length);
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add Failed,Require index >=0 and index <= size");
        }

        for (int i = size-1 ; i >= index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //扩容
    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i <size ; i++) {
            newData[i] = data[i];
        }
        data =newData;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d ,capacity = %d\n",size,data.length));
        sb.append("[");
        for (int i = 0; i < size ; i++){
            sb.append(data[i]);
            if (i != size-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //获取元素
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("add Failed, Array is Full");
        }
        return data[index];
    }

    //删除元素
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("remove Failed,index is Illegal");
        }
        E ret = data[index];
        for (int i = index + 1 ; i < size ; i ++){
            data[i - 1] = data[i];
        }
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        size -- ;
        data[size] = null;
        return ret;
    }

    //删除指定位置的元素
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    //修改元素
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("add Failed, Array is Full");
        }
        data[index] = e;
    }

//    public static void main(String[] args) {
//        Array arr = new Array(20);
//        for (int i = 0; i < 10 ; i++) {
//            arr.addLast(i);
//        }
//        arr.addFirst(100);
//        System.out.println(arr.toString());
//        System.out.println(arr.get(0));
//        System.out.println(arr.removeFirst());
//        System.out.println(arr);
//        System.out.println(arr.remove(0));
//        System.out.println(arr);
//        System.out.println(arr.remove(1));
//        System.out.println(arr.toString());
//    }

    public static void main(String[] args) {
        Array arr = new Array<>(10);
//        arr.addLast(new Student("Alice"));
//        arr.addLast(new Student("Bob"));
//        arr.addLast(new Student("lihai"));
        for (int i = 0; i < 10 ; i++) {
            arr.addLast(new Integer(i));
        }
        System.out.println(arr.toString());
        arr.remove(1);
        arr.remove(2);
        arr.remove(3);
        arr.remove(4);
        arr.remove(5);
        arr.remove(1);
        System.out.println(arr.toString());
    }

}
