package com.kevin.datastructure.blockqueue;

/**
 * 队列
 * @author kevin
 * @version 1.0
 * @date 2021-03-04 9:03
 */
public class MyLinkedList {

    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private Node head;
    private int size;
    private Node last;

    public void insert(int index,int data){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node insertNode = new Node(data);
        if (size == 0){
            //空链表
            head = insertNode;
            last = insertNode;
        }else if (index == 0){
            //插入链表头  第一个元素的插入
            insertNode.next = head;
            head = insertNode;
        }else if (index == size){
            //插入最后一个元素
            last.next = insertNode;
            last = insertNode;
        }else {
            //插入中间
            Node preNode = get(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size++;
    }

    //删除元素
    public Node remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node removeNode = null;
        if (index == 0){
            //删除头结点
            removeNode = head;
            head = head.next;
        }else if (index == size){
            //删除尾结点
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            last = removeNode;
        }else {
            //删除中间节点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    private Node get(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node temp = head;
        for (int i = 0; i < index ; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void output(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
