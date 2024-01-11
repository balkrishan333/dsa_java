package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1026_MaximumDifferenceBetweenNodeAndAncestor {

    public static void main(String[] args) {
        _1026_MaximumDifferenceBetweenNodeAndAncestor obj = new _1026_MaximumDifferenceBetweenNodeAndAncestor();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{8,3,10,1,6,null,14,null,null,4,7,13});
        System.out.println(obj.maxAncestorDiff(root));
    }

    public int maxAncestorDiff(BinaryTreeNode root) {
        return traverse(root, root.val, root.val);
    }

    private int traverse(BinaryTreeNode node, int min, int max) {
        if (node == null) {
            return max - min;
        }

        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        int leftDiff = traverse(node.left, min, max);
        int rightDiff = traverse(node.right, min, max);

        return Math.max(leftDiff, rightDiff);
    }
}
