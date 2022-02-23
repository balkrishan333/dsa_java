package crackingcodinginterviewbook.ch2;

import java.util.LinkedList;
import java.util.List;

public final class RemoveDuplicates_1 {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val).append(", ");

            Node node = this.next;

            while (node != null) {
                sb.append(node.val).append(", ");
                node = node.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates_1 duplicates = new RemoveDuplicates_1();
        Node head = duplicates.constructList();

        System.out.println("head = " + head);

        Node noDups = removeDups(head);
        System.out.println("noDups = " + noDups);
    }

    private static Node removeDups(Node head) {
        List<Integer> elemeents = new LinkedList<>();
        elemeents.add(head.val);

        Node node = head.next;
        Node prev = head;
        while (node != null){
            if (!elemeents.contains(node.val)) {
                elemeents.add(node.val);
                prev.next = node;
                prev = node;
            }
            node = node.next;
        }
        return head;
    }

    private Node constructList() {
        Node head = new Node(3);
        Node node1 = createNode(2, head);
        Node node2 = createNode(5, node1);
        Node node3 = createNode(6, node2);
        Node node4 = createNode(1, node3);
        Node node5 = createNode(3, node4);
        Node node6 = createNode(2, node5);
        Node node7 = createNode(8, node6);

        return head;
    }

    private Node createNode(int val, Node predecessor) {
        Node node = new Node(val);
        predecessor.next = node;

        return node;
    }
}
