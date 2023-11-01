package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.*;

public class _501_FindModeInBinarySearchTree {

    public static void main(String[] args) {
        _501_FindModeInBinarySearchTree obj = new _501_FindModeInBinarySearchTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,null,2,2});
        System.out.println(Arrays.toString(obj.findMode(root)));
    }

    private final Map<Integer, Integer> counter = new HashMap<>();
    private int maxFreq = -1;
    public int[] findMode(BinaryTreeNode root) {

        dfs(root);
        List<Integer> ans = new ArrayList<>();
        for (int key : counter.keySet()) {
            if (counter.get(key) == maxFreq) {
                ans.add(key);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public void dfs(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        counter.merge(node.val, 1, Integer::sum);
        maxFreq = Math.max(counter.get(node.val), maxFreq);
        dfs(node.left);
        dfs(node.right);
    }
}
