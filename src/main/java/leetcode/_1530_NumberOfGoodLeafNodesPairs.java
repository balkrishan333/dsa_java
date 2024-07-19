package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.*;

public class _1530_NumberOfGoodLeafNodesPairs {

    public static void main(String[] args) {
        _1530_NumberOfGoodLeafNodesPairs obj = new _1530_NumberOfGoodLeafNodesPairs();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,4,5,6,7});
        int distance = 3;
        System.out.println(obj.countPairs(root, distance));
    }

    public int countPairs(BinaryTreeNode root, int distance) {
        Map<BinaryTreeNode, List<BinaryTreeNode>> graph = new HashMap<>();
        Set<BinaryTreeNode> leafNodes = new HashSet<>();

        traverseTree(root, null, graph, leafNodes);

        int ans = 0;

        for (BinaryTreeNode leaf : leafNodes) {
            Queue<BinaryTreeNode> bfsQueue = new LinkedList<>();
            Set<BinaryTreeNode> seen = new HashSet<>();
            bfsQueue.add(leaf);
            seen.add(leaf);
            // Go through all nodes that are within the given distance of
            // the current leaf node
            for (int i = 0; i <= distance; i++) {
                // Clear all nodes in the queue (distance i away from leaf node)
                // Add the nodes' neighbors (distance i+1 away from leaf node)
                int size = bfsQueue.size();
                for (int j = 0; j < size; j++) {
                    // If current node is a new leaf node, add the found pair to our count
                    BinaryTreeNode currNode = bfsQueue.remove();
                    if (leafNodes.contains(currNode) && currNode != leaf) {
                        ans++;
                    }
                    if (graph.containsKey(currNode)) {
                        for (BinaryTreeNode neighbor : graph.get(currNode)) {
                            if (!seen.contains(neighbor)) {
                                bfsQueue.add(neighbor);
                                seen.add(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return ans / 2;
    }

    private void traverseTree(BinaryTreeNode currNode, BinaryTreeNode prevNode, Map<BinaryTreeNode, List<BinaryTreeNode>> graph,
                                Set<BinaryTreeNode> leafNodes) {
        if (currNode == null) {
            return;
        }
        if (currNode.left == null && currNode.right == null) {
            leafNodes.add(currNode);
        }
        if (prevNode != null) {
            graph.computeIfAbsent(prevNode, k -> new ArrayList<>());
            graph.get(prevNode).add(currNode);
            graph.computeIfAbsent(currNode, k -> new ArrayList<>());
            graph.get(currNode).add(prevNode);
        }
        traverseTree(currNode.left, currNode, graph, leafNodes);
        traverseTree(currNode.right, currNode, graph, leafNodes);
    }
}
