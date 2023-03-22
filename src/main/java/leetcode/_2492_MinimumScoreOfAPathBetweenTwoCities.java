package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2492_MinimumScoreOfAPathBetweenTwoCities {

    public static void main(String[] args) {
        _2492_MinimumScoreOfAPathBetweenTwoCities obj = new _2492_MinimumScoreOfAPathBetweenTwoCities();

        int n = 4;
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        System.out.println(obj.minScore(n, roads));
    }

    public int minScore(int n, int[][] roads) {
        List<Integer>[] graph = new List[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] parent = new int[n+1];
        parent[1] = 1;

        int[] minDistance = new int[n+1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        for (int[] road : roads) {
            //Build graph
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);

            //initialize union find the nodes
            if (parent[road[0]] == 0) {
                parent[road[0]] = road[1];
            } else if (parent[road[1]] == 0) {
                parent[road[1]] = road[0];
            }

            minDistance[road[0]] = Math.min(minDistance[road[0]], road[2]);
            minDistance[road[1]] = Math.min(minDistance[road[1]], road[2]);
        }

//        System.out.println(Arrays.toString(graph));
//        System.out.println(Arrays.toString(parent));
//        System.out.println(Arrays.toString(minDistance));

        //union find the nodes
        for (int i = 1; i <= n; i++) {
            int childOf = find(i, parent);
            parent[i] = childOf;
        }

//        System.out.println(Arrays.toString(parent));
        //identify the graph which has both first and last node
        int root = parent[1];

        //find minimum distance in the graph
        boolean[] visited = new boolean[n+1];
        int min = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (road[0] == root || road[1] == root) {
                min = Math.min(min, road[2]);
            }
        }
        return minDistance[root];
    }

    private int find(int node, int[] parent) {
        if (parent[node] == node) {
            return node;
        }

        return find(parent[node], parent);
    }
}
