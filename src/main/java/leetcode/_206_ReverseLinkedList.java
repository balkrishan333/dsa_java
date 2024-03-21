package leetcode;

import leetcode.common.ListNode;

public class _206_ReverseLinkedList {

    public static void main(String[] args) {
        _206_ReverseLinkedList obj = new _206_ReverseLinkedList();

        ListNode head = ListNode.constructList(1,2,3,4,5);
        System.out.println(obj.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode node = new ListNode(head.val);
            if (newHead == null) {
                newHead = node;
            } else {
                node.next = newHead;
                newHead = node;
            }
            head = head.next;
        }
        return newHead;
    }
}
