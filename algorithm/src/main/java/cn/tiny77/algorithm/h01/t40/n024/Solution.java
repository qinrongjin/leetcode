package cn.tiny77.algorithm.h01.t40.n024;

class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode left = h;
        ListNode right = head;
        while (right != null && right.next != null) {
            ListNode temp = right.next.next;
            left.next = right.next;
            left.next.next = right;
            right.next = temp;
            left = right;
            right = right.next;
        }
        return h.next;
    }
}