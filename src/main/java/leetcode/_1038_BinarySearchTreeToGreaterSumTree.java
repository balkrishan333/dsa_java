package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1038_BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {
        _1038_BinarySearchTreeToGreaterSumTree obj = new _1038_BinarySearchTreeToGreaterSumTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        System.out.println(obj.bstToGst(root));
    }

    public BinaryTreeNode bstToGst(BinaryTreeNode root) {
        int[] sum = new int[1];
        traverse(root, sum);
        return root;
    }

    private void traverse(BinaryTreeNode node, int[] sum) {
        if (node == null) {
            return;
        }

        traverse(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        traverse(node.left, sum);
    }
}
