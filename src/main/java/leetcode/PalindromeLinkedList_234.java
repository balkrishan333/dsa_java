package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeLinkedList_234 {

    public static void main(String[] args) {
        ListNode listNode = constructList();
        PalindromeLinkedList_234 obj = new PalindromeLinkedList_234();

        System.out.println("obj.isPalindrome(listNode) = " + obj.isPalindrome(listNode));
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) {
            return true;
        }
        ListNode curr = head;
        int length = 0;
        while(curr != null) {
            length++;
            curr = curr.next;
        }

        boolean evenLength = (length % 2) == 0;
        Deque<Integer> stack = new ArrayDeque<>();
        curr = head; //reset to start of list after length calculation
        for(int i = 0 ; i < length/2; i++) {
            stack.push(curr.val);
            curr = curr.next;
        }
        if(evenLength) {
            //since we have already stepped once step ahead in previous loop, we need to check one element here
            if(stack.pop() != curr.val) {
                return false;
            }
            curr = curr.next;
        } else {
            //if length is odd, skip to next element as we are at middle element
            curr = curr.next;
        }

        while(curr != null){
            if(curr.val != stack.pop()) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    private static ListNode constructList() {
        ListNode head = new ListNode(1);
        ListNode node1 = createNode(2, head);
        ListNode node2 = createNode(3, node1);
        ListNode node3 = createNode(4, node2);
        ListNode node4 = createNode(3, node3);
        ListNode node5 = createNode(2, node4);
        ListNode node6 = createNode(1, node5);

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }

}
