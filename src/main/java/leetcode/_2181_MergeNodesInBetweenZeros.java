package leetcode;

import leetcode.common.ListNode;

public class _2181_MergeNodesInBetweenZeros {

    public static void main(String[] args) {
        _2181_MergeNodesInBetweenZeros obj = new _2181_MergeNodesInBetweenZeros();

        ListNode head = ListNode.constructList(0,3,1,0,4,5,2,0);
        System.out.println(obj.mergeNodes(head));
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode prev = null;
        ListNode answer = null;

        int currSum = 0;
        head = head.next;

        while (head != null) {
            if (head.val == 0) {
                ListNode node = new ListNode(currSum);
                if (prev == null) {
                    prev = node;
                    answer = prev;
                } else {
                    prev.next = node;
                    prev = node;
                }
                currSum = 0;
            } else {
                currSum += head.val;
            }
            head = head.next;
        }
        return answer;
    }
}
