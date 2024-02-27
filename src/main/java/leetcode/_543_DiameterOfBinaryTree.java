package leetcode;

import leetcode.common.BinaryTreeNode;

public class _543_DiameterOfBinaryTree {

    public static void main(String[] args) {
        _543_DiameterOfBinaryTree obj = new _543_DiameterOfBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,4,5});
        System.out.println(obj.diameterOfBinaryTree(root));
    }

    /*
        Find the max depth of each subTree. Max path size is number of edges travelling from left subTree to right subTree.

        So, to calculate path, we add the depth of left and right subtree
     */
    private int max = 0;
    public int diameterOfBinaryTree(BinaryTreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        //Add left and right subtree depth to find max length of path
        max = Math.max(max, leftDepth + rightDepth);

        //return depth of current node which is max of left and right. Add 1 to account for node itself.
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
