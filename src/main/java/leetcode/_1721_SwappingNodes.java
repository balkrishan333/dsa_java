package leetcode;

import leetcode.common.ListNode;

public class _1721_SwappingNodes {

    public static void main(String[] args) {
        _1721_SwappingNodes obj = new _1721_SwappingNodes();
        ListNode head = constructList();
        obj.swapNodes(head,2);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1 = head;
        for(int i=0; i < k-1; i++) {
            node1 = node1.next;
        }
        ListNode node2 = head, ptr = node1;

        while(ptr.next != null) {
            ptr = ptr.next;
            node2 = node2.next;
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

        return head;
    }

    private static ListNode constructList() {
        ListNode head = new ListNode(1);
        ListNode node1 = createNode(2, head);
        ListNode node2 = createNode(3, node1);
        ListNode node3 = createNode(4, node2);
        ListNode node4 = createNode(5, node3);

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}

