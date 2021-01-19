package com.kevin.datastructure.chapter6;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-01-14 16:55
 */
public class Solution4 {

    public ListNode removeElements(ListNode head,int val){
        if (head == null){
            return head;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }
}
