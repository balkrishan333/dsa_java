package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1457_PseudoPalindromicPathsInABinaryTree {

    public static void main(String[] args) {
        _1457_PseudoPalindromicPathsInABinaryTree obj = new _1457_PseudoPalindromicPathsInABinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{2,3,1,3,1,null,1});
        System.out.println(obj.pseudoPalindromicPaths(root));
    }

    private int answer = 0;
    public int pseudoPalindromicPaths (BinaryTreeNode root) {
        int[] count = new int[10];
        dfs(root, count);
        return answer;
    }

    private void dfs(BinaryTreeNode node, int[] count) {
        if (node == null) {
            return;
        }
        count[node.val]++;
        if (node.left == null && node.right == null) {
            int oddNums = 0;
            for (int val : count) {
                if (val % 2 == 1) {
                    oddNums++;
                }
            }
            if (oddNums <= 1) {
                answer++;
            }
            return;
        }
        dfs(node.left, count.clone());
        dfs(node.right, count.clone());
    }
}
