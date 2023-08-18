package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1615_MaximalNetworkRank {

    public static void main(String[] args) {
        _1615_MaximalNetworkRank obj = new _1615_MaximalNetworkRank();

        int n = 2;
//        int[][] roads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
        int[][] roads = {{1,0}};
        System.out.println(obj.maximalNetworkRank(n, roads));
    }

    /*
        Approach: Calculate in degree
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<String> adjList = new HashSet<>();

        for(int[] road : roads) {
            //since edges are bidirectional, increase in degree of both nodes
            inDegree.merge(road[0], 1, Integer::sum);
            inDegree.merge(road[1], 1, Integer::sum);

            //since edges are bidirectional, add adjacency edge for both nodes
            adjList.add(road[0] + "#" + road[1]);
            adjList.add(road[1] + "#" + road[0]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int rank = inDegree.getOrDefault(i, 0) + inDegree.getOrDefault(j, 0);
                if (adjList.contains(i + "#" + j)) {
                    rank--; //reduce by 1 if there is a direct edge between nodes
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}
