package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    private int count;

    public static void main(String[] args) {
        _1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero obj = new _1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero();

//        int n = 6;
//        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 3;
        int[][] connections = {{1,0},{2,0}};
        System.out.println(obj.minReorder(n, connections));
    }

    /*
        Approach:
        create a graph and do save the direction of node while creating the graph.
        Though given graph is directed but when creating the graph treat it as undirected

        Do DFS starting from first node and at any point if we find edge in opposite direction, increase the count because for that node
         we will have to change the direction to reach the first city.
     */
    public int minReorder(int n, int[][] connections) {
        List<Tuple>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            graph[connection[0]].add(new Tuple(connection[1], true));
            graph[connection[1]].add(new Tuple(connection[0], false));
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, graph, visited);
        return count;
    }

    private void dfs(int node, List<Tuple>[] graph, boolean[] visited) {
        List<Tuple> children = graph[node];
        for (Tuple child : children) {
            if (!visited[child.node]) {
                visited[child.node] = true;
                if (child.out) {
                    count++;
                }
                dfs(child.node, graph, visited);
            }
        }
    }
    
    private static class Tuple {
        int node;
        boolean out;
        
        Tuple(int node, boolean out) {
            this.node = node;
            this.out = out;
        }
    }
}
