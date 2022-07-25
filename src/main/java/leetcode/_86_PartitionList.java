package leetcode;

import leetcode.common.ListNode;

public class _86_PartitionList {

    public static void main(String[] args) {
        ListNode head = constructList();
        int x =3;

        _86_PartitionList obj = new _86_PartitionList();
        System.out.println(obj.partition(head, x));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode partitionHead = null;
        ListNode partitionTail = null;
        ListNode headEnd = null;
        ListNode tailEnd = null;

        ListNode node = head;

        while (node != null) {
            if (node.val <x ) {
                if (partitionHead == null) {
                    partitionHead = node;
                } else {
                    headEnd.next = node;
                }
                headEnd = node;
            } else {
                if (partitionTail == null) {
                    partitionTail = node;
                } else {
                    tailEnd.next = node;
                }
                tailEnd = node;
            }
            node = node.next;
        }

        if (tailEnd != null) {
            tailEnd.next = null;
        }

        if (partitionHead == null) {
            return partitionTail;
        }

        headEnd.next = partitionTail;

        return partitionHead;
    }

    private static ListNode constructList() {
        ListNode head = new ListNode(1);
        ListNode node1 = createNode(4, head);
        ListNode node2 = createNode(3, node1);
        ListNode node3 = createNode(2, node2);
        ListNode node4 = createNode(5, node3);
        ListNode node5 = createNode(2, node4);

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}
