package lhq.lhqstudy.arithmetic.ex2;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/17 17:06
 */
public class Solution {
/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        ListNode tmp = prev;
        int tag = 0;
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + tag;
            if(sum >= 10){
                sum = sum % 10;
                tag = 1;
            }else {
                tag = 0;
            }
            tmp.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            tmp = tmp.next;
        }
        if(tag == 1){
            if(l1 != null){
                while (l1 != null){
                    int sum = l1.val + tag;
                    if(sum >= 10){
                        sum = sum % 10;
                        tag = 1;
                    }else {
                        tag = 0;
                    }
                    tmp.next = new ListNode(sum);
                    l1 = l1.next;
                    tmp = tmp.next;
                }
                if(tag == 1){
                    tmp.next = new ListNode(1);
                }
            }else {
                while (l2 != null){
                    int sum = l2.val + tag;
                    if(sum >= 10){
                        sum = sum % 10;
                        tag = 1;
                    }else {
                        tag = 0;
                    }
                    tmp.next = new ListNode(sum);
                    l2 = l2.next;
                    tmp = tmp.next;
                }
                if(tag == 1){
                    tmp.next = new ListNode(1);
                }
            }
        }else {
            tmp.next = l1 == null ? l2 : l1;

        }
        return prev.next;
    }*/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        ListNode tmp = prev;
        int tag = 0;
        while (l1 != null || l2 != null){
            int l1Val = l1 == null? 0 : l1.val;
            int l2Val = l2 == null? 0 : l2.val;
            int sum = l1Val + l2Val + tag;
            if(sum >= 10){
                sum = sum % 10;
                tag = 1;
            }else {
                tag = 0;
            }
            tmp.next = new ListNode(sum);

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            tmp = tmp.next;
        }
        if(tag == 1){
            tmp.next = new ListNode(1);
        }
        return prev.next;
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
