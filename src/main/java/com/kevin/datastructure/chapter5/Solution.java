package com.kevin.datastructure.chapter5;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-01-11 18:02
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //判断head是否为空
        while (head != null && head.val == val){
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }
        //判断head不为空的情况删除元素
//        while (head != null && head.next.val == val){
//            ListNode delNode = head.next;
//            head.next.val
//        }
        if (head == null){
            return head;
        }
        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
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
