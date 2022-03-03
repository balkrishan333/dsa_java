package crackingcodinginterviewbook.ch2;

public class Node {

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
