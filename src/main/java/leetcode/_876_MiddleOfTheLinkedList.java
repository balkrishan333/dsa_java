package leetcode;

import leetcode.common.ListNode;

public class _876_MiddleOfTheLinkedList {

    public static void main(String[] args) {
        _876_MiddleOfTheLinkedList obj = new _876_MiddleOfTheLinkedList();

        ListNode head = ListNode.constructList(1,2,3,4,5);
        System.out.println(obj.middleNode(head));
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null) { // we need to stay on last element and not go to null, so check for fast.next != null rather than
            // fast != null
            slow = slow.next;
            fast = fast.next;

            if (fast.next != null) {
                fast = fast.next;
            }
        }
        return slow;
    }
}
