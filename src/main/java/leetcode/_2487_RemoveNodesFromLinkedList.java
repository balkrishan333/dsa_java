package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2487_RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        _2487_RemoveNodesFromLinkedList obj = new _2487_RemoveNodesFromLinkedList();

        ListNode head = ListNode.constructList(5,2,13,3,8);
        System.out.println(obj.removeNodes(head));
    }

    public ListNode removeNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node =  node.next;
        }

        int max = stack.pop();
        ListNode result = null;

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (top >= max) {
                ListNode curr = new ListNode(max);
                max = top;
                curr.next = result;
                result = curr;
            }
        }
        return new ListNode(max, result);
    }
}
