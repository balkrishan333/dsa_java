package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _382_LinkedListRandomNode {

    private final List<Integer> list;

    public _382_LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = constructList();
        _382_LinkedListRandomNode obj = new _382_LinkedListRandomNode(head);
        int count = 4;

        for (int i = 0; i < count; i++) {
            System.out.println(obj.getRandom());
        }
    }

    public int getRandom() {
        if(this.list.size() == 1) {
            return this.list.get(0);
        }

        Random r = new Random();
        int num = r.nextInt(this.list.size());
        return list.get(num);
    }

    private static ListNode constructList() {
        ListNode head = new ListNode(3);
        ListNode node1 = createNode(2, head);
        ListNode node2 = createNode(0, node1);
        createNode(-4, node2);

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}
