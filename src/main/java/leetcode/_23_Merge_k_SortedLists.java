package leetcode;

import leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23_Merge_k_SortedLists {

    public static void main(String[] args) {
        _23_Merge_k_SortedLists obj = new _23_Merge_k_SortedLists();

        ListNode[] lists = new ListNode[3];
        lists[0] = constructList_1();
        lists[1] = constructList_2();
        lists[2] = constructList_3();

        System.out.println(obj.mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        if (pq.isEmpty()) {
            return null;
        }

        ListNode answer;
        ListNode curr = pq.poll();
        answer = new ListNode(curr.val);
        if (curr.next != null) {
            pq.add(curr.next);
        }

        ListNode prev = answer;
        while (!pq.isEmpty()) {
            curr = pq.poll();
            ListNode n1 = new ListNode(curr.val);
            prev.next = n1;
            prev = n1;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return answer;
    }

    private static ListNode constructList_1() {
        ListNode head = new ListNode(-4);
        ListNode node1 = createNode(0, head);
        ListNode node2 = createNode(2, node1);
        createNode(3, node2);

        return head;
    }

    private static ListNode constructList_2() {
        ListNode head = new ListNode(-4);
        ListNode node1 = createNode(0, head);
        ListNode node2 = createNode(2, node1);
        createNode(3, node2);

        return head;
    }

    private static ListNode constructList_3() {
        ListNode head = new ListNode(-4);
        ListNode node1 = createNode(0, head);
        ListNode node2 = createNode(2, node1);
        createNode(3, node2);

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}
