package leetcode;

import leetcode.common.ListNode;

public class _1721_SwappingNodes {

    public static void main(String[] args) {
        _1721_SwappingNodes obj = new _1721_SwappingNodes();
        ListNode head = constructList();
        System.out.println(obj.swapNodes(head,2));;
    }

    /*
        Approach:

        Move first pointer k times forward, we found the first node to swap value with. Now need to find 2nd node.

        We have already skipped k nodes from front, in order to skip k nodes from end, we take 2 new pointers one points to head and
        other points to node1. Traverse till pointer pointing to node1 reaches null at that time node2 (which started from head) has
        reached the correct position i.e. kth node from end

        why does above work while finding node2

        we check for nullability of pointer which started from node1, so that pointer will only traverse (list.length - k) more nodes,
        and node2 pointer will also traverse same number of nodes and by the time node1 pointer reaches end node 2 pointer will have k
        more nodes to traverse i.e. it is at kth node from end and that's what we want.

     */
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

        //swap values
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
        createNode(5, node3);

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}

