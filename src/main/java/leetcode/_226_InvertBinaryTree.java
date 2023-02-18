package leetcode;

import leetcode.common.BinaryTreeNode;

public class _226_InvertBinaryTree {

    public static void main(String[] args) {
        _226_InvertBinaryTree obj = new _226_InvertBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{4,2,7,1,3,6,9});
        System.out.println(obj.invertTree(root));
    }

    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        if(root == null) {
            return null;
        }
        invertTree(root, root.left, root.right);
        return root;
    }

    private void invertTree(BinaryTreeNode parent, BinaryTreeNode left, BinaryTreeNode right) {
        if(left == null && right == null) {
            return;
        }

        if(left != null) {
            invertTree(left, left.left, left.right);
        }

        if(right != null) {
            invertTree(right, right.left, right.right);
        }

        BinaryTreeNode temp = left;
        parent.left = right;
        parent.right = temp;
    }
}
