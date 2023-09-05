package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _138_CopyListWithRandomPointer {

    public static void main(String[] args) {
        _138_CopyListWithRandomPointer obj = new _138_CopyListWithRandomPointer();

        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        head.next = node1;
        node1.next = node2;
        node1.random = head;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node3.random = node2;

        node4.random = head;

        System.out.println(obj.copyRandomList(head));
    }

    public Node copyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        Map<Node, Node> mapping = new HashMap<>();

        Node n1 = head, prev, newHead, newNode;

        newNode = new Node(n1.val);
        newHead = newNode;
        newNode.random = n1.random;

        mapping.put(n1, newNode);
        prev = newNode;
        n1 = n1.next;

        while(n1 != null) {
            newNode = new Node(n1.val);
            prev.next = newNode;
            newNode.random = n1.random;
            mapping.put(n1, newNode);
            prev = newNode;

            n1 = n1.next;
        }

        Node n2 = newHead;
        while(n2 != null) {
            if(n2.random != null) {
                n2.random = mapping.get(n2.random);
            }
            n2 = n2.next;
        }

        return newHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
