package leetcode;

import java.util.*;

public class _2316_CountUnreachablePairsOfNodesInAnUndirectedGraph {

    public static void main(String[] args) {
        _2316_CountUnreachablePairsOfNodesInAnUndirectedGraph obj = new _2316_CountUnreachablePairsOfNodesInAnUndirectedGraph();

        int n = 7;
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        System.out.println(obj.countPairs(n, edges));
    }

    /*
        Approach:
        Do union find to create group of nodes connected. To find the answer we need to find the product of no of nodes in each group.
        When iterated over values in nested loop to find product, it timed out. So needed to use trick to avoid nested loop.
        See inline comments below to learn abt trick.
     */
    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, rank);
        }

        Map<Integer, Integer> groupNodeCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i, parent);
            groupNodeCount.merge(root, 1, Integer::sum);
        }

        long answer = 0;
        long remainingNodes = n; // start with all nodes remaining
        for (int groupSize : groupNodeCount.values()) {
            answer += groupSize * (remainingNodes - groupSize); // on each iteration multiply the nodes in current group with nodes
            // remaining (of course we need to subtract the nodes in current group from total before multiplication) and update the
            // remaining nodes by subtracting the current group size from remaining nodes.
            remainingNodes -= groupSize;
        }
        return answer;
    }

    private void union(int node1, int node2, int[] parent, int[] rank) {
        int node1Parent = find(node1, parent);
        int node2Parent = find(node2, parent);

        if (node1Parent == node2Parent) {
            return;
        }

        if (rank[node1Parent] < rank[node2Parent]) {
            parent[node1Parent] = node2Parent;
        } else if (rank[node1Parent] > rank[node2Parent]) {
            parent[node2Parent] = node1Parent;
        } else {
            parent[node1Parent] = node2Parent;
            rank[node2Parent]++;
        }
    }

    private int find(int node, int[] parent) {
        if (parent[node] == node) {
            return parent[node];
        }
        return find(parent[node], parent);
    }
}
