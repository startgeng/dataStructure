package com.kevin.datastructure.chapter5;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-01-13 10:38
 */
public class TestSolution {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null){
            return head;
        }

        if (head.val == val){
            ListNode delNode = head;
            delNode.next = head.next;
            delNode.next = null;
        }

        ListNode prev = head;
        while (head != null){
            if (head.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }
}
