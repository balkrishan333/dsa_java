package leetcode;

import leetcode.common.ListNode;

public class _141_LinkedListCycle {

    public static void main(String[] args) {
        _141_LinkedListCycle obj = new _141_LinkedListCycle();

        ListNode head = constructList();
        System.out.println(obj.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {

        if(head == null) {
            return false;
        }

        ListNode slow = head, fast = head;

        while(slow != null && fast != null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static ListNode constructList() {
        ListNode head = new ListNode(-4);
        ListNode node1 = createNode(0, head);
        ListNode node2 = createNode(2, node1);
        createNode(3, node2);

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}
