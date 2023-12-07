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

        int carry = 0;
        while(l1 != null || l2 != null || carry == 1) {
            int sum = carry;
            if(l1 != null) {
                sum  += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            int val = sum % 10;

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
        return result;
    }
}
