package com.kevin.datastructure.chapter6;

import com.kevin.datastructure.chapter5.LinkedList;

/**
 *  递归模式的链表
 * @author kevin
 * @version 1.0
 * @date 2021-01-14 17:36
 */
public class LinkedListR<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedListR(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add Failed,Illegal index.");
        }
        head = add(head,index,e);
    }

    private Node add(Node node, int index, E e) {
        if (index == 0){
            return new Node(e, node);
        }
        node.next = add(node.next,index-1,e);
        return node;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    //以node为节点，找到inde位置的元素
//    public E get(){
//        return get(0);
//    }

//    private E get(int index){
//        if (index < 0 || index > size){
//            throw new IllegalArgumentException("get Failed,illegal index");
//        }
//        return
//    }
}
