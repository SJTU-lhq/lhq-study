package com.lhq.ex160;

/**
 * 星光荡开宇宙，本人闪耀其中
 *
 * @author LHQ
 * @data 2023/8/16 1:25
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode indexA = headA;
        ListNode indexB = headB;

        while (indexA != indexB){
            indexA = indexA.next;
            indexB = indexB.next;
            if(indexA == null && indexB == null){
                return null;
            }
            if(indexA == null){
                indexA = headB;
            }
            if(indexB == null){
                indexB = headA;
            }

        }

        return indexA;
    }

      public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
