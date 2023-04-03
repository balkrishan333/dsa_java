package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1022_RootToLeafSum {

    private int sum;

    public static void main(String[] args) {
        _1022_RootToLeafSum obj = new _1022_RootToLeafSum();

        Integer[] input = {1, 0, 1, 0, 1, 0, 1};
        BinaryTreeNode root = new BinaryTreeNode().createTree(input);

        System.out.println(obj.sumRootToLeaf(root));

    }

    public int sumRootToLeaf(BinaryTreeNode root) {
        dfs(root, 0);
        return sum;
    }

    /*
        Initial attempt was by using string builder but problem with that was
        with pass by reference all node values were passed.
     */
    private void dfs(BinaryTreeNode node, int currNumber) {
        if (node != null) {
            currNumber = currNumber << 1 | node.val;
            if (node.left == null && node.right == null) {
                sum += currNumber;
            }
            dfs(node.left, currNumber);
            dfs(node.right, currNumber);
        }
    }
}
