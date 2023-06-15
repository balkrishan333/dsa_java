package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _1161_MaximumLevelSumOfABinaryTree {

    public static void main(String[] args) {
        _1161_MaximumLevelSumOfABinaryTree obj = new _1161_MaximumLevelSumOfABinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{-100,-200,-300,-20,-5,-10,null});
        System.out.println(obj.maxLevelSum(root));
    }

    /*
        Approach: BFS
     */
    public int maxLevelSum(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0, answer = 1, sum = Integer.MIN_VALUE;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();;
            level++;

            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (levelSum > sum) {
                sum = levelSum;
                answer = level;
            }
        }
        return answer;
    }
}
