package leetcode;

import leetcode.common.BinaryTreeNode;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _95_UniqueBinarySearchTrees_II {

    public static void main(String[] args) {
        _95_UniqueBinarySearchTrees_II obj = new _95_UniqueBinarySearchTrees_II();

        int n = 3;
        System.out.println(obj.generateTrees(n));
    }

    public List<BinaryTreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<BinaryTreeNode>> memo = new HashMap<>();

        return generateTrees(1, n, memo);
    }

    private List<BinaryTreeNode> generateTrees(int start, int end, Map<Pair<Integer, Integer>, List<BinaryTreeNode>> memo) {
        List<BinaryTreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null); //add to avoid NPE when iterating through list
            return result;
        }

        if (memo.containsKey(new Pair<>(start, end))) {
            return memo.get(new Pair<>(start, end));
        }

        for (int i = start; i <= end; i++) {
            List<BinaryTreeNode> leftSubTrees = generateTrees(start, i-1, memo);
            List<BinaryTreeNode> rightSubTrees = generateTrees(i+1, end, memo);

            for (BinaryTreeNode left : leftSubTrees) {
                for (BinaryTreeNode right : rightSubTrees) {
                    BinaryTreeNode root = new BinaryTreeNode(i, left, right);
                    result.add(root);
                }
            }
        }
        memo.put(new Pair<>(start, end), result);
        return result;
    }
}
