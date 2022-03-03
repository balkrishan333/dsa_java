package crackingcodinginterviewbook.ch2;

public class DeleteMiddleNode_3 {

    public static void main(String[] args) {
        DeleteMiddleNode_3 deleteMiddle = new DeleteMiddleNode_3();
        Node head = deleteMiddle.constructList();

        System.out.println("head = " + head);

        delete(head.next.next);
        System.out.println("result = " + head);
    }

    private static void delete(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private Node constructList() {
        Node head = new Node(1);
        Node node1 = createNode(4, head);
        Node node2 = createNode(3, node1);
        Node node3 = createNode(2, node2);
        Node node4 = createNode(5, node3);
        Node node5 = createNode(2, node4);

        return head;
    }

    private Node createNode(int val, Node predecessor) {
        Node node = new Node(val);
        predecessor.next = node;

        return node;
    }
}
