package cn.tiny77.algorithm.from0000to0100.n025;

import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        ListNode head = fromArray(Arrays.asList(1,2,3,4,5));
        ListNode listNode = new Solution().reverseKGroup(head, 2);
        display(listNode);
    }

    private static void display(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    private static ListNode fromArray(List<Integer> list) {
        ListNode head = null;
        ListNode p = null;
        for (Integer i : list) {
            if (head == null) {
                head = new ListNode(i);
                p = head;
            } else {
                p.next = new ListNode(i);
                p = p.next;
            }
        }
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode left = h;
        ListNode right = h;
        while (left != null) {
            int i = 0;
            while (i < k && right != null) {
                right = right.next;
                i ++;
            }
            if (right == null) {
                break;
            }
            ListNode p = left.next;
            ListNode n = right.next;
            ListNode next = p;
            ListNode temp;
            while (p != right) {
                temp = p.next;
                p.next = n;
                n = p;
                p = temp;
            }
            p.next = n;
            left.next = p;
            left = next;
            right = next;
        }
        return h.next;
    }
}