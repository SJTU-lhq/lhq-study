package lhq.lhqstudy.arithmetic.ex21;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/17 16:43
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode prev = new ListNode(0);
        ListNode tmpNode = prev;
        while(list2!= null && list1!= null){
            if(list1.val < list2.val){
                tmpNode.next = list1;
                list1 = list1.next;
            }else {
                tmpNode.next = list2;
                list2 = list2.next;
            }
            tmpNode = tmpNode.next;
        }
        if(list2 == null){
            tmpNode.next = list1;
        }else {
            tmpNode.next = list2;
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
