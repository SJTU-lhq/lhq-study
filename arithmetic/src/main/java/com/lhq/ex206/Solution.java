package com.lhq.ex206;

/**
 * 星光荡开宇宙，本人闪耀其中
 *
 * @author LHQ
 * @data 2023/8/16 1:37
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
       ListNode pre = null;
       ListNode index = head;
       while(index != null){
           ListNode next = index.next;
           index.next = pre;
           pre = index;
           index = next;
       }
       return pre;
    }


  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;}
  }
}
