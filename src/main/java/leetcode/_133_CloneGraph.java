package leetcode;

import java.util.*;

public class _133_CloneGraph {

    private final Map<Integer, Node> processed = new HashMap<>();

    public static void main(String[] args) {
        _133_CloneGraph obj = new _133_CloneGraph();

        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node.neighbors = new ArrayList<>();
        node.neighbors.add(node2);
        node.neighbors.add(node4);

        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node);
        node2.neighbors.add(node3);

        node3.neighbors = new ArrayList<>();
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors = new ArrayList<>();
        node4.neighbors.add(node);
        node4.neighbors.add(node3);

        Node cloned = obj.cloneGraph(node);
        System.out.println(cloned);
    }

    /*
        Approach: Create a map of al ready cloned nodes

        Before cloning a node, check if is present in map or not. If present use that other wise create a new node and clone that and put
         the new node in map.
     */
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        return cloneNode(node);
    }

    public Node cloneNode(Node node) {

        //if node is already cloned, use that
        if(processed.get(node.val) != null) {
            return processed.get(node.val);
        }

        //create anew node
        Node newNode = new Node();
        newNode.val = node.val;
        //put in processed
        processed.put(node.val, newNode);
        if(node.neighbors != null) {
            for(Node n1 : node.neighbors) {
                //clone all neighbors
                newNode.neighbors.add(cloneNode(n1));
            }
        }
        return newNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
