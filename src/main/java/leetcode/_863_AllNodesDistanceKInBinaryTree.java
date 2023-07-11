package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.*;

public class _863_AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        _863_AllNodesDistanceKInBinaryTree obj = new _863_AllNodesDistanceKInBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{0,1,null,3,2});
        BinaryTreeNode target = new BinaryTreeNode(2);
        int k = 1;

        System.out.println(obj.distanceK(root, target, k));
    }

    private Map<Integer, List<Integer>> graph;
    private List<Integer> answer;
    private Set<Integer> visited;

    /*
        Approach: Convert the tree in undirected graph and traverse neighboring nodes starting from target
     */
    public List<Integer> distanceK(BinaryTreeNode root, BinaryTreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);

        answer = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target.val);

        dfs(target.val, 0, k);

        return answer;
    }

    // Recursively build the undirected graph from the given binary tree.
    private void buildGraph(BinaryTreeNode cur, BinaryTreeNode parent) {
        if (cur == null) {
            return;
        }

        if (cur != null && parent != null) {
            graph.computeIfAbsent(cur.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(cur.val);
        }

        buildGraph(cur.left, cur);
        buildGraph(cur.right, cur);
    }

    private void dfs(int cur, int distance, int k) {
        if (distance == k) {
            answer.add(cur);
            return;
        }
        for (int neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(neighbor, distance + 1, k);
            }
        }
    }
}
