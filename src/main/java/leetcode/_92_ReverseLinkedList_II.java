package leetcode;

import leetcode.common.ListNode;

public class _92_ReverseLinkedList_II {

    public static void main(String[] args) {
        _92_ReverseLinkedList_II obj = new _92_ReverseLinkedList_II();

        ListNode head = ListNode.constructList(1, 2, 3, 4, 5);
        int left = 2;
        int right = 4;

        System.out.println(obj.reverseBetween(head, left, right));
    }

    /*
        Approach:

        why use dummy node
        Because, if we are given "left = 1" then where our prev pointer will be assigned then,
        to handle that case we're going to use one dummy node. So, if left = 1 then our prev will be at dummy node
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0); // created dummy node
        dummy.next = head;
        ListNode prev = dummy; // initialising prev pointer on dummy node

        for (int i = 0; i < left - 1; i++){
            prev = prev.next; // adjusting the prev pointer on it's actual index
        }

        ListNode curr = prev.next; // curr pointer will be just after prev
        // reversing
        for (int i = 0; i < right - left; i++) {
            ListNode forw = curr.next; // forw pointer will be after curr
            curr.next = forw.next;
            forw.next = prev.next;
            prev.next = forw;
        }
        return dummy.next;
    }
}
