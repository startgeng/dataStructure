package com.kevin.datastructure.chapter5;

/**
 * 链表
 * @author kevin
 * @version 1.0
 * @date 2021-01-07 14:21
 */
public class LinkedList<E> {

    private class Node{
        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    //获取元素个数
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
        Node prev = dummyHead;
        for (int i = 0 ; i < index ; i++){
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("get failed,illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0 ; i < index ; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size);
    }

    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("get Failed,illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0 ; i < index ; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur != null){
            buffer.append(cur + "->");
            cur = cur.next;
        }
        buffer.append("NULL");
        return buffer.toString();
    }
}
