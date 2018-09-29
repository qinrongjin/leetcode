package cn.tiny77.algorithm;

public class A019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rNode = head;
        for (int i = 0; i < n; i ++) {
            rNode = rNode.next;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode lNode = newHead;
        while (rNode != null) {
            rNode = rNode.next;
            lNode = lNode.next;
        }
        lNode.next = lNode.next.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = createNode(1,2,3,4,5);
        head = new A019().removeNthFromEnd(head, 2);
        display(head);
    }

    private static void display(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val + ",");
            head = head.next;
        }
        System.out.println("A019.display " + stringBuilder);
    }

    private static ListNode createNode(int... num) {
        ListNode head = null;
        ListNode result = null;
        for (int i : num) {
            if(head == null) {
                head = new ListNode(i);
                result = head;
            }else{
                head.next =  new ListNode(i);
                head = head.next;
            }
        }
        return result;
    }

}
