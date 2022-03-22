package leetcode;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
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
}
