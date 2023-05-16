package leetcode;

import leetcode.common.ListNode;

public class _24_SwapNodesInPairs {

    public static void main(String[] args) {

        _24_SwapNodesInPairs obj = new _24_SwapNodesInPairs();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(obj.swapPairs(head));
    }

    /*
        Approach: see inline comments
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        return swapPairs(head, head.next);
    }

    private ListNode swapPairs(ListNode node1, ListNode node2) {
        //return if one node is null, nothing to swap
        if(node2 == null) {
            return node1;
        }

        //save reference to next node and assign first node as next of second
        ListNode temp = node2.next;
        node2.next = node1;

        //if list not null, follow the chain
        if(temp != null) {
            node1.next = swapPairs(temp, temp.next);
        } else {
            node1.next = null;
        }
        return node2;
    }
}
