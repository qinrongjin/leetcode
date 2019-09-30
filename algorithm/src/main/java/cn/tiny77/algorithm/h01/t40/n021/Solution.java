package cn.tiny77.algorithm.h01.t40.n021;

class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode p = null;
        while (l1 != null || l2 != null) {
            ListNode min;
            if(l1 == null) {
                min = l2;
                l2 = l2.next;
            }else if(l2 == null) {
                min = l1;
                l1 = l1.next;
            }else if(l1.val > l2.val) {
                min = l2;
                l2 = l2.next;
            }else{
                min = l1;
                l1 = l1.next;
            }
            if(head == null) {
                head = min;
                p = min;
            } else {
                p.next = min;
                p = p.next;
            }
        }
        return head;
    }
}