package leetcode;

import leetcode.common.BinaryTreeNode;
import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _109_ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode head = constructList();

        _109_ConvertSortedListToBinarySearchTree obj = new _109_ConvertSortedListToBinarySearchTree();

        System.out.println(obj.sortedListToBST(head));
    }

    public BinaryTreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> numbers = new ArrayList<>();
        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }

        BinaryTreeNode root = constructSubTree(numbers, 0, numbers.size()-1);
        return root;
    }

    private BinaryTreeNode constructSubTree(List<Integer> numbers, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right-left)/2;
        BinaryTreeNode node = new BinaryTreeNode();

        node.val = numbers.get(mid);
        node.left = constructSubTree(numbers, left, mid-1);
        node.right = constructSubTree(numbers, mid+1, right);

        return node;
    }

    private static ListNode constructList() {
        ListNode head = new ListNode(-10);
        ListNode node1 = createNode(-3, head);
        ListNode node2 = createNode(0, node1);
        ListNode node3 = createNode(5, node2);
        ListNode node4 = createNode(9, node3);
//        ListNode head = new ListNode(-10);
//        ListNode node1 = createNode(-5, head);
//        ListNode node2 = createNode(-3, node1);
//        ListNode node3 = createNode(0, node2);
//        ListNode node4 = createNode(5, node3);
//        ListNode node5 = createNode(7, node4);
//        createNode(9, node5);

        return head;
    }
    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}
