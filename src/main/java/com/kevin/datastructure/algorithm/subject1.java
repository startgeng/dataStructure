package com.kevin.datastructure.algorithm;

/**
 * 判断链表是否有环
 * @author kevin
 * @version 1.0
 * @date 2021-03-10 13:20
 */
public class subject1 {

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }


    public boolean isCycle(Node head){
        Node p1 = head;
        Node p2 = head;

        while (p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                return true;
            }
        }
        return false;
    }
}
