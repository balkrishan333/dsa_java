package leetcode;

import java.util.*;

public class _785_IsGraphBipartite {

    public static void main(String[] args) {
        _785_IsGraphBipartite obj = new _785_IsGraphBipartite();

        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(obj.isBipartite(graph));
    }

    /*
        Approach: Color the nodes. If at any time any 2 adjacent nodes have same color, return false;

        Use DFS.
     */
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        // 0 - blue
        // 1  - red
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !dfs(i, graph, colors, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int[][] graph, int[] colors, int color) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }
        colors[node] = color;

        int nextColor = 1;
        if (color == 1) {
            nextColor = 0;
        }
        for (int adjacent : graph[node]) {
            if (!dfs(adjacent, graph, colors, nextColor)){
                return false;
            }
        }
        return true;
    }
}
