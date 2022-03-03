package crackingcodinginterviewbook.ch2;

public final class Return_Kth_To_Last_2 {

    public static void main(String[] args) {
        Return_Kth_To_Last_2 duplicates = new Return_Kth_To_Last_2();
        Node head = duplicates.constructList();

        System.out.println("head = " + head);

        int kth = 7;
        Node ele = returnKthFromLast(head, kth);
        System.out.println(kth + "th node from last = " + ele.val);
    }

    private static Node returnKthFromLast(Node head, int kth) {
        Node leading = head;
        Node trailing = head;
        int i = 0;

        while (leading != null) {
            if(i >= kth) {
                trailing = trailing.next;
            } else {
                i++;
            }
            leading = leading.next;
        }

        return trailing;
    }

    private Node constructList() {
        Node head = new Node(1);
        Node node1 = createNode(2, head);
        Node node2 = createNode(3, node1);
        Node node3 = createNode(4, node2);
        Node node4 = createNode(5, node3);
        Node node5 = createNode(6, node4);
        Node node6 = createNode(7, node5);
        Node node7 = createNode(8, node6);
        Node node8 = createNode(9, node7);
        Node node9 = createNode(10, node8);

        return head;
    }

    private Node createNode(int val, Node predecessor) {
        Node node = new Node(val);
        predecessor.next = node;

        return node;
    }
}
