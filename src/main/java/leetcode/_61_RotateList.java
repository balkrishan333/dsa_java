package leetcode;

import leetcode.common.ListNode;

public class _61_RotateList {

    public static void main(String[] args) {
        _61_RotateList obj = new _61_RotateList();

        ListNode head = ListNode.constructList(1,2,3,4,5);
        int k = 2;
        System.out.println(obj.rotateRight(head, k));
    }

    private ListNode prev = null;

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        //find length of list
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        k = k % length;
        //if no rotations required return original list
        if (k == 0) {
            return head;
        }

        node = head;
        ListNode prevHead = head;
        for (int i = 0; i < length - k; i++) {
            prev = node;
            node = node.next;
        }
        head = node;
        prev.next = null;

        node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = prevHead;

        return head;
    }
}
