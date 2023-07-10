package leetcode;

import leetcode.common.BinaryTreeNode;

public class _111_MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        _111_MinimumDepthOfBinaryTree obj = new _111_MinimumDepthOfBinaryTree();

        BinaryTreeNode root  = new BinaryTreeNode().createTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println( obj.minDepth(root));
    }

    private int answer = Integer.MAX_VALUE;
    public int minDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        traverse(root, 1);
        return answer;
    }

    private void traverse(BinaryTreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            answer = Math.min(answer, depth);
        }
        traverse(node.left, depth+1);
        traverse(node.right, depth+1);
    }
}
