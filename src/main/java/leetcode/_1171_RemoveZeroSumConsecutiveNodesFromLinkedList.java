package leetcode;

import leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class _1171_RemoveZeroSumConsecutiveNodesFromLinkedList {

    public static void main(String[] args) {
        _1171_RemoveZeroSumConsecutiveNodesFromLinkedList obj = new _1171_RemoveZeroSumConsecutiveNodesFromLinkedList();

        ListNode head = ListNode.constructList(1,2,3,-3,-2);
        System.out.println(obj.removeZeroSumSublists(head));
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode current = front;
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        int prefixSum = 0;

        while (current != null) {
            prefixSum += current.val;
            prefixSumToNode.put(prefixSum, current);
            current = current.next;
        }

        prefixSum = 0;
        current = front;

        while (current != null) {
            prefixSum += current.val;
            current.next = prefixSumToNode.get(prefixSum).next;
            current = current.next;
        }
        return front.next;
    }
}
