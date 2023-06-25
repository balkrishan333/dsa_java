package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1145_BinaryTreeColoringGame {

    public static void main(String[] args) {
        _1145_BinaryTreeColoringGame obj = new _1145_BinaryTreeColoringGame();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3});
        int n = 3, x = 2;

        System.out.println(obj.btreeGameWinningMove(root, n, x));
    }

    private int left;
    private int right;

    /*
        Approach: Count number of nodes in left and right subtree of selected node of player 1

        If left count or right count is more than  n/2, return true as player 2 can win by selecting any of these nodes as its starting node

        If left count + right count +1 is less than n/2, return true as player 2 can win by selecting parent node of node selected by
        player 1

        Return false otherwise.
     */
    public boolean btreeGameWinningMove(BinaryTreeNode root, int n, int x) {
        if (root == null) {
            return false;
        }

        countNodes(root, x);

        if (left + right + 1 <= n / 2) {
            return true;
        }

        if (left > n/2 || right > n/2) {
            return true;
        }

        return false;
    }

    private int countNodes(BinaryTreeNode node, int x) {
        if (node == null) {
            return 0;
        }

        int left = countNodes(node.left, x);
        int right = countNodes(node.right, x);

        if (node.val == x) {
            this.left = left;
            this.right = right;
        }

        return left + right +1;
    }
}
