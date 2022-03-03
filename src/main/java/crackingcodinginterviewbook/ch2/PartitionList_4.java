package crackingcodinginterviewbook.ch2;

public class PartitionList_4 {

    public static void main(String[] args) {
        PartitionList_4 partition = new PartitionList_4();
        Node head = partition.constructList();
        int x = 3;
        System.out.println("head = " + head);

        Node result = partitionList(head, x);
        System.out.println("result = " + result);
    }

    private static Node partitionList(Node head, int x) {
        Node tail = null;
        Node newHead = null;
        Node node = head;
        Node newHeadEnd = null, tailEnd = null;

        while(node != null) {
            if(node.val < x) {
                if(newHead == null) {
                    newHead = node;
                } else {
                    newHeadEnd.next = node;
                }
                newHeadEnd = node;
            } else {
                if(tail == null) {
                    tail = node;
                } else {
                    tailEnd.next = node;
                }
                tailEnd = node;
            }
            node = node.next;
        }

        //make sure there is no cycle in list
        if(tailEnd != null) {
            tailEnd.next = null;
        }

        //if head is null return tail
        if(newHead == null) {
            return tail;
        }

        //merge head and tail
        newHeadEnd.next = tail;

        return newHead;
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
