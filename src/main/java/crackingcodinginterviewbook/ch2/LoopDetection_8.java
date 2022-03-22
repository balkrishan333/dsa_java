package crackingcodinginterviewbook.ch2;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection_8 {

    public static void main(String[] args) {
        LoopDetection_8 detection = new LoopDetection_8();
        Node head = detection.constructList();
        boolean hasCycle = hasCycle(head);
        System.out.println("hasCycle = " + hasCycle);

        Node cycleStart;
        if (hasCycle) {
            cycleStart = findCycleStart(head);
            System.out.println("cycleStart.val = " + cycleStart.val);
        }

        System.out.println("hasCycle_efficient(head).val = " + hasCycle_efficient(head).val);
    }

    /*
        Note: This method can detect both cycle and find start of loop
        Time - O(n), space - O(n)
        Find start of cycle
        1. Push each node to hash set
        2. if a node is already present in set
            a. cycle is present
            b. for the first such instance, it is start of loop
     */
    private static Node findCycleStart(Node head) {
        Set<Node> nodeHash = new HashSet<>();
        Node result = null;
        while (head != null) {
            boolean exists = nodeHash.add(head);
            if (!exists) {
                result = head;
                break;
            }
            head = head.next;
        }
        return result;
    }

    private static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head, fast = head;
        while (slow != null & fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static Node hasCycle_efficient(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head;
        boolean hasCycle = false;
        while (slow != null & fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        Node result = null;
        if (hasCycle){
            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            result = slow;
        }
        return result;
    }

    private Node constructList() {
        Node head = new Node(1);
        Node node1 = createNode(2, head);
        Node node2 = createNode(3, node1);
        Node node3 = createNode(4, node2);
        Node node4 = createNode(5, node3);
        node4.next = node2; // introduce cycle

        return head;
    }

    private Node createNode(int val, Node predecessor) {
        Node node = new Node(val);
        predecessor.next = node;

        return node;
    }
}
