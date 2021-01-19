package com.kevin.datastructure.chapter6;
/**
 * @author kevin
 * @version 1.0
 * @date 2021-01-14 16:10
 */
public class Solution3 {

    public ListNode removeElements(ListNode head,int val){
        if (head == null){
            return null;
        }
        ListNode res = removeElements(head.next,val);
        if (head.val == val){
            //这是直接删除头元素的情况
            return res;
        }else {
            //这是head后面的链表删除的元素的情况
            head.next = res;
            return head;
        }
    }
}
