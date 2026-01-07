package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1339_MaximumProductOfSplittedBinaryTree {

    private static int MOD = 1_000_000_007;
    private long total;
    private long max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        _1339_MaximumProductOfSplittedBinaryTree obj =
                new _1339_MaximumProductOfSplittedBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,4,5,6});
        System.out.println(obj.maxProduct(root));
    }

    public int maxProduct(BinaryTreeNode root) {
        total = sum(root);
        dfs(root);
        return (int)(max % MOD);
    }

    private long dfs(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        long sum =  node.val + dfs(node.left) + dfs(node.right);
        max = Math.max(max, sum * (total-sum));
        return sum;
    }

    private long sum(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }
}
