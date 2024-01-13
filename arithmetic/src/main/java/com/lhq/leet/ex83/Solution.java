package com.lhq.leet.ex83;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/12/13 22:12
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
