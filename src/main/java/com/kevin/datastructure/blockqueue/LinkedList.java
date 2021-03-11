package com.kevin.datastructure.blockqueue;

/**
 * 链表
 * @author kevin
 * @version 1.0
 * @date 2021-03-03 16:46
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(){
            this(null,null);
        }

        public Node(E e){
            this(e,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    public Node dummyHead;
    public int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        add(e,0);
    }

    public void add(E e,int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size ++;
    }

    public void addLast(E e){
        add(e,size);
    }

    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("get Failed,index is Illegal");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("set Failed,index is Illegal");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size);
    }

    public boolean contain(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("set Failed,index is Illegal");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size);
    }

    //从链表里面移除一个元素
    public void removeElement(E e){
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.equals(e)){
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
