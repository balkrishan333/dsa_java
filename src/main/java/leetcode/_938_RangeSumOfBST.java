package leetcode;

import leetcode.common.BinaryTreeNode;

public class _938_RangeSumOfBST {

    public static void main(String[] args) {
        _938_RangeSumOfBST obj = new _938_RangeSumOfBST();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{10,5,15,3,7,null,18});
        int low = 7, high = 15;
        System.out.println(obj.rangeSumBST(root, low, high));
    }

    private int answer = 0;
    public int rangeSumBST(BinaryTreeNode root, int low, int high) {
        traverse(root, low, high);
        return answer;
    }

    private void traverse(BinaryTreeNode node , int low, int high) {
        if (node == null) {
            return;
        }

        if (node.val >= low && node.val <= high) {
            answer += node.val;
        }

        if (node.val >= low) {
            traverse(node.left, low, high);
        }

        if (node.val <= high) {
            traverse(node.right, low, high);
        }
    }
}
