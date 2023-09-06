package leetcode;

import leetcode.common.ListNode;

import java.util.Arrays;

public class _725_SplitLinkedListInParts {

    public static void main(String[] args) {
        _725_SplitLinkedListInParts obj = new _725_SplitLinkedListInParts();

        ListNode head = ListNode.constructList(1,2,3,4,5,6,7,8,9,10);
        int k = 15;

        System.out.println(Arrays.toString(obj.splitListToParts(head, k)));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode node = head;

        int size = 0;
        while (node != null) {
            size++;
            node = node.next;

        }

        int len = size/k;
        int rem = size%k;

        ListNode[] answer = new ListNode[k];

        for (int i = 1; i <= k; i++) {
            ListNode prev = null;

            int n = 0;
            while (n < len) {
                ListNode curr = new ListNode(head.val);
                if (prev == null) {
                    answer[i-1] = curr;
                } else {
                    prev.next = curr;
                }
                prev = curr;
                head = head.next;
                n++;
            }

            if (rem > 0 && i <= rem) {
                if (prev == null) {
                    answer[i-1] = new ListNode(head.val);
                } else {
                    prev.next = new ListNode(head.val);
                }
                head = head.next;
            }
        }
        return answer;
    }
}
