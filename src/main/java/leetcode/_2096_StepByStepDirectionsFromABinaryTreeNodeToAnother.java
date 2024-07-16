package leetcode;

import leetcode.common.BinaryTreeNode;
import org.apache.commons.math3.util.Pair;

import java.util.*;

public class _2096_StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public static void main(String[] args) {
        _2096_StepByStepDirectionsFromABinaryTreeNodeToAnother obj = new _2096_StepByStepDirectionsFromABinaryTreeNodeToAnother();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{5, 1, 2, 3, null, 6, 4});
        int startValue = 3;
        int destValue = 6;
        System.out.println(obj.getDirections(root, startValue, destValue));
    }

    public String getDirections(BinaryTreeNode root, int startValue, int destValue) {
        Map<Integer, BinaryTreeNode> parentMap = new HashMap<>();
        prepareParentMap(root, parentMap);

        BinaryTreeNode startNode = findStartNode(root, startValue);

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(startNode);

        Set<BinaryTreeNode> visitedNodes = new HashSet<>();
        visitedNodes.add(startNode);

        Map<BinaryTreeNode, Pair<BinaryTreeNode, String>> pathTracker = new HashMap<>();

        while (!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.poll();

            if (currNode.val == destValue) {
                return constructPath(currNode, pathTracker);
            }

            if (parentMap.containsKey(currNode.val)) {
                BinaryTreeNode parent = parentMap.get(currNode.val);
                if (!visitedNodes.contains(parent)) {
                    visitedNodes.add(parent);
                    queue.add(parent);
                    pathTracker.put(parent, new Pair<>(currNode, "U"));
                }
            }

            if (currNode.left != null && !visitedNodes.contains(currNode.left)) {
                visitedNodes.add(currNode.left);
                queue.add(currNode.left);
                pathTracker.put(currNode.left, new Pair<>(currNode, "L"));
            }

            if (currNode.right != null && !visitedNodes.contains(currNode.right)) {
                visitedNodes.add(currNode.right);
                queue.add(currNode.right);
                pathTracker.put(currNode.right, new Pair<>(currNode, "R"));
            }
        }
        return null;
    }

    private String constructPath(BinaryTreeNode currNode, Map<BinaryTreeNode, Pair<BinaryTreeNode, String>> pathTracker) {
        StringBuilder sb = new StringBuilder();

        while (pathTracker.containsKey(currNode)) {
            sb.append(pathTracker.get(currNode).getValue());
            currNode = pathTracker.get(currNode).getKey();
        }
        return sb.reverse().toString();
    }

    private BinaryTreeNode findStartNode(BinaryTreeNode node, int startValue) {

        if (node == null) {
            return null;
        }

        if (node.val == startValue) {
            return node;
        }

        BinaryTreeNode startNode = findStartNode(node.left, startValue);

        if (startNode != null) {
            return startNode;
        }
        return findStartNode(node.right, startValue);
    }

    private void prepareParentMap(BinaryTreeNode node, Map<Integer, BinaryTreeNode> parentMap) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            parentMap.put(node.left.val, node);
            prepareParentMap(node.left, parentMap);
        }

        if (node.right != null) {
            parentMap.put(node.right.val, node);
            prepareParentMap(node.right, parentMap);
        }
    }
}
