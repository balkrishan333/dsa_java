package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1443_MinimumTimToCollectAllApplesInATree {

    public static void main(String[] args) {
        _1443_MinimumTimToCollectAllApplesInATree obj = new _1443_MinimumTimToCollectAllApplesInATree();
//        int n = 7;
//        int[][] edges = {{0,1}, {0,2}, {1,4}, {1,5}, {2,3}, {2,6}};
//        List<Boolean> hasApples = List.of(false, false, true, false, true, true, false);

        int n = 4;
        int[][] edges = {{0,1}, {1,2}, {0,3}};
        List<Boolean> hasApples = List.of( true, true, false, true);

        System.out.println(obj.minTime(n, edges, hasApples));
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApples) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n]; // marker for visited nodes
        return count(0, graph, visited, hasApples);
    }

    private int count(int node, List<Integer>[] graph, boolean[] visited, List<Boolean> hasApples) {
        if (visited[node]) {
            return 0;
        }
        visited[node] = true;

        int sum = 0;
        for (int edge : graph[node]) {
            sum += count(edge, graph, visited, hasApples); //line 1
        }

        if(node == 0) {
            // Special case for the root node as all children of root have already been account for in line 1
            return  sum;
        }

        // If any children contain an apple or the current node contains an apple we return (2+sum)
        if(hasApples.get(node) || sum > 0 ) {
            return (2 + sum);
        } else {
            //If neither the children nor the current node contain an apple we just return 0
            return 0;
        }
    }
}
