package leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next; // Added for problem NextRightPointer

    public TreeNode parent; //Add for inorder successor LC 510

    public TreeNode() {}
    public TreeNode(int x) { val = x; }

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
                i++;
                if (i < input.length && input[i] != null) {
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
