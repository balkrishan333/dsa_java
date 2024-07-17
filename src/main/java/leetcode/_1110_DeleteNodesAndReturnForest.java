package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.*;

public class _1110_DeleteNodesAndReturnForest {

    public static void main(String[] args) {
        _1110_DeleteNodesAndReturnForest obj = new _1110_DeleteNodesAndReturnForest();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,4,5,6,7});
        int[] to_delete = {3,5};

        System.out.println(obj.delNodes(root, to_delete));
    }

    public List<BinaryTreeNode> delNodes(BinaryTreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        List<BinaryTreeNode> forest = new ArrayList<>();

        Queue<BinaryTreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        while (!nodesQueue.isEmpty()) {
            BinaryTreeNode currentNode = nodesQueue.poll();

            if (currentNode.left != null) {
                nodesQueue.add(currentNode.left);
                // Disconnect the left child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.left.val)) {
                    currentNode.left = null;
                }
            }

            if (currentNode.right != null) {
                nodesQueue.add(currentNode.right);
                // Disconnect the right child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.right.val)) {
                    currentNode.right = null;
                }
            }

            // If the current node needs to be deleted, add its non-null children to the forest
            if (toDeleteSet.contains(currentNode.val)) {
                if (currentNode.left != null) {
                    forest.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    forest.add(currentNode.right);
                }
            }
        }

        // Ensure the root is added to the forest if it is not to be deleted
        if (!toDeleteSet.contains(root.val)) {
            forest.add(root);
        }

        return forest;
    }
}
