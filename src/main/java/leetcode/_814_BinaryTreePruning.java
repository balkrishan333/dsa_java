package leetcode;

import leetcode.common.BinaryTreeNode;

public class _814_BinaryTreePruning {

    public static void main(String[] args) {
        _814_BinaryTreePruning obj = new _814_BinaryTreePruning();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,1,0,1,1,0,1,0});
        obj.pruneTree(root);
    }

    public BinaryTreeNode pruneTree(BinaryTreeNode root) {
        return traverse(root);
    }

    private BinaryTreeNode traverse(BinaryTreeNode node) {
        if(node == null) {
            return null;
        }

        node.left = pruneNode(traverse(node.left));
        node.right = pruneNode(traverse(node.right));

        return pruneNode(node);
    }

    private BinaryTreeNode pruneNode(BinaryTreeNode node) {
        if(node == null || (node.val == 0 && node.left == null && node.right == null)) {
            return null;
        }
        return node;
    }
}
