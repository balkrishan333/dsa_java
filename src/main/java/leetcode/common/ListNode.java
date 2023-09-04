package leetcode.common;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val).append(", ");

        ListNode node = this.next;

        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        return sb.toString();
    }

    public static ListNode constructList(int... nums) {
        ListNode head = new ListNode(nums[0]);

        ListNode prev = head;
        for (int i = 1; i < nums.length; i++) {
            prev = createNode(nums[i], prev);
        }
        return head;
    }

    private static ListNode createNode(int val, ListNode predecessor) {
        ListNode node = new ListNode(val);
        predecessor.next = node;

        return node;
    }
}
