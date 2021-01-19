package com.kevin.datastructure.chapter5;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-01-14 13:37
 */
public class TestSolution2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while (dummyHead.next != null){
            if (dummyHead.next.val == val){
                ListNode delNode = dummyHead.next;
                dummyHead.next = delNode.next;
                delNode.next = null;
            }else {
                dummyHead = dummyHead.next;
            }
        }
        return dummyHead;
    }
}
