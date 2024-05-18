package leetcode;

import leetcode.common.BinaryTreeNode;

public class _979_DistributeCoinsInBinaryTree {

    private int moves;
    public static void main(String[] args) {
        _979_DistributeCoinsInBinaryTree obj = new _979_DistributeCoinsInBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{3,0,0});
        System.out.println(obj.distributeCoins(root));
    }

    public int distributeCoins(BinaryTreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftCoins = dfs(node.left);
        int rightCoins = dfs(node.right);

        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        return node.val-1 + leftCoins + rightCoins;
    }
}
