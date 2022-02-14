package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode next; // Added for problem NextRightPointer

    TreeNode() {}
    TreeNode(int x) { val = x; }

    public TreeNode createTree(Integer[] input) {
        TreeNode root = null;
        Queue<TreeNode> nodes = new LinkedList<>();

        //add first element to queue. This is root.
        if (input.length > 0) {
            root = new TreeNode(input[0]);
            nodes.offer(root);
        }
        for (int i = 1; i < input.length; i++) {
            TreeNode parent = nodes.poll();

            if (parent != null) {
                if (input[i] != null) {
                    TreeNode node = new TreeNode();
                    node.val = input[i];
                    parent.left = node;
                    nodes.offer(node);
                }

                if (input[++i] != null) {
                    TreeNode node = new TreeNode();
                    node.val = input[i];
                    parent.right = node;
                    nodes.offer(node);
                }
            }
        }
        return root;
    }
}
