package leetcode;

import leetcode.common.BinaryTreeNode;

public class _104_MaximumDepthOfBinaryTree {

    private int maxDepth = 0;

    public static void main(String[] args) {
        _104_MaximumDepthOfBinaryTree obj = new _104_MaximumDepthOfBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(obj.maxDepth(root));
    }

    public int maxDepth(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }

        levelAwareTraversal(root, 1);
        return maxDepth;
    }

    private void levelAwareTraversal(BinaryTreeNode node, int level) {

        maxDepth = Math.max(maxDepth, level);

        if(node.left != null) {
            levelAwareTraversal(node.left, level+1);
        }

        if(node.right != null) {
            levelAwareTraversal(node.right, level+1);
        }
    }
}
