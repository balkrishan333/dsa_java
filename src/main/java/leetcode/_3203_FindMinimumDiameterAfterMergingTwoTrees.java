package leetcode;

import java.util.*;

public class _3203_FindMinimumDiameterAfterMergingTwoTrees {

    public static void main(String[] args) {
        _3203_FindMinimumDiameterAfterMergingTwoTrees obj = new _3203_FindMinimumDiameterAfterMergingTwoTrees();
        System.out.println(obj.minimumDiameterAfterMerge(new int[][]{{0,1}, {0,2}, {0,3}}, new int[][]{{0,1}}));
    }

    /*
        Approach:

        Diameter of a tree is the longest path between two nodes.

        Connecting nodes should be middle nodes of the diameter of the tree because it will minimize the diameter.

        1. Find diameter of both trees.
        2. Merge diameter = 1 + ceil(diameter1/2) + ceil(diameter2/2)
        3. Return max of merge diameter, diameter1 and diameter2.
     */

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        int diameter1 = findDiameter(edges1);
        int diameter2 = findDiameter(edges2);

        int mergeDiameter = 1 + Math.ceilDiv(diameter1,2) + Math.ceilDiv(diameter2,2);

        return Math.max(mergeDiameter, Math.max(diameter2, diameter1));
    }

    private int findDiameter(int[][] edges) {

        if (edges.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> list = adjList.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            adjList.put(edge[0], list);

            List<Integer> list2 = adjList.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            adjList.put(edge[1], list2);
        }
        return diameter(adjList);
    }

    private int diameter(Map<Integer, List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];
        queue.offer(0);
        int last =0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited[node] = true;
                last = node;
                for (int neighbor : adjList.get(node)) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        queue.offer(last);
        int diameter = -1;
        Arrays.fill(visited, false);

        while(!queue.isEmpty()) {
            int size = queue.size();
            diameter++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited[node] = true;
                for (int neighbor : adjList.get(node)) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return diameter;
    }
}
