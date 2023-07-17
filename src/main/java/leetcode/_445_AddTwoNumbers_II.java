package leetcode;

import leetcode.common.ListNode;

import java.util.*;

public class _445_AddTwoNumbers_II {

    public static void main(String[] args) {
        _445_AddTwoNumbers_II obj = new _445_AddTwoNumbers_II();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9, new ListNode(9));
        System.out.println(obj.addTwoNumbers(l1, l2));
    }

    /*
        Approach: Stack
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        Deque<Integer> s3 = new ArrayDeque<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = carry + s1.pop() + s2.pop();
            s3.push(sum % 10);
            carry = sum /10;
        }

        Deque<Integer> left = null;
        if (!s1.isEmpty()) {
            left = s1;
        } else if (!s2.isEmpty()) {
            left = s2;
        }

        while (left != null && !left.isEmpty()) {
            int sum = carry + left.pop();
            s3.push(sum %10);
            carry = sum/10;
        }

        if (carry != 0) {
            s3.push(carry);
        }

        ListNode prev = null;
        ListNode answer = null;

        while (!s3.isEmpty()) {
            ListNode node = new ListNode(s3.pop());
            if (prev == null) {
                answer = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }
        return answer;
    }
}
