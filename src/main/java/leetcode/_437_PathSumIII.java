package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

public class _437_PathSumIII {

    public static void main(String[] args) {
        _437_PathSumIII obj = new _437_PathSumIII();

//        Integer[] input = {10,5,-3,3,2,null,11,3,-2,null,1};
        Integer[] input = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int target = 22;
        BinaryTreeNode root = new BinaryTreeNode().createTree(input);

        System.out.println(obj.pathSum(root, target));
    }

    public int pathSum(BinaryTreeNode root, int targetSum) {
        return dfs(root, 0, targetSum, new HashMap<>());
    }

    private int dfs(BinaryTreeNode node, int runningSum, int targetSum, Map<Integer, Integer> counts) {
        if(node == null) {
            return 0;
        }

        int totalPath = 0;
        runningSum += node.val;

        int pathCount = counts.getOrDefault(runningSum-targetSum, 0);
        totalPath += pathCount;

        if (runningSum == targetSum) {
            totalPath++;
        }

        counts.merge(runningSum, 1, Integer::sum);

        totalPath += dfs(node.left, runningSum, targetSum, counts);
        totalPath += dfs(node.right, runningSum, targetSum, counts);

        counts.merge(runningSum, -1, Integer::sum);

        return totalPath;
    }
}
