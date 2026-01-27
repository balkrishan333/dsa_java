package leetcode;

import java.util.*;

public class _3650_MinimumCostPathWithEdgeReversals {

    public static void main(String[] args) {
        _3650_MinimumCostPathWithEdgeReversals obj =
                new _3650_MinimumCostPathWithEdgeReversals();

        int n = 4;
        int[][] edges = {{0,1,3},{3,1,1},{2,3,4},{0,2,2}};
        System.out.println(obj.minCost(n, edges));
    }

    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            graph[start].add(new int[]{end, cost});
            graph[end].add(new int[]{start, 2*cost});
        }

        boolean[] visited = new boolean[n];

        int[] nodeCosts = new int[n];
        Arrays.fill(nodeCosts, Integer.MAX_VALUE);
        nodeCosts[0] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        priorityQueue.offer(new int[]{0,0}); //[node, cost]

        while (!priorityQueue.isEmpty()) {
            int[] currentNode = priorityQueue.poll();
            int node = currentNode[0];
            int cost = currentNode[1];

            if (node == n-1) {
                return cost;
            }

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            for (int[] neighbor : graph[node]) {
                int newNode = neighbor[0];
                int newCost = neighbor[1];

                if (cost + newCost < nodeCosts[newNode]) {
                    nodeCosts[newNode] = cost + newCost;
                    priorityQueue.add(new int[]{newNode, nodeCosts[newNode]});
                }
            }
        }
        return -1;
    }
}
