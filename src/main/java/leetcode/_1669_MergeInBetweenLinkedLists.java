package leetcode;

import leetcode.common.ListNode;

public class _1669_MergeInBetweenLinkedLists {

    public static void main(String[] args) {
        _1669_MergeInBetweenLinkedLists obj = new _1669_MergeInBetweenLinkedLists();

        ListNode list1 = ListNode.constructList(10,1,13,6,9,5);
        ListNode list2 = ListNode.constructList(1000000,1000001,1000002);
        int a = 3, b= 4;

        System.out.println(obj.mergeInBetween(list1, a, b, list2));
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null;
        ListNode end = list1;

        // Set start to node a - 1 and end to node b
        for (int index = 0; index < b; index++) {
            if (index == a - 1) {
                start = end;
            }
            end = end.next;
        }
        // Connect the start node to list2
        start.next = list2;

        // Find the tail of list2
        while (list2.next != null) {
            list2 = list2.next;
        }
        // Set the tail of list2 to end.next
        list2.next = end.next;
        end.next = null;

        return list1;
    }
}
