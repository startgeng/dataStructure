package com.kevin.datastructure.chapter6;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-01-11 18:02
 */
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }



      public ListNode(int[] arr){
            if (arr == null && arr.length == 0){
                  throw new IllegalArgumentException("传入的数组为空");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 0 ; i < arr.length ; i++){
                  cur.next = new ListNode(arr[i]);
                  cur = cur.next;
            }
      }

      @Override
      public String toString(){
            StringBuilder builder = new StringBuilder();
            ListNode cur = this;
            while (cur != null){
                  builder.append(cur.val + "->");
                  cur = cur.next;
            }
            builder.append("NULL");
            return builder.toString();
      }
}
