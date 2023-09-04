package leetcode;

import leetcode.common.ListNode;

public class _2_AddTwoNumbers {

    public static void main(String[] args) {
        _2_AddTwoNumbers obj = new _2_AddTwoNumbers();

        ListNode l1 = ListNode.constructList(2,4,3);
        ListNode l2 = ListNode.constructList(5,6,4);

        System.out.println(obj.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null, prev=null;

        if(l1 == null && l2 == null) {
            return null;
        }

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        int carry = 0;

        while(l1 != null || l2 != null) {
            int val1 = 0, val2=0;

            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int add = val1+val2+carry;
            carry = add / 10;
            int val = add % 10;

            if(result == null) {
                result = new ListNode();
                result.val = val;
                prev = result;
            } else {
                ListNode node = new ListNode();
                node.val = val;
                prev.next = node;
                prev = node;
            }
        }

        if(carry != 0) {
            ListNode node = new ListNode();
            node.val = carry;
            prev.next = node;
        }

        return result;

    }
}
