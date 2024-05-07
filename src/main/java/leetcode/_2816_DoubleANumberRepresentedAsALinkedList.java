package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2816_DoubleANumberRepresentedAsALinkedList {

    public static void main(String[] args) {
        _2816_DoubleANumberRepresentedAsALinkedList obj = new _2816_DoubleANumberRepresentedAsALinkedList();

        ListNode head = ListNode.constructList(9,9,9);
        System.out.println(obj.doubleIt(head));
    }

    public ListNode doubleIt(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        int carry;
        int top = stack.pop() * 2;

        ListNode result = new ListNode(top % 10);
        carry = top /10;

        while (!stack.isEmpty()) {
            top = stack.pop() *2 + carry;
            result = new ListNode(top % 10, result);
            carry = top / 10;
        }
        if (carry > 0) {
            return new ListNode(carry, result);
        }
        return result;
    }
}
