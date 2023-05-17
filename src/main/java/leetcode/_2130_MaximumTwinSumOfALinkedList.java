package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _2130_MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
        _2130_MaximumTwinSumOfALinkedList obj = new _2130_MaximumTwinSumOfALinkedList();

        ListNode head = new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))));
        System.out.println(obj.pairSum(head));
    }

    public int pairSum(ListNode head) {

        List<Integer> numbers = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            numbers.add(node.val);
            node = node.next;
        }

        int max = 0, n = numbers.size();

        for (int i = 0; i <= n/2-1; i++) {
            max = Math.max(max, numbers.get(i) + numbers.get(n-i-1));
        }
        return max;
    }
}
