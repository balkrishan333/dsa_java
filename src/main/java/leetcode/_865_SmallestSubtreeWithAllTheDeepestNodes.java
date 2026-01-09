package leetcode;

import leetcode.common.BinaryTreeNode;

public class _865_SmallestSubtreeWithAllTheDeepestNodes {

    public static void main(String[] args) {
        _865_SmallestSubtreeWithAllTheDeepestNodes obj =
                new _865_SmallestSubtreeWithAllTheDeepestNodes();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        System.out.println(obj.subtreeWithAllDeepest(root).val);
    }

    /*
        Approach:

        If the left and right subtree depths are equal, this node is the LCA of all deepest nodes.
        Otherwise:
            If left depth > right depth → deepest nodes are in the left subtree.
            If right depth > left depth → deepest nodes are in the right subtree.
     */
    public BinaryTreeNode subtreeWithAllDeepest(BinaryTreeNode root) {
        Result result = dfs(root);
        return result.node;
    }

    private Result dfs(BinaryTreeNode node) {
        if (node == null) {
            return new Result(null, 0);
        }

        Result left = dfs(node.left);
        Result right = dfs(node.right);

        if (left.depth > right.depth) {
            return new Result(left.node, left.depth+1);
        } else if (right.depth > left.depth) {
            return new Result(right.node, right.depth+1);
        } else {
            return new Result(node, left.depth+1);
        }
    }

    static class Result {

        private BinaryTreeNode node;
        private int depth;

        Result(BinaryTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
