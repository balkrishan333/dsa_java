package leetcode;

import leetcode.common.ListNode;

public class _142_LinkedListCycleII {

    public static void main(String[] args) {
        _142_LinkedListCycleII obj = new _142_LinkedListCycleII();

        ListNode head = constructList();
        System.out.println(obj.detectCycle(head));
    }

    /*
        Approach:


     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                fast = null;
            }

            //Both pointers are equal, loop detected
            //pointers can meet anywhere in loop not necessarily at start of loop,so need to figure out start of loop
            if (slow != null && fast != null && slow == fast) {
                slow = head; //reset one of slow and fast to head and move both 1 step. where they meet is start of loop
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }

    private static ListNode constructList() {
        ListNode head = new ListNode(3);
        ListNode node1 = createNode(2, head);
        ListNode node2 = createNode(0, node1);
        ListNode node3 = createNode(-4, node2);
        head.next = node3;

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}
