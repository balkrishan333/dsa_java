package leetcode;

import leetcode.common.BinaryTreeNode;

public class _404_SumOfLeftLeaves {

    public static void main(String[] args) {
        _404_SumOfLeftLeaves obj = new _404_SumOfLeftLeaves();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(obj.sumOfLeftLeaves(root));
    }

    private int sum = 0;
    public int sumOfLeftLeaves(BinaryTreeNode root) {
        traverse(root, false);
        return sum;
    }

    private void traverse(BinaryTreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }

        if (isLeft && isLeaf(node)) {
            sum += node.val;
        }
        traverse(node.left, true);
        traverse(node.right, false);
    }

    private boolean isLeaf(BinaryTreeNode node) {
        return node.left == null && node.right == null;
    }
}
