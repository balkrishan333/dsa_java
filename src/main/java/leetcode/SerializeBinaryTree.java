package leetcode;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

    private static final Integer[] input = {1,2,3,null,null,4,5};

    public static void main(String[] args) {
        TreeNode root = new TreeNode().createTree(input);
        String data = serialize(root);
        TreeNode tree = deserialize(data);
        System.out.println("tree = " + tree);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                builder.append(node.val);
                builder.append("::");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                builder.append("-");
                builder.append("::");
            }

        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data)  {

        if (data == null) {
            return null;
        }

        String[] arr = data.split("::");

        TreeNode root = null;
        Queue<TreeNode> nodes = new LinkedList<>();

        //add first element to queue. This is root.
        if (arr.length > 0) {
            root = new TreeNode(Integer.parseInt(arr[0]));
            nodes.offer(root);
        }
        for (int i = 1; i < arr.length; i++) {
            TreeNode parent = nodes.poll();

            if (parent != null) {
                if (!arr[i].equals("-")) {
                    TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
                    parent.left = node;
                    nodes.offer(node);
                }

                if (!arr[++i].equals("-")) {
                    TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
                    parent.right = node;
                    nodes.offer(node);
                }
            }
        }
        return root;
    }
}
