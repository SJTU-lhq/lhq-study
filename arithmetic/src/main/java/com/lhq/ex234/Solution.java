package com.lhq.ex234;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/16 11:44
 */
class Solution {
    /**
     * 判断链表是否是回文链表,输入是头结点
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = reverseList(slow.next);
        ListNode p1 = head;
        ListNode p2 = temp;

        while (p1 != null && p2!= null){
            if(p1.val != p2.val){
                return false;
            }else {
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return true;
    }

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
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
