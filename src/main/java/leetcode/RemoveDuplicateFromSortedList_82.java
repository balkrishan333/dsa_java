package leetcode;

public final class RemoveDuplicateFromSortedList_82 {

    public static void main(String[] args) {
        ListNode listNode = constructList();
        System.out.println("listNode = " + listNode);
        ListNode result = deleteDuplicates(listNode);

        System.out.println("result = " + result);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head, prev = null, newHead=null;
        boolean duplicate = false;

        if(node == null || node.next == null) {
            return node;
        }

        while(node != null) {
            if(node.next == null) {
                if(!duplicate) {
                    if(prev == null) {
                        newHead = node;
                    } else {
                        prev.next = node;
                    }
                } else {
                    if(prev != null) {
                        prev.next = null;
                    }
                }
                break;
            }

            if(node.val != node.next.val) {
                if(duplicate) {
                    duplicate = false;
                } else {
                    if(prev == null) {
                        prev = node;
                        newHead = node;
                    } else {
                        prev.next = node;
                        prev = node;
                    }
                }
            } else {
                duplicate = true;
            }
            node = node.next;
        }
        return newHead;
    }

    private static ListNode constructList() {
        ListNode head = new ListNode(1);
        ListNode node1 = createNode(1, head);
        ListNode node2 = createNode(2, node1);
//        ListNode node3 = createNode(3, node2);
//        ListNode node4 = createNode(4, node3);
//        ListNode node5 = createNode(4, node4);
//        ListNode node6 = createNode(5, node5);

        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}
