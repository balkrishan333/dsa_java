package leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode {

    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode next; // Added for problem NextRightPointer

    public BinaryTreeNode parent; //Add for inorder successor LC 510

    public BinaryTreeNode() {}
    public BinaryTreeNode(int x) { val = x; }

    public BinaryTreeNode createTree(Integer[] input) {
        BinaryTreeNode root = null;
        Queue<BinaryTreeNode> nodes = new LinkedList<>();

        //add first element to queue. This is root.
        if (input.length > 0) {
            root = new BinaryTreeNode(input[0]);
            nodes.offer(root);
        }
        for (int i = 1; i < input.length; i++) {
            BinaryTreeNode parent = nodes.poll();

            if (parent != null) {
                if (input[i] != null) {
                    BinaryTreeNode node = new BinaryTreeNode();
                    node.val = input[i];
                    parent.left = node;
                    nodes.offer(node);
                }
                i++;
                if (i < input.length && input[i] != null) {
                    BinaryTreeNode node = new BinaryTreeNode();
                    node.val = input[i];
                    parent.right = node;
                    nodes.offer(node);
                }
            }
        }
        return root;
    }
}
