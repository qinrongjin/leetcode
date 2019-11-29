package cn.tiny77.algorithm.from0000to0100.n023;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = mergeKLists(lists, 0, lists.length);
        return result;
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        ListNode l1, l2;
        if (start == end - 2) {
            l1 = lists[start];
            l2 = lists[end - 1];
        } else if (start == end - 1) {
            return lists[start];
        } else if (start >= end) {
            return null;
        } else {
            int mid = (start + end) / 2;
            l1 = mergeKLists(lists, start, mid);
            l2 = mergeKLists(lists, mid, end);
        }
        ListNode head = null;
        ListNode temp = null;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    if (head == null) {
                        head = l1;
                        temp = head;
                    } else {
                        temp.next = l1;
                        temp = l1;
                    }
                    l1 = l1.next;
                } else {
                    if (head == null) {
                        head = l2;
                        temp = head;
                    } else {
                        temp.next = l2;
                        temp = l2;
                    }
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                while (l1 != null) {
                    if (head == null) {
                        head = l1;
                        temp = head;
                    } else {
                        temp.next = l1;
                        temp = l1;
                    }
                    l1 = l1.next;
                }
            } else if (l2 != null) {
                while (l2 != null) {
                    if (head == null) {
                        head = l2;
                        temp = head;
                    } else {
                        temp.next = l2;
                        temp = l2;
                    }
                    l2 = l2.next;
                }
            }
        }
        return head;
    }

}