package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1372_LongestZigZagPathInABinaryTree {

    private int answer = 0;
    public static void main(String[] args) {

        _1372_LongestZigZagPathInABinaryTree obj = new _1372_LongestZigZagPathInABinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1});
        System.out.println(obj.longestZigZag(root));
    }

    public int longestZigZag(BinaryTreeNode root) {

        traverse(root.left, "left", 0);
        traverse(root.right, "right", 0);

        return answer;
    }

    private void traverse(BinaryTreeNode node, String direction, int count) {
        if (node == null) {
            answer = Math.max(answer, count);
            return;
        }

        traverse(node.left, "left", direction.equals("left") ? 0 : count + 1);
        traverse(node.right, "right", direction.equals("right") ? 0 : count + 1);
    }
}
