package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1129_ShortestPathWithAlternatingColors {

    public static void main(String[] args) {
        _1129_ShortestPathWithAlternatingColors obj = new _1129_ShortestPathWithAlternatingColors();

//        int n = 5;
//        int[][] redEdges = {{0,1},{1,2},{2,3},{3,4}};
//        int[][] blueEdges = {{1,2},{2,3},{3,1}};
        int n = 3;
        int[][] redEdges = {{0,1},{0,2}};
        int[][] blueEdges = {{1,0}};
        System.out.println(Arrays.toString(obj.shortestAlternatingPaths(n, redEdges, blueEdges)));
    }

    /*

    class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] redEdge : redEdges) {
            adj.computeIfAbsent(redEdge[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(redEdge[1], 0));
        }

        for (int[] blueEdge : blueEdges) {
            adj.computeIfAbsent(blueEdge[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(blueEdge[1], 1));
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[][] visit = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();

        // Start with node 0, with number of steps as 0 and undefined color -1.
        q.offer(new int[] { 0, 0, -1 });
        answer[0] = 0;
        visit[0][1] = visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] element = q.poll();
            int node = element[0], steps = element[1], prevColor = element[2];

            if (!adj.containsKey(node)) {
                continue;
            }

            for (List<Integer> nei : adj.get(node)) {
                int neighbor = nei.get(0);
                int color = nei.get(1);
                if (!visit[neighbor][color] && color != prevColor) {
                    if (answer[neighbor] == -1)
                        answer[neighbor] = 1 + steps;
                    visit[neighbor][color] = true;
                    q.offer(new int[] { neighbor, 1 + steps, color });
                }
            }
        }
        return answer;
    }
}


     */

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] =0;

        if (redEdges.length == 0 && blueEdges.length == 0) {
            return answer;
        }

        List<Edge>[] redGraph = new ArrayList[n];
        List<Edge>[] blueGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }

        prepareGraph(redEdges, redGraph, true);
        prepareGraph(blueEdges, blueGraph, false);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        List<Edge> start = redGraph[0];
        start.addAll(blueGraph[0]);

        if (start.size() == 0) {
            return answer;
        }

        for (Edge e1 : start) {
            answer[e1.node] = 1;
        }

        for (Edge e1 : start) {
            dfs(e1, redGraph, blueGraph, visited, 0, answer);
        }

        return answer;
    }

    private static void prepareGraph(int[][] edges, List<Edge>[] redGraph, boolean red) {
        for (int[] edge : edges) {
            Edge e1 = new Edge();
            e1.node = edge[1];
            e1.red = red;
            redGraph[edge[0]].add(e1);
        }
    }

    private void dfs(Edge e1, List<Edge>[] redGraph, List<Edge>[] blueGraph, boolean[] visited, int distance, int[] answer) {

        answer[e1.node] = answer[e1.node] == -1 ? distance +1 : Math.min(distance+1, answer[e1.node]);

        if (!visited[e1.node]) {
            visited[e1.node] = true;

            List<Edge> children;
            if (e1.red) {
                children = blueGraph[e1.node];
            } else {
                children = redGraph[e1.node];
            }

            if (children.size() == 0) {
                return;
            }

            boolean[] visited_2 = new boolean[visited.length];
            visited_2[e1.node] = true;
            for(Edge next : children) {
                dfs(next, redGraph, blueGraph, visited_2, distance+1, answer);
            }
        }
    }

    static class Edge {
        int node;
        boolean red;
    }
}
