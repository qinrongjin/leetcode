package cn.tiny77.algorithm.from0000to0100.n002;

class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            int re = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            boolean in = false;
            if (re >= 10) {
                in = true;
                re -= 10;
            }
            ListNode result = new ListNode(re);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (in) {
                if (l1 == null) {
                    l1 = new ListNode(1);
                } else {
                    l1.val += 1;
                }
            }
            ListNode next = addTwoNumbers(l1, l2);
            result.next = next;
            return result;
        }

    }