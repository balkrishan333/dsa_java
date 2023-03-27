package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _2360_LongestCycleInAGraph {

    private int answer = -1;

    public static void main(String[] args) {
        _2360_LongestCycleInAGraph obj = new _2360_LongestCycleInAGraph();

        int[] edges = {3,3,4,2,3};
        System.out.println(obj.longestCycle(edges));
    }

    /*
        Approach: Kahn's algorithm
     */
    public int longestCycle(int[] edges) {
        int[] inDegree = new int[edges.length];
        for(int edge : edges) {
            if(edge != -1) {
                inDegree[edge]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        boolean[] visited = new boolean[edges.length];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;
                int neighbor = edges[node];
                if(neighbor != -1) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        int answer = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int count = 1;
                int neighbor = edges[i];
                while (neighbor != i) {
                    count++;
                    neighbor = edges[neighbor];
                    visited[neighbor] = true;
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }

    /*
        Approach: DFS
        DFS for each node and keep track of distance of each node as we traverse deep. Distance is no. of nodes visited.

        if no edge exists, i.e. we can't move further, return

        if next node is not visited, update its distance and do DFS for next node

        if next node is visited and is in current map (being in current map means it was visited in current cycle and not in some earlier
         cycle), find the length of cycle and save max.

     */
    public int longestCycle_v1(int[] edges) {
        boolean[] visited = new boolean[edges.length];

        int nodes = edges.length;
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, visited, dist, edges);
            }
        }
        return answer;
    }

    private void dfs(int node, boolean[] visited, Map<Integer, Integer> dist, int[] edges) {
        visited[node] = true;

        int neighbor = edges[node];

        if (neighbor == -1) {
            return;
        }

        if (!visited[neighbor]) {
            dist.put(neighbor, dist.get(node)+1);
            dfs(neighbor, visited, dist, edges);
        } else if (dist.containsKey(neighbor)) {
            answer = Math.max(answer, dist.get(node) - dist.get(neighbor) + 1);
        }
    }
}
