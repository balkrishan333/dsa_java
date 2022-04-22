package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DesignHashMap_706 {

    private static final int INITIAL_CAPACITY = 1000000;
    private List<Node>[] map;
    private int capacity;

    public DesignHashMap_706() {
        map = new ArrayList[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }

    public void put(int key, int value) {
        int index = calculateHashCode(key);

        List<Node> nodeList = map[index];

        if (nodeList == null) {
            nodeList = new ArrayList<>();
            Node node = new Node(key, value);
            nodeList.add(node);

            map[index] = nodeList;
        } else {
            boolean set = false;

            for (Node n1 : nodeList) {
                if (n1.key == key) {
                    n1.value = value;
                    set = true;
                    break;
                }
            }

            if (!set) {
                Node n1 = new Node(key, value);
                nodeList.add(n1);
            }
        }
    }

    public int get(int key) {
        int index = calculateHashCode(key);

        List<Node> nodeList = map[index];

        if (nodeList == null) {
            return -1;
        }

        for(Node n1 : nodeList) {
            if (n1.key == key) {
                return n1.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = calculateHashCode(key);
        List<Node> nodeList = map[index];

        if (nodeList == null) {
            return;
        }

        Iterator<Node> iterator = nodeList.iterator();

        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                break;
            }
        }
    }

    private int calculateHashCode(int key) {
        int hash = Integer.hashCode(key);
        hash = hash % capacity;
        return hash;
    }

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
