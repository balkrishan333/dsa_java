package leetcode;

import leetcode.common.BinaryTreeNode;

public class _2331_EvaluateBooleanBinaryTree {

    public static void main(String[] args) {
        _2331_EvaluateBooleanBinaryTree obj = new _2331_EvaluateBooleanBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{2,1,3,null,null,0,1});
        System.out.println(obj.evaluateTree(root));
    }

    public boolean evaluateTree(BinaryTreeNode root) {
        return preorderTraverse(root);
    }

    private boolean preorderTraverse(BinaryTreeNode node) {
        if (node.val == 1) {
            return true;
        }

        if (node.val == 0) {
            return false;
        }

        if (node.val == 2) {
            return preorderTraverse(node.left) | preorderTraverse(node.right);
        }
        return preorderTraverse(node.left) & preorderTraverse(node.right);
    }
}
