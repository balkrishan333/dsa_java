package leetcode;

import leetcode.common.TreeNode;

public class RootToLeafSum_1022 {

    private int sum;

    public static void main(String[] args) {
        RootToLeafSum_1022 obj = new RootToLeafSum_1022();

        Integer[] input = {1, 0, 1, 0, 1, 0, 1};
        TreeNode root = new TreeNode().createTree(input);

        System.out.println(obj.sumRootToLeaf(root));

    }

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    /*
        Initial attempt was by using string builder but problem with that was
        with pass by reference all node values were passed.
     */
    private void dfs(TreeNode node, int currNumber) {
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
